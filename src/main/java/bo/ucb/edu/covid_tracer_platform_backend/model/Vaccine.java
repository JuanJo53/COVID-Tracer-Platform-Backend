package bo.ucb.edu.covid_tracer_platform_backend.model;

import java.util.Date;

public class Vaccine {
    private Integer vaccineId;
    private Integer vaccineTypeId;
    private Integer countryId;
    private Integer departmentId;
    private Integer vaccinated;
    private Integer cumulativeVaccinated;
    private Date date;
    private Integer status;
    private Transaction transaction;

    public Vaccine() {
        transaction = new Transaction();
    }

    public Integer getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    public Integer getVaccineTypeId() {
        return vaccineTypeId;
    }

    public void setVaccineTypeId(Integer vaccineTypeId) {
        this.vaccineTypeId = vaccineTypeId;
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

    public Integer getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Integer vaccinated) {
        this.vaccinated = vaccinated;
    }

    public Integer getCumulativeVaccinated() {
        return cumulativeVaccinated;
    }

    public void setCumulativeVaccinated(Integer cumulativeVaccinated) {
        this.cumulativeVaccinated = cumulativeVaccinated;
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
        return "Vaccine{" +
                "vaccineId=" + vaccineId +
                ", vaccineTypeId=" + vaccineTypeId +
                ", countryId=" + countryId +
                ", departmentId=" + departmentId +
                ", vaccinated=" + vaccinated +
                ", cumulativeVaccinated=" + cumulativeVaccinated +
                ", date=" + date +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
