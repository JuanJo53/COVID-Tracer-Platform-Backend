package bo.ucb.edu.covid_tracer_platform_backend.model;

public class DataRequest {
    private Integer dataRequestId;
    private Integer departmentId;
    private Integer userId;
    private Integer type;
    private Integer status;
    private Transaction transaction;

    public DataRequest() {
        transaction = new Transaction();
    }

    public Integer getDataRequestId() {
        return dataRequestId;
    }

    public void setDataRequestId(Integer dataRequestId) {
        this.dataRequestId = dataRequestId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        return "DataRequest{" +
                "dataRequestId=" + dataRequestId +
                ", departmentId=" + departmentId +
                ", userId=" + userId +
                ", type=" + type +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
