package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.Service;
import nu.swe.hotel_chain.models.ServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, ServiceId> {

    @Query(value = "select S.s_price from Service as S where S.hotel_id= ?1 and  S.service_type = ?2")
    float findS_priceByHotelIdAndService_type(String hotel_id, String service_type);
}
