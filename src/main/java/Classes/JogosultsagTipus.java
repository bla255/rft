package Classes;

/**
 * A JogosultsagTipus enum a felhasználói jogosultságokat írja le.
 */
public enum JogosultsagTipus {
    /**
     * Normál felhasználó, alapvető jogosultságokkal.
     */
    NORMAL,

    /**
     * Adminisztrátor, teljes hozzáféréssel.
     */
    ADMIN,

    /**
     * Operátor, technikai kezelői jogosultsággal.
     */
    OPERATOR,

    /**
     * Tulajdonos, a legmagasabb szintű hozzáféréssel.
     */
    TULAJDONOS,

    /**
     * Pénzügyi részleg számára biztosított jogosultság.
     */
    PENZUGY,

    /**
     * Jegyárus, aki jogosult jegyekkel kapcsolatos műveletekre.
     */
    JEGYARUS
}