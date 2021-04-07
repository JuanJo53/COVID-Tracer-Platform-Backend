package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public void createUser(User user);
}
