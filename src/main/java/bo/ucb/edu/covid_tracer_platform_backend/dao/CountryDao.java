package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CountryDao {
    public void createCountry(Country country);
    public List<String> getIsoList();
    public Integer findCountryIdByIso(String isoCountry);


}
