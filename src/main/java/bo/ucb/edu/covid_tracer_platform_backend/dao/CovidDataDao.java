package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.dto.DepartmentHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DepartmentListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.MunicipalityListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.*;
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

    public List<WorldRequest> covidDataHistoricWorldList(Integer page, Integer size);

    public List<WorldRequest> covidDataCumulativeWorldList(Integer page, Integer size);

    public List<WorldRequest> worldTotal();

    public List<CountryListRequest> listCountry();

    public List<DepartmentListRequest> listDepartment(String countryISO);

    public WorldRequest getTotalWorld();

    public List<DataDepartmentCsvRequest> getCovidData(Integer departmentId);

    public DepartmentListRequest getDepartment(String countryISO, String isoDepartment);

    public Date lastDateMunicipality(String  municipality);

    public List<MunicipalityListRequest> listMunicipality(String countryISO, String isoDepartment);

    public List<DepartmentHistoricRequest> getDepartmentHistoric(String countryIso, String departmentIso);

    public List<CountryListHistoricEveryDayRequest> getCountryListHistoric(String isoCountry,Integer page,Integer size);

    public List<CountryListHistoricVaccineRequest> getCountryHistoricVaccine(String isoCountry,Integer page,Integer size);

    public CountryHistoricRequest getCountryHistoric(String isoCountry,String dateCountry);

    public String getDateCovidData();

    public CountryListHistoricVaccineRequest getCountryHistoricVa(String isoCountry,String dateCountry);

    public List<CountryListHistoricRequest> getCountryCumulativeEveryDayList(String isoCountry,Integer page,Integer size);
}
