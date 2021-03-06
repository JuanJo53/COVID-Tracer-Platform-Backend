package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DataRequestList;
import bo.ucb.edu.covid_tracer_platform_backend.shared.model.DataRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataRequestDao {
    public void createDataRequest(DataRequest dataRequest);
    public List<DataRequestList> dataRequestWorldList(Integer page, Integer size);
    public List<DataRequestList> dataRequestDepartmentList(Integer page, Integer size);
    public Integer getDataRequestTotalWorld();
    public Integer getDataRequestTotalDepartment();
}
