package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryDao {
    public void createCountry(Country country);
}
