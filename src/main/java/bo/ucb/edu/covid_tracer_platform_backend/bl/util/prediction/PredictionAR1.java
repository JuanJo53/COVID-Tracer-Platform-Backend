package bo.ucb.edu.covid_tracer_platform_backend.bl.util.prediction;

import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.CountryListHistoricEveryDayRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.DepartmentHistoricRequest;
import bo.ucb.edu.covid_tracer_platform_backend.shared.dto.PredictionDateRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PredictionAR1 {

    public static List<PredictionDateRequest> predictionDepartmentMain(List<DepartmentHistoricRequest> data, String date, Integer type) {
        // Creo los LocalDate
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fin = null;
        try {

            fin = formatoDelTexto.parse(date);

        } catch (ParseException ex) {

            ex.printStackTrace();

        } // Usando ChronoUnit, calculo el numero de dias
        Calendar c = Calendar.getInstance();
        //sacar la cantidad
        int con=data.size();
        LocalDate inicio=null;
        Date dateInicio = new Date();
        List<PredictionDateRequest> predictionDateRequests = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        for (int i=0;i<data.size();i++){
            DepartmentHistoricRequest departmentdata = new DepartmentHistoricRequest();
            departmentdata = data.get(i);
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();

            predictionDateRequest.setDate(departmentdata.getDate1());
            predictionDateRequest.setStatus(0);



            dateInicio=departmentdata.getDate1(); // fecha inicio
            if (type==0){//Casos
                if (departmentdata.getConfirmed()>0){
                    lists.add(departmentdata.getConfirmed());
                }
                predictionDateRequest.setCount(departmentdata.getConfirmed());
            }
            if (type==1){//Muertos
                if (departmentdata.getDeaths()>0){
                    lists.add(departmentdata.getDeaths());
                }

                predictionDateRequest.setCount(departmentdata.getDeaths());
            }
            if (type==2){//Recuperados
                if (departmentdata.getRecovered()>0){
                    lists.add(departmentdata.getRecovered());
                }
                predictionDateRequest.setCount(departmentdata.getRecovered());
            }
            predictionDateRequests.add(predictionDateRequest);
            c.setTime(departmentdata.getDate1());
        }

        int milisecondsByDay = 86400000;
        int dias = (int) ((fin.getTime()-dateInicio.getTime()) / milisecondsByDay);
        System.out.println("Numero de dias: " + dias); // 365 dias
        double [][] vector=new double[lists.size()][1];
        for (int i=0;i<lists.size();i++){
            vector[i][0]=lists.get(i);
        }
        int [] dateF=generarPrediccion(dias,lists.size()-1,vector);

        for(int i=0;i<dateF.length;i++){
            c.add(Calendar.DATE, 1);
            Date dt = c.getTime();
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();
            predictionDateRequest.setCount(dateF[i]);
            predictionDateRequest.setDate(dt);
            predictionDateRequest.setStatus(1);
            predictionDateRequests.add(predictionDateRequest);
        }
        return predictionDateRequests;
    }
    public static List<PredictionDateRequest> predictionMain(List<CountryListHistoricEveryDayRequest> data,String date,Integer type){
        // Creo los LocalDate
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fin = null;
        try {

            fin = formatoDelTexto.parse(date);

        } catch (ParseException ex) {

            ex.printStackTrace();

        } // Usando ChronoUnit, calculo el numero de dias
        Calendar c = Calendar.getInstance();
        //sacar la cantidad
        int con=data.size();
        LocalDate inicio=null;
        Date dateInicio = new Date();
        List<PredictionDateRequest> predictionDateRequests = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();
        for (int i=0;i<data.size();i++){
            CountryListHistoricEveryDayRequest countrydata = new CountryListHistoricEveryDayRequest();
            countrydata = data.get(i);
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();

            predictionDateRequest.setDate(countrydata.getDateCountry());
            predictionDateRequest.setStatus(0);



            dateInicio=countrydata.getDateCountry(); // fecha inicio
            if (type==0){//Casos
                if (countrydata.getConfirmed()>0){
                    lists.add(countrydata.getConfirmed());
                }
                predictionDateRequest.setCount(countrydata.getConfirmed());
            }
            if (type==1){//Muertos
                if (countrydata.getDeaths()>0){
                    lists.add(countrydata.getDeaths());
                }

                predictionDateRequest.setCount(countrydata.getDeaths());
            }
            if (type==2){//Recuperados
                if (countrydata.getRecovered()>0){
                    lists.add(countrydata.getRecovered());
                }
                predictionDateRequest.setCount(countrydata.getRecovered());
            }
            predictionDateRequests.add(predictionDateRequest);
            c.setTime(countrydata.getDateCountry());
        }

        int milisecondsByDay = 86400000;
        int dias = (int) ((fin.getTime()-dateInicio.getTime()) / milisecondsByDay);
        System.out.println("Numero de dias: " + dias); // 365 dias
        double [][] vector=new double[lists.size()][1];
        for (int i=0;i<lists.size();i++){
            vector[i][0]=lists.get(i);
        }
        int [] dateF=generarPrediccion(dias,lists.size()-1,vector);

        for(int i=0;i<dateF.length;i++){
            c.add(Calendar.DATE, 1);
            Date dt = c.getTime();
            PredictionDateRequest predictionDateRequest=new PredictionDateRequest();
            predictionDateRequest.setCount(dateF[i]);
            predictionDateRequest.setDate(dt);
            predictionDateRequest.setStatus(1);
            predictionDateRequests.add(predictionDateRequest);
        }
        return predictionDateRequests;
    }


    public static void main(String[] args) throws IOException {
        double x=Math.log(32);
        System.out.println(x);
        //sacar los datos del archivo
        //generarPrediccion(100,con,vector1);
    }

    private static int[] generarPrediccion(int cantidad,int con, double[][] vector1) {
        int [] datosF = new int[cantidad];
        for(int i=0;i<cantidad;i++) {
            double[][] datosXY=generarXY(vector1,con);

            //Suma de XY
            Double sumXY=0.0;
            //Suma del X
            Double sumaX=0.0;
            //media X
            Double mediaX=0.0;

            Double sumaY=0.0;
            //media X
            Double mediaY=0.0;
            // suma X*X
            Double sumXX=0.0;
            for (int j=0;j<datosXY.length;j++){
                //for(int j=0;j<datosXY[0].length;j++){
                sumXY=sumXY+(datosXY[j][0]*datosXY[j][1]);
                sumaX=sumaX+datosXY[j][1];
                sumXX=sumXX+(datosXY[j][1]*datosXY[j][1]);
                sumaY=sumaY+datosXY[j][0];

                //}
            }
            //System.out.println("can: "+con);
            mediaX=sumaX/(con*1.0);
            //System.out.println("meX: "+mediaX+" suma"+sumaX);
            mediaY=sumaY/(con*1.0);
            Double b1=(sumXY-((sumaX*sumaY)/con))/(sumXX-((sumaX*sumaX)/con));
            //System.out.println("b1: "+b1);
            Double b0=mediaY-b1*mediaX;
            Double b2=b1*b1;

            //System.out.println("dato ex"+ Math.exp(b0+b1*datosXY[datosXY.length-1][0]));
            double val= Math.exp(b0+b1*datosXY[datosXY.length-1][0])+b2*datosXY[datosXY.length-1][0];
            datosF[i]= (int) val;
            //System.out.printf("\n%.0f", val);
            con=con+1;
            double [][] nuevoDatos=new double[con+1][1];
            for (int c=0;c<nuevoDatos.length-1;c++){
                nuevoDatos[c][0]=vector1[c][0];
            }
            nuevoDatos[nuevoDatos.length-1][0]=val;
            for (int c=0;c<nuevoDatos.length;c++){
                //System.out.print(nuevoDatos[c][0]+" ");
            }

            //System.out.println(" ");
            vector1=nuevoDatos;
            for (int c=0;c<vector1.length;c++){
                //System.out.print(vector1[c][0]+" ");
            }
        }
        return datosF;
    }

    public static double[][] generarXY(double[][] vector1,int con){
        double [][] datosXY=new double[con][2];
        for (int i=0;i<datosXY.length+1;i++){
            for(int j=0;j<datosXY[0].length;j++){
                if (i>0){
                    if(j==0){
                        datosXY[i-1][j]=Math.log(vector1[i][0]);
                    }
                    else{
                        datosXY[i-1][j]=Math.log(vector1[i-1][0]);
                    }
                }
            }
        }

        return datosXY;
    }

    private static int cantidad(String s) throws IOException {
        FileInputStream fis=new FileInputStream(s);
        int valor=fis.read();
        int cont=0;
        while( (valor=fis.read()) != -1 ) {
            if(valor=='\n') {
                cont++;
            }
        }
        fis.close();
        return cont;
    }

    public static double [][] datosG(String archivo,double [][] vector) throws IOException {
        FileInputStream fis=new FileInputStream(archivo);
        int valor=fis.read();
        int cont=0;
        String reg="";
        while(valor!=-1){
            if(valor!='\n') {
                reg = reg + (char)valor;
            }else {
                vector[cont][0]=Double.parseDouble(reg);
                reg = "";
                cont++;
            }
            valor=fis.read();
        }
        fis.close();
        return vector;

    }



}
