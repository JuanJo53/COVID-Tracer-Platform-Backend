package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao {
    public void createUserRole(UserRole userRole);
}
