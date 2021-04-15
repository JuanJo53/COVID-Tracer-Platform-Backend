package bo.ucb.edu.covid_tracer_platform_backend.dao;

import bo.ucb.edu.covid_tracer_platform_backend.model.Municipality;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MunicipalityDao {
    public void createMunicipality(Municipality municipality);
}
