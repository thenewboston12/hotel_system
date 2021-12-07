package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "schedule")
@IdClass(ScheduleId.class)
public class Schedule implements Serializable {

    @Id
    @Column(name = "employee_id")
    private int employee_id;

    @Id
    @Column(name = "r_number")
    private int r_number;

    @Id
    @Column(name = "hotel_id")
    private String hotel_id;

    @Column(name = "start_time")
    private Timestamp start_time;

    @Column(name = "end_time")
    private Timestamp end_time;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id", insertable = false, updatable = false),
            @JoinColumn(name = "r_number", referencedColumnName = "r_number", insertable = false, updatable = false)
    })
    @JsonBackReference
    private Room room;

    public Schedule(){}

    public Schedule(int employee_id, int r_number, String hotel_id, Timestamp start_time, Timestamp end_time) {
        this.employee_id = employee_id;
        this.r_number = r_number;
        this.hotel_id = hotel_id;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getR_number() {
        return r_number;
    }

    public void setR_number(int r_number) {
        this.r_number = r_number;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "employee_id=" + employee_id +
                ", r_number=" + r_number +
                ", hotel_id='" + hotel_id + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", employee=" + employee +
                ", room=" + room +
                '}';
    }
}
