package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao {
    public void createRole(Role role);
}
