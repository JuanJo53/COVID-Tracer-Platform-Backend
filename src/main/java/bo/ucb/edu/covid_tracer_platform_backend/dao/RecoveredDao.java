package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Recovered;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecoveredDao {
    public void createRecovered(Recovered recovered);
}
