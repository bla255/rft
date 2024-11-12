package Classes;


import java.time.LocalDate;


/**
 * Az Ertesites osztály egy értesítést reprezentál, amely tartalmaz egy egyedi azonosítót,
 * létrehozási dátumot, valamint a tartalmat. Az értesítést különböző címzetteknek lehet elküldeni.
 */

public class Ertesites {
    private final String id;
    private final LocalDate letrehozva;
    private final String tartalom;


    /**
     * Új értesítést hoz létre a megadott azonosítóval és tartalommal.
     * A létrehozás időpontja automatikusan a jelenlegi dátumra kerül felparaméterezésre.
     *
     * @param id Az értesítés egyedi azonosítója.
     * @param tartalom Az értesítés tartalma.
     */

    public Ertesites(String id, String tartalom) {
        this.id = id;
        this.letrehozva = LocalDate.now();
        this.tartalom = tartalom;
    }


    /**
     * Visszaadja az értesítés azonosítóját.
     *
     * @return Az értesítés egyedi azonosítója.
     */

    public String getId() {
        return id;
    }

    /**
     * Visszaadja az értesítés létrehozásának dátumát.
     *
     * @return Az értesítés létrehozásának dátuma.
     */

    public LocalDate getLetrehozva() {
        return letrehozva;
    }

    /**
     * Visszaadja az értesítés tartalmát.
     *
     * @return Az értesítés tartalma.
     */

    public String getTartalom() {
        return tartalom;
    }
    /**
     * Elküldi az értesítést a megadott címzettnek, illetve átadja a típus paramétert (mobil,mail stb.).
     *
     * @param cimzett A címzett, aki az értesítést kapja.
     * @param tipus Az értesítés típusa.
     */
    public void kuldesErtesites(String cimzett, String tipus) {
        ErtesitesKuld.kuldes(this, cimzett, tipus);
    }
    /**
     * Visszaadja az értesítés szöveges reprezentációját, beleértve az értesítés ID-jét, létrehozási dátumát és tartalmát.
     *
     * @return Az értesítés szöveges reprezentációja.
     */
    @Override
    public String toString() {
        return "Értesítés ID: " + id + ", Létrehozva: " + letrehozva + ", Tartalom: " + tartalom;
    }
}