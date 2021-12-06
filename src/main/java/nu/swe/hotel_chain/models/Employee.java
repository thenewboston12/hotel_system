package nu.swe.hotel_chain.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer emp_id;

    @Column(name = "name")
    private String e_name;

    @Column(name = "sname")
    private String e_sname;

    @Column(name = "mobile_n")
    private String mobile;

    @Column(name = "salary")
    private float salary;

    @Column(name = "e_category")
    private String e_category;

    @Column(name = "emp_email")
    private String e_email;

    @Column(name = "m_w_hours")
    private int e_hours;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public String getHName() {
        return hotel.getH_name();
    }

    public String getHid() {
        return hotel.getHotel_id();
    }

    public String getHCity() {
        return hotel.getH_city();
    }



    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_sname() {
        return e_sname;
    }

    public void setE_sname(String e_sname) {
        this.e_sname = e_sname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getE_category() {
        return e_category;
    }

    public void setE_category(String e_category) {
        this.e_category = e_category;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public Integer getE_hours() {
        return e_hours;
    }

    public void setE_hours(Integer e_hours) {
        this.e_hours = e_hours;
    }



    public Employee(Integer emp_id, String e_name, String e_sname, String mobile, float salary, String e_category, String e_email, int e_hours, Hotel hotel) {
        this.emp_id = emp_id;
        this.e_name = e_name;
        this.e_sname = e_sname;
        this.mobile = mobile;
        this.salary = salary;
        this.e_category = e_category;
        this.e_email = e_email;
        this.e_hours = e_hours;
        this.hotel = hotel;
    }

    public Employee(String e_name, String e_sname, String mobile, float salary, String e_category, String e_email, int e_hours,  Hotel hotel) {
        this.e_name = e_name;
        this.e_sname = e_sname;
        this.mobile = mobile;
        this.salary = salary;
        this.e_category = e_category;
        this.e_email = e_email;
        this.e_hours = e_hours;
        this.hotel = hotel;
    }

    public Employee() {

    }
}
