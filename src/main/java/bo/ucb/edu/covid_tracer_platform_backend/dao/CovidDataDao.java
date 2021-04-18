package bo.ucb.edu.covid_tracer_platform_backend.dao;

<<<<<<< HEAD
import bo.ucb.edu.covid_tracer_platform_backend.dto.CovidDataListDepartment;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DepartmentHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DepartmentListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.MunicipalityListRequest;
=======
import bo.ucb.edu.covid_tracer_platform_backend.dto.*;
>>>>>>> 56cb2af890dadb61e59356e87ce4466fac576d33
import bo.ucb.edu.covid_tracer_platform_backend.model.CovidData;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CovidDataDao {
    public void createCovidData(CovidData covidData);
    public Date lastDateDepartment(Integer departmentId);
    public Date lastDateCountry(Integer countryId);
    public Integer getCovidDataTotalByDepartment(Integer departmentId);
    public List<CovidDataListDepartmentRequest> covidDataHistoricListByDepartment(Integer departmentId, Integer page, Integer size);
    public List<CovidDataListDepartmentRequest> covidDataCumulativeListByDepartment(Integer departmentId, Integer page, Integer size);
    public List<CountryListRequest> listCountry();
    public List<DepartmentListRequest> listDepartament(String countryISO);
    public TotalWorldRequest getTotalWorld();

    public DepartmentListRequest getDepartament(String countryISO, String isoDepartment);

    public Date lastDateMunicipality(String  municipality);

    public List<MunicipalityListRequest> listMunicipality(String countryISO, String isoDepartment);

    public List<DepartmentHistoricRequest> getDepartmentHistoric(String countryIso, String departmentIso);
}
