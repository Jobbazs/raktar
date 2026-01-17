package View;

import Model.Elelmiszer;
import Model.Raktar;

import java.util.List;


public class RaktarView {

    public void uzenetKiir(String uzenet) {
        System.out.println(uzenet);
        System.out.println("");
    }

    public void hibaKiir(String hiba) {
        System.err.println("HIBA: " + hiba);
    }


    public void raktarTartalomKiir(Raktar r, int meret) {


        int s = 1;
        for (Elelmiszer e : r) {
            System.out.printf("%4d. %s%n", s++, e);
        }

        System.out.println("");
        System.out.println("Összesen: " + meret + " tétel");
        System.out.println("");
    }

    public void listaKiir(String cim, List<Elelmiszer> lista) {

        int s = 1;
        for (Elelmiszer e : lista) {
            System.out.printf("%3d. %s%n", s++, e);
        }
        System.out.println("");
    }

    public void sikeresMusvelet(String muvelet) {
        System.out.println(muvelet + " sikeres!");
    }
}