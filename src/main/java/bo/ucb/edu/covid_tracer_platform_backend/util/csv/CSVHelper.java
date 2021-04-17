package bo.ucb.edu.covid_tracer_platform_backend.util.csv;

import bo.ucb.edu.covid_tracer_platform_backend.dto.DataCountryCsvRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataDepartmentCsvRequest;
import bo.ucb.edu.covid_tracer_platform_backend.dto.DataMunicipalityCvsRequest;
import org.apache.commons.csv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Fecha", "Casos", "Casos_Acum", "Muertes", "Muertes_Acum", "Recuperados", "Recuperados_Acum"};

    public static Logger LOGGER = LoggerFactory.getLogger(CSVHelper.class);

    public static boolean hasCSVFormat(MultipartFile file) {
        System.out.println(file.getContentType());
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<DataDepartmentCsvRequest> csvToDataDepartmentCsvRequest(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<DataDepartmentCsvRequest> dataDepartmentCsvRequestList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (CSVRecord csvRecord : csvRecords) {
                DataDepartmentCsvRequest dataDepartmentCsvRequest = new DataDepartmentCsvRequest();
                dataDepartmentCsvRequest.setDate(sdf.parse(csvRecord.get("Fecha")));
                //LOGGER.error(String.valueOf(dataCsvRequest.getDate()));
                dataDepartmentCsvRequest.setConfirmed(Integer.parseInt(csvRecord.get("Casos")));
                dataDepartmentCsvRequest.setCumulativeConfirmed(Integer.parseInt(csvRecord.get("Casos_Acum")));
                dataDepartmentCsvRequest.setDeaths(Integer.parseInt(csvRecord.get("Muertes")));
                dataDepartmentCsvRequest.setCumulativeDeaths(Integer.parseInt(csvRecord.get("Muertes_Acum")));
                dataDepartmentCsvRequest.setRecovered(Integer.parseInt(csvRecord.get("Recuperados")));
                dataDepartmentCsvRequest.setCumulativeRecovered(Integer.parseInt(csvRecord.get("Recuperados_Acum")));
                dataDepartmentCsvRequest.setFirstVaccine(Integer.parseInt(csvRecord.get("Vacunados_Prim")));
                dataDepartmentCsvRequest.setSecondVaccine(Integer.parseInt(csvRecord.get("Vacunados_Seg")));
                dataDepartmentCsvRequestList.add(dataDepartmentCsvRequest);
            }

            return dataDepartmentCsvRequestList;
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<DataCountryCsvRequest> csvToDataCountryCsvRequest(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<DataCountryCsvRequest> dataCountryCsvRequestList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (CSVRecord csvRecord : csvRecords) {
                DataCountryCsvRequest dataCountryCsvRequest = new DataCountryCsvRequest();
                dataCountryCsvRequest.setIso(csvRecord.get("iso_code"));
                dataCountryCsvRequest.setDate(sdf.parse(csvRecord.get("date")));
                dataCountryCsvRequest.setCumulativeConfirmed(Integer.parseInt(csvRecord.get("total_cases")));
                dataCountryCsvRequest.setConfirmed(Integer.parseInt(csvRecord.get("new_cases")));
                dataCountryCsvRequest.setCumulativeDeaths(Integer.parseInt(csvRecord.get("total_deaths")));
                dataCountryCsvRequest.setDeaths(Integer.parseInt(csvRecord.get("new_deaths")));
                //LOGGER.error(String.valueOf(dataCsvRequest.getDate()));
                dataCountryCsvRequestList.add(dataCountryCsvRequest);
            }

            return dataCountryCsvRequestList;
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    /*public static ByteArrayInputStream tutorialsToCSV(List<DeveloperTutorial> developerTutorialList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (DeveloperTutorial developerTutorial : developerTutorialList) {
                List<String> data = Arrays.asList(
                        String.valueOf(developerTutorial.getId()),
                        developerTutorial.getTitle(),
                        developerTutorial.getDescription(),
                        String.valueOf(developerTutorial.isPublished())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }*/

    public static List<DataMunicipalityCvsRequest> csvMunDataCsvRequest(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<DataMunicipalityCvsRequest> dataMunicipalityCvsRequestList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (CSVRecord csvRecord : csvRecords) {

                DataMunicipalityCvsRequest dataMunicipalityCvsRequest = new DataMunicipalityCvsRequest();
                //dataMunicipalityCvsRequest.setDate(sdf.parse(csvRecord.get("Fecha")));
                dataMunicipalityCvsRequest.setMunicipality(csvRecord.get("Municipio"));
                dataMunicipalityCvsRequest.setDate(sdf.parse(csvRecord.get("Fecha")));
                dataMunicipalityCvsRequest.setTotalconfirmed(Integer.parseInt(csvRecord.get("Total_confirmados")));
                dataMunicipalityCvsRequest.setTotalassets(Integer.parseInt(csvRecord.get("Total_activos")));
                dataMunicipalityCvsRequest.setTotalrecovered(Integer.parseInt(csvRecord.get("Total_recuperado")));
                dataMunicipalityCvsRequest.setTotalDeceased(Integer.parseInt(csvRecord.get("Total_fallecido")));
                dataMunicipalityCvsRequestList.add(dataMunicipalityCvsRequest);

            }
            return dataMunicipalityCvsRequestList;
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
