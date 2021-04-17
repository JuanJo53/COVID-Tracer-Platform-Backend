package bo.ucb.edu.covid_tracer_platform_backend.api;

import bo.ucb.edu.covid_tracer_platform_backend.bl.DataRequestBl;
import bo.ucb.edu.covid_tracer_platform_backend.bl.TransactionBl;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataRequestList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path="/world", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataRequestList> dataRequestWorldList(@RequestParam Integer page, @RequestParam Integer size){
        List<DataRequestList> list = dataRequestBl.dataRequestList(page, size);
        return list;
    }

    @GetMapping(path="/department", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataRequestList> dataRequestDepartmentList(@RequestParam Integer page, @RequestParam Integer size){
        List<DataRequestList> list = dataRequestBl.dataRequestDepartmentList(page, size);
        return list;
    }
}
