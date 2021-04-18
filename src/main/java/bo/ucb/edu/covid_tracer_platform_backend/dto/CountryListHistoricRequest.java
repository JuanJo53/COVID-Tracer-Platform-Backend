package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class CountryListHistoricRequest {
    private String dateCountry;
    private Integer confirmed;
    private Integer totalconfirmed;
    private Integer deaths;
    private Integer totalDeaths;
    private Integer recovered;
    private Integer totalrecovered;


    public CountryListHistoricRequest() {
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

    public Integer getTotalconfirmed() {
        return totalconfirmed;
    }

    public void setTotalconfirmed(Integer totalconfirmed) {
        this.totalconfirmed = totalconfirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getTotalrecovered() {
        return totalrecovered;
    }

    public void setTotalrecovered(Integer totalrecovered) {
        this.totalrecovered = totalrecovered;
    }

    @Override
    public String toString() {
        return "CountryListHistoricRequest{" +
                "date1='" + dateCountry + '\'' +
                ", confirmed=" + confirmed +
                ", totalconfirmed=" + totalconfirmed +
                ", deaths=" + deaths +
                ", totalDeaths=" + totalDeaths +
                ", recovered=" + recovered +
                ", totalrecovered=" + totalrecovered +
                '}';
    }
}
