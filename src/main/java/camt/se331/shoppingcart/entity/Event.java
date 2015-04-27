package camt.se331.shoppingcart.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nettanwat on 4/6/15 AD.
 */

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length = 1000000)
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private int start_hour;
    private int start_minute;
    private int end_hour;
    private int end_minute;
    private String location;
    private Double latitude;
    private Double longitude;
    private  String imagePath;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Member> members;
    private String category;
    private boolean status;


    public Event() {

    }

    public Event(Long id, String name, String description, Date date, int start_hour, int start_minute, int end_hour, int end_minute, String location, Double latitude, Double longitude, List<Member> members, String category, boolean status) {
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
        this.members = members;
        this.category = category;
        this.status = status;
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFormatDate(){
        SimpleDateFormat dt1 = new SimpleDateFormat("EEE, MMM d yyyy");
        return dt1.format(getDate());
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (end_hour != event.end_hour) return false;
        if (end_minute != event.end_minute) return false;
        if (start_hour != event.start_hour) return false;
        if (start_minute != event.start_minute) return false;
        if (status != event.status) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (latitude != null ? !latitude.equals(event.latitude) : event.latitude != null) return false;
        if (location != null ? !location.equals(event.location) : event.location != null) return false;
        if (longitude != null ? !longitude.equals(event.longitude) : event.longitude != null) return false;
        if (members != null ? !members.equals(event.members) : event.members != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + start_hour;
        result = 31 * result + start_minute;
        result = 31 * result + end_hour;
        result = 31 * result + end_minute;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (members != null ? members.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
