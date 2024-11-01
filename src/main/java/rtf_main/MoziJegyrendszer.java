package rtf_main;

import Classes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MoziJegyrendszer {

    private static MoziJegyrendszer instance;
    private final List<Film> filmek;
    private final List<Mozi> mozik;
    private final Map<String, Vetites> vetitesek;
    private final Map<String, Foglalas> foglalasok;

    private static final AtomicLong foglalas_szamlalo = new AtomicLong(0);

    private MoziJegyrendszer(){
        filmek = new ArrayList<>();
        mozik = new ArrayList<>();
        vetitesek = new ConcurrentHashMap<>();
        foglalasok = new ConcurrentHashMap<>();
    }

    public static synchronized MoziJegyrendszer getInstance(){
        if (instance == null){
            instance = new MoziJegyrendszer();
        }
        return instance;
    }

    public void ujFilm(Film film){
        filmek.add(film);
    }
    public void ujMozi(Mozi mozi){
        mozik.add(mozi);
    }
    public void ujVetites(Vetites vetites){
        vetitesek.put(vetites.getId(), vetites);
    }
    public List<Film> getFilmek(){
        return filmek;
    }
    public List<Mozi> getMozik(){
        return mozik;
    }
    public Vetites getVetites(String vetitesId){
        return vetitesek.get(vetitesId);
    }

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

    private boolean SzekElerheto(Vetites vetites, List<Szek> kivalasztottSzekek) {
        for (Szek szek : kivalasztottSzekek) {
            Szek szekMutat = vetites.getSzekek().get(szek.getId());
            if (szekMutat == null || szekMutat.getSzekallapota() != SzekAllapota.SZABAD) {
                return false;
            }
        }
        return true;
    }
private void szeketLefoglal(Vetites vetites, List<Szek> kivalasztottSzekek){
        for (Szek szekek : kivalasztottSzekek){
            Szek szekMutat = vetites.getSzekek().get(szekek.getId());
            szekMutat.setAllapot(SzekAllapota.LEFOGLALVA);
        }
}
private double vetelArKiszamol(List<Szek> kivalasztottSzekek){
        return kivalasztottSzekek.stream().mapToDouble(Szek::getEgysegar).sum();
}
private String letrehozfoglalasId(){
        long foglalasUtolsosorszam = foglalas_szamlalo.incrementAndGet();
        Random random = new Random();
        String datum = LocalDate.now().toString();
        return foglalasUtolsosorszam + random.nextInt(500) + datum;

}
public synchronized void FoglalasVeglegesit(String foglalasId){
        Foglalas foglalas = foglalasok.get(foglalasId);
        if(foglalas != null || foglalas.getFoglalasallapota() == FoglalasAllapota.ELOFOGLALVA) {
            foglalas.setFoglalasAllapota(FoglalasAllapota.ELOFOGLALVA);

        }
}

public synchronized void FoglalasTorol(String foglalasId){
        Foglalas foglalas = foglalasok.get(foglalasId);
        if ( foglalas != null && foglalas.getFoglalasallapota() != FoglalasAllapota.TOROLVE){
            foglalas.setFoglalasAllapota(FoglalasAllapota.TOROLVE);
            szekElerheto(foglalas.getVetites(), foglalas.getSzekek());
        }
}
private void szekElerheto(Vetites vetites, List<Szek> szekek){
        for (Szek szek: szekek){
            Szek szekMutat = vetites.getSzekek().get(szek.getId());
            szekMutat.setAllapot(SzekAllapota.SZABAD);
        }


}



}





