package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Vaccine;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface VaccineDao {
    public void createVaccine(Vaccine vaccine);
    public Date lastDateDepartment(Integer departmentId);
}
