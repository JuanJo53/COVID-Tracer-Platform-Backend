package bo.ucb.edu.covid_tracer_platform_backend.model;

public class Department {
    private Integer departmentId;
    private String department;
    private Double longitude;
    private Double latitude;
    private Integer status;
    private Transaction transaction;

    public Department() {
        transaction = new Transaction();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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
        return "Department{" +
                "departmentId=" + departmentId +
                ", department='" + department + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
