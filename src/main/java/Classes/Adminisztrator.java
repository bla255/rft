package Classes;

import rtf_main.MoziJegyrendszer;

/**
 * Az Adminisztrator osztály a mozijegyrendszer adminisztrátori műveleteit kezeli,
 * például a filmek és vetítések létrehozását, törlését és módosítását.
 */


public class Adminisztrator {
    private String adminId;
    private String adminNev;

    /**
     * Létrehoz egy új adminisztrátort az adminisztrátor azonosítójával és nevével.
     *
     * @param adminId Az adminisztrátor egyedi azonosítója.
     * @param adminNev Az adminisztrátor neve.
     */

    public Adminisztrator(String adminId, String adminNev) {
        this.adminId = adminId;
        this.adminNev = adminNev;
    }

    /**
     * Hozzáad egy új filmet a mozijegyrendszerhez.
     *
     * @param moziJegyrendszer A mozijegyrendszer, amelyhez a filmet hozzá kell adni.
     * @param film Az új film, amelyet létre kell hozni.
     */
    public void filmLetrehoz(MoziJegyrendszer moziJegyrendszer, Film film) {
        moziJegyrendszer.ujFilm(film);
        System.out.println("Film létrehozva: " + film.getCim());
    }

    /**
     * Töröl egy filmet a mozijegyrendszerből.
     *
     * @param moziJegyrendszer A mozijegyrendszer, amelyből a filmet törölni kell.
     * @param filmId A törölni kívánt film egyedi azonosítója.
     */

    public void filmTorol(MoziJegyrendszer moziJegyrendszer, String filmId) {
        boolean torolve = moziJegyrendszer.torolFilm(filmId);
        if (torolve) {
            System.out.println("Film törölve. ID: " + filmId);
        } else {
            System.out.println("Film törlése sikertelen. Film ID nem található: " + filmId);
        }
    }

    /**
     * Módosít egy meglévő filmet a mozijegyrendszerben.
     *
     * @param moziJegyrendszer A mozijegyrendszer, amelyben a filmet módosítani kell.
     * @param filmId A módosítani kívánt film egyedi azonosítója.
     * @param ujFilmAdatok Az új filmadatok, amelyekkel a filmet frissíteni kell.
     */

    public void filmModosit(MoziJegyrendszer moziJegyrendszer, String filmId, Film ujFilmAdatok) {
        boolean modositva = moziJegyrendszer.modositFilm(filmId, ujFilmAdatok);
        if (modositva) {
            System.out.println("Film módosítva. ID: " + filmId);
        } else {
            System.out.println("Film módosítása sikertelen. Film ID nem található: " + filmId);
        }
    }

    /**
     * Hozzáad egy új vetítést a mozijegyrendszerhez.
     *
     * @param moziJegyrendszer A mozijegyrendszer, amelyhez a vetítést hozzá kell adni.
     * @param vetites Az új vetítés, amelyet létre kell hozni.
     */

    public void vetitesLetrehoz(MoziJegyrendszer moziJegyrendszer, Vetites vetites) {
        moziJegyrendszer.ujVetites(vetites);
        System.out.println("Vetítés létrehozva. ID: " + vetites.getId());
    }

    /**
     * Töröl egy vetítést a mozijegyrendszerből.
     *
     * @param moziJegyrendszer A mozijegyrendszer, amelyből a vetítést törölni kell.
     * @param vetitesId A törölni kívánt vetítés egyedi azonosítója.
     */

    public void vetitesTorol(MoziJegyrendszer moziJegyrendszer, String vetitesId) {
        boolean torolve = moziJegyrendszer.torolVetites(vetitesId);
        if (torolve) {
            System.out.println("Vetítés törölve. ID: " + vetitesId);
        } else {
            System.out.println("Vetítés törlése sikertelen. Vetítés ID nem található: " + vetitesId);
        }
    }

    /**
     * Módosít egy meglévő vetítést a mozijegyrendszerben.
     *
     * @param moziJegyrendszer A mozijegyrendszer, amelyben a vetítést módosítani kell.
     * @param vetitesId A módosítani kívánt vetítés egyedi azonosítója.
     * @param ujVetitesAdatok Az új vetítés adatai, amelyekkel a vetítést frissíteni kell.
     */

    public void vetitesModosit(MoziJegyrendszer moziJegyrendszer, String vetitesId, Vetites ujVetitesAdatok) {
        boolean modositva = moziJegyrendszer.modositVetites(vetitesId, ujVetitesAdatok);
        if (modositva) {
            System.out.println("Vetítés módosítva. ID: " + vetitesId);
        } else {
            System.out.println("Vetítés módosítása sikertelen. Vetítés ID nem található: " + vetitesId);
        }
    }



}
