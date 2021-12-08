package nu.swe.hotel_chain.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nu.swe.hotel_chain.exceptions.HException;
import nu.swe.hotel_chain.models.Guest;
import nu.swe.hotel_chain.models.Users;
import nu.swe.hotel_chain.service.GuestService;
import nu.swe.hotel_chain.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/users")
public class UsersController {
    private final UsersService usersService;
    private final GuestService guestService;

    @Autowired
    public UsersController(UsersService usersService, GuestService guestService) {
        this.usersService = usersService;
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers(){
        return ResponseEntity.ok().body(this.usersService.getUsers());
    }

    @GetMapping(path = "/token/refresh")
    public void  refreshToken(HttpServletRequest  request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String email = decodedJWT.getSubject();
                Users user = usersService.getUser(email);
                String access_token = JWT.create()
                        .withSubject(user.getEmail( ))
                        .withExpiresAt(new Date(System.currentTimeMillis() + 20*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRole()) // problematic line
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            }catch (Exception e){
                System.out.println("error refreshing token: " + e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }
        }else{
            throw new RuntimeException("Refresh Token is missing");
        }
    }





    @PostMapping(path = "/signup")
    public ResponseEntity<Map<String, String>> registerNewUser(@RequestBody String userAndGuest){
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(userAndGuest);
            String email = jsonNode.get("email").asText();
            String password = jsonNode.get("password").asText();
            String role = jsonNode.get("role").asText();
            String id_type = jsonNode.get("id_type").asText();
            String id_number = jsonNode.get("id_number").asText();
            String g_address = jsonNode.get("address").asText();
            String mobile_n = jsonNode.get("mobile_n").asText();
            String home_n = jsonNode.get("home_n").asText();
            String g_name = jsonNode.get("name").asText();
            String g_surname = jsonNode.get("surname").asText();
            String g_category = jsonNode.get("g_category").asText();

            // uncomment to test
//            System.out.print(email + " + " + password + " + " + role + " + " +id_type + " + " + id_number + " + " + g_address + " + "
//                + mobile_n + " + " + home_n + " + " + " + " + g_name + " + " + g_surname +" + " + g_category + " + "
//                );
            Users userToInsert  = new Users(email, password, role);
            Guest guestToInsert = new Guest(id_type, id_number, g_address, mobile_n, home_n, g_name, g_category, g_surname, email);


            boolean check = usersService.addNewUser(userToInsert);

            if ( check){
                guestService.addNewGuest(guestToInsert);
            }else {
                throw new HException( "user parameters are incorrect");
            }

        }catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        map.put("message", "registration was successful");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
