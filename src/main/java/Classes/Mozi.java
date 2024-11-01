package Classes;


import java.util.List;

public class Mozi {
    private final String id;
    private final String nev;
    private final String varos;
    private final String cim;
    private final List<Vetites> vetitesek;


    public Mozi(String id, String nev, String varos, String cim, List<Vetites> vetitesek) {
        this.id = id;
        this.nev = nev;
        this.varos = varos;
        this.cim = cim;
        this.vetitesek = vetitesek;
    }

    public String getNev() {
        return nev;
    }

    public String getVaros() {
        return varos;
    }

    public String getCim() {
        return cim;
    }
}
