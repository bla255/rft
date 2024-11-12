package Classes;

/**
 * A SzekAllapota enum a székek aktuális állapotát írja le.
 */
public enum SzekAllapota {
    /**
     * Szabad szék, foglalható.
     */
    SZABAD,

    /**
     * A szék le van foglalva.
     */
    LEFOGLALVA,

    /**
     * Nem elérhető szék, nem foglalható.
     */
    NEM_ELERHETO
}