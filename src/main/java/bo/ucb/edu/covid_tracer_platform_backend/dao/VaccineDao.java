package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Vaccine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VaccineDao {
    public void createVaccine(Vaccine vaccine);
}
