package bo.ucb.edu.covid_tracer_platform_backend.shared.dto;

import java.util.Date;

public class CountryListHistoricRequest {
    private Date dateCountry;
    private Integer confirmed;
    private Integer Deaths;
    private Integer recovered;
    private Integer firstVaccine;
    private Integer secondVaccine;

    public CountryListHistoricRequest() {
    }

    public Date getDateCountry() {
        return dateCountry;
    }

    public void setDateCountry(Date dateCountry) {
        this.dateCountry = dateCountry;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return Deaths;
    }

    public void setDeaths(Integer deaths) {
        Deaths = deaths;
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
        return "CountryListHistoricRequest{" +
                "dateCountry='" + dateCountry + '\'' +
                ", confirmed=" + confirmed +
                ", Deaths=" + Deaths +
                ", recovered=" + recovered +
                ", firstVaccine=" + firstVaccine +
                ", secondVaccine=" + secondVaccine +
                '}';
    }
}
