package Classes;

public class Felhasznalo {
    private final String id;
    private final String felhasznalonev;
    private final String vezeteknev;
    private final String keresztnev;
    private final int nem;
    private final String email;
    private final String telefon;
    private final int extra_jogosultsag;


    public Felhasznalo(String id, String felhasznalonev, String vezeteknev, String keresztnev, int nem, String email, String telefon, int extra_jogosultsag) {
        this.id = id;
        this.felhasznalonev = felhasznalonev;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.nem = nem;
        this.email = email;
        this.telefon = telefon;
        this.extra_jogosultsag = extra_jogosultsag;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }
}
