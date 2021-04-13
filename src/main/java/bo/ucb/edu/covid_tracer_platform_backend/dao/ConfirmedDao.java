package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Confirmed;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfirmedDao {
    public void createConfirmed(Confirmed confirmed);
}
