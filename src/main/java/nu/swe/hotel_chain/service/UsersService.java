package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Users;
import nu.swe.hotel_chain.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers(){
        return this.usersRepository.findAll();
    }
}