package de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{
    @Test
    public void testGeldbetragFromInt()
    {
        // gueltig:   2005 ; 1 ; 0 ; 
        // ungueltig: -1 ; 

        assertTrue(Geldbetrag.istEingabeGueltig(2005));
        assertTrue(Geldbetrag.istEingabeGueltig(1));
        assertTrue(Geldbetrag.istEingabeGueltig(0));
        assertFalse(Geldbetrag.istEingabeGueltig(-1));
    }

    @Test
    public void testGeldbetragFromString()
    {
        // gueltig:   20,05 ; 20 ; 2,15 ; 020 ; 
        // ungueltig: 20,5  ; "" ; 20,  ; ,05 ; "," ; "a"

        Geldbetrag g1 = Geldbetrag.fromString("20,05");
        Geldbetrag g2 = Geldbetrag.fromString("20");
        Geldbetrag g3 = Geldbetrag.fromString("2,15");

        assertEquals(Geldbetrag.fromInt(2005), g1);
        assertEquals(Geldbetrag.fromInt(2000), g2);
        assertEquals(Geldbetrag.fromInt(215), g3);

        assertFalse(Geldbetrag.istEingabeGueltig("a"));
        assertFalse(Geldbetrag.istEingabeGueltig(","));
        assertFalse(Geldbetrag.istEingabeGueltig("-20"));
        assertFalse(Geldbetrag.istEingabeGueltig("20,"));
        assertFalse(Geldbetrag.istEingabeGueltig(",05"));
        assertFalse(Geldbetrag.istEingabeGueltig("20,5"));
       
        assertFalse(Geldbetrag.istEingabeGueltig("21474836,47"));
        assertFalse(Geldbetrag.istEingabeGueltig("21474836"));
    }

    @Test
    public void testAddiereGeldbetraege()
    {
        Geldbetrag g = new Geldbetrag(100);

        assertTrue(g.istAddierenMoegelich(g));
        assertTrue(g.addiere(g)
            .equals(new Geldbetrag(200)));

        assertFalse(g.istAddierenMoegelich(new Geldbetrag(Integer.MAX_VALUE)));
    }

    @Test
    public void testSubtrahiereGeldbetraege()
    {
        Geldbetrag g1 = new Geldbetrag(100);
        Geldbetrag g2 = new Geldbetrag(200);

        assertTrue(g2.istSubtrahierenMoegelich(g1));
        assertTrue(g2.subtrahiere(g1)
            .equals(g1));

        assertFalse(g1.istSubtrahierenMoegelich(g2));
    }

    @Test
    public void testMultipliziereGeldbetraege()
    {
        Geldbetrag g = new Geldbetrag(100);

        assertTrue(g.istMultiplizierenMoegelich(2));
        assertTrue(g.multipliziere(2)
            .equals(new Geldbetrag(200)));

        assertFalse(g.istAddierenMoegelich(new Geldbetrag(Integer.MAX_VALUE)));
    }

    @Test
    public void testToString()
    {
        Geldbetrag g1 = Geldbetrag.fromInt(20005);
        Geldbetrag g2 = Geldbetrag.fromInt(2);
        Geldbetrag g3 = Geldbetrag.fromInt(215);
        assertEquals("200,05", g1.toString());
        assertEquals("0,02", g2.toString());
        assertEquals("2,15", g3.toString());
    }

    @Test
    public void testComparable()
    {
        Geldbetrag g1 = Geldbetrag.fromInt(100);
        Geldbetrag g2 = Geldbetrag.fromInt(200);
        Geldbetrag g3 = Geldbetrag.fromString("2,00");

        assertTrue(g1.compareTo(g2) == -1);
        assertTrue(g2.compareTo(g1) == 1);
        assertTrue(g2.compareTo(g3) == 0);

        assertFalse(g1.compareTo(g2) == 1);
        assertFalse(g1.compareTo(g2) == 0);
        assertFalse(g2.compareTo(g3) == 1);
        assertFalse(g2.compareTo(g3) == -1);
    }
}
