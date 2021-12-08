package nu.swe.hotel_chain.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nu.swe.hotel_chain.exceptions.HException;
import nu.swe.hotel_chain.models.Guest;
import nu.swe.hotel_chain.models.Users;
import nu.swe.hotel_chain.service.GuestService;
import nu.swe.hotel_chain.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Users> getUsers(){
        return this.usersService.getUsers();
    }

    @PostMapping(path = "/signup")
    public void registerNewUser(@RequestBody String userAndGuest){
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
            throw new HException( e.getMessage());
        }

    }
}
