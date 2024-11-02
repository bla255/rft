package Test;

import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rtf_main.Main;
import rtf_main.MoziJegyrendszer;

import java.util.List;

import static Classes.JogosultsagTipus.NORMAL;
import static org.junit.jupiter.api.Assertions.*;

public class FelhasznaloTest {
    private MoziJegyrendszer moziJegyrendszer;

    @BeforeEach
    public void setUp() {
        moziJegyrendszer = Main.run();
    }


    @Test
    public void KonstruktorTeszt() {
        Felhasznalo user = new Felhasznalo("1", "testuser", "pw123", "Kovacs", "Janos", 1, "test@example.com", "123456789", NORMAL);
        assertEquals("1", user.getId());
        assertEquals("testuser", user.getFelhasznalonev());
        assertEquals("pw123", user.getJelszo());
        assertEquals("Kovacs", user.getVezeteknev());
        assertEquals("Janos", user.getKeresztnev());
        assertEquals(1, user.getNem()); // Itt vársz 1-et
        assertEquals("test@example.com", user.getEmail());
        assertEquals("123456789", user.getTelefon());
        assertEquals(NORMAL, user.getJogosultsagTipus());
    }


    @Test
    public void testGetFelhasznalonev() {
        Felhasznalo user = new Felhasznalo("2", "jancsika", "pw123", "kovacs", "janos", 1, "jani@nye.hu", "987654321", NORMAL);
        assertEquals("jancsika", user.getFelhasznalonev());
    }

    @Test
    public void testEmailFormat() {
        // Ellenőrizd, hogy a Felhasznalo konstruktor megfelelő paraméterekkel van használva
        Felhasznalo felhasznalo = new Felhasznalo("3", "margitka", "unokamlajos", "kovacs", "margit", 2, "kovacsmargit@eloremegyunk.hu", "987654321", NORMAL);
        assertNotNull(felhasznalo.getEmail(), "Az email nem lehet null");
        assertTrue(felhasznalo.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"), "Hibás email formátum");
    }

    @Test
    public void testMoziHozzaadas() {
        // Egy mozi hozzáadva a Mainban, teszteljük, hogy újra hozzáadható-e az első ID-jű mozi, ha a Main is setUp-ra elindult. Amennyiben nem, a tesztnek le kell futnia!
        List<Mozi> mozik = moziJegyrendszer.getMozik();
        assertEquals(1, mozik.size(), "A mozik száma nem megfelelő");
        Mozi mozi = mozik.get(0);
        assertEquals("Komolymozi", mozi.getNev());
        assertEquals("Nyiregyhaza", mozi.getVaros());
        assertEquals("Sostoi ut 34/E", mozi.getCim());
    }




}