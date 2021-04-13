package bo.ucb.edu.covid_tracer_platform_backend.util.csv;

import bo.ucb.edu.covid_tracer_platform_backend.dto.DataCsvRequest;
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

    public static List<DataCsvRequest> csvToDataCsvRequest(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<DataCsvRequest> dataCsvRequestList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (CSVRecord csvRecord : csvRecords) {
                DataCsvRequest dataCsvRequest = new DataCsvRequest();
                dataCsvRequest.setDate(sdf.parse(csvRecord.get("Fecha")));
                //LOGGER.error(String.valueOf(dataCsvRequest.getDate()));
                dataCsvRequest.setConfirmed(Integer.parseInt(csvRecord.get("Casos")));
                dataCsvRequest.setCumulativeConfirmed(Integer.parseInt(csvRecord.get("Casos_Acum")));
                dataCsvRequest.setDead(Integer.parseInt(csvRecord.get("Muertes")));
                dataCsvRequest.setCumulativeDead(Integer.parseInt(csvRecord.get("Muertes_Acum")));
                dataCsvRequest.setRecovered(Integer.parseInt(csvRecord.get("Recuperados")));
                dataCsvRequest.setCumulativeRecovered(Integer.parseInt(csvRecord.get("Recuperados_Acum")));
                dataCsvRequestList.add(dataCsvRequest);
            }

            return dataCsvRequestList;
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
}
