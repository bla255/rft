package Classes;


import java.util.List;


/**
 * A Mozi osztály egy mozit reprezentál, amely tartalmazza a mozi adatait,
 * beleértve a nevét, városát, címét és a vetítések listáját.
 */

public class Mozi {
    private final String id;
    private final String nev;
    private final String varos;
    private final String cim;
    private final List<Vetites> vetitesek;

    /**
     * Konstruktor, amely inicializálja a mozi alapvető adatait és a hozzá tartozó vetítések listáját.
     *
     * @param id        A mozi egyedi azonosítója.
     * @param nev       A mozi neve.
     * @param varos     A mozi városa.
     * @param cim       A mozi címe.
     * @param vetitesek A mozihoz tartozó vetítések listája.
     */

    public Mozi(String id, String nev, String varos, String cim, List<Vetites> vetitesek) {
        this.id = id;
        this.nev = nev;
        this.varos = varos;
        this.cim = cim;
        this.vetitesek = vetitesek;
    }

    /**
     * A mozi nevének lekérése.
     *
     * @return A mozi neve.
     */

    public String getNev() {
        return nev;
    }

    /**
     * A mozi városának lekérése.
     *
     * @return A mozi városa.
     */
    public String getVaros() {
        return varos;
    }

    /**
     * A mozi címének lekérése.
     *
     * @return A mozi címe.
     */

    public String getCim() {
        return cim;
    }
}
