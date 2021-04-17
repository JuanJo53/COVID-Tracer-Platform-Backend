package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.dto.CovidDataListDepartment;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DepartmentListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.MunicipalityListRequet;
import bo.ucb.edu.covid_tracer_platform_backend.model.CovidData;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CovidDataDao {
    public void createCovidData(CovidData covidData);
    public Date lastDateDepartment(Integer departmentId);
    public Date lastDateCountry(Integer countryId);
    public Integer getCovidDataTotalByDepartment(Integer departmentId);
    public List<CovidDataListDepartment> covidDataHistoricListByDepartment(Integer departmentId, Integer page, Integer size);
    public List<CovidDataListDepartment> covidDataCumulativeListByDepartment(Integer departmentId, Integer page, Integer size);
    public List<DepartmentListRequest> listDepartament(String countryISO);

    public DepartmentListRequest getDepartament(String countryISO, String isoDepartment);

    public Date lastDateMunicipality(String  municipality);

    public List<MunicipalityListRequet> listMunicipality(String countryISO, String isoDepartment);
}
