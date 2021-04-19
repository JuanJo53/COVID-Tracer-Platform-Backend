package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.UserPasswordRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.UserM;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public void createUser(UserM userM);
    public UserM findUserByUserName(String userName);
    public String passwordUser(Integer userId);
    public void passwordNewUser(UserPasswordRequest userPasswordRequest);

}
