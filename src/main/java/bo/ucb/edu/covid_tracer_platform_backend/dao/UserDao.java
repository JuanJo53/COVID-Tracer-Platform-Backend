package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.UserM;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public void createUser(UserM userM);
    public UserM findUserByUserName(String userName);
}
