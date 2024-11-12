package Classes;

/**
 * A Film osztály a filmek alapvető adatait és attribútumait tartalmazza,
 * például a címét, leírását, műfaját, hosszát, megjelenési dátumát és kiemeltként kezelendő-e a moziba.
 */

public class Film {
    private final String id;
    private final String cim;
    private final String leiras;
    private final String mufaj;
    private final int filmhossza;
    private final String megjelenes;
    private final String kiemelt_film;

    /**
     * Film példány létrehozása a megadott adatokkal.
     *
     * @param id A film egyedi azonosítója
     * @param cim A film címe
     * @param leiras A film rövid leírása
     * @param mufaj A film műfaja
     * @param filmhossza A film hossza percekben
     * @param megjelenes A film megjelenési dátuma
     * @param kiemelt_film A kiemelt filmként kezelendő-e
     */

    public Film(String id, String cim, String leiras, String mufaj, int filmhossza, String megjelenes, String kiemelt_film) {
        this.id = id;
        this.cim = cim;
        this.leiras = leiras;
        this.mufaj = mufaj;
        this.filmhossza = filmhossza;
        this.megjelenes = megjelenes;
        this.kiemelt_film = kiemelt_film;
    }

    /**
     * Visszaadja a film azonosítóját.
     *
     * @return A film azonosítója
     */

    public String getId() {
        return id;
    }

    /**
     * Visszaadja a film címét.
     *
     * @return A film címe
     */

    public String getCim() {
        return cim;
    }

    /**
     * Visszaadja a film leírását.
     *
     * @return A film leírása
     */

    public String getLeiras() {
        return leiras;
    }

    /**
     * Visszaadja a film műfaját.
     *
     * @return A film műfaja
     */

    public String getMufaj() {
        return mufaj;
    }

    /**
     * Visszaadja a film hosszát percekben.
     *
     * @return A film hossza percekben
     */

    public int getFilmhossza() {
        return filmhossza;
    }
    /**
     * Visszaadja a film megjelenési dátumát.
     *
     * @return A film megjelenési dátuma
     */

    public String getMegjelenes() {
        return megjelenes;
    }

    /**
     * Visszaadja, hogy a film kiemelt státusz-e (igen, nem, esetleg valami más paraméter - enum ehhez nem íródott!).
     *
     * @return A film kiemelt státuszú-e, és annak stringje
     */
    public String getKiemelt_film() {
        return kiemelt_film;
    }
}



