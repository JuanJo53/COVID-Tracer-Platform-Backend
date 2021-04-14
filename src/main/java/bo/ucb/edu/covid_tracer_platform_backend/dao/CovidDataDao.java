package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.CovidData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CovidDataDao {
    public void createCovidData(CovidData covidData);
}
