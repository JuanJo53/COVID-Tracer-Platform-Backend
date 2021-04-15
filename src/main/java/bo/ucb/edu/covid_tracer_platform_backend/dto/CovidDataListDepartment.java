package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class CovidDataListDepartment {
    private Integer id;
    private Date date;
    private Integer confirmed;
    private Integer dead;
    private Integer recovered;

    public CovidDataListDepartment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return "CovidDataListDepartment{" +
                "id=" + id +
                ", date=" + date +
                ", confirmed=" + confirmed +
                ", dead=" + dead +
                ", recovered=" + recovered +
                '}';
    }
}
