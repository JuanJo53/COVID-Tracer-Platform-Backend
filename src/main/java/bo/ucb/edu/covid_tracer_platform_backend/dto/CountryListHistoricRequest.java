package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class CountryListHistoricRequest {
    private Date dateCountry;
    private Integer totalconfirmed;
    private Integer totalDeaths;
    private Integer totalrecovered;
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

    public Integer getTotalconfirmed() {
        return totalconfirmed;
    }

    public void setTotalconfirmed(Integer totalconfirmed) {
        this.totalconfirmed = totalconfirmed;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getTotalrecovered() {
        return totalrecovered;
    }

    public void setTotalrecovered(Integer totalrecovered) {
        this.totalrecovered = totalrecovered;
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
                ", totalconfirmed=" + totalconfirmed +
                ", totalDeaths=" + totalDeaths +
                ", totalrecovered=" + totalrecovered +
                ", firstVaccine=" + firstVaccine +
                ", secondVaccine=" + secondVaccine +
                '}';
    }
}
