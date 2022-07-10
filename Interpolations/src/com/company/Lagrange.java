package com.company;

public class Lagrange {

    double[] x = {-4,-2, 0, 2, 4};
    double[] y = {-524, -36 ,-4,-44,-540};
    double X = 3;

    int n;

    public Lagrange(int n) {
        this.n = n;
    }

    void Oblicz()
    {
        double Wx = 0;
        double Li = 1;
        for(int i = 0; i <= n-1; i++)
        {
            for(int j = 0; j <= n - 1; j++)
            {
                if(i!=j)
                {
                    Li *= (X - x[j])/(x[i]-x[j]);
                }

            }
            Wx += y[i]*Li;
            Li = 1;

        }
        System.out.println("Wynik Lagrange: "+ Wx);
    }


}
