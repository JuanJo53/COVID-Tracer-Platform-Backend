package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class MunicipalityListRequet {
    private String municipality;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Double longitude;
    private Double latitude;

    public MunicipalityListRequet() {
    }


    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
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
        return "MunicipalityListRequet{" +
                "municipality='" + municipality + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
