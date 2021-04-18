package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface DepartmentDao {
    public void createDepartment(Department department);
    public Integer findDepartmentIdByIso(String isoDepartment);
    public Integer findCountryIdByDepartmentId(Integer departmentId);

    public List<String> departmentList(String countryISO);
}
