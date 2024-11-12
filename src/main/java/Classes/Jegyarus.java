package Classes;
import Classes.*;
import rtf_main.MoziJegyrendszer;

import java.util.List;

/**
 * A Jegyarus osztály felelős a jegyfoglalások, törlések és módosítások kezeléséért
 * a mozijegy árus / kiosk részére (Fejlesztés szükséges - ez csak a példa hozzá!).
 */


public class Jegyarus {
    private final MoziJegyrendszer moziJegyrendszer;


    /**
     * Alapértelmezett konstruktor, amely inicializálja a mozi jegyrendszert.
     */

    public Jegyarus() {
        this.moziJegyrendszer = MoziJegyrendszer.getInstance();
    }

    /**
     * Létrehoz egy új foglalást egy felhasználó számára a megadott vetítéshez és székekhez.
     *
     * @param felhasznalo       A foglalást végző felhasználó.
     * @param vetites           A vetítés, amelyre a foglalás történik.
     * @param kivalasztottSzekek A felhasználó által kiválasztott székek listája.
     * @return A létrejött foglalás objektuma, vagy null, ha a foglalás sikertelen.
     */
    public Foglalas jegyetFoglalni(Felhasznalo felhasznalo, Vetites vetites, List<Szek> kivalasztottSzekek) {
        Foglalas foglalas = moziJegyrendszer.foglaltJegyek(felhasznalo, vetites, kivalasztottSzekek);
        if (foglalas != null) {
            System.out.println("Jegyfoglalás sikeres! Tranzakcióazonosító: " + foglalas.getId());
        } else {
            System.out.println("Jegyfoglalás sikertelen. A választott székek nem elérhetők.");
        }
        return foglalas;
    }

    /**
     * Töröl egy létező foglalást a megadott foglalásazonosító alapján.
     *
     * @param foglalasId A törölni kívánt foglalás azonosítója.
     * @return Igaz, ha a törlés sikeres, egyébként hamis.
     */

    public boolean jegyetTorolni(String foglalasId) {
        Foglalas foglalas = moziJegyrendszer.getFoglalas(foglalasId);
        if (foglalas != null && foglalas.getFoglalasallapota() != FoglalasAllapota.TOROLVE) {
            moziJegyrendszer.FoglalasTorol(foglalasId);
            System.out.println("Jegytörlés sikeres! Foglalás azonosítója: " + foglalasId);
            return true;
        }
        System.out.println("Jegytörlés sikertelen. Nem található ilyen foglalás, vagy már törölték.");
        return false;
    }

    /**
     * Módosít egy létező foglalást új székekre a megadott foglalásazonosító alapján.
     *
     * @param foglalasId A módosítani kívánt foglalás azonosítója.
     * @param ujSzekek   Az újonnan kiválasztott székek listája.
     * @return Igaz, ha a módosítás sikeres, egyébként hamis - terminálra kiírja mindkét esetet, kivételként pedig hibaüzenet.
     */

    public boolean jegyetModositani(String foglalasId, List<Szek> ujSzekek) {
        Foglalas foglalas = moziJegyrendszer.getFoglalas(foglalasId);
        if (foglalas != null && foglalas.getFoglalasallapota() == FoglalasAllapota.ELOFOGLALVA) {
            Vetites vetites = foglalas.getVetites();
            if (moziJegyrendszer.SzekElerheto(vetites, ujSzekek)) {
                moziJegyrendszer.FoglalasTorol(foglalasId); // Régi székek felszabadítása
                foglalas = moziJegyrendszer.foglaltJegyek(foglalas.getFelhasznalo(), vetites, ujSzekek); // Új foglalás a módosított székekkel
                System.out.println("Jegymódosítás sikeres! Új foglalás azonosító: " + foglalas.getId());
                return true;
            } else {
                System.out.println("Jegymódosítás sikertelen. Az új székek nem elérhetők.");
            }
        } else {
            System.out.println("Jegymódosítás sikertelen. A foglalás nem található vagy nem módosítható.");
        }
        return false;
    }
}