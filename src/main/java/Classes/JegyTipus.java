package Classes;

/**
 * A JegyTipus enum a jegy típusát reprezentálja.
 */
public enum JegyTipus {
    /**
     * Normál jegy, teljes áron.
     */
    NORMAL,

    /**
     * Diákok számára kedvezményes jegy.
     */
    DIAK,

    /**
     * Nyugdíjasok számára kedvezményes jegy.
     */
    NYUGDIJAS,

    /**
     * Politikusi jegy, áfakedvezménnyel.
     */
    POLITIKUS,

    /**
     * Adományjegy, melyet segélyszolgálatok kapnak / használhatnak fel.
     */
    ADOMANY
}