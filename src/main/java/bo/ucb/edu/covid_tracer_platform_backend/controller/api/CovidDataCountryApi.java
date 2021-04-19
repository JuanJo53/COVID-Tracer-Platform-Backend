package bo.ucb.edu.covid_tracer_platform_backend.controller.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.CovidDataCountryBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.*;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CountryListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.WorldRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.shared.util.TransactionUtil;
import bo.ucb.edu.covid_tracer_platform_backend.shared.util.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/data/country")
public class CovidDataCountryApi {
    private CovidDataCountryBl covidDataCountryBl;
    private TransactionBl transactionBl;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataCountryApi.class);

    @Autowired
    public CovidDataCountryApi(CovidDataCountryBl covidDataCountryBl, TransactionBl transactionBl) {
        this.covidDataCountryBl = covidDataCountryBl;
        this.transactionBl = transactionBl;
    }

    @PostMapping(path = "/admin/{id}")
    public HttpStatus uploadFile(@RequestParam("file") MultipartFile file,
                                     @PathVariable Integer id, HttpServletRequest request) {

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                Transaction transaction = TransactionUtil.createTransaction(request);
                transactionBl.createTransaction(transaction);
                covidDataCountryBl.saveData(file,id, transaction);


                return HttpStatus.OK;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return HttpStatus.EXPECTATION_FAILED;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(path="/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryListRequest> listCountry(){
        List<CountryListRequest> data = covidDataCountryBl.listCountry();
        return data;
    }
    @GetMapping(path="/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public WorldRequest getTotalWorld(){
        WorldRequest data = covidDataCountryBl.getTotalWorld();
        return data;
    }

    @GetMapping(path="/{isoCountry}/historicList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryListHistoricEveryDayRequest> countryListHistoric(@PathVariable String isoCountry,
                                                                        @RequestParam String page, @RequestParam String size){
        List<CountryListHistoricEveryDayRequest> data = covidDataCountryBl.countryListHistoric(isoCountry,page,size);
        return data;
    }


    @GetMapping(path="/{isoCountry}/CumulativeEveryDay", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryListHistoricRequest> countryListEveryDay(@PathVariable String isoCountry,
                                                                @RequestParam String page, @RequestParam String size){
        List<CountryListHistoricRequest> data = covidDataCountryBl.countryListEveryDay(isoCountry,page,size);
        return data;
    }

    @GetMapping(path="/{isoCountry}/general", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryHistoricRequest countryHistoric(@PathVariable String isoCountry){
        CountryHistoricRequest data = covidDataCountryBl.countryHistoric(isoCountry);
        return data;
    }

    @GetMapping(path="/{list}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WorldRequest> worldList(@PathVariable String list, @RequestParam String page, @RequestParam String size){
        List<WorldRequest> data = covidDataCountryBl.covidDataListWorld(list, page, size);
        return data;
    }

    @GetMapping(path="/world/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getCovidDataTotalByDepartment(){
        Integer total = covidDataCountryBl.worldTotal();
        return total;
    }
    @GetMapping(path="/{isoCountry}/totalCases", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer worldList(@PathVariable String isoCountry) {
        Integer data = covidDataCountryBl.QuantityCasesCountry(isoCountry);
        return data;
    }
    @GetMapping(path="/{isoCountry}/download")
    public ResponseEntity<Resource> getFile(@PathVariable String isoCountry){
        String filename = "data.csv";
        InputStreamResource file = new InputStreamResource(covidDataCountryBl.load(isoCountry));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
