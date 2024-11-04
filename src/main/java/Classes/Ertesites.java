package Classes;


import java.time.LocalDate;

public class Ertesites {
    private String id;
    private LocalDate letrehozva;
    private String tartalom;

    public Ertesites(String id, String tartalom) {
        this.id = id;
        this.letrehozva = LocalDate.now();
        this.tartalom = tartalom;
    }

    public String getId() {
        return id;
    }

    public LocalDate getLetrehozva() {
        return letrehozva;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void kuldesErtesites(String cimzett, String tipus) {
        ErtesitesKuld.kuldes(this, cimzett, tipus);
    }

    @Override
    public String toString() {
        return "Értesítés ID: " + id + ", Létrehozva: " + letrehozva + ", Tartalom: " + tartalom;
    }
}