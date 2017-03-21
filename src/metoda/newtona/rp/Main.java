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
    }
}
