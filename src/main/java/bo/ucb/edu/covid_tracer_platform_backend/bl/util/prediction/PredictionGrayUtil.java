package bo.ucb.edu.covid_tracer_platform_backend.bl.util.prediction;

import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CountryListHistoricEveryDayRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DepartmentHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.PredictionDateRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PredictionGrayUtil {
    private double a0, a1, a2;
    private int size;
    private double error;

    public PredictionGrayUtil() {
    }

    public static List<PredictionDateRequest> predictionMain(List<CountryListHistoricEveryDayRequest> data, String date) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fin = null;
        try {

            fin = formatoDelTexto.parse(date);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        Calendar c = Calendar.getInstance();
        Date dateInicio = new Date();
        List<PredictionDateRequest> predictionDateRequests = new ArrayList<>();
        List<Integer> listsConfirmed = new ArrayList<>();
        List<Integer> listsDeaths = new ArrayList<>();
        List<Integer> listsRecovered = new ArrayList<>();
        for (int i=0;i<data.size();i++){
            CountryListHistoricEveryDayRequest countrydata = new CountryListHistoricEveryDayRequest();
            countrydata = data.get(i);
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();

            predictionDateRequest.setDate(countrydata.getDateCountry());
            predictionDateRequest.setStatus(0);



            dateInicio=countrydata.getDateCountry(); // fecha inicio
            //Casos
            if (countrydata.getConfirmed()>0){
                listsConfirmed.add(countrydata.getConfirmed());
            }
            if (countrydata.getDeaths()>0){
                listsDeaths.add(countrydata.getDeaths());
            }
            if (countrydata.getRecovered()>0){
                listsRecovered.add(countrydata.getRecovered());
            }
            predictionDateRequest.setConfirmed(countrydata.getConfirmed());
            predictionDateRequest.setDeaths(countrydata.getDeaths());
            predictionDateRequest.setRecovered(countrydata.getRecovered());

            predictionDateRequests.add(predictionDateRequest);
            c.setTime(countrydata.getDateCountry());
        }
        int milisecondsByDay = 86400000;
        int dias = (int) ((fin.getTime()-dateInicio.getTime()) / milisecondsByDay);


        double [] vector=new double[listsConfirmed.size()];
        double [] vector1=new double[listsDeaths.size()];
        double [] vector2=new double[listsRecovered.size()];
        for (int i=0;i<listsConfirmed.size();i++){
            vector[i]=listsConfirmed.get(i);
        }
        for (int i=0;i<listsDeaths.size();i++){
            vector1[i]=listsDeaths.get(i);
        }
        for (int i=0;i<listsRecovered.size();i++){
            vector2[i]=listsRecovered.get(i);
        }
        PredictionGrayUtil gs1 = new PredictionGrayUtil();
        gs1.build(vector);
        PredictionGrayUtil gs2 = new PredictionGrayUtil();
        gs2.build(vector1);
        PredictionGrayUtil gs3 = new PredictionGrayUtil();
        gs3.build(vector2);
        for (int i = 0; i < dias; i++) {
            c.add(Calendar.DATE, 1);
            Date dt = c.getTime();
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();
            predictionDateRequest.setConfirmed((int) gs1.nextValue(i));
            predictionDateRequest.setDeaths((int) gs2.nextValue(i));
            predictionDateRequest.setRecovered((int) gs3.nextValue(i));
            predictionDateRequest.setDate(dt);
            predictionDateRequest.setStatus(1);
            predictionDateRequests.add(predictionDateRequest);
        }

        return predictionDateRequests;
    }


    public static List<PredictionDateRequest> predictionDepartmentMain(List<DepartmentHistoricRequest> data, String date) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fin = null;
        try {

            fin = formatoDelTexto.parse(date);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        Calendar c = Calendar.getInstance();
        Date dateInicio = new Date();
        List<PredictionDateRequest> predictionDateRequests = new ArrayList<>();
        List<Integer> listsConfirmed = new ArrayList<>();
        List<Integer> listsDeaths = new ArrayList<>();
        List<Integer> listsRecovered = new ArrayList<>();
        for (int i=0;i<data.size();i++){
            DepartmentHistoricRequest departmentdata = new DepartmentHistoricRequest();
            departmentdata = data.get(i);
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();

            predictionDateRequest.setDate(departmentdata.getDate1());
            predictionDateRequest.setStatus(0);



            dateInicio=departmentdata.getDate1(); // fecha inicio
            //Casos
            if (departmentdata.getConfirmed()>0){
                listsConfirmed.add(departmentdata.getConfirmed());
            }
            if (departmentdata.getDeaths()>0){
                listsDeaths.add(departmentdata.getDeaths());
            }
            if (departmentdata.getRecovered()>0){
                listsRecovered.add(departmentdata.getRecovered());
            }
            predictionDateRequest.setConfirmed(departmentdata.getConfirmed());
            predictionDateRequest.setDeaths(departmentdata.getDeaths());
            predictionDateRequest.setRecovered(departmentdata.getRecovered());


            predictionDateRequests.add(predictionDateRequest);
            c.setTime(departmentdata.getDate1());
        }
        int milisecondsByDay = 86400000;
        int dias = (int) ((fin.getTime()-dateInicio.getTime()) / milisecondsByDay);


        double [] vector=new double[listsConfirmed.size()];
        double [] vector1=new double[listsDeaths.size()];
        double [] vector2=new double[listsRecovered.size()];
        for (int i=0;i<listsConfirmed.size();i++){
            vector[i]=listsConfirmed.get(i);
        }
        for (int i=0;i<listsDeaths.size();i++){
            vector1[i]=listsDeaths.get(i);
        }
        for (int i=0;i<listsRecovered.size();i++){
            vector2[i]=listsRecovered.get(i);
        }
        PredictionGrayUtil gs1 = new PredictionGrayUtil();
        gs1.build(vector);
        PredictionGrayUtil gs2 = new PredictionGrayUtil();
        gs2.build(vector1);
        PredictionGrayUtil gs3 = new PredictionGrayUtil();
        gs3.build(vector2);
        for (int i = 0; i < dias; i++) {
            c.add(Calendar.DATE, 1);
            Date dt = c.getTime();
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();
            predictionDateRequest.setConfirmed((int) gs1.nextValue(i));
            predictionDateRequest.setDeaths((int) gs2.nextValue(i));
            predictionDateRequest.setRecovered((int) gs3.nextValue(i));
            predictionDateRequest.setDate(dt);
            predictionDateRequest.setStatus(1);
            predictionDateRequests.add(predictionDateRequest);
        }
        return predictionDateRequests;
    }

    public void build(double[] x0) {
        size = x0.length;
        double[] x1 = new double[size];
        x1[0] = x0[0];
        for (int i = 1; i < size; i++) {
            x1[i] = x0[i] + x1[i - 1];
        }
        double[][] b = new double[size - 1][2];
        double[][] bt = new double[2][size - 1];
        double[][] y = new double[size - 1][1];
        for (int i = 0; i < b.length; i++) {
            b[i][0] = -(x1[i] + x1[i + 1]) / 2;
            b[i][1] = 1;
            bt[0][i] = b[i][0];
            bt[1][i] = 1;
            y[i][0] = x0[i + 1];
        }
        double[][] t = new double[2][2];
        multiply(bt, b, t);
        t = inverse(t);
        double[][] t1 = new double[2][size - 1];
        multiply(t, bt, t1);
        double[][] t2 = new double[2][1];
        multiply(t1, y, t2);
        a0 = t2[0][0];
        double u = t2[1][0];
        a2 = u / a0;
        a1 = x0[0] - a2;
        a0 = -a0;
        error = 0;
        for (int i = 0; i < x0.length; i++) {
            double d = (x0[i] - getX0(i));
            error += d * d;
        }
        error /= x0.length;
    }

    public double getError() {
        return error;
    }

    double getX1(int k) {
        return a1 * Math.exp(a0 * k) + a2;
    }

    double getX0(int k) {
        // return a0 * a1 * Math.exp(a0 * k);
        if (k == 0)
            return a1 * Math.exp(a0 * k) + a2;
        else
            return a1 * (Math.exp(a0 * k) - Math.exp(a0 * (k - 1)));
    }

    public double nextValue(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();
        return getX0(size + index);
    }

    public double nextValue() {
        return nextValue(0);
    }

    static double[][] inverse(double[][] t) {
        double[][] a = new double[2][2];
        double det = t[0][0] * t[1][1] - t[0][1] * t[1][0];
        a[0][0] = t[1][1] / det;
        a[0][1] = -t[1][0] / det;
        a[1][0] = -t[0][1] / det;
        a[1][1] = t[0][0] / det;
        return a;
    }

    static void multiply(double[][] left, double[][] right, double[][] dest) {
        int n1 = left.length;
        int m1 = left[0].length;
        int m2 = right[0].length;
        for (int k = 0; k < n1; k++) {
            for (int s = 0; s < m2; s++) {
                dest[k][s] = 0;
                for (int i = 0; i < m1; i++) {
                    dest[k][s] += left[k][i] * right[i][s];
                }
            }
        }
    }


}
