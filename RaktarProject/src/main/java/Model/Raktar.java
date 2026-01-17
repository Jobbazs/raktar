package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Raktar implements Serializable, Iterable<Elelmiszer> {
    private List<Elelmiszer> elelmiszerek;

    public Raktar() {
        this.elelmiszerek = new ArrayList<>();
    }

    public void felvesz(Elelmiszer elelmiszer) {
        elelmiszerek.add(elelmiszer);
    }

    public List<Elelmiszer> getElelmiszerek() {
        return Collections.unmodifiableList(elelmiszerek);
    }


    public int getMeret() {
        return elelmiszerek.size();
    }


    @Override
    public Iterator<Elelmiszer> iterator() {
        return elelmiszerek.iterator();
    }

}