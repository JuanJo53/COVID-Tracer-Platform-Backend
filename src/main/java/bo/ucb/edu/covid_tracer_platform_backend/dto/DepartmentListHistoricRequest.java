package bo.ucb.edu.covid_tracer_platform_backend.dto;

import java.util.List;

public class DepartmentListHistoricRequest {

    private List<DepartmentHistoricRequest> listDepartment;

    public DepartmentListHistoricRequest() {
    }

    public List<DepartmentHistoricRequest> getListDepartment() {
        return listDepartment;
    }

    public void setListDepartment(List<DepartmentHistoricRequest> listDepartment) {
        this.listDepartment = listDepartment;
    }

    @Override
    public String toString() {
        return "DepartmentListHistoricRequest{" +
                "listDepartment=" + listDepartment +
                '}';
    }
}
