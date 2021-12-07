package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.RoomType;
import nu.swe.hotel_chain.models.RoomTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, RoomTypeId> {
}
