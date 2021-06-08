package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.bl.util.prediction.PredictionGrayUtil;
import bo.ucb.edu.covid_tracer_platform_backend.dao.*;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CountryListHistoricEveryDayRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DepartmentHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.PredictionDateRequest;
import bo.ucb.edu.covid_tracer_platform_backend.bl.util.prediction.PredictionAR1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PredictionBl {

    private TransactionDao transactionDao;
    private CovidDataDao covidDataDao;

    @Autowired
    public PredictionBl(TransactionDao transactionDao, CovidDataDao covidDataDao) {
        this.transactionDao = transactionDao;
        this.covidDataDao = covidDataDao;
    }




    public List<PredictionDateRequest> predictionCountryList(String isoCountry, String date) {
        List<CountryListHistoricEveryDayRequest> data = new ArrayList<>();
        data = covidDataDao.getCountryListHistoricPredict(isoCountry);

        return PredictionAR1.predictionMain(data,date);
    }

    public List<PredictionDateRequest> predictionDepartmentList(String countryISO,String departmentISO, String date) {
        List<DepartmentHistoricRequest> data = new ArrayList<>();
        data = covidDataDao.getDepartmentHistoric(countryISO,departmentISO);
        return PredictionAR1.predictionDepartmentMain(data,date);
    }

    public List<PredictionDateRequest> predictionCountryListGray(String isoCountry, String date) {
        List<CountryListHistoricEveryDayRequest> data = new ArrayList<>();
        data = covidDataDao.getCountryListHistoricPredict(isoCountry);

        return PredictionGrayUtil.predictionMain(data,date);


    }

    public List<PredictionDateRequest> predictionDepartmentListGray(String countryISO, String departmentISO, String date) {
        List<DepartmentHistoricRequest> data = new ArrayList<>();
        data = covidDataDao.getDepartmentHistoric(countryISO,departmentISO);
        return PredictionGrayUtil.predictionDepartmentMain(data,date);

    }
}
