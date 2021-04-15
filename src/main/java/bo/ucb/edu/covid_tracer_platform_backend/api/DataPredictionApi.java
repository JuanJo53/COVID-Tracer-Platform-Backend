package bo.ucb.edu.covid_tracer_platform_backend.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.DataPredictionBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dataPrediction")
public class DataPredictionApi {
    private DataPredictionBl dataPredictionBl;
    private TransactionBl transactionBl;


    /*@Autowired
    public DataPredictionApi(DataPredictionBl dataPredictionBl, TransactionBl transactionBl) {
        this.dataPredictionBl = dataPredictionBl;
        this.transactionBl = transactionBl;
    }*/


}
