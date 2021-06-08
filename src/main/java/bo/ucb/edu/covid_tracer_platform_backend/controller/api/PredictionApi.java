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

    @GetMapping(path="/{isoCountry}/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PredictionDateRequest> predictionCountryList(@PathVariable String isoCountry, @RequestParam String date){
        List<PredictionDateRequest> list = predictionBl.predictionCountryList(isoCountry,date);
        return list;
    }

    @GetMapping(path="/{countryISO}/{departmentISO}/department", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PredictionDateRequest> predictionDepartmentList(@PathVariable String countryISO,@PathVariable String departmentISO, @RequestParam String date){
        List<PredictionDateRequest> list = predictionBl.predictionDepartmentList(countryISO,departmentISO, date);
        return list;
    }


}
