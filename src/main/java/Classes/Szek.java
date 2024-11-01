package Classes;

public class Szek {


    private final String id;
    private final int oszlop;
    private final int sor;
    private final SzekTipus szektipus;
    private final double egysegar;
    private SzekAllapota szekallapota;


    public Szek(String id, int oszlop, int sor, SzekTipus szektipus, double egysegar, SzekAllapota szekallapota) {
        this.id = id;
        this.oszlop = oszlop;
        this.sor = sor;
        this.szektipus = szektipus;
        this.egysegar = egysegar;
        this.szekallapota = szekallapota;
    }


public String getId() {
    return id;
}

    public int getSor() {
        return sor;
    }

    public int getOszlop() {
        return oszlop;
    }

    public SzekTipus getSzektipus() {
        return szektipus;
    }

    public double getEgysegar() {
        return egysegar;
    }

    public SzekAllapota getSzekallapota() {
        return szekallapota;
    }

    public void setAllapot(SzekAllapota szekallapota){
        this.szekallapota = szekallapota;
    }


    @Override
    public String toString() {
        return  "Oszlop: " + this.getOszlop() +
                ", Sor: " + this.getSor();
    }
}