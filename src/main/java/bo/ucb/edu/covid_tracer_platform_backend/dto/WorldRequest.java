package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class WorldRequest {
    private Integer confirmed;
    private Integer deaths;
    private Date date;

    public WorldRequest() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "WorldRequest{" +
                "confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", date=" + date +
                '}';
    }
}
