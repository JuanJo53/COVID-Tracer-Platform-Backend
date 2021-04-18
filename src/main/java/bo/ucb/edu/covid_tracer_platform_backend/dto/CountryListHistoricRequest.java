package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class CountryListHistoricRequest {
    private String date1;
    private Integer confirmed;
    private Integer totalconfirmed;
    private Integer deaths;
    private Integer totalDeaths;
    private Integer recovered;
    private Integer totalrecovered;


    public CountryListHistoricRequest() {
    }



    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
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
                "date1='" + date1 + '\'' +
                ", confirmed=" + confirmed +
                ", totalconfirmed=" + totalconfirmed +
                ", deaths=" + deaths +
                ", totalDeaths=" + totalDeaths +
                ", recovered=" + recovered +
                ", totalrecovered=" + totalrecovered +
                '}';
    }
}
