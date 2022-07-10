package com.company;

import java.util.Arrays;

public class Newton_IR {


    double[] x = {-4.0, -2.0, 0.0, 2.0, 4.0};
    double[] y = {-524.0, -36.0, -4.0, -44.0, -540.0};
    double X;


    int n;

    public Newton_IR(int n, double X) {
        this.n = n;
        this.X = X;
    }

    void Oblicz() {
        double tab[][] = new double[n][n];
        double licznik[][] = new double[n][n];

        for (int i = 0; i < n - 1; i++) {

            for(int j = 0; j < n - i - 1; j++)
            {
                if(i == 0)
                {
                    tab[i][j] = (y[j+1]-y[j])/(x[j+1]-x[j]);
                    licznik[i][j] = tab[i][j];
                }
                if(i>0)
                {
                    tab[i][j] = (licznik[i-1][j+1]-licznik[i-1][j])/(x[j+i+1]-x[j]);
                    licznik[i][j] = tab[i][j];
                }

            }

        }
            double Wx = 0;
                for (int k = 0; k < n; k++){
                    if (k==0){
                        Wx += y[k];
                    }
                    else{
                        double mnoznik = 1;
                        for(int j=0; j<k; j++){
                            mnoznik *= (X - x[j]);
                        }
                        Wx += licznik[k-1][0]*mnoznik;

                    }
                }
                System.out.println("Wynik Newton_IR: " + Wx);
            }
        }



