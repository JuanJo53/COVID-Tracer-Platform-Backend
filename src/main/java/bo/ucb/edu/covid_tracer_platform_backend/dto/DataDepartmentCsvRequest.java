package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class DataDepartmentCsvRequest {
    private Date date;
    private Integer confirmed;
    private Integer cumulativeConfirmed;
    private Integer deaths;
    private Integer cumulativeDeaths;
    private Integer recovered;
    private Integer cumulativeRecovered;

    public DataDepartmentCsvRequest() {
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

    public Integer getCumulativeConfirmed() {
        return cumulativeConfirmed;
    }

    public void setCumulativeConfirmed(Integer cumulativeConfirmed) {
        this.cumulativeConfirmed = cumulativeConfirmed;
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

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getCumulativeRecovered() {
        return cumulativeRecovered;
    }

    public void setCumulativeRecovered(Integer cumulativeRecovered) {
        this.cumulativeRecovered = cumulativeRecovered;
    }
}
