package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.Date;

public class TotalWorldRequest {
    private Integer totalConfirmed;
    private Integer totalDeaths;
    private Date date;

    public TotalWorldRequest() {
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TotalWorldRequest{" +
                "totalConfirmed=" + totalConfirmed +
                ", totalDeaths=" + totalDeaths +
                ", date=" + date +
                '}';
    }
}
