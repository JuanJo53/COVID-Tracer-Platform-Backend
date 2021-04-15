package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class DataDepartmentCsvRequest {
    private Date date;
    private Integer confirmed;
    private Integer cumulativeConfirmed;
    private Integer dead;
    private Integer cumulativeDead;
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

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public Integer getCumulativeDead() {
        return cumulativeDead;
    }

    public void setCumulativeDead(Integer cumulativeDead) {
        this.cumulativeDead = cumulativeDead;
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

    @Override
    public String toString() {
        return "CsvRequest{" +
                "date=" + date +
                ", confirmed=" + confirmed +
                ", cumulativeConfirmed=" + cumulativeConfirmed +
                ", dead=" + dead +
                ", cumulativeDead=" + cumulativeDead +
                ", recovered=" + recovered +
                ", cumulativeRecovered=" + cumulativeRecovered +
                '}';
    }
}
