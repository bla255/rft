package Classes;

/**
 * A FizetesiMod enum a lehetséges fizetési módokat reprezentálja.
 */
public enum FizetesiMod {
    /**
     * Készpénzes fizetési mód.
     */
    KESZPENZ,

    /**
     * Bankkártyás fizetési mód.
     */
    BANKKARTYA,

    /**
     * Utalvánnyal történő fizetés.
     */
    VOUCHER,

    /**
     * Belső felhasználással történő fizetés, például alkalmazotti kedvezmény.
     */
    BELSO_FELHASZNALAS
}