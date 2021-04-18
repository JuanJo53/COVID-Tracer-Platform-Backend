package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class CountryHistoricRequest {
    private String dateCountry;
    private Integer totalconfirmed;
    private Integer totalDeaths;
    private Integer totalrecovered;
    private Integer firstVaccine;
    private Integer secondVaccine;
    private Double longitude;
    private Double latitude;

    public CountryHistoricRequest() {

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

    public String getDateCountry() {
        return dateCountry;
    }

    public void setDateCountry(String dateCountry) {
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "CountryHistoricRequest{" +
                "dateCountry='" + dateCountry + '\'' +
                ", totalconfirmed=" + totalconfirmed +
                ", totalDeaths=" + totalDeaths +
                ", totalrecovered=" + totalrecovered +
                ", firstVaccine=" + firstVaccine +
                ", secondVaccine=" + secondVaccine +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
