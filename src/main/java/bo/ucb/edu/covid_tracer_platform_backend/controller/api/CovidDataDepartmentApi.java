package bo.ucb.edu.covid_tracer_platform_backend.controller.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.CovidDataDepartmentBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DepartmentHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DepartmentListHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CovidDataListDepartmentRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DepartmentListRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.bl.util.TransactionUtil;
import bo.ucb.edu.covid_tracer_platform_backend.bl.util.csv.CSVHelper;
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
@RequestMapping(value = "/api/v1/data/department")
public class CovidDataDepartmentApi {
    private CovidDataDepartmentBl covidDataDepartmentBl;
    private TransactionBl transactionBl;

    private static Logger LOGGER = LoggerFactory.getLogger(CovidDataDepartmentApi.class);

    @Autowired
    public CovidDataDepartmentApi(CovidDataDepartmentBl covidDataDepartmentBl, TransactionBl transactionBl) {
        this.covidDataDepartmentBl = covidDataDepartmentBl;
        this.transactionBl = transactionBl;
    }
    @PostMapping(path = "/{isoDepartment}/admin/{id}")
    public HttpStatus uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String isoDepartment,
                                     @PathVariable Integer id, HttpServletRequest request) {

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                Transaction transaction = TransactionUtil.createTransaction(request);
                transactionBl.createTransaction(transaction);
                covidDataDepartmentBl.saveData(file, isoDepartment, id, transaction);

                return HttpStatus.OK;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return HttpStatus.EXPECTATION_FAILED;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(path="/{isoDepartment}/total", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getCovidDataTotalByDepartment(@PathVariable String isoDepartment){
        Integer total = covidDataDepartmentBl.getCovidDataTotalByDepartment(isoDepartment);
        return total;
    }

    @GetMapping(path="/{isoDepartment}/{list}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CovidDataListDepartmentRequest> covidDataListDepartment(@PathVariable String isoDepartment, @PathVariable String list,
                                                                        @RequestParam String page, @RequestParam String size){
        List<CovidDataListDepartmentRequest> data = covidDataDepartmentBl.covidDataListDepartment(isoDepartment, list, page, size);
        return data;
    }


    @GetMapping(path="/{countryISO}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentListRequest> listDepartment(@PathVariable String countryISO){
        List<DepartmentListRequest> data = covidDataDepartmentBl.listDepartment(countryISO);
        return data;
    }
    @GetMapping(path="/{countryISO}/{departmentISO}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentListRequest getDepartment(@PathVariable String countryISO,@PathVariable String departmentISO){
        DepartmentListRequest data = covidDataDepartmentBl.getDepartment(countryISO,departmentISO);
        return data;
    }


    @GetMapping(path="/{countryISO}/{departmentISO}/historic", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentHistoricRequest> getDepartmentHistoric(@PathVariable String countryISO, @PathVariable String departmentISO){
        List<DepartmentHistoricRequest>  data = covidDataDepartmentBl.getDepartmentHistoric(countryISO,departmentISO);
        return data;
    }

    @GetMapping(path="/{countryISO}/list/historic", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentListHistoricRequest> getDepartmentListHistoric(@PathVariable String countryISO){
        List<DepartmentListHistoricRequest>  data = covidDataDepartmentBl.getDepartmentListHistoric(countryISO);
        return data;
    }

    @GetMapping(path="/{isoDepartment}/download")
    public ResponseEntity<Resource> getFile(@PathVariable String isoDepartment){
        String filename = "data.csv";
        InputStreamResource file = new InputStreamResource(covidDataDepartmentBl.load(isoDepartment));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
