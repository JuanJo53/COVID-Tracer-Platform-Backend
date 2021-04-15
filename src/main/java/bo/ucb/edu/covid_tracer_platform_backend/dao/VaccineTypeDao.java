package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.VaccineType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VaccineTypeDao {
    public void createVaccineType(VaccineType vaccineType);
}
