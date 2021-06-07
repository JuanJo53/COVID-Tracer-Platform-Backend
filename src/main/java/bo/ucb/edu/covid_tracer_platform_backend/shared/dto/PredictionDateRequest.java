package bo.ucb.edu.covid_tracer_platform_backend.shared.dto;

import java.util.Date;

public class PredictionDateRequest {

    private Date date;
    private Integer count;
    private Integer status;

    public PredictionDateRequest() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "predictionDateRequest{" +
                "date=" + date +
                ", count=" + count +
                ", status=" + status +
                '}';
    }
}
