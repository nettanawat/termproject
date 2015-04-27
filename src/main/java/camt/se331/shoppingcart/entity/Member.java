package camt.se331.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity


public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Date joinDate;
    private boolean status;
    private String role;

    public Member() {
    }

    public Member(Long id, String firstName, String lastName, String email, String password,String phoneNumber, Date joinDate, boolean status, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
        this.status = status;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFormatDate(){
        SimpleDateFormat dt1 = new SimpleDateFormat("EEE, MMM d yyyy");
        return dt1.format(getJoinDate());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (status != member.status) return false;
        if (email != null ? !email.equals(member.email) : member.email != null) return false;
        if (firstName != null ? !firstName.equals(member.firstName) : member.firstName != null) return false;
        if (id != null ? !id.equals(member.id) : member.id != null) return false;
        if (joinDate != null ? !joinDate.equals(member.joinDate) : member.joinDate != null) return false;
        if (lastName != null ? !lastName.equals(member.lastName) : member.lastName != null) return false;
        if (password != null ? !password.equals(member.password) : member.password != null) return false;
        if (role != null ? !role.equals(member.role) : member.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}