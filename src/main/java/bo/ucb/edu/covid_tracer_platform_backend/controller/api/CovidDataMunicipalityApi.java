package bo.ucb.edu.covid_tracer_platform_backend.controller.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.CovidDataMunicipalityBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.MunicipalityListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.shared.util.TransactionUtil;
import bo.ucb.edu.covid_tracer_platform_backend.shared.util.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/data/municipality")
public class CovidDataMunicipalityApi {

    private CovidDataMunicipalityBl covidDataMunicipalityBl;
    private TransactionBl transactionBl;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataDepartmentApi.class);

    @Autowired
    public CovidDataMunicipalityApi(CovidDataMunicipalityBl covidDataMunicipalityBl, TransactionBl transactionBl) {
        this.covidDataMunicipalityBl = covidDataMunicipalityBl;
        this.transactionBl = transactionBl;
    }



    @PostMapping(path = "/{isoDepartment}/admin/{id}")
    public HttpStatus uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String isoDepartment,
                                     @PathVariable Integer id, HttpServletRequest request) {
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                Transaction transaction = TransactionUtil.createTransaction(request);
                transactionBl.createTransaction(transaction);
                covidDataMunicipalityBl.saveData(file, isoDepartment, id, transaction);

                return HttpStatus.OK;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return HttpStatus.EXPECTATION_FAILED;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(path="/{countryISO}/{departmentISO}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MunicipalityListRequest> getMunicipality(@PathVariable String countryISO, @PathVariable String departmentISO){
        List<MunicipalityListRequest> data = covidDataMunicipalityBl.getMunicipality(countryISO,departmentISO);
        return data;
    }
}
