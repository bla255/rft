package Classes;

/**
 * A Felhasznalo osztály a felhasználók alapvető adatait és attribútumait tartalmazza,
 * például a felhasználónevet, jelszót, nevét, nemét, email címét, telefonszámát, valamint jogosultsági szintjét a platformhoz.
 */

public class Felhasznalo {
    private String id;
    private String felhasznalonev;
    private String jelszo;
    private String vezeteknev;
    private String keresztnev;
    private int nem; // 0: nő, 1: férfi
    private String email;
    private String telefon;
    private JogosultsagTipus jogosultsagTipus;


    /**
     * Felhasznalo példány létrehozása a megadott adatokkal.
     *
     * @param id A felhasználó azonosítója
     * @param felhasznalonev A felhasználó neve a bejelentkezéshez
     * @param jelszo A felhasználó jelszava
     * @param vezeteknev A felhasználó vezetékneve
     * @param keresztnev A felhasználó keresztneve
     * @param nem A felhasználó neme (0: nő, 1: férfi)
     * @param email A felhasználó email címe
     * @param telefon A felhasználó telefonszáma
     * @param jogosultsagTipus A felhasználó jogosultsági típusa
     */

    public Felhasznalo(String id, String felhasznalonev, String jelszo, String vezeteknev, String keresztnev, int nem, String email, String telefon, JogosultsagTipus jogosultsagTipus) {
        this.id = id;
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.nem = nem;
        this.email = email;
        this.telefon = telefon;
        this.jogosultsagTipus = jogosultsagTipus;
    }


    /**
     * Beállítja a felhasználó azonosítóját.
     *
     * @param id A felhasználó új azonosítója
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Beállítja a felhasználó vezetéknevét.
     *
     * @param vezeteknev A felhasználó új vezetékneve
     */

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }
    /**
     * Beállítja a felhasználó nevét a bejelentkezéshez.
     *
     * @param felhasznalonev Az új felhasználónév
     */

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }
    /**
     * Beállítja a felhasználó keresztnevét.
     *
     * @param keresztnev Az új keresztnév
     */
    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }
    /**
     * Beállítja a felhasználó nemét.
     *
     * @param nem A felhasználó új neme (0: nő, 1: férfi)
     */

    public void setNem(int nem) {
        this.nem = nem;
    }


    /**
     * Beállítja a felhasználó email címét.
     *
     * @param email Az új email cím
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Beállítja a felhasználó telefonszámát.
     *
     * @param telefon Az új telefonszám
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Beállítja a felhasználó jogosultsági típusát.
     *
     * @param jogosultsagTipus Az új jogosultsági típus
     */

    public void setExtraJogosultsag(JogosultsagTipus jogosultsagTipus) {

        this.jogosultsagTipus = jogosultsagTipus;
    }

    /**
     * Visszaadja a felhasználó azonosítóját.
     *
     * @return A felhasználó azonosítója
     */
    public String getId() {
        return id;
    }

    /**
     * Visszaadja a felhasználó nevét.
     *
     * @return A felhasználónév
     */
    public String getFelhasznalonev() {

        return felhasznalonev;
    }
    /**
     * Visszaadja a felhasználó vezetéknevét.
     *
     * @return A vezetéknev
     */

    public String getVezeteknev() {

        return vezeteknev;
    }
    /**
     * Visszaadja a felhasználó keresztnevét.
     *
     * @return A keresztnév
     */
    public String getKeresztnev() {

        return keresztnev;
    }
    /**
     * Visszaadja a felhasználó nemét.
     *
     * @return A felhasználó neme (0: nő, 1: férfi)
     */
    public int getNem() {

        return nem; // Ellenőrizd, hogy ez a metódus visszaadja a nem változót
    }

    /**
     * Visszaadja a felhasználó email címét.
     *
     * @return Az email cím
     */
    public String getEmail() {

        return email;
    }

    /**
     * Visszaadja a felhasználó telefonszámát.
     *
     * @return A telefonszám
     */


    public String getTelefon() {

        return telefon;
    }

    /**
     * Visszaadja a felhasználó jogosultsági szinjét.
     *
     * @return A jogosultsági szint
     */
    public JogosultsagTipus getJogosultsagTipus() {

        return jogosultsagTipus;
    }

    /**
     * Visszaadja a felhasználó jelszavát.
     *
     * @return A jelszó
     */
    public String getJelszo() {
        return jelszo;
    }

    /**
     * Beállítja a felhasználó új jelszavát.
     *
     * @param jelszo Az új jelszó
     */
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }




}



