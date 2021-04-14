package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao {
    public void createDepartment(Department department);
}
