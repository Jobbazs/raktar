package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Elelmiszer implements Serializable{
    private String nev, gyarto;
    private LocalDate lejaratiDatum;

    public Elelmiszer(String nev, String gyarto, LocalDate lejaratiDatum) throws Lejart {
        if (lejaratiDatum.isBefore(LocalDate.now()) || lejaratiDatum.isEqual(LocalDate.now())) {
            throw new Lejart();
        }
        this.nev = nev;
        this.gyarto = gyarto;
        this.lejaratiDatum = lejaratiDatum;
    }

    public Elelmiszer(String nev, String gyarto) throws Lejart {
        this(nev, gyarto, LocalDate.now().plusYears(1));
    }

    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    public LocalDate getLejaratiDatum() {
        return lejaratiDatum;
    }

    public static Comparator<Elelmiszer> nevSzerint() {
        return Comparator.comparing(Elelmiszer::getNev);
    }

    public static Comparator<Elelmiszer> gyartoSzerint() {
        return Comparator.comparing(Elelmiszer::getGyarto);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (lejár: %s)",gyarto,nev,lejaratiDatum);
    }
}