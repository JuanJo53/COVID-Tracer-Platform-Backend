package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.CountryDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.CovidDataDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.DataRequestDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.TransactionDao;
import bo.ucb.edu.covid_tracer_platform_backend.dto.*;
import bo.ucb.edu.covid_tracer_platform_backend.model.CovidData;
import bo.ucb.edu.covid_tracer_platform_backend.model.DataRequest;
import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.util.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidDataCountryBl {
    private DataRequestDao dataRequestDao;
    private CountryDao countryDao;
    private CovidDataDao covidDataDao;
    private TransactionDao transactionDao;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataCountryBl.class);

    @Autowired
    public CovidDataCountryBl(DataRequestDao dataRequestDao, CountryDao countryDao, CovidDataDao covidDataDao, TransactionDao transactionDao) {
        this.dataRequestDao = dataRequestDao;
        this.countryDao = countryDao;
        this.covidDataDao = covidDataDao;
        this.transactionDao = transactionDao;
    }

    public void saveData(MultipartFile file, Integer userId, Transaction transaction){
        try{
            List<DataCountryCsvRequest> dataDepartmentCsvRequestList = CSVHelper.csvToDataCountryCsvRequest(file.getInputStream());
            List<String> iso = countryDao.getIsoList();
            LOGGER.error(String.valueOf(iso.size()));
            LOGGER.error(String.valueOf(dataDepartmentCsvRequestList.size()));
            for(int i=0; i< iso.size(); i++){
                String isoS = iso.get(i);

                List<DataCountryCsvRequest> filter = dataDepartmentCsvRequestList.stream()
                                                     .filter(x -> x.getIso().equals(isoS))
                                                     .collect(Collectors.toList());
                Integer countryId = countryDao.findCountryIdByIso(isoS);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date lastDate = covidDataDao.lastDateCountry(countryId);
                LOGGER.error("Last: "+String.valueOf(lastDate));
                if(lastDate == null){
                    String aux = "1970-01-01";
                    lastDate = sdf.parse(aux);
                }

                CovidData covidData = new CovidData();
                String pastDate = "2021-03-28";
                Date pastDateAux = sdf.parse(pastDate);
                for(DataCountryCsvRequest data: filter){
                    if(pastDateAux.after(data.getDate()) && lastDate.before(data.getDate())){
                    //if(lastDate.before(data.getDate())){
                        covidData.setCountryId(countryId);
                        covidData.setConfirmed(data.getConfirmed());
                        covidData.setCumulativeConfirmed(data.getCumulativeConfirmed());
                        covidData.setDeaths(data.getDeaths());
                        covidData.setCumulativeDeaths(data.getCumulativeDeaths());
                        covidData.setDate(data.getDate());
                        covidData.setTransaction(transaction);
                        covidDataDao.createCovidData(covidData);
                    }
                }
                LOGGER.error(isoS + " " + String.valueOf(countryId));
                LOGGER.error(String.valueOf(filter.size()));
                DataRequest dataRequest = new DataRequest();

                dataRequest.setCountryId(countryId);
                dataRequest.setUserId(userId);
                dataRequest.setType(0);
                dataRequest.setTransaction(transaction);
                dataRequestDao.createDataRequest(dataRequest);
            }
        } catch (IOException | ParseException e){
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<CountryListRequest> listCountry(){
        List<CountryListRequest> countries = covidDataDao.listCountry();
        Integer total = 0;
        for(int i=0; i<countries.size();i++){
            total += countries.get(i).getCumulativeConfirmed();
        }
        LOGGER.error(String.valueOf(total));
        return countries;
    }

    public WorldRequest getTotalWorld(){
        WorldRequest total = covidDataDao.getTotalWorld();
        return total;
    }

    public List<CountryListHistoricEveryDayRequest> countryListHistoric(String isoCountry,Integer page, Integer size) {
        List<CountryListHistoricEveryDayRequest> data = new ArrayList<>();
        data = covidDataDao.getCountryListHistoric(isoCountry, page, size);

        return data;
    }



    public CountryHistoricRequest countryHistoric(String isoCountry) {
        CountryHistoricRequest countryHistoricRequest =new CountryHistoricRequest();
        String dateCountry = covidDataDao.getDateCovidData();
        System.out.println(dateCountry);
        countryHistoricRequest = covidDataDao.getCountryHistoric(isoCountry,dateCountry);
        CountryListHistoricVaccineRequest covi = covidDataDao.getCountryHistoricVa(isoCountry,dateCountry);
        countryHistoricRequest.setFirstVaccine(covi.getFirstVaccine());
        countryHistoricRequest.setSecondVaccine(covi.getSecondVaccine());
        return countryHistoricRequest;
    }

    public List<CountryListHistoricRequest> countryListEveryDay(String isoCountry,Integer page,Integer size) {
        List<CountryListHistoricRequest> data = new ArrayList<>();
        data = covidDataDao.getCountryCumulativeEveryDayList(isoCountry,page,size);
        List<CountryListHistoricVaccineRequest> countryListHistoricVaccineRequest = new ArrayList<>();
        countryListHistoricVaccineRequest = covidDataDao.getCountryHistoricVaccine(isoCountry,page,size);
        List<CountryListHistoricRequest> dataFinal = new ArrayList<>();
        for(int i=0;i<data.size();i++){
            CountryListHistoricRequest countryListHistoricRequest = new CountryListHistoricRequest();
            countryListHistoricRequest=data.get(i);
            CountryListHistoricVaccineRequest countryListHistoricVaccineRequest1=new CountryListHistoricVaccineRequest();
            countryListHistoricVaccineRequest1=countryListHistoricVaccineRequest.get(i);
            countryListHistoricRequest.setFirstVaccine(countryListHistoricVaccineRequest1.getFirstVaccine());
            countryListHistoricRequest.setSecondVaccine(countryListHistoricVaccineRequest1.getSecondVaccine());
            dataFinal.add(countryListHistoricRequest);

        }
        return dataFinal;
    }

    public List<WorldRequest> covidDataListWorld(String list, Integer page, Integer size){
        List<WorldRequest> data = new ArrayList<>();
        if(list.equals("historic")){
            data = covidDataDao.covidDataHistoricWorldList(page, size);
        }
        if(list.equals("cumulative")){
            data = covidDataDao.covidDataCumulativeWorldList(page, size);
        }
        return data;
    }

    public Integer worldTotal(){
        Integer total = covidDataDao.worldTotal().size();
        return total;
    }
    public ByteArrayInputStream load(String isoCountry){
        List<CountryListHistoricRequest> c1 = countryListEveryDay(isoCountry);
        List<CountryListHistoricEveryDayRequest> c2 = countryListHistoric(isoCountry);

        ByteArrayInputStream in = CSVHelper.covidDataCountryToCSV(c2, c1);
        return in;
    }
}
