package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class ScheduleId implements Serializable {
    private int employee_id;
    private int r_number;
    private int hotel_id;

    public ScheduleId(){}

    public ScheduleId(int employee_id, int r_number, int hotel_id) {
        this.employee_id = employee_id;
        this.r_number = r_number;
        this.hotel_id = hotel_id;
    }
}
