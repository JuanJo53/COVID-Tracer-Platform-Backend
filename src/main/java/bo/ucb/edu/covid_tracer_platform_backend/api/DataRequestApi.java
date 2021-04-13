package bo.ucb.edu.covid_tracer_platform_backend.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.DataRequestBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.model.Transaction;
import bo.ucb.edu.covid_tracer_platform_backend.util.TransactionUtil;
import bo.ucb.edu.covid_tracer_platform_backend.util.csv.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/data")
public class DataRequestApi {
    private DataRequestBl dataRequestBl;
    private TransactionBl transactionBl;

    @Autowired
    public DataRequestApi(DataRequestBl dataRequestBl, TransactionBl transactionBl) {
        this.dataRequestBl = dataRequestBl;
        this.transactionBl = transactionBl;
    }
    @PostMapping(path = "/{department}/admin/{id}")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String department,
                                     @PathVariable Integer id, HttpServletRequest request) {

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                Transaction transaction = TransactionUtil.createTransaction(request);
                transactionBl.createTransaction(transaction);
                dataRequestBl.saveData(file, department, id, transaction);

                /*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/csv/download/")
                        .path(file.getOriginalFilename())
                        .toUriString();*/

                return new ResponseEntity("Uploaded file successfully!",HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Could not upload the file!", HttpStatus.EXPECTATION_FAILED);
            }
        }
        return new ResponseEntity("Please upload a csv file!", HttpStatus.BAD_REQUEST);
    }
}
