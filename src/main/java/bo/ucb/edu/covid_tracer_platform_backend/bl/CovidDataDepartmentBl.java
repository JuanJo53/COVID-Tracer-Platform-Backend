package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.*;
<<<<<<< HEAD
import bo.ucb.edu.covid_tracer_platform_backend.dto.*;
=======
import bo.ucb.edu.covid_tracer_platform_backend.dto.CovidDataListDepartmentRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataDepartmentCsvRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DepartmentListRequest;
>>>>>>> 56cb2af890dadb61e59356e87ce4466fac576d33
import bo.ucb.edu.covid_tracer_platform_backend.model.*;
import bo.ucb.edu.covid_tracer_platform_backend.util.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CovidDataDepartmentBl {
    private DataRequestDao dataRequestDao;
    private DepartmentDao departmentDao;
    private VaccineDao vaccineDao;
    private CovidDataDao covidDataDao;
    private TransactionDao transactionDao;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataDepartmentBl.class);

    @Autowired
    public CovidDataDepartmentBl(DataRequestDao dataRequestDao, DepartmentDao departmentDao, VaccineDao vaccineDao, CovidDataDao covidDataDao, TransactionDao transactionDao) {
        this.dataRequestDao = dataRequestDao;
        this.departmentDao = departmentDao;
        this.vaccineDao = vaccineDao;
        this.covidDataDao = covidDataDao;
        this.transactionDao = transactionDao;
    }

    public void saveData(MultipartFile file, String isoDepartment, Integer userId, Transaction transaction){
        try{
            Integer departmentId = departmentDao.findDepartmentIdByIso(isoDepartment);
            Integer countryId = departmentDao.findCountryIdByDepartmentId(departmentId);
            LOGGER.error(String.valueOf(departmentId));
            LOGGER.error(String.valueOf(countryId));
            List<DataDepartmentCsvRequest> dataDepartmentCsvRequestList = CSVHelper.csvToDataDepartmentCsvRequest(file.getInputStream());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date lastDateCovid = covidDataDao.lastDateDepartment(departmentId);
            Date lastDateVaccine = vaccineDao.lastDateDepartment(departmentId);
            LOGGER.error("Last: "+String.valueOf(lastDateCovid));
            LOGGER.error("Last Vaccine: "+String.valueOf(lastDateVaccine));
            if(lastDateCovid == null){
                String aux = "1970-01-01";
                lastDateCovid = sdf.parse(aux);
            }
            if(lastDateVaccine == null){
                String aux = "1970-01-01";
                lastDateVaccine = sdf.parse(aux);
            }

            CovidData covidData = new CovidData();
            Vaccine vaccine = new Vaccine();

            for(DataDepartmentCsvRequest data : dataDepartmentCsvRequestList){
                if(lastDateCovid.before(data.getDate())){
                    covidData.setCountryId(countryId);
                    covidData.setDepartmentId(departmentId);
                    covidData.setConfirmed(data.getConfirmed());
                    covidData.setCumulativeConfirmed(data.getCumulativeConfirmed());
                    covidData.setDeaths(data.getDeaths());
                    covidData.setCumulativeDeaths(data.getCumulativeDeaths());
                    covidData.setRecovered(data.getRecovered());
                    covidData.setCumulativeRecovered(data.getCumulativeRecovered());
                    covidData.setDate(data.getDate());
                    covidData.setTransaction(transaction);
                    covidDataDao.createCovidData(covidData);
                }
                if(lastDateVaccine.before(data.getDate())){
                    vaccine.setDepartmentId(departmentId);
                    vaccine.setFirstVaccine(data.getFirstVaccine());
                    vaccine.setSecondVaccine(data.getSecondVaccine());
                    vaccine.setDate(data.getDate());
                    vaccine.setTransaction(transaction);
                    vaccineDao.createVaccine(vaccine);
                }

            }
            DataRequest dataRequest = new DataRequest();

            dataRequest.setCountryId(countryId);
            dataRequest.setDepartmentId(departmentId);
            dataRequest.setUserId(userId);
            dataRequest.setType(0);
            dataRequest.setTransaction(transaction);
            dataRequestDao.createDataRequest(dataRequest);


        } catch (IOException | ParseException e){
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public Integer getCovidDataTotalByDepartment(String isoDepartment){
        Integer departmentId = departmentDao.findDepartmentIdByIso(isoDepartment);
        Integer total = covidDataDao.getCovidDataTotalByDepartment(departmentId);
        return total;
    }

    public List<CovidDataListDepartmentRequest> covidDataListDepartment(String isoDepartment, String list, Integer page, Integer size){
        Integer departmentId = departmentDao.findDepartmentIdByIso(isoDepartment);
        List<CovidDataListDepartmentRequest> data = new ArrayList<>();
        if(list.equals("historic")){
            data = covidDataDao.covidDataHistoricListByDepartment(departmentId, page, size);
        }
        if(list.equals("cumulative")){
            data = covidDataDao.covidDataCumulativeListByDepartment(departmentId, page, size);
        }
        return data;
    }


    public List<DepartmentListRequest> listDepartment(String countryISO) {
        List<DepartmentListRequest> data = new ArrayList<>();
        data = covidDataDao.listDepartament(countryISO);
        return data;
    }

    public DepartmentListRequest getDepartment(String countryISO, String isoDepartment) {
        DepartmentListRequest data = new DepartmentListRequest();
        data = covidDataDao.getDepartament(countryISO,isoDepartment);
        return data;
    }

    public List<DepartmentHistoricRequest> getDepartmentHistoric(String countryISO, String departmentISO) {
        List<DepartmentHistoricRequest> data = new ArrayList<>();
        data = covidDataDao.getDepartmentHistoric(countryISO,departmentISO);
        return data;
    }

    public List<DepartmentListHistoricRequest> getDepartmentListHistoric(String countryISO) {

        List<DepartmentListHistoricRequest> data = new ArrayList<>();
        List<String> listIso = departmentDao.departmentList(countryISO);
        for (int i=0;i<listIso.size();i++){

            DepartmentListHistoricRequest departmentListHistoricRequest = new DepartmentListHistoricRequest();
            List<DepartmentHistoricRequest> departmentHistoricRequest = covidDataDao.getDepartmentHistoric(countryISO,listIso.get(i));

            departmentListHistoricRequest.setListDepartment(departmentHistoricRequest);
            if (departmentHistoricRequest.size()>0){
                data.add(departmentListHistoricRequest);
            }
        }
        return data;
    }
}
