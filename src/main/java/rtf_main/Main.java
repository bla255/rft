package rtf_main;

import Classes.*;

import java.time.LocalDateTime;
import java.util.*;


/**
 * A rendszer felhasználók számára mozijegyek foglalását biztosít. A felhasználó kiválaszthatja a filmeket,
 *  * a vetítéseket, és lefoglalhatja a székeket a kívánt időpontokban.
 * @author Orosz Richard, Kulcsar Bela, Kocserha Patrik
 * @version 0.1 alpha
 */


public class Main {



    /**
     * Az alapértelmezett konstruktor a Main osztály számára.
     * A konstruktor automatikusan létrehozza a MoziJegyrendszer példányt.
     */
    public Main() {
        //Üres konstruktor
    }


    /**
     * A fő függvény, amely elindítja a mozi jegyrendszert és végrehajtja az alapvető műveleteket.
     * @param args parancssori argumentumok
     */

    public static void main(String[] args) {
        MoziJegyrendszer moziJegyrendszer = run();

    }

    /**
     * Inicializálja a mozi jegyrendszert, létrehoz filmeket, mozikat, vetítéseket,
     * valamint végrehajt egy jegyfoglalást, majd kiírja a rendszer adatait.
     *
     * @return A MoziJegyrendszer példány
     */

    public static MoziJegyrendszer run() {
        MoziJegyrendszer moziJegyrendszer = MoziJegyrendszer.getInstance();

        // Filmek létrehozása és hozzáadása a rendszerhez
        Film elsofilm = new Film("1", "Patrik filmje", "Patrik nagyonjo filme a lolbol", "Vicces", 50, "2024-01-01", "1");
        Film masodikfilm = new Film("1", "Ricsi filmje", "Ricsi osszecsap a focihuliganokkal a varosba", "Drama", 90, "2022-01-01", "0");
        Film harmadikfilm = new Film("1", "Bela es a gombgyar", "Bela a gyarban nem dolgozik rendesen", "Eletrajz", 5, "2000-01-01", "0");
        moziJegyrendszer.ujFilm(elsofilm);
        moziJegyrendszer.ujFilm(masodikfilm);
        moziJegyrendszer.ujFilm(harmadikfilm);

        // Mozi létrehozása és hozzáadása
        Mozi mozi = new Mozi("1", "Komolymozi", "Nyiregyhaza", "Sostoi ut 34/E", new ArrayList<>());
        moziJegyrendszer.ujMozi(mozi);

        // Vetítés létrehozása
        LocalDateTime kezdes = LocalDateTime.of(2024, 8, 1, 13, 30);
        LocalDateTime befejezes = LocalDateTime.of(2024, 8, 1, 15, 30);
        Map<String, Szek> szekek = SzekekLetrehozasa(3, 3);
        Vetites vetites1 = new Vetites("V1", elsofilm, mozi, kezdes, befejezes, szekek);

        // Foglalás létrehozása
        Felhasznalo felhasznalo = new Felhasznalo("1", "jegyvasrlo123", "asdasd", "Kiss", "Jancsi", 1,"teszt@teszt.hu", "3630303030", JogosultsagTipus.NORMAL);

        List<Szek> kivalasztottSzek = Arrays.asList(vetites1.getSzekek().get("1-3"), vetites1.getSzekek().get("1-2"));
        Foglalas foglalas = moziJegyrendszer.foglaltJegyek(felhasznalo, vetites1, kivalasztottSzek);

        // Filmek és vetítések adatai kiírása
        for (Film film : moziJegyrendszer.getFilmek()) {
            System.out.println("Film címe: " + film.getCim());
            System.out.println("Leírás: " + film.getLeiras());
            System.out.println("Műfaj: " + film.getMufaj());
            System.out.println("Hossz: " + film.getFilmhossza() + " perc");
            System.out.println("Megjelenési dátum: " + film.getMegjelenes());
            System.out.println("------");
        }

        // Vetítés adatok kiírása
        System.out.println("Vetítés ID: " + vetites1.getId());
        System.out.println("Film címe: " + vetites1.getFilm().getCim());
        System.out.println("Mozi neve: " + vetites1.getMozi().getNev() + ", "+ vetites1.getMozi().getVaros() + ", "+ vetites1.getMozi().getCim());
        System.out.println("Kezdés időpontja: " + vetites1.getKezdes());
        System.out.println("Befejezés időpontja: " + vetites1.getBefejezes());

        // Székadatok kiírása
        for (Map.Entry<String, Szek> entry : szekek.entrySet()) {
            Szek szek = entry.getValue();
            System.out.println("Elhelyezkedés: " + szek.getId());
            System.out.println("Oszlop: " + szek.getOszlop());
            System.out.println("Sor: " + szek.getSor());
            System.out.println("Széktípus: " + szek.getSzektipus());
            System.out.println("Egységár: " + szek.getEgysegar() + " Forint");
            System.out.println("Szék állapota: " + szek.getSzekallapota());
            System.out.println("------");
        }

        // Foglalás állapotának ellenőrzése és véglegesítése
        if (foglalas != null) {
            System.out.println("Szekek befoglalasa sikeres. Tranzakcioazonosito: " + foglalas.getId());
            moziJegyrendszer.FoglalasVeglegesit(foglalas.getId());

        } else {
            System.out.println("Szekek befoglalasa nem sikerult, talan nem szabadok a kivalasztott helyek?");
        }

        // Foglalás nyugtájának kiírása
        System.out.println("------Vasarlas adatai--------");
            System.out.println("Foglalás id: " + foglalas.getId());
            System.out.println("Foglalás állapota: " + foglalas.getFoglalasallapota());
            System.out.println("Foglalás tulajdonosa: " + foglalas.getFelhasznalo().getFelhasznalonev() + " (Jogosultsagszint: " + foglalas.getFelhasznalo().getJogosultsagTipus());
            System.out.println("Foglalás filmje: " + foglalas.getVetites().getFilm().getCim());
        System.out.println("Lefoglalt székek:");
        for (Szek szek : foglalas.getSzekek()) {
            System.out.println(szek);
        }
            System.out.println("Vételár összesen: " + foglalas.getvetelArosszesen() + " Forint");



        //Letrehozott foglalas torles
        //moziJegyrendszer.FoglalasTorol(foglalas.getId());
       // System.out.println("Foglalast toroltem, Foglalas azonositoja: " + foglalas.getId());

        /*
        //Értesítés paraméterek, kiküldés - csak szemléltetés!
        Ertesites ertesites = new Ertesites("1", "Teszt értesítés.");
         Értesítés küldése e-mail címre
        ertesites.kuldesErtesites("teszt@emailcim.hu", "email");
        Értesítés küldése mobilra
        ertesites.kuldesErtesites("36302897995", "mobil");
        */



        return moziJegyrendszer;
    }

