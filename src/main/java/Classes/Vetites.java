package Classes;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * A Vetites osztály egy film vetítését reprezentálja, amely tartalmazza a vetítéshez kapcsolódó
 * film és mozi adatait, valamint a kezdés és befejezés időpontját és az elérhető székeket.
 */

public class Vetites {
    private final String id;
    private final Film film;
    private final Mozi mozi;
    private final LocalDateTime kezdes;
    private final LocalDateTime befejezes;
    private final Map<String, Szek> szekek;

    /**
     * Konstruktor, amely inicializálja a vetítés alapvető adatait, beleértve a film, mozi,
     * kezdési és befejezési időpont, valamint a székek listáját.
     *
     * @param id       A vetítés egyedi azonosítója.
     * @param film     A vetítéshez tartozó film objektuma.
     * @param mozi     A mozi, ahol a vetítés történik.
     * @param kezdes   A vetítés kezdési időpontja.
     * @param befejezes A vetítés befejezési időpontja.
     * @param szekek   A vetítéshez tartozó székek, azonosító és Szek objektum párokként.
     */

    public Vetites(String id, Film film, Mozi mozi, LocalDateTime kezdes, LocalDateTime befejezes, Map<String, Szek> szekek) {
        this.id = id;
        this.film = film;
        this.mozi = mozi;
        this.kezdes = kezdes;
        this.befejezes = befejezes;
        this.szekek = szekek;
    }

    /**
     * A vetítés azonosítójának lekérése.
     *
     * @return A vetítés azonosítója.
     */

    public String getId() {
        return id;
    }
    /**
     * A vetítéshez tartozó film objektumának lekérése.
     *
     * @return A vetítéshez tartozó film.
     */

    public Film getFilm() {
        return film;
    }

    /**
     * A vetítést tartalmazó mozi objektumának lekérése.
     *
     * @return A vetítéshez tartozó mozi.
     */

    public Mozi getMozi() {
        return mozi;
    }

    /**
     * A vetítés kezdési időpontjának lekérése.
     *
     * @return A vetítés kezdési időpontja.
     */

    public LocalDateTime getKezdes() {
        return kezdes;
    }

    /**
     * A vetítés befejezési időpontjának lekérése.
     *
     * @return A vetítés befejezési időpontja.
     */

    public LocalDateTime getBefejezes() {
        return befejezes;
    }

    /**
     * A vetítéshez tartozó székek lekérése.
     *
     * @return A székek listája, ahol az egyes székek azonosító alapján érhetők el.
     */

    public Map<String, Szek> getSzekek() {
        return szekek;
    }
}