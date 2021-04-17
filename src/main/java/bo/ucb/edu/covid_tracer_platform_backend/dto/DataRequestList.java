package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class DataRequestList {
    private Integer id;
    private String username;
    private String region;
    private Date date;

    public DataRequestList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DataRequestList{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", region='" + region + '\'' +
                ", date=" + date +
                '}';
    }
}