    /**
     * Létrehozza a székek térképét a mozi vetítéshez a megadott sorok és oszlopok számával.
     *
     * @param oszlopokszama A székek oszlopainak száma
     * @param sorokszama A székek sorainak száma
     * @return A székek tárképe, amely székazonosítók és a székek objektumai közötti kapcsolatot hozzák létre
     */
    private static Map<String, Szek> SzekekLetrehozasa(int oszlopokszama, int sorokszama) {
        Map<String, Szek> szekek = new HashMap<>();
        for (int oszlop = 1; oszlop <= oszlopokszama; oszlop++) {
            for (int sor = 1; sor <= sorokszama; sor++) {
                String szekId = oszlop+"-"+sor;
                if (oszlop == 1 && sor == 1) {
                    SzekTipus szekTipus = SzekTipus.VIP;
                    double ar = 999;
                    Szek szek = new Szek(szekId, oszlop, sor, szekTipus, ar, SzekAllapota.SZABAD);
                    szekek.put(szekId, szek); // Hozzáadás a kollekcióhoz
                } else {
                    SzekTipus szekTipus = SzekTipus.SIMA;
                    double ar = 100;
                    Szek szek = new Szek(szekId, oszlop, sor, szekTipus, ar, SzekAllapota.SZABAD);
                    szekek.put(szekId, szek);
                }
            }
        }
        return szekek;
    }

        }

