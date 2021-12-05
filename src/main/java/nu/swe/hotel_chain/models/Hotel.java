package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hotel_id;

    private String name;
    private String address;
    private String city;
    private String country;

    @OneToMany(mappedBy = "hotel_id", cascade = CascadeType.ALL)
    private Set<RoomType> telephones;

    public Hotel(){

    }

    public Hotel(Long hotel_id, String name, String address, String city, String country) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public Hotel(String name, String address, String city, String country) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
