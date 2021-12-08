package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Users;
import nu.swe.hotel_chain.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers(){
        return this.usersRepository.findAll();
    }


    public boolean addNewUser(Users user) {
        // validation
        String uEmail = user.getEmail();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(uEmail != null) uEmail = uEmail.toLowerCase();
        if(!pattern.matcher(uEmail).matches())
            throw new IllegalStateException("invalid email");

        Optional<Users> userByEmail = usersRepository.findUserByEmail(user.getEmail());
        // check if email is not taken
        if ( userByEmail.isPresent()){
            throw new IllegalStateException("email already exists");
        }
        return usersRepository.save(user)!= null;

    }
}
