package nu.swe.hotel_chain.models;

import javax.persistence.*;


@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Integer gId;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "g_address")
    private String gAddress;

    @Column(name = "mobile_n")
    private String mobileNumber;

    @Column(name = "home_n")
    private String homeNumber;

    @Column(name = "g_name")
    private String gName;

    @Column(name = "g_category")
    private String gCategory;

    @Column(name = "g_surname")
    private String gSname;

    @Column(name = "g_email")
    private String gEmail;

    @Column(name = "g_password")
    private String gPassword;

    public Guest (){

    }

    public Guest(Integer gId, String idType, String idNumber, String gAddress, String mobileNumber, String homeNumber, String gName, String gCategory, String gSname, String gEmail, String gPassword) {
        this.gId = gId;
        this.idType = idType;
        this.idNumber = idNumber;
        this.gAddress = gAddress;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.gName = gName;
        this.gCategory = gCategory;
        this.gSname = gSname;
        this.gEmail = gEmail;
        this.gPassword = gPassword;
    }

    public Guest(String idType, String idNumber, String gAddress, String mobileNumber, String homeNumber, String gName, String gCategory, String gSname, String gEmail, String gPassword) {
        this.idType = idType;
        this.idNumber = idNumber;
        this.gAddress = gAddress;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.gName = gName;
        this.gCategory = gCategory;
        this.gSname = gSname;
        this.gEmail = gEmail;
        this.gPassword = gPassword;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgCategory() {
        return gCategory;
    }

    public void setgCategory(String gCategory) {
        this.gCategory = gCategory;
    }

    public String getgSname() {
        return gSname;
    }

    public void setgSname(String gSname) {
        this.gSname = gSname;
    }

    public String getgEmail() {
        return gEmail;
    }

    public void setgEmail(String gEmail) {
        this.gEmail = gEmail;
    }

    public String getgPassword() {
        return gPassword;
    }

    public void setgPassword(String gPassword) {
        this.gPassword = gPassword;
    }
}
