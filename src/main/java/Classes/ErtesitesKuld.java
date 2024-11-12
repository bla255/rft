package Classes;


/**
 * Az ErtesitesKuld osztály az értesítések különböző
 * csatornákon való elküldésére hivatott, jelenleg e-mail, mobil típus támogatott.
 */


public class ErtesitesKuld {

    /**
     * Elküldi az értesítést a megadott címzettnek a megadott csatornán (pl. e-mail vagy mobil).
     * Az értesítési csatorna típusa szerint különböző formátumban jeleníti meg az értesítést.
     *
     * @param ertesites Az értesítés, amelyet el kell küldeni.
     * @param cimzett A címzett elérhetősége, pl. e-mail cím vagy telefonszám.
     * @param tipus Az értesítés típusa, amely meghatározza, hogy milyen típusú csatornán (e-mail vagy mobil) küldjük el az értesítést.
     *              Az érvényes értékek: "email", "mobil". Ha az érték ismeretlen a methódus számára, abban az esetben figyelmeztetést ad.
     */
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