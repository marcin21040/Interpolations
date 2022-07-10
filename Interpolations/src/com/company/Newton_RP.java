package com.company;

public class Newton_RP {


    public static double[] x = {-4.0, -2.0, 0.0, 2.0, 4.0};
    public static double[] y = {-524.0, -36.0, -4.0, -44.0, -540.0};
    public static int X = x.length;
    private static double silnia(double i){
        if(i < 1)
            return 1.0;
        else
            return i * silnia(i-1);

    }
    public static double[][] Oblicz(double[] wartosci){
        double[][] licznik = new double[5][5];
        for(int i = 0; i< X -1; i++){
            for(int j = 0; j< X -i-1; j++){
                if(i==0){
                    licznik[i][j] = wartosci[j+1] - wartosci[j];
                }
                else {
                    licznik[i][j] = licznik[i-1][j+1] - licznik[i-1][j];
                }
            }
        }
        return licznik;
    }
    public static double Oblicz2(double m, double[] f_x, double[] f_Y){
        double wynik = 0;
        double [][] a = Oblicz(f_Y);
        double arg = f_x[1] - f_x[0];
        for(int k = 0; k < X; k++){
            if(k==0){
                wynik += f_Y[k];
            }
            else {
                double licznik = 1;
                for(int j = 0; j < k; j++){

                    licznik = licznik * (m-f_x[j]);
                }
                wynik += ((a[k-1][0]) / (silnia(k)*Math.pow(arg,k))) *

                        licznik;
            }
        }
        System.out.println("Wynik Newton RP: ");
        return wynik;
    }
    public static void main(String[] args) {
        System.out.println(Oblicz2(3, x, y));
    }


}
