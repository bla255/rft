package Classes;

import rtf_main.MoziJegyrendszer;

public class Adminisztrator {
    private String adminId;
    private String adminNev;

    public Adminisztrator(String adminId, String adminNev) {
        this.adminId = adminId;
        this.adminNev = adminNev;
    }

    // Film létrehozása
    public void filmLetrehoz(MoziJegyrendszer moziJegyrendszer, Film film) {
        moziJegyrendszer.ujFilm(film);
        System.out.println("Film létrehozva: " + film.getCim());
    }

    // Film törlése
    public void filmTorol(MoziJegyrendszer moziJegyrendszer, String filmId) {
        boolean torolve = moziJegyrendszer.torolFilm(filmId);
        if (torolve) {
            System.out.println("Film törölve. ID: " + filmId);
        } else {
            System.out.println("Film törlése sikertelen. Film ID nem található: " + filmId);
        }
    }

    // Film módosítása
    public void filmModosit(MoziJegyrendszer moziJegyrendszer, String filmId, Film ujFilmAdatok) {
        boolean modositva = moziJegyrendszer.modositFilm(filmId, ujFilmAdatok);
        if (modositva) {
            System.out.println("Film módosítva. ID: " + filmId);
        } else {
            System.out.println("Film módosítása sikertelen. Film ID nem található: " + filmId);
        }
    }

    // Vetítés létrehozása
    public void vetitesLetrehoz(MoziJegyrendszer moziJegyrendszer, Vetites vetites) {
        moziJegyrendszer.ujVetites(vetites);
        System.out.println("Vetítés létrehozva. ID: " + vetites.getId());
    }

    // Vetítés törlése
    public void vetitesTorol(MoziJegyrendszer moziJegyrendszer, String vetitesId) {
        boolean torolve = moziJegyrendszer.torolVetites(vetitesId);
        if (torolve) {
            System.out.println("Vetítés törölve. ID: " + vetitesId);
        } else {
            System.out.println("Vetítés törlése sikertelen. Vetítés ID nem található: " + vetitesId);
        }
    }

    // Vetítés módosítása
    public void vetitesModosit(MoziJegyrendszer moziJegyrendszer, String vetitesId, Vetites ujVetitesAdatok) {
        boolean modositva = moziJegyrendszer.modositVetites(vetitesId, ujVetitesAdatok);
        if (modositva) {
            System.out.println("Vetítés módosítva. ID: " + vetitesId);
        } else {
            System.out.println("Vetítés módosítása sikertelen. Vetítés ID nem található: " + vetitesId);
        }
    }



}
