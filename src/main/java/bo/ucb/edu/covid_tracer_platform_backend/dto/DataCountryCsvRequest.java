package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class DataCountryCsvRequest {
    private String iso;
    private Date date;
    private Integer cumulativeConfirmed;
    private Integer confirmed;
    private Integer deaths;
    private Integer cumulativeDeaths;

    public DataCountryCsvRequest() {
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCumulativeConfirmed() {
        return cumulativeConfirmed;
    }

    public void setCumulativeConfirmed(Integer cumulativeConfirmed) {
        this.cumulativeConfirmed = cumulativeConfirmed;
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

    public Integer getCumulativeDeaths() {
        return cumulativeDeaths;
    }

    public void setCumulativeDeaths(Integer cumulativeDeaths) {
        this.cumulativeDeaths = cumulativeDeaths;
    }

    @Override
    public String toString() {
        return "DataCountryCsvRequest{" +
                "iso='" + iso + '\'' +
                ", date=" + date +
                ", cumulativeConfirmed=" + cumulativeConfirmed +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", cumulativeDeaths=" + cumulativeDeaths +
                '}';
    }
}
