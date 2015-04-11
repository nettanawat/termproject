package camt.se331.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nettanwat on 4/6/15 AD.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue
    private  Long id;
    private String name;
    private String description;
    private Date date;
    private int start_hour;
    private int start_minute;
    private int end_hour;
    private int end_minute;
    private String location;
    private Double latitude;
    private Double longitude;
    private int status;
    private int add_by;



    public Event() {
    }

    public Event(Long id,String name, String description, Date date, int start_hour, int start_minute, int end_hour, int end_minute, String location, Double latitude, Double longitude, int status, int add_by) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.start_hour = start_hour;
        this.start_minute = start_minute;
        this.end_hour = end_hour;
        this.end_minute = end_minute;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.add_by = add_by;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(int start_hour) {
        this.start_hour = start_hour;
    }

    public int getStart_minute() {
        return start_minute;
    }

    public void setStart_minute(int start_minute) {
        this.start_minute = start_minute;
    }

    public int getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(int end_hour) {
        this.end_hour = end_hour;
    }

    public int getEnd_minute() {
        return end_minute;
    }

    public void setEnd_minute(int end_minute) {
        this.end_minute = end_minute;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAdd_by() {
        return add_by;
    }

    public void setAdd_by(int add_by) {
        this.add_by = add_by;
    }
}
