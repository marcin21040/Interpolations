package com.company;

import com.company.Punkt;

import java.util.ArrayList;

public class Sklejana {

    double[][] tab;
    int liczba_wezlow;
    double x;
    double[][] a;
    double[][] pochodna;
    double[] wyrazy_wolne;
    double[] wektor;
    ArrayList<Punkt> punkty = new ArrayList<>();
    ArrayList<Punkt> punkty_pochodne = new ArrayList<>();

    void tworzenieWektora() {
        wektor = new double[wyrazy_wolne.length];
    }

    void wypelnianieTablic() {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j <= i) {
                    a[i][j] = Math.pow(punkty.get(i).x - punkty.get(j).x, 3);
                } else {
                    a[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < pochodna.length; i++) {
            for (int j = 0; j < pochodna[i].length; j++) {
                if (j < 3) {
                    pochodna[i][j] = (j + 1) * Math.pow(punkty_pochodne.get(i).x, j);
                } else {
                    pochodna[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < pochodna.length; i++) {
            for (int j = 3; j < pochodna[i].length; j++) {
                if (i == 1) {
                    pochodna[i][j] = 3 * Math.pow(punkty_pochodne.get(1).x - punkty.get(j -
                            2).x, 2);
                }
            }
        }

        int temp;
        for (int i = 0; i < tab.length; i++) {
            if (i < liczba_wezlow) {
                tab[i][0] = 1;
            } else {
                tab[i][0] = 0;
            }
        }
        for (int i = 0; i < liczba_wezlow; i++) {
            for (int j = 1; j <= 3; j++) {
                tab[i][j] = Math.pow(punkty.get(i).x, j);
            }
            System.out.println();
        }
        for (int i = 1; i <= a.length; i++) {
            temp = 0;
            for (int j = liczba_wezlow; j < tab.length; j++) {
                tab[i][j] = a[i - 1][temp];
                temp++;
            }
        }
        for (int i = liczba_wezlow; i < tab.length; i++) {
            for (int j = 1; j < tab.length; j++) {
                tab[i][j] = pochodna[i - liczba_wezlow][j - 1];
            }
        }
        int temp1 = 0;
        for (int i = 0; i < wyrazy_wolne.length; i++) {
            if (i < liczba_wezlow) {
                wyrazy_wolne[i] = punkty.get(i).y;
            } else {
                wyrazy_wolne[i] = punkty_pochodne.get(temp1).y;
                temp1++;
            }
        }
    }

    void tworzenieTablic() {
        tab = new double[liczba_wezlow + 2][2 + liczba_wezlow];
        a = new double[liczba_wezlow - 1][liczba_wezlow - 1];
        pochodna = new double[2][3 + liczba_wezlow - 2];
        wyrazy_wolne = new double[liczba_wezlow + 2];
    }

    void roz() {
        int ilosc_wezlow = wyrazy_wolne.length;
        for (int p = 0; p < ilosc_wezlow; p++) {
            int max = p;
            for (int i = p + 1; i < ilosc_wezlow; i++) {
                if (Math.abs(tab[i][p]) > Math.abs(tab[max][p])) {
                    max = i;
                }
            }
            double[] temp = tab[p];
            tab[p] = tab[max];
            tab[max] = temp;
            double t = wyrazy_wolne[p];
            wyrazy_wolne[p] = wyrazy_wolne[max];
            wyrazy_wolne[max] = t;
            for (int i = p + 1; i < ilosc_wezlow; i++) {
                double alfa = tab[i][p] / tab[p][p];
                wyrazy_wolne[i] -= alfa * wyrazy_wolne[p];
                for (int j = p; j < ilosc_wezlow; j++) {
                    tab[i][j] -= alfa * tab[p][j];
                }
            }
        }
        for (int i = ilosc_wezlow - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < ilosc_wezlow; j++) {
                sum += tab[i][j] * wektor[j];
            }
            wektor[i] = (wyrazy_wolne[i] - sum) / tab[i][i];
        }
    }

    double wynik() {
        double wynik = 0;
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            wynik = wynik + wektor[i] * Math.pow(x, i);
        }
        for (int i = 1; i <= liczba_wezlow - 1; i++) {
            if (x >= punkty.get(i).x) {
                wynik = wynik + wektor[4 + tmp] * Math.pow(x - punkty.get(i).x, 3);
            }
            tmp++;
        }
        return wynik;
    }
}


