package nu.swe.hotel_chain.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    @Column(name = "id", unique = true)
    private Integer u_id;

    @NotNull
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    public static enum Role{Staff, Guest, Clerk, Manager}
    @Column(name = "role")
    private String role;

    public Users(){}

    public Users(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // connection to Guest and Employee classes.Need to be revised

//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
//    @JsonManagedReference(value = "guest-user")
//    private Guest guest;

//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
//    @JsonManagedReference(value = "employee-user")
//    private Employee employee;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public Guest getGuest() {
//        return guest;
//    }
//
//    public void setGuest(Guest guest) {
//        this.guest = guest;
//    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
//                ", employee=" + employee +
//                ", guest=" + guest +
                '}';
    }
}
