package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.*;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataCsvRequest;
import bo.ucb.edu.covid_tracer_platform_backend.model.*;
import bo.ucb.edu.covid_tracer_platform_backend.util.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DataRequestBl {
    private ConfirmedDao confirmedDao;
    private DataRequestDao dataRequestDao;
    private DeadDao deadDao;
    private DepartmentDao departmentDao;
    private RecoveredDao recoveredDao;
    private TransactionDao transactionDao;

    private static Logger LOGGER = LoggerFactory.getLogger(DataRequestBl.class);

    @Autowired
    public DataRequestBl(ConfirmedDao confirmedDao, DataRequestDao dataRequestDao, DeadDao deadDao, DepartmentDao departmentDao, RecoveredDao recoveredDao, TransactionDao transactionDao) {
        this.confirmedDao = confirmedDao;
        this.dataRequestDao = dataRequestDao;
        this.deadDao = deadDao;
        this.departmentDao = departmentDao;
        this.recoveredDao = recoveredDao;
        this.transactionDao = transactionDao;
    }

    public void saveData(MultipartFile file, String department, Integer userId, Transaction transaction){
        try{
            Integer departmentId = departmentDao.findDepartmentIdByDepartment(department);
            LOGGER.error(String.valueOf(departmentId));
            List<DataCsvRequest> dataCsvRequestList = CSVHelper.csvToDataCsvRequest(file.getInputStream());
            Confirmed confirmed = new Confirmed();
            Dead dead = new Dead();
            Recovered recovered = new Recovered();
            for(DataCsvRequest data : dataCsvRequestList){
                confirmed.setDate(data.getDate());
                confirmed.setCount(data.getConfirmed());
                confirmed.setCumulative(data.getCumulativeConfirmed());
                confirmed.setDepartmentId(departmentId);
                confirmed.setTransaction(transaction);
                confirmedDao.createConfirmed(confirmed);

                dead.setDate(data.getDate());
                dead.setCount(data.getDead());
                dead.setCumulative(data.getCumulativeDead());
                dead.setDepartmentId(departmentId);
                dead.setTransaction(transaction);
                deadDao.createDead(dead);

                recovered.setDate(data.getDate());
                recovered.setCount(data.getRecovered());
                recovered.setCumulative(data.getCumulativeRecovered());
                recovered.setDepartmentId(departmentId);
                recovered.setTransaction(transaction);
                recoveredDao.createRecovered(recovered);
            }
            DataRequest dataRequest = new DataRequest();

            dataRequest.setDepartmentId(departmentId);
            dataRequest.setUserId(userId);
            dataRequest.setType(0);
            dataRequest.setTransaction(transaction);
            dataRequestDao.createDataRequest(dataRequest);
        } catch (IOException e){
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
