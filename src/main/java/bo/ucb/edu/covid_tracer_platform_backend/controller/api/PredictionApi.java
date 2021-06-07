package bo.ucb.edu.covid_tracer_platform_backend.controller.api;
import bo.ucb.edu.covid_tracer_platform_backend.bl.PredictionBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CountryListHistoricEveryDayRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.PredictionDateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/data/prediction")
public class PredictionApi {

    private PredictionBl predictionBl;
    private TransactionBl transactionBl;

    @Autowired
    public PredictionApi(PredictionBl predictionBl, TransactionBl transactionBl) {
        this.predictionBl = predictionBl;
        this.transactionBl = transactionBl;
    }

    @GetMapping(path="/{isoCountry}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PredictionDateRequest> predictionCountryList(@PathVariable String isoCountry, @RequestParam String date, @RequestParam Integer type){
        List<PredictionDateRequest> list = predictionBl.predictionList(isoCountry, date,type);
        return list;
    }


}
