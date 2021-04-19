package bo.ucb.edu.covid_tracer_platform_backend.shared.dto;

import java.util.Date;

public class CountryListRequest {
    private Integer countryId;
    private String iso;
    private String country;
    private Integer cumulativeConfirmed;
    private Integer cumulativeDeaths;
    private Date date;
    private Double latitude;
    private Double longitude;

    public CountryListRequest() {
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCumulativeConfirmed() {
        return cumulativeConfirmed;
    }

    public void setCumulativeConfirmed(Integer cumulativeConfirmed) {
        this.cumulativeConfirmed = cumulativeConfirmed;
    }

    public Integer getCumulativeDeaths() {
        return cumulativeDeaths;
    }

    public void setCumulativeDeaths(Integer cumulativeDeaths) {
        this.cumulativeDeaths = cumulativeDeaths;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CountryListRequest{" +
                "countryId=" + countryId +
                ", iso='" + iso + '\'' +
                ", country='" + country + '\'' +
                ", cumulativeConfirmed=" + cumulativeConfirmed +
                ", cumulativeDeaths=" + cumulativeDeaths +
                ", date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
