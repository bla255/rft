package Classes;

public class ErtesitesKuld {
    public static void kuldes(Ertesites ertesites, String cimzett, String tipus) {
        switch (tipus.toLowerCase()) {
            case "email":
                System.out.println("Értesítés küldése e-mailben a következő címre: " + cimzett);
                System.out.println("Tartalom: " + ertesites.getTartalom());
                break;
            case "mobil":
                System.out.println("Értesítés küldése mobilra a következő számra: " + cimzett);
                System.out.println("Tartalom: " + ertesites.getTartalom());
                break;
            default:
                System.out.println("Ismeretlen értesítési típus: " + tipus);
        }
    }
}