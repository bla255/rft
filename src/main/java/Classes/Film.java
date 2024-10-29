package Classes;

public class Film {
    private final String id;
    private final String cim;
    private final String leiras;
    private final String mufaj;
    private final int filmhossza;
    private final String megjelenes;
    private final String kiemelt_film;


    public Film(String id, String cim, String leiras, String mufaj, int filmhossza, String megjelenes, String kiemelt_film) {
        this.id = id;
        this.cim = cim;
        this.leiras = leiras;
        this.mufaj = mufaj;
        this.filmhossza = filmhossza;
        this.megjelenes = megjelenes;
        this.kiemelt_film = kiemelt_film;
    }

    public String getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public String getLeiras() {
        return leiras;
    }

    public String getMufaj() {
        return mufaj;
    }

    public int getFilmhossza() {
        return filmhossza;
    }

    public String getMegjelenes() {
        return megjelenes;
    }

    public String getKiemelt_film() {
        return kiemelt_film;
    }
}



