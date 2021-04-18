package bo.ucb.edu.covid_tracer_platform_backend.dto;

public class CountryListHistoricVaccineRequest {

    private String dateCountry;
    private Integer firstVaccine;
    private Integer secondVaccine;

    public CountryListHistoricVaccineRequest() {
    }

    public String getDateCountry() {
        return dateCountry;
    }

    public void setDateCountry(String dateCountry) {
        this.dateCountry = dateCountry;
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
                "date1='" + dateCountry + '\'' +
                ", firstVaccine=" + firstVaccine +
                ", secondVaccine=" + secondVaccine +
                '}';
    }
}
