package Classes;

/**
 * Az ErtesitesTipus enum az értesítések lehetséges típusait határozza meg,
 * amelyeket különböző csatornákon keresztül lehet továbbítani.
 */
public enum ErtesitesTipus {

    /**
     * E-mail alapú értesítés küldése.
     */
    EMAIL,

    /**
     * Mobiltelefon alapú értesítés küldése, például SMS-ben.
     */
    MOBIL,

    /**
     * Postai úton történő értesítés küldése.
     */
    POSTA,

    /**
     * Push értesítés küldése egy eszközre, például egy mobilalkalmazáson keresztül.
     */
    PUSH
}