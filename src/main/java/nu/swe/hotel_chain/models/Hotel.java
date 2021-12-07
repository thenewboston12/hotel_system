package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

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
    @JsonManagedReference
    private Set<Telephone> h_telephones = new HashSet<>();

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<RoomType> h_roomtypes = new HashSet<>();

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Service> h_services = new HashSet<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employees = new HashSet<>();

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

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_address() {
        return h_address;
    }

    public void setH_address(String h_address) {
        this.h_address = h_address;
    }

    public String getH_city() {
        return h_city;
    }

    public void setH_city(String h_city) {
        this.h_city = h_city;
    }

    public String getH_country() {
        return h_country;
    }

    public void setH_country(String h_country) {
        this.h_country = h_country;
    }

    public Set<Telephone> getH_telephones() {
        return h_telephones;
    }

    public void setH_telephones(Set<Telephone> h_telephones) {
        this.h_telephones = h_telephones;
    }

    public Set<RoomType> getH_roomtypes() {
        return h_roomtypes;
    }

    public void setH_roomtypes(Set<RoomType> h_roomtypes) {
        this.h_roomtypes = h_roomtypes;
    }

    public Set<Service> getH_services() {
        return h_services;
    }

    public void setH_services(Set<Service> h_services) {
        this.h_services = h_services;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id='" + hotel_id + '\'' +
                ", h_name='" + h_name + '\'' +
                ", h_address='" + h_address + '\'' +
                ", h_city='" + h_city + '\'' +
                ", h_country='" + h_country + '\'' +
                ", h_telephones=" + h_telephones +
                ", h_roomtypes=" + h_roomtypes +
                ", h_services=" + h_services +
                ", employees=" + employees +
                '}';
    }
}
