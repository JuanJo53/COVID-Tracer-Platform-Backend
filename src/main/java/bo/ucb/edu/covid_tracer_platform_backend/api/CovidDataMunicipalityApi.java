package bo.ucb.edu.covid_tracer_platform_backend.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.CovidDataDepartmentBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.CovidDataMunicipalityBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.util.TransactionUtil;
import bo.ucb.edu.covid_tracer_platform_backend.util.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String isoDepartment,
                                     @PathVariable Integer id, HttpServletRequest request) {
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                Transaction transaction = TransactionUtil.createTransaction(request);
                transactionBl.createTransaction(transaction);
                covidDataMunicipalityBl.saveData(file, isoDepartment, id, transaction);

                return new ResponseEntity("Uploaded file successfully!", HttpStatus.OK);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return new ResponseEntity("Could not upload the file!", HttpStatus.EXPECTATION_FAILED);
            }
        }
        return new ResponseEntity("Please upload a csv file!", HttpStatus.BAD_REQUEST);
    }
}
