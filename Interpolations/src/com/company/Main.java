package com.company;


import static com.company.Newton_RP.x;
import static com.company.Newton_RP.y;

public class Main {

    public static void main(String[] args) {

        Lagrange l1 = new Lagrange(5);
        l1.Oblicz();
        Newton_IR nir = new Newton_IR(5,3);
        nir.Oblicz();
        Newton_RP nrp = new Newton_RP();
        System.out.println(nrp.Oblicz2(3,x,y));

        Sklejana sklejane = new Sklejana();
        sklejane.x = 3;
        sklejane.punkty.add(new Punkt(-4, -524));
        sklejane.punkty.add(new Punkt(-2, -36));
        sklejane.punkty.add(new Punkt(0, -4));
        sklejane.punkty.add(new Punkt(2, -44));
        sklejane.punkty.add(new Punkt(4, -540));

        sklejane.liczba_wezlow = sklejane.punkty.size();
        sklejane.punkty_pochodne.add(new Punkt(-4, 518));
        sklejane.punkty_pochodne.add(new Punkt(4, -522));
        sklejane.tworzenieTablic();
        sklejane.wypelnianieTablic();
        sklejane.tworzenieWektora();
        sklejane.roz();
        System.out.println("Wynik Sklejana: " + sklejane.wynik());

    }
}