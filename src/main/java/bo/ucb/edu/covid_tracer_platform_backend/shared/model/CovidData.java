package bo.ucb.edu.covid_tracer_platform_backend.shared.model;

import java.util.Date;

public class CovidData {
    private Integer covidDataId;
    private Integer countryId;
    private Integer departmentId;
    private Integer municipalityId;
    private Integer confirmed;
    private Integer cumulativeConfirmed;
    private Integer deaths;
    private Integer cumulativeDeaths;
    private Integer recovered;
    private Integer cumulativeRecovered;
    private Date date;
    private Integer status;
    private Transaction transaction;

    public CovidData() {
        transaction = new Transaction();
    }

    public Integer getCovidDataId() {
        return covidDataId;
    }

    public void setCovidDataId(Integer covidDataId) {
        this.covidDataId = covidDataId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "CovidData{" +
                "covidDataId=" + covidDataId +
                ", countryId=" + countryId +
                ", departmentId=" + departmentId +
                ", municipalityId=" + municipalityId +
                ", confirmed=" + confirmed +
                ", cumulativeConfirmed=" + cumulativeConfirmed +
                ", deaths=" + deaths +
                ", cumulativeDeaths=" + cumulativeDeaths +
                ", recovered=" + recovered +
                ", cumulativeRecovered=" + cumulativeRecovered +
                ", date=" + date +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
