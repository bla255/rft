package Classes;

import java.util.List;
public class Foglalas {
    private final String id;
    private final Felhasznalo felhasznalo;
    private final Vetites vetites;
    private final List<Szek> szekek;
    private final double vetelArosszesen;
    private FoglalasAllapota foglalasallapota;

    public Foglalas(String id, Felhasznalo felhasznalo, Vetites vetites, List<Szek> szekek, double vetelArosszesen, FoglalasAllapota foglalasallapota) {
        this.id = id;
        this.felhasznalo = felhasznalo;
        this.vetites = vetites;
        this.szekek = szekek;
        this.vetelArosszesen = vetelArosszesen;
        this.foglalasallapota = foglalasallapota;
    }


    public void setFoglalasAllapota(FoglalasAllapota foglalasallapota){
            this.foglalasallapota = foglalasallapota;
}

public String getId(){
            return id;
}

public Felhasznalo getFelhasznalo(){
            return felhasznalo;
}

    public void setFoglalasallapota(FoglalasAllapota foglalasallapota) {
        this.foglalasallapota = foglalasallapota;
    }

    public Vetites getVetites(){
            return vetites;
}
public List<Szek> getSzekek(){
            return szekek;
}
public double getvetelArosszesen(){
            return vetelArosszesen;
}
public FoglalasAllapota getFoglalasallapota(){
            return foglalasallapota;

}
}
