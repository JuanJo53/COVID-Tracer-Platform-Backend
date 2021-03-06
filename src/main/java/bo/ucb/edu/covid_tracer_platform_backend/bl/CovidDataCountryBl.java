package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.CountryDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.CovidDataDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.DataRequestDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.TransactionDao;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.*;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.CovidData;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.DataRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.bl.util.csv.CSVHelper;
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


    // Funcion para guardar datos de los países
    public void saveData(MultipartFile file, Integer userId, Transaction transaction){
        try{
            // Enviando el inputStream del csv a CSVHelper
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
                //Obteniendo la última fecha de datos registrados de un país
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
                    // Comparando las fechas. Si las fechas del csv soin posteriores a la ultima fecha registrada se registran los datos
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

    // Funcion para calcular el toal mundial de contagiados
    public List<CountryListRequest> listCountry(){
        List<CountryListRequest> countries = covidDataDao.listCountry();
        Integer total = 0;
        for(int i=0; i<countries.size();i++){
            total += countries.get(i).getCumulativeConfirmed();
        }
        LOGGER.error(String.valueOf(total));
        return countries;
    }

    // Función para obtener los datos totales del mundo
    public WorldRequest getTotalWorld(){
        WorldRequest total = covidDataDao.getTotalWorld();
        return total;
    }
    // Función para obtener los datos históricos de un país
    public List<CountryListHistoricEveryDayRequest> countryListHistoric(String isoCountry,String page, String size) {
        List<CountryListHistoricEveryDayRequest> data = new ArrayList<>();
        if(isNumeric(page) && isNumeric(size)){
            data = covidDataDao.getCountryListHistoric(isoCountry, Integer.parseInt(page), Integer.parseInt(size));
        }
        if(!isNumeric(page) && !isNumeric(size)){
            data = covidDataDao.getCountryListHistoricDate(isoCountry, page, size);
        }

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
    // Funcion para obtener los datos acumulados de un país
    public List<CountryListHistoricRequest> countryListEveryDay(String isoCountry,String page,String size) {
        List<CountryListHistoricRequest> data = new ArrayList<>();
        List<CountryListHistoricVaccineRequest> countryListHistoricVaccineRequest = new ArrayList<>();
        if(isNumeric(page) && isNumeric(size)){
            data = covidDataDao.getCountryCumulativeEveryDayList(isoCountry,Integer.parseInt(page),Integer.parseInt(size));
            countryListHistoricVaccineRequest = covidDataDao.getCountryHistoricVaccine(isoCountry,Integer.parseInt(page),Integer.parseInt(size));
        }
        if(!isNumeric(page) && !isNumeric(size)){
            data = covidDataDao.getCountryCumulativeEveryDayListDate(isoCountry,page,size);
            countryListHistoricVaccineRequest = covidDataDao.getCountryHistoricVaccineDate(isoCountry,page,size);
        }



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

    // Función que obteniene los datos acumulados o historicos a nivel mundial
    public List<WorldRequest> covidDataListWorld(String list, String page, String size){
        List<WorldRequest> data = new ArrayList<>();
        if(isNumeric(page) && isNumeric(size)){
            if(list.equals("historic")){
                data = covidDataDao.covidDataHistoricWorldList(Integer.parseInt(page), Integer.parseInt(size));
            }
            if(list.equals("cumulative")){
                data = covidDataDao.covidDataCumulativeWorldList(Integer.parseInt(page), Integer.parseInt(size));
            }
        }
        if(!isNumeric(page) && !isNumeric(size)){
            if(list.equals("historic")){
                data = covidDataDao.covidDataHistoricWorldListDate(page, size);
            }
            if(list.equals("cumulative")){
                data = covidDataDao.covidDataCumulativeWorldListDate(page, size);
            }
        }

        return data;
    }

    // Funcion para comprobar si un string se puede tranformar a Integer
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    // Funcion para obtener la cantidad de datos registrados en el mundo
    public Integer worldTotal(){
        Integer total = covidDataDao.worldTotal().size();
        return total;
    }
    // Funcion para obtener la cantidad de casos registrados en un país
    public Integer QuantityCasesCountry(String isoCountry) {
        Integer quantity = countryDao.quantityCasesCountry(isoCountry).size();
        return quantity;
    }
    // Funcion para descargar los datos de un país en un archivos csv
    public ByteArrayInputStream load(String isoCountry){
        Integer cant = 1000;
        List<CountryListHistoricRequest> c1 = countryListEveryDay(isoCountry,"0", String.valueOf(cant));
        List<CountryListHistoricEveryDayRequest> c2 = countryListHistoric(isoCountry,"0", String.valueOf(cant));

        ByteArrayInputStream in = CSVHelper.covidDataCountryToCSV(c2, c1);
        return in;
    }
}
