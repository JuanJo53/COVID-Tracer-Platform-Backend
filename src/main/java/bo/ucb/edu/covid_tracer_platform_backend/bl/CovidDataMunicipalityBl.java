package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.*;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataMunicipalityCvsRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.MunicipalityListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.model.CovidData;
import bo.ucb.edu.covid_tracer_platform_backend.model.DataRequest;
import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;
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
import java.util.stream.Collectors;

@Service
public class CovidDataMunicipalityBl {


    private TransactionDao transactionDao;
    private MunicipalityDao municipalityDao;
    private CovidDataDao covidDataDao;
    private DepartmentDao departmentDao;
    private DataRequestDao dataRequestDao;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataDepartmentBl.class);
    @Autowired
    public CovidDataMunicipalityBl(TransactionDao transactionDao, MunicipalityDao municipalityDao, CovidDataDao covidDataDao, DepartmentDao departmentDao, DataRequestDao dataRequestDao) {
        this.transactionDao = transactionDao;
        this.municipalityDao = municipalityDao;
        this.covidDataDao = covidDataDao;
        this.departmentDao = departmentDao;
        this.dataRequestDao = dataRequestDao;
    }






    public void saveData(MultipartFile file, String iso, Integer userId, Transaction transaction){
        try{

            Integer departmentId=departmentDao.findDepartmentIdByIso(iso);
            List<String> municipalityList = municipalityDao.municipalityList(departmentId);
            Integer countryId = departmentDao.findCountryIdByDepartmentId(departmentId);
            LOGGER.error(String.valueOf(departmentId));
            List<DataMunicipalityCvsRequest> dataMunicipalityCvsRequest = CSVHelper.csvMunDataCsvRequest(file.getInputStream());
            for (int i=0;i<municipalityList.size();i++){
                String municipality=municipalityList.get(i);
                List<DataMunicipalityCvsRequest> dataMunicipalityCvsList = dataMunicipalityCvsRequest.stream()
                        .filter(x -> x.getMunicipality().equals(municipality))
                        .collect(Collectors.toList());
                Integer municipalityId = municipalityDao.findMunicipalityIdByMunicipality(municipality,departmentId);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date lastDate = covidDataDao.lastDateMunicipality(municipality);
                LOGGER.error("Last: "+String.valueOf(lastDate));
                if(lastDate == null){
                    String aux = "1970-01-01";
                    lastDate = sdf.parse(aux);
                }
                CovidData covidData= new CovidData();
                for (DataMunicipalityCvsRequest data: dataMunicipalityCvsList){
                    if (lastDate.before(data.getDate())){
                        covidData.setCountryId(countryId);
                        covidData.setDepartmentId(departmentId);
                        covidData.setMunicipalityId(municipalityId);
                        covidData.setCumulativeConfirmed(data.getTotalconfirmed());
                        covidData.setCumulativeDeaths(data.getTotalDeceased());
                        covidData.setCumulativeRecovered(data.getTotalrecovered());
                        covidData.setDate(data.getDate());
                        //sacar id de muni
                        covidData.setTransaction(transaction);

                        covidDataDao.createCovidData(covidData);
                    }

                }


                DataRequest dataRequest = new DataRequest();

                dataRequest.setCountryId(countryId);
                dataRequest.setDepartmentId(departmentId);
                dataRequest.setUserId(userId);
                dataRequest.setMunicipalityId(municipalityId);
                dataRequest.setType(0);
                dataRequest.setTransaction(transaction);
                dataRequestDao.createDataRequest(dataRequest);
            }



        } catch (IOException | ParseException e){
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<MunicipalityListRequest> getMunicipality(String countryISO, String departmentISO) {
        return covidDataDao.listMunicipality(countryISO,departmentISO);
    }
}
