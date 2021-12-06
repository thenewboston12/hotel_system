package nu.swe.hotel_chain.models;

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

    @Column(name = "start_time")
    private Timestamp start_time;

    @Column(name = "end_time")
    private Timestamp end_time;

    public Schedule(){}

    public Schedule(int employee_id, int r_number, Timestamp start_time, Timestamp end_time) {
        this.employee_id = employee_id;
        this.r_number = r_number;
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

    @Override
    public String toString() {
        return "Schedule{" +
                "employee_id=" + employee_id +
                ", r_number=" + r_number +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
