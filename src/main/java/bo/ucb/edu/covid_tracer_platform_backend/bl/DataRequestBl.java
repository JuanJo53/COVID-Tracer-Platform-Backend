package bo.ucb.edu.covid_tracer_platform_backend.bl;

import bo.ucb.edu.covid_tracer_platform_backend.dao.DataRequestDao;
import bo.ucb.edu.covid_tracer_platform_backend.dao.TransactionDao;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DataRequestList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRequestBl {
    private DataRequestDao dataRequestDao;
    private TransactionDao transactionDao;

    @Autowired
    public DataRequestBl(DataRequestDao dataRequestDao, TransactionDao transactionDao) {
        this.dataRequestDao = dataRequestDao;
        this.transactionDao = transactionDao;
    }

    public List<DataRequestList> dataRequestList(Integer page, Integer size){
        List<DataRequestList> list = dataRequestDao.dataRequestWorldList(page, size);
        return list;
    }

    public List<DataRequestList> dataRequestDepartmentList(Integer page, Integer size){
        List<DataRequestList> list = dataRequestDao.dataRequestDepartmentList(page, size);
        return list;
    }

    public Integer getDataRequestTotalWorld(){
        Integer total = dataRequestDao.getDataRequestTotalWorld();
        return total;
    }

    public Integer getDataRequestTotalDepartment(){
        Integer total = dataRequestDao.getDataRequestTotalDepartment();
        return total;
    }
}
