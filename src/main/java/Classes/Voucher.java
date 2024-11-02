package Classes;

import java.time.LocalDate;

public class Voucher {
    private String id;                // Voucher azonosító
    private double kedvezmenyErtek;    // Kedvezmény mértéke
    private LocalDate letrehozasDatum; //mikor hoztuk létre?
    private LocalDate lejaratDatum;   // Lejárati dátum
    private boolean felhasznalva;      // Felhasználtság jelző

    public Voucher(String id, double kedvezmenyErtek, LocalDate letrehozasDatum, LocalDate lejaratiDatum) {
        this.id = id;
        this.kedvezmenyErtek = kedvezmenyErtek;
        this. letrehozasDatum = letrehozasDatum;
        this.lejaratDatum = lejaratiDatum;
        this.felhasznalva = false; // Amikor létrehozzuk a vouchert, természetesen nincs már akkor felhasználva
    }

    public boolean ervenyes() {
        return !felhasznalva && LocalDate.now().isBefore(lejaratDatum);
    }

    public double alkalmazKedvezmeny(double eredetiAr) {
        if (ervenyes()) {
            this.felhasznalva = true;
            return eredetiAr - kedvezmenyErtek;
        }
        return eredetiAr;
    }

    public String getId() {
        return id;
    }

    public double getKedvezmenyErtek() {
        return kedvezmenyErtek;
    }

    public LocalDate getLejaratiDatum() {
        return lejaratDatum;
    }

    public boolean isFelhasznalva() {
        return felhasznalva;
    }

    public void setFelhasznalva(boolean felhasznalva) {
        this.felhasznalva = felhasznalva;
    }
}