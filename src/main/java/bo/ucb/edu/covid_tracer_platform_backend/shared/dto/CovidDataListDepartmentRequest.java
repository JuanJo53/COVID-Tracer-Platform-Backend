package bo.ucb.edu.covid_tracer_platform_backend.shared.dto;

import java.util.Date;

public class CovidDataListDepartmentRequest {
    private Integer id;
    private Date date;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer firstVaccine;
    private Integer secondVaccine;

    public CovidDataListDepartmentRequest() {
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

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getFirstVaccine() {
        return firstVaccine;
    }

    public void setFirstVaccine(Integer firstVaccine) {
        this.firstVaccine = firstVaccine;
    }

    public Integer getSecondVaccine() {
        return secondVaccine;
    }

    public void setSecondVaccine(Integer secondVaccine) {
        this.secondVaccine = secondVaccine;
    }

    @Override
    public String toString() {
        return "CovidDataListDepartmentRequest{" +
                "id=" + id +
                ", date=" + date +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", firstVaccine=" + firstVaccine +
                ", secondVaccine=" + secondVaccine +
                '}';
    }
}
