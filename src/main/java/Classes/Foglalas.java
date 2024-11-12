package Classes;

import java.util.List;

/**
 * A Foglalas osztály a foglalásokhoz kapcsolódó adatokat, metódusokat és attribútumokat tartalmazza,
 * például a foglalás felhasználónevét, a vetítést, a foglalt székeket, az összesített vételárat
 * és a foglalás állapotát.
 */


public class Foglalas {
    private final String id;
    private final Felhasznalo felhasznalo;
    private final Vetites vetites;
    private final List<Szek> szekek;
    private final double vetelArosszesen;
    private FoglalasAllapota foglalasallapota;


    /**
     * Foglalas példány létrehozása a megadott adatokkal.
     *
     * @param id A foglalás egyedi azonosítója
     * @param felhasznalo A foglalást létrehozó felhasználó
     * @param vetites A foglaláshoz tartozó vetítés
     * @param szekek A foglaláshoz kapcsolódó székek listája
     * @param vetelArosszesen Az összesített vételár
     * @param foglalasallapota A foglalás állapota
     */

    public Foglalas(String id, Felhasznalo felhasznalo, Vetites vetites, List<Szek> szekek, double vetelArosszesen, FoglalasAllapota foglalasallapota) {
        this.id = id;
        this.felhasznalo = felhasznalo;
        this.vetites = vetites;
        this.szekek = szekek;
        this.vetelArosszesen = vetelArosszesen;
        this.foglalasallapota = foglalasallapota;
    }

    /**
     * Beállítja a foglalás állapotát.
     *
     * @param foglalasallapota Az új foglalási állapot
     */

    public void setFoglalasAllapota(FoglalasAllapota foglalasallapota){
            this.foglalasallapota = foglalasallapota;
}

    /**
     * Visszaadja a foglalás azonosítóját.
     *
     * @return A foglalás azonosítója
     */

public String getId(){
            return id;
}

    /**
     * Visszaadja a foglaláshoz tartozó felhasználót.
     *
     * @return A foglalást létrehozó felhasználó
     */

public Felhasznalo getFelhasznalo(){
            return felhasznalo;
}

    /**
     * Visszaadja a foglaláshoz tartozó vetítést.
     *
     * @return A foglaláshoz kapcsolódó vetítés
     */

    public Vetites getVetites(){
            return vetites;
}

    /**
     * Visszaadja a foglaláshoz tartozó székek listáját.
     *
     * @return A foglalt székek listája
     */

public List<Szek> getSzekek(){
            return szekek;
}

    /**
     * Visszaadja az összesített vételárat.
     *
     * @return Az összesített vételár
     */
public double getvetelArosszesen(){
            return vetelArosszesen;
}
    /**
     * Visszaadja a foglalás jelenlegi állapotát.
     *
     * @return A foglalás állapota
     */

public FoglalasAllapota getFoglalasallapota(){
            return foglalasallapota;

}
}
