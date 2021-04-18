package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class CountryListHistoricEveryDayRequest {
    private String dateCountry;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;

    public CountryListHistoricEveryDayRequest() {
    }

    public String getDateCountry() {
        return dateCountry;
    }

    public void setDateCountry(String dateCountry) {
        this.dateCountry = dateCountry;
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

    @Override
    public String toString() {
        return "CountryListHistoricEveryDayRequest{" +
                "dateCountry='" + dateCountry + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
