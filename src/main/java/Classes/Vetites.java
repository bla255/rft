package Classes;

import java.time.LocalDateTime;
import java.util.Map;

public class Vetites {
    private final String id;
    private final Film film;
    private final Mozi mozi;
    private final LocalDateTime kezdes;
    private final LocalDateTime endtime;
    private final Map<String, Szek> szekek;


    public Vetites(String id, Film film, Mozi mozi, LocalDateTime kezdes, LocalDateTime endtime, Map<String, Szek> szekek) {
        this.id = id;
        this.film = film;
        this.mozi = mozi;
        this.kezdes = kezdes;
        this.endtime = endtime;
        this.szekek = szekek;
    }

    public String getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public Mozi getMozi() {
        return mozi;
    }

    public LocalDateTime getKezdes() {
        return kezdes;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public Map<String, Szek> getSzekek() {
        return szekek;
    }
}