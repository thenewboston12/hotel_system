package nu.swe.hotel_chain.models;

import java.io.Serializable;

public class ScheduleId implements Serializable {
    private int employee_id;
    private int r_number;

    public ScheduleId(){}

    public ScheduleId(int employee_id, int r_number) {
        this.employee_id = employee_id;
        this.r_number = r_number;
    }
}
