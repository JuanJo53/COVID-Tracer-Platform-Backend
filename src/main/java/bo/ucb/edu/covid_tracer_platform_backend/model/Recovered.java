package bo.ucb.edu.covid_tracer_platform_backend.model;

import java.util.Date;

public class Recovered {
    private Integer recoveredId;
    private Integer departmentId;
    private Integer count;
    private Integer cumulative;
    private Date date;
    private Integer status;
    private Transaction transaction;

    public Recovered() {
        transaction = new Transaction();
    }

    public Integer getRecoveredId() {
        return recoveredId;
    }

    public void setRecoveredId(Integer recoveredId) {
        this.recoveredId = recoveredId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCumulative() {
        return cumulative;
    }

    public void setCumulative(Integer cumulative) {
        this.cumulative = cumulative;
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
        return "Recovered{" +
                "recoveredId=" + recoveredId +
                ", departmentId=" + departmentId +
                ", count=" + count +
                ", cumulative=" + cumulative +
                ", date=" + date +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
