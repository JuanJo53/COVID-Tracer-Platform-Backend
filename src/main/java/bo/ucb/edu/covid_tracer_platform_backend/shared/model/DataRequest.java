package bo.ucb.edu.covid_tracer_platform_backend.shared.model;

public class DataRequest {
    private Integer dataRequestId;
    private Integer userId;
    private Integer countryId;
    private Integer departmentId;
    private Integer municipalityId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
                ", userId=" + userId +
                ", countryId=" + countryId +
                ", departmentId=" + departmentId +
                ", municipalityId=" + municipalityId +
                ", type=" + type +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
