package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class CountryListHistoricVaccineRequest {

    private String date1;
    private Integer firstVaccine;
    private Integer secondVaccine;

    public CountryListHistoricVaccineRequest() {
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public Integer getFirstVaccine() {
        return firstVaccine;
    }

    public void setFirstVaccine(Integer firstVaccine) {
        this.firstVaccine = firstVaccine;
    }

    public Integer getSecondVaccine() {
        return secondVaccine;
    }

    public void setSecondVaccine(Integer secondVaccine) {
        this.secondVaccine = secondVaccine;
    }

    @Override
    public String toString() {
        return "CountryListHistoricVaccineRequest{" +
                "date1='" + date1 + '\'' +
                ", firstVaccine=" + firstVaccine +
                ", secondVaccine=" + secondVaccine +
                '}';
    }
}
