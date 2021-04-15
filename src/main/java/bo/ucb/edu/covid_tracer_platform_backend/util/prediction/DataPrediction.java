package bo.ucb.edu.covid_tracer_platform_backend.util.prediction;

import java.io.FileInputStream;
import java.io.IOException;

public class DataPrediction {

    public static void main(String[] args) throws IOException {
        double x=Math.log(32);
        System.out.println(x);
        //sacar la cantidad
        int con=cantidad("Datosn.txt");
        //sacar los datos del archivo

        double [][] vector=new double[con][1];
        double [][] vector1=datosG("Datosn.txt",vector);
        for (int i=0;i< vector1.length;i++){
            System.out.println(vector1[i][0]);

        }
        con=con-1;


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

        System.out.println("dat: "+datosXY.length);
        for (int i=0;i<datosXY.length;i++){
            for(int j=0;j<datosXY[0].length;j++){
                System.out.print(datosXY[i][j]+" ");
            }
            System.out.println();
        }

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
        for (int i=0;i<datosXY.length;i++){
            //for(int j=0;j<datosXY[0].length;j++){
            sumXY=sumXY+(datosXY[i][0]*datosXY[i][1]);
            sumaX=sumaX+datosXY[i][1];
            sumXX=sumXX+(datosXY[i][1]*datosXY[i][1]);
            sumaY=sumaY+datosXY[i][0];

            //}
        }

        System.out.println("can: "+con);
        mediaX=sumaX/(con*1.0);
        System.out.println("meX: "+mediaX);
        mediaY=sumaY/(con*1.0);
        Double b1=(sumXY-((sumaX*sumaY)/con))/(sumXX-((sumaX*sumaX)/con));
        System.out.println("b1: "+b1);
        Double b0=mediaY-b1*mediaX;
        System.out.println("b0: "+b0);

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
