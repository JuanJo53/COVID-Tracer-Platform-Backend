package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    public void createPerson(Person person);
}
