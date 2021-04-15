package bo.ucb.edu.covid_tracer_platform_backend.model;

public class VaccineType {
    private Integer vaccineTypeId;
    private Integer type;
    private Integer status;
    private Transaction transaction;

    public VaccineType() {
        transaction = new Transaction();
    }

    public Integer getVaccineTypeId() {
        return vaccineTypeId;
    }

    public void setVaccineTypeId(Integer vaccineTypeId) {
        this.vaccineTypeId = vaccineTypeId;
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
        return "VaccineType{" +
                "vaccineTypeId=" + vaccineTypeId +
                ", type=" + type +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
