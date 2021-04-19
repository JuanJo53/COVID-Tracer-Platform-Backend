package bo.ucb.edu.covid_tracer_platform_backend.shared.dto;

import java.util.Date;

public class DataMunicipalityCvsRequest {
    private String municipality;
    private Date date;
    private Integer totalconfirmed;
    private Integer totalassets;
    private Integer totalrecovered;
    private Integer totalDeceased;

    public DataMunicipalityCvsRequest() {
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTotalconfirmed() {
        return totalconfirmed;
    }

    public void setTotalconfirmed(Integer totalconfirmed) {
        this.totalconfirmed = totalconfirmed;
    }

    public Integer getTotalassets() {
        return totalassets;
    }

    public void setTotalassets(Integer totalassets) {
        this.totalassets = totalassets;
    }

    public Integer getTotalrecovered() {
        return totalrecovered;
    }

    public void setTotalrecovered(Integer totalrecovered) {
        this.totalrecovered = totalrecovered;
    }

    public Integer getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(Integer totalDeceased) {
        this.totalDeceased = totalDeceased;
    }


    @Override
    public String toString() {
        return "DataMunicipalityCvsRequest{" +
                "municipality='" + municipality + '\'' +
                ", date=" + date +
                ", totalconfirmed=" + totalconfirmed +
                ", totalassets=" + totalassets +
                ", totalrecovered=" + totalrecovered +
                ", totalDeceased=" + totalDeceased +
                '}';
    }
}
