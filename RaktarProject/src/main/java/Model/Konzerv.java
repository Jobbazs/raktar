package Model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {
    private String leiras;
    private String receptAjanlas;

    public Konzerv(String nev, String gyarto, LocalDate lejaratiDatum,
                   String leiras, String receptAjanlas) throws Lejart {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.receptAjanlas = receptAjanlas;
    }

    public Konzerv(String nev, String gyarto, LocalDate lejaratiDatum,
                   String leiras) throws Lejart {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.receptAjanlas = null;
    }

    public Konzerv(String nev, String gyarto, String leiras,
                   String receptAjanlas) throws Lejart {
        super(nev, gyarto);
        this.leiras = leiras;
        this.receptAjanlas = receptAjanlas;
    }

    public Konzerv(String nev, String gyarto, String leiras) throws Lejart {
        super(nev, gyarto);
        this.leiras = leiras;
        this.receptAjanlas = null;
    }

    public String getLeiras() {
        return leiras;
    }

    public String getReceptAjanlas() {
        return receptAjanlas;
    }

    public void receptetMutat() {
        if (Files.exists(Paths.get(receptAjanlas))) {
        }
        ;

    }


    @Override
    public String toString() {
        String alap = super.toString();
        String recept = receptAjanlas != null ? " [Recept: " + receptAjanlas + "]" : "";
        return alap + " - " + leiras + recept;
    }
}