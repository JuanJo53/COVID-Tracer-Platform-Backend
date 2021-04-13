package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.DataRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataRequestDao {
    public void createDataRequest(DataRequest dataRequest);
}
