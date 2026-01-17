package Controller;

import Model.*;
import View.RaktarView;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RaktarController {
    private Raktar raktar;
    private RaktarView view;
    private static final String FAJLNEV = "raktar.bin";

    public RaktarController() {
        this.raktar = new Raktar();
        this.view = new RaktarView();
    }


    public void raktarFeltolt() {


        try {
            Konzerv k1 = new Konzerv(
                    "Paradicsom konzerv",
                    "Univer",
                    LocalDate.of(2026, 12, 31),
                    "Hámozott paradicsom",
                    "paradicsom_recept.txt"
            );

            Konzerv k2 = new Konzerv(
                    "Kukorica konzerv",
                    "Bonduelle",
                    "Édes kukorica"
            );

            Konzerv k3 = new Konzerv(
                    "Borsó konzerv",
                    "Globus",
                    LocalDate.of(2027, 6, 15),
                    "Zöldborsó konzerv"
            );

            Konzerv k4 = new Konzerv(
                    "Bab konzerv",
                    "Sága",
                    "Vörösbab",
                    "bab_recept.txt"
            );

            raktar.felvesz(k1);
            raktar.felvesz(k2);
            raktar.felvesz(k3);
            raktar.felvesz(k4);

            view.sikeresMusvelet("Raktár feltöltése");
            view.uzenetKiir(raktar.getMeret() + " tétel hozzáadva");

        } catch (Lejart e) {
            view.hibaKiir(e.getMessage());
        }
    }


    public void raktarMegjelenit() {
        view.raktarTartalomKiir(
                raktar,
                raktar.getMeret()
        );
    }


    public void raktarMent() {


        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FAJLNEV))) {

            oos.writeObject(raktar);
            view.sikeresMusvelet("Mentés");
            view.uzenetKiir("Fájl: " + FAJLNEV);

        } catch (IOException e) {
            view.hibaKiir("Hiba: " + e.getMessage());
        }
    }


    public void raktarBetolt() {

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FAJLNEV))) {

            raktar = (Raktar) ois.readObject();
            view.sikeresMusvelet("Betöltés");
            view.uzenetKiir("Fájl: " + FAJLNEV);
            view.uzenetKiir(raktar.getMeret() + " tétel betöltve ");

        } catch (IOException e) {
            view.hibaKiir("Betöltési hiba: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            view.hibaKiir("Osztály nem található: " + e.getMessage());
        }
    }


    public void rendezesekBemutat() {



        List<Elelmiszer> lista = new ArrayList<>(raktar.getElelmiszerek());
        lista.sort(Elelmiszer.nevSzerint());

        view.listaKiir("Név szerint (természetes rendezés):", lista);



        lista.sort(Elelmiszer.gyartoSzerint());
        view.listaKiir("Gyártó szerint (Comparator):", lista);
    }


    public void Futtat() {

        raktarFeltolt();

        raktarMegjelenit();


        raktarMent();


        raktarBetolt();

        view.raktarTartalomKiir(
                raktar,
                raktar.getMeret()
        );


        rendezesekBemutat();



    }

    public Raktar getRaktar() {
        return raktar;
    }

    public RaktarView getView() {
        return view;
    }
}