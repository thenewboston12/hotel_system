package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "h_name")
    private String h_name;

    @Column(name = "h_address")
    private String h_address;

    @Column(name = "h_city")
    private String h_city;

    @Column(name = "h_country")
    private String h_country;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Telephone> h_telephones = new HashSet<>();

    public Hotel(){

    }

    public Hotel(String hotel_id, String h_name, String h_address, String h_city, String h_country) {
        this.hotel_id = hotel_id;
        this.h_name = h_name;
        this.h_address = h_address;
        this.h_city = h_city;
        this.h_country = h_country;
    }

    public Hotel(String h_name, String h_address, String h_city, String h_country) {
        this.h_name = h_name;
        this.h_address = h_address;
        this.h_city = h_city;
        this.h_country = h_country;
    }
}
