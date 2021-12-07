package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Service;
import nu.swe.hotel_chain.models.ServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, ServiceId> {
}
