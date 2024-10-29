package Classes;

public class Felhasznalo {
    private final String id;
    private final String vezeteknev;
    private final String keresztnev;
    private final boolean nem;
    private final String email;
    private final int telefon;
    private final int extra_jogosultsag;


    public Felhasznalo(String id, String vezeteknev, String keresztnev, boolean nem, String email, int telefon, int extra_jogosultsag) {
        this.id = id;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.nem = nem;
        this.email = email;
        this.telefon = telefon;
        this.extra_jogosultsag = extra_jogosultsag;
    }
}
