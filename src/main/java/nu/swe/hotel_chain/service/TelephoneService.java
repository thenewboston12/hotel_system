package nu.swe.hotel_chain.service;

import nu.swe.hotel_chain.models.Telephone;
import nu.swe.hotel_chain.repository.TelephoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneService {
    private final TelephoneRepository telephoneRepository;

    public TelephoneService(TelephoneRepository telephoneRepository) {
        this.telephoneRepository = telephoneRepository;
    }

    public List<Telephone> getTelephones(){
        return this.telephoneRepository.findAll();
    }
}
