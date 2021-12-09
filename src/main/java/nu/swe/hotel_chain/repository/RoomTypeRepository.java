package nu.swe.hotel_chain.repository;

import nu.swe.hotel_chain.models.RoomType;
import nu.swe.hotel_chain.models.RoomTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, RoomTypeId> {
    @Query(value = "select RT from RoomType as RT where RT.r_type = ?1")
    List<RoomType> findByR_type(String r_type);

    @Query(value = "select RT from RoomType as RT where RT.hotel_id = ?1")
    List<RoomType> findByHotel_id(String hotel_id);
}
