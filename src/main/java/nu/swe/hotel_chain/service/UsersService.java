package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.exceptions.HException;
import nu.swe.hotel_chain.models.Users;
import nu.swe.hotel_chain.repository.UsersRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service @Transactional
public class UsersService implements UserDetailsService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    public UsersService(UsersRepository usersRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> getUsers(){
        return this.usersRepository.findAll();
    }

    public Users getUser (String email){
        return usersRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            System.out.println("user found in database" + email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public boolean addNewUser(Users user) {
        // validation
        String uEmail = user.getEmail();
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(uEmail != null) uEmail = uEmail.toLowerCase();
        if(!pattern.matcher(uEmail).matches())
            throw new HException( "invalid email");

        Optional<Users> userByEmail = usersRepository.findUserByEmail(user.getEmail());
        // check if email is not taken
        if ( userByEmail.isPresent()){
            throw new HException("email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user)!= null;

    }
}
