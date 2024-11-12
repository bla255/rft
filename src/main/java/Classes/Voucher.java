package Classes;

import java.time.LocalDate;


/**
 * A Voucher osztály egy kedvezményre jogosító utalványt reprezentál, amely tartalmazza az utalvány azonosítóját,
 * kedvezmény értékét, létrehozásának és lejárati dátumát, valamint hogy fel lett-e használva.
 */

public class Voucher {
    private final String id;
    private final double kedvezmenyErtek;
    private final LocalDate letrehozasDatum;
    private final LocalDate lejaratDatum;
    private boolean felhasznalva;


    /**
     * Konstruktor, amely létrehozza a Voucher objektumot a megadott paraméterek alapján.
     *
     * @param id              Az utalvány egyedi azonosítója.
     * @param kedvezmenyErtek A kedvezmény értéke, amelyet az utalvány biztosít.
     * @param letrehozasDatum Az utalvány létrehozásának dátuma.
     * @param lejaratiDatum   Az utalvány lejárati dátuma.
     */

    public Voucher(String id, double kedvezmenyErtek, LocalDate letrehozasDatum, LocalDate lejaratiDatum) {
        this.id = id;
        this.kedvezmenyErtek = kedvezmenyErtek;
        this. letrehozasDatum = letrehozasDatum;
        this.lejaratDatum = lejaratiDatum;
        this.felhasznalva = false;
    }

    /**
     * Ellenőrzi, hogy az utalvány érvényes-e. Az utalvány érvényes, ha még nem lett felhasználva és
     * a jelenlegi dátum a lejárati dátum előtt van.
     *
     * @return true, ha az utalvány érvényes; false, ha nem.
     */

    public boolean ervenyes() {
        return !felhasznalva && LocalDate.now().isBefore(lejaratDatum);
    }

    /**
     * Alkalmazza a kedvezményt az eredeti árból, ha az utalvány érvényes.
     *
     * @param eredetiAr Az eredeti ár, amelyre a kedvezményt alkalmazni kell.
     * @return A kedvezménnyel csökkentett ár, ha az utalvány érvényes; egyébként az eredeti ár.
     */


    public double alkalmazKedvezmeny(double eredetiAr) {
        if (ervenyes()) {
            this.felhasznalva = true;
            return eredetiAr - kedvezmenyErtek;
        }
        return eredetiAr;
    }

    /**
     * Az utalvány azonosítójának lekérése.
     *
     * @return Az utalvány azonosítója.
     */

    public String getId() {
        return id;
    }

    /**
     * Az utalvány kedvezmény értékének lekérése.
     *
     * @return Az utalvány kedvezmény értéke.
     */

    public double getKedvezmenyErtek() {
        return kedvezmenyErtek;
    }

    /**
     * Az utalvány lejárati dátumának lekérése.
     *
     * @return Az utalvány lejárati dátuma.
     */

    public LocalDate getLejaratiDatum() {
        return lejaratDatum;
    }

    /**
     * Annak lekérése, hogy az utalvány fel lett-e használva.
     *
     * @return true, ha az utalvány fel lett használva; false, ha nem.
     */


    public boolean isFelhasznalva() {
        return felhasznalva;
    }

    /**
     * Az utalvány felhasználásának beállítása.
     *
     * @param felhasznalva true, ha az utalvány felhasznált; false, ha nem.
     */

    public void setFelhasznalva(boolean felhasznalva) {
        this.felhasznalva = felhasznalva;
    }
}