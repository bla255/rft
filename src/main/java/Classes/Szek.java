package Classes;


/**
 * A Szek osztály egy szék objektumot reprezentál a moziban, amely tartalmazza a szék azonosítóját,
 * helyét (oszlop és sor), típusát, egységárát és állapotát.
 */

public class Szek {


    private final String id;
    private final int oszlop;
    private final int sor;
    private final SzekTipus szektipus;
    private final double egysegar;
    private SzekAllapota szekallapota;

    /**
     * Konstruktor, amely létrehozza a szék objektumot a megadott paraméterek alapján.
     *
     * @param id          A szék egyedi azonosítója.
     * @param oszlop      Az oszlop száma, ahol a szék található.
     * @param sor         A sor száma, ahol a szék található.
     * @param szektipus   A szék típusa (pl. normál, VIP).
     * @param egysegar    A szék egységára.
     * @param szekallapota A szék aktuális állapota (pl. foglalt, szabad).
     */

    public Szek(String id, int oszlop, int sor, SzekTipus szektipus, double egysegar, SzekAllapota szekallapota) {
        this.id = id;
        this.oszlop = oszlop;
        this.sor = sor;
        this.szektipus = szektipus;
        this.egysegar = egysegar;
        this.szekallapota = szekallapota;
    }


    /**
     * A szék egyedi azonosítójának lekérése.
     *
     * @return A szék azonosítója.
     */

public String getId() {
    return id;
}

    /**
     * A szék sorának lekérése.
     *
     * @return A szék sora.
     */

    public int getSor() {
        return sor;
    }

    /**
     * A szék oszlopának lekérése.
     *
     * @return A szék oszlopa.
     */

    public int getOszlop() {
        return oszlop;
    }

    /**
     * A szék típusának lekérése.
     *
     * @return A szék típusa.
     */

    public SzekTipus getSzektipus() {
        return szektipus;
    }

    /**
     * A szék egységárának lekérése.
     *
     * @return A szék egységára.
     */

    public double getEgysegar() {
        return egysegar;
    }

    /**
     * A szék aktuális állapotának lekérése.
     *
     * @return A szék állapota.
     */

    public SzekAllapota getSzekallapota() {
        return szekallapota;
    }

    /**
     * A szék állapotának módosítása.
     *
     * @param szekallapota Az új állapot, amelyre a szék állapotát módosítani kell.
     */

    public void setAllapot(SzekAllapota szekallapota){

        this.szekallapota = szekallapota;
    }

    /**
     * A szék reprezentációját adja vissza szöveg formájában.
     *
     * @return A szék helyét (oszlop és sor) tartalmazó szöveges reprezentáció.
     */
    @Override
    public String toString() {
        return  "Oszlop: " + this.getOszlop() +
                ", Sor: " + this.getSor();
    }
}