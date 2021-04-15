package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.*;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataDepartmentCsvRequest;
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
import java.util.Date;
import java.util.List;

@Service
public class CovidDataDepartmentBl {
    private DataRequestDao dataRequestDao;
    private DepartmentDao departmentDao;
    private TransactionDao transactionDao;
    private CovidDataDao covidDataDao;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataDepartmentBl.class);

    @Autowired
    public CovidDataDepartmentBl(DataRequestDao dataRequestDao, DepartmentDao departmentDao, TransactionDao transactionDao, CovidDataDao covidDataDao) {
        this.dataRequestDao = dataRequestDao;
        this.departmentDao = departmentDao;
        this.transactionDao = transactionDao;
        this.covidDataDao = covidDataDao;
    }

    public void saveData(MultipartFile file, String isoDepartment, Integer userId, Transaction transaction){
        try{
            Integer departmentId = departmentDao.findDepartmentIdByIso(isoDepartment);
            Integer countryId = departmentDao.findCountryIdByDepartmentId(departmentId);
            LOGGER.error(String.valueOf(departmentId));
            LOGGER.error(String.valueOf(countryId));
            List<DataDepartmentCsvRequest> dataDepartmentCsvRequestList = CSVHelper.csvToDataCsvRequest(file.getInputStream());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date lastDate = covidDataDao.lastDateDepartment(departmentId);
            LOGGER.error("Last: "+String.valueOf(lastDate));
            if(lastDate == null){
                String aux = "1970-01-01";
                lastDate = sdf.parse(aux);
            }

            CovidData covidData = new CovidData();


            for(DataDepartmentCsvRequest data : dataDepartmentCsvRequestList){
                //LOGGER.error("entra");
                if(lastDate.before(data.getDate())){
                    //LOGGER.error(String.valueOf(data.getDate()));
                    covidData.setCountryId(countryId);
                    //LOGGER.error("Country: "+String.valueOf(covidData.getCountryId()));
                    covidData.setDepartmentId(departmentId);
                    //LOGGER.error("Department: "+String.valueOf(covidData.getDepartmentId()));
                    covidData.setConfirmed(data.getConfirmed());
                    //LOGGER.error("Confirmed: "+String.valueOf(covidData.getConfirmed()));
                    covidData.setCumulativeConfirmed(data.getCumulativeConfirmed());
                    //LOGGER.error(String.valueOf(covidData.getCumulativeConfirmed()));
                    covidData.setDead(data.getDead());
                    //LOGGER.error("Dead: "+String.valueOf(covidData.getDead()));
                    covidData.setCumulativeDead(data.getCumulativeDead());
                    //LOGGER.error(String.valueOf(covidData.getCumulativeDead()));
                    covidData.setRecovered(data.getRecovered());
                    //LOGGER.error("Recovered: "+String.valueOf(covidData.getRecovered()));
                    covidData.setCumulativeRecovered(data.getCumulativeRecovered());
                    //LOGGER.error(String.valueOf(covidData.getCumulativeRecovered()));
                    covidData.setDate(data.getDate());
                    //LOGGER.error("Date: "+String.valueOf(covidData.getDate()));
                    covidData.setTransaction(transaction);
                    //LOGGER.error("Sale dao");
                    covidDataDao.createCovidData(covidData);
                    //LOGGER.error("Despues dao");
                }
                //LOGGER.error("sale");

            }
            DataRequest dataRequest = new DataRequest();

            dataRequest.setDepartmentId(departmentId);
            dataRequest.setUserId(userId);
            dataRequest.setType(0);
            dataRequest.setTransaction(transaction);
            dataRequestDao.createDataRequest(dataRequest);


        } catch (IOException | ParseException e){
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
