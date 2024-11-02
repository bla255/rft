package Classes;
import Classes.*;
import rtf_main.MoziJegyrendszer;

import java.util.List;

public class Jegyarus {
    private final MoziJegyrendszer moziJegyrendszer;

    public Jegyarus() {
        this.moziJegyrendszer = MoziJegyrendszer.getInstance();
    }

    // Jegyfoglalás
    public Foglalas jegyetFoglalni(Felhasznalo felhasznalo, Vetites vetites, List<Szek> kivalasztottSzekek) {
        Foglalas foglalas = moziJegyrendszer.foglaltJegyek(felhasznalo, vetites, kivalasztottSzekek);
        if (foglalas != null) {
            System.out.println("Jegyfoglalás sikeres! Tranzakcióazonosító: " + foglalas.getId());
        } else {
            System.out.println("Jegyfoglalás sikertelen. A választott székek nem elérhetők.");
        }
        return foglalas;
    }

    // Jegytörlés
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

    // Jegymódosítás
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