package rtf_main;

import Classes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * A MoziJegyrendszer osztály kezeli a mozi jegyrendszerét, beleértve a filmeket, mozikat, vetítéseket és foglalásokat.
 * Singleton design pattern-t alkalmaz, hogy csak egy példány legyen az alkalmazás futása alatt.
 */

public class MoziJegyrendszer {

    private static MoziJegyrendszer instance;
    private final List<Film> filmek;
    private final List<Mozi> mozik;
    private final Map<String, Vetites> vetitesek;
    private final Map<String, Foglalas> foglalasok;

    private static final AtomicLong foglalas_szamlalo = new AtomicLong(0);

    /**
     * Privát konstruktor, hogy a MoziJegyrendszer osztály egyetlen példányban működjön.
     * Inicializálja a filmek, mozik, vetítések és foglalások listáját.
     */

    private MoziJegyrendszer(){
        filmek = new ArrayList<>();
        mozik = new ArrayList<>();
        vetitesek = new ConcurrentHashMap<>();
        foglalasok = new ConcurrentHashMap<>();
    }

    /**
     * Visszaadja a MoziJegyrendszer egyetlen példányát.
     * Ha még nincs példány, létrehozza.
     *
     * @return A MoziJegyrendszer példánya.
     */

    public static synchronized MoziJegyrendszer getInstance(){
        if (instance == null){
            instance = new MoziJegyrendszer();
        }
        return instance;
    }

    /**
     * Új film hozzáadása a rendszerhez.
     *
     * @param film A hozzáadandó film.
     */

    public void ujFilm(Film film){
        filmek.add(film);
    }

    /**
     * Új mozi hozzáadása a rendszerhez.
     *
     * @param mozi A hozzáadandó mozi.
     */

    public void ujMozi(Mozi mozi){
        mozik.add(mozi);
    }

    /**
     * Új vetítés hozzáadása a rendszerhez.
     *
     * @param vetites A hozzáadandó vetítés.
     */

    public void ujVetites(Vetites vetites){
        vetitesek.put(vetites.getId(), vetites);
    }
    /**
     * Visszaadja a filmek listáját.
     *
     * @return A filmek listája.
     */

    public List<Film> getFilmek(){
        return filmek;
    }
    /**
     * Visszaadja a mozik listáját.
     *
     * @return A mozik listája.
     */

    public List<Mozi> getMozik(){
        return mozik;
    }
    /**
     * Visszaadja a vetítést a vetítés azonosítója alapján.
     *
     * @param vetitesId A vetítés azonosítója.
     * @return A keresett vetítés, vagy null, ha nem található.
     */

    public Vetites getVetites(String vetitesId){
        return vetitesek.get(vetitesId);
    }

    /**
     * Foglalás létrehozása a felhasználó számára.
     *
     * @param felhasznalo A felhasználó, aki foglal.
     * @param vetites A vetítés, amelyre foglalni szeretne.
     * @param kivalasztottSzekek A foglalni kívánt székek.
     * @return A létrehozott foglalás, ha sikerült, egyébként null.
     */

    public synchronized Foglalas foglaltJegyek(Felhasznalo felhasznalo, Vetites vetites, List<Szek> kivalasztottSzekek){
        if (SzekElerheto(vetites, kivalasztottSzekek)){
            szeketLefoglal(vetites, kivalasztottSzekek);
            double fizetendo = vetelArKiszamol(kivalasztottSzekek);
            String foglalasId = letrehozfoglalasId();
            Foglalas foglalas = new Foglalas(foglalasId, felhasznalo, vetites, kivalasztottSzekek, fizetendo, FoglalasAllapota.ELOFOGLALVA);
            foglalasok.put(foglalasId, foglalas);
            return foglalas;
        }
        return null;

    }
    /**
     * Ellenőrzi, hogy a kiválasztott székek elérhetők-e a vetítésen.
     *
     * @param vetites A vetítés.
     * @param kivalasztottSzekek A kiválasztott székek.
     * @return True, ha minden szék elérhető, különben false.
     */

    public boolean SzekElerheto(Vetites vetites, List<Szek> kivalasztottSzekek) {
        for (Szek szek : kivalasztottSzekek) {
            Szek szekMutat = vetites.getSzekek().get(szek.getId());
            if (szekMutat == null || szekMutat.getSzekallapota() != SzekAllapota.SZABAD) {
                return false;
            }
        }
        return true;
    }
    /**
     * Lefoglalja a kiválasztott székeket.
     *
     * @param vetites A vetítés, ahol a székek le lesznek foglalva.
     * @param kivalasztottSzekek A kiválasztott székek.
     */

private void szeketLefoglal(Vetites vetites, List<Szek> kivalasztottSzekek){
        for (Szek szekek : kivalasztottSzekek){
            Szek szekMutat = vetites.getSzekek().get(szekek.getId());
            szekMutat.setAllapot(SzekAllapota.LEFOGLALVA);
        }
}
    /**
     * Kiszámolja a kiválasztott székek összes vételárát.
     *
     * @param kivalasztottSzekek A kiválasztott székek.
     * @return A kiválasztott székek összes vételára.
     */

private double vetelArKiszamol(List<Szek> kivalasztottSzekek){
        return kivalasztottSzekek.stream().mapToDouble(Szek::getEgysegar).sum();
}
    /**
     * Létrehozza a foglalás egyedi azonosítóját.
     *
     * @return A foglalás egyedi azonosítója.
     */

private String letrehozfoglalasId(){
        long foglalasUtolsosorszam = foglalas_szamlalo.incrementAndGet();
        Random random = new Random();
        String datum = LocalDate.now().toString();
        return foglalasUtolsosorszam + random.nextInt(500) + datum;

}
    /**
     * A foglalás véglegesítése, azaz az állapotot ELOFOGLALVA-ra módosítja.
     *
     * @param foglalasId A foglalás azonosítója.
     */


public synchronized void FoglalasVeglegesit(String foglalasId){
        Foglalas foglalas = foglalasok.get(foglalasId);
        if(foglalas != null || foglalas.getFoglalasallapota() == FoglalasAllapota.ELOFOGLALVA) {
            foglalas.setFoglalasAllapota(FoglalasAllapota.ELOFOGLALVA);

        }
}
    /**
     * A foglalás törlése, ha nem volt még törölve.
     *
     * @param foglalasId A törlendő foglalás azonosítója.
     */

public synchronized void FoglalasTorol(String foglalasId){
        Foglalas foglalas = foglalasok.get(foglalasId);
        if ( foglalas != null && foglalas.getFoglalasallapota() != FoglalasAllapota.TOROLVE){
            foglalas.setFoglalasAllapota(FoglalasAllapota.TOROLVE);
            szeketLefoglal(foglalas.getVetites(), foglalas.getSzekek());
        }
}
    /**
     * Ellenőrzi, hogy a székek elérhetők-e a vetítésen.
     *
     * @param vetites A vetítés.
     * @param szekek A székek.
     */

private void szekElerheto(Vetites vetites, List<Szek> szekek){
        for (Szek szek: szekek){
            Szek szekMutat = vetites.getSzekek().get(szek.getId());
            szekMutat.setAllapot(SzekAllapota.SZABAD);
        }


}
    /**
     * Film törlése az azonosítója alapján.
     *
     * @param filmId A törlendő film azonosítója.
     * @return True, ha a film sikeresen törlésre került, különben false.
     */

    public boolean torolFilm(String filmId) {
        return filmek.removeIf(film -> film.getId().equals(filmId));
    }

    /**
     * Film módosítása az azonosítója alapján.
     *
     * @param filmId Az azonosító, amely alapján a filmet módosítjuk.
     * @param ujFilmAdatok Az új film adatainak objektuma.
     * @return True, ha sikerült a film módosítása, különben false.
     */

    public boolean modositFilm(String filmId, Film ujFilmAdatok) {
        for (int i = 0; i < filmek.size(); i++) {
            if (filmek.get(i).getId().equals(filmId)) {
                filmek.set(i, ujFilmAdatok);
                return true;
            }
        }
        return false;
    }

    /**
     * Vetítés törlése az azonosítója alapján.
     *
     * @param vetitesId A törlendő vetítés azonosítója.
     * @return True, ha a vetítés sikeresen törlésre került, különben false.
     */

    public boolean torolVetites(String vetitesId) {
        Vetites toroltVetites = vetitesek.remove(vetitesId);
        if (toroltVetites != null) {
            szekElerheto(toroltVetites, new ArrayList<>(toroltVetites.getSzekek().values())); // székek felszabadítása
            return true;
        }
        return false;
    }

    /**
     * Vetítés módosítása az azonosítója alapján.
     *
     * @param vetitesId Az azonosító, amely alapján a vetítést módosítjuk.
     * @param ujVetitesAdatok Az új vetítés adatainak objektuma.
     * @return True, ha sikerült a vetítés módosítása, különben false.
     */

    public boolean modositVetites(String vetitesId, Vetites ujVetitesAdatok) {
        if (vetitesek.containsKey(vetitesId)) {
            vetitesek.put(vetitesId, ujVetitesAdatok);
            return true;
        }
        return false;
    }

    /**
     * Visszaadja a foglalást az azonosítója alapján.
     *
     * @param foglalasId A foglalás azonosítója.
     * @return A keresett foglalás, vagy null, ha nem található.
     */

    public Foglalas getFoglalas(String foglalasId) {
        return foglalasok.get(foglalasId);
    }

}





