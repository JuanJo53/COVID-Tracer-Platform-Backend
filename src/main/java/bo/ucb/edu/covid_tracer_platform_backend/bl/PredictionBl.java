package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.CountryDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.CovidDataDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.DataRequestDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.TransactionDao;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CountryListHistoricEveryDayRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.PredictionDateRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Country;
import bo.ucb.edu.covid_tracer_platform_backend.shared.util.prediction.PredictionAR1;
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




    public List<PredictionDateRequest> predictionList(String isoCountry, String date, Integer type) {
        List<CountryListHistoricEveryDayRequest> data = new ArrayList<>();
        data = covidDataDao.getCountryListHistoricPredict(isoCountry);

        return PredictionAR1.predictionMain(data,date,type);
    }
}
