package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Dead;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeadDao {
    public void createDead(Dead dead);
}
