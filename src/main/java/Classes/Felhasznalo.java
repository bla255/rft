package Classes;

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

    public Felhasznalo(String number, String jegyvasrlo123) {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public void setNem(int nem) {
        this.nem = nem;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setExtraJogosultsag(JogosultsagTipus jogosultsagTipus) {
        this.jogosultsagTipus = jogosultsagTipus;
    }

    public String getId() {
        return id;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public int getNem() {
        return nem; // Ellenőrizd, hogy ez a metódus visszaadja a nem változót
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public JogosultsagTipus getJogosultsagTipus() {
        return jogosultsagTipus;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }




}



