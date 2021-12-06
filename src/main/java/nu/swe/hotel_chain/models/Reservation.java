package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@IdClass(ReservationId.class)
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "res_id")
    private int res_id;

    @Id
    @Column(name = "guest_id")
    private int guest_id;

    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "r_number")
    private int r_number;

    @Column(name = "check_in")
    private LocalDate check_in;

    @Column(name = "check_out")
    private LocalDate check_out;

    public Reservation(){}

    public Reservation(int res_id, int guest_id, String hotel_id, int r_number, LocalDate check_in, LocalDate check_out) {
        this.res_id = res_id;
        this.guest_id = guest_id;
        this.hotel_id = hotel_id;
        this.r_number = r_number;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public Reservation(int guest_id, String hotel_id, int r_number, LocalDate check_in, LocalDate check_out) {
        this.guest_id = guest_id;
        this.hotel_id = hotel_id;
        this.r_number = r_number;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getR_number() {
        return r_number;
    }

    public void setR_number(int r_number) {
        this.r_number = r_number;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalDate check_in) {
        this.check_in = check_in;
    }

    public LocalDate getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalDate check_out) {
        this.check_out = check_out;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id=" + res_id +
                ", guest_id=" + guest_id +
                ", hotel_id='" + hotel_id + '\'' +
                ", r_number=" + r_number +
                ", check_in_date=" + check_in +
                ", check_out_date=" + check_out +
                '}';
    }
}