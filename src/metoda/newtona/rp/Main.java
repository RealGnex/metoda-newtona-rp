package metoda.newtona.rp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Punkt> punkty = new ArrayList<>();
        double podanyX, podanyY;
        int iloscPunktow;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ile punktów chcesz wprowadzić?");
        iloscPunktow = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < iloscPunktow; i++) {
            System.out.println("Podaj wartość X:");
            podanyX = Double.parseDouble(sc.nextLine());
            System.out.println("Podaj wartość Y:");
            podanyY = Double.parseDouble(sc.nextLine());
            punkty.add(new Punkt(podanyX,podanyY));
            System.out.println("Punkt numer " + (i+1) + " został dodany!");
        }
        interpolacjaNewtona(2.5,punkty);
    }
    public static int silnia (int n) {
        if (n==0)
            return 1;
        else
            return (n*silnia(n-1));
    }

    public static double[] roznicaProgresywna(ArrayList<Punkt> punkty) {
        double wynik = 0;
        final int iloscPunktow = punkty.size();
        double[][] roznicaProgresywna = new double[iloscPunktow][]; //tworzenie kolumn
        //tworzenie wierszy
        for (int i = 0; i < iloscPunktow; i++)
            roznicaProgresywna[i] = new double[iloscPunktow-i];
        //ustawienie pierwszego wiersza
        for (int i = 0; i < iloscPunktow; i++)
            roznicaProgresywna[i][0] = punkty.get(i).y;
        //wypełnianie reszty wierszy
        for (int i = 1; i < iloscPunktow; i++) {
            for (int j = 0; j < iloscPunktow - i; j++) {
                roznicaProgresywna[j][i] = ((roznicaProgresywna[j+1][i-1] - roznicaProgresywna[j][i-1])
                        / (silnia(i) * Math.pow(1,i)));
            }
        }
        double[] wiersz = roznicaProgresywna[0];
        return wiersz;

    }

    private static void interpolacjaNewtona(double szukanyX, ArrayList<Punkt> punkty) {
        final int iloscPunktow = punkty.size();
        double[] roznica = roznicaProgresywna(punkty);
        double y = roznica[iloscPunktow-1];
        for (int j = iloscPunktow - 2; j >= 0; j--)
            y = y * (szukanyX - punkty.get(j).x) + roznica[j]; //TODO - inaczej trzeba liczyć
        System.out.println("Interpolacja w punkcie " + szukanyX + " to " + y);
    }

}
