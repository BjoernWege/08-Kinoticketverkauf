package de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte;

/**
 * 
 */
public record Geldbetrag(int _eurocent) implements Comparable<Geldbetrag>
{
    /**
     * Erstellt ein Geldbetrag von einem int
     * @param eurocent
     * @assert istEingabeGueltig(eurocent) 
     * @return
     */
    public static Geldbetrag fromInt(int eurocent)
    {
        assert istEingabeGueltig(
                eurocent) : "Vorbedingung verletzt: istEingabeGueltig(eurocent)";
        return new Geldbetrag(eurocent);
    }

    /**
     * Erstellt ein Geldbetrag von einem String
     * @param eurocent
     * @assert istEingabeGueltig(eurocent) 
     * @return
     */
    public static Geldbetrag fromString(String eurocent)
    {
        assert istEingabeGueltig(
                eurocent) : "Vorbedingung verletzt: istEingabeGueltig(eurocent)";
        if (eurocent.contains(","))
        {
            eurocent = eurocent.replace(",", "");
            return new Geldbetrag(Integer.valueOf(eurocent));
        }
        return new Geldbetrag(Integer.valueOf(eurocent) * 100);
    }

    /**
     * Überprüft ob der eingegebene int als Geldbetrag dargestellt werden kann.
     * @param eurocent
     * @assert istEingabeGueltig(eurocent) 
     * @return
     */
    public static boolean istEingabeGueltig(int eurocent)
    {
        if (eurocent >= 0 && eurocent <= Integer.MAX_VALUE)
        {
            return true;
        }
        return false;
    }

    /**
     * Überprüft ob der eingegebene String als Geldbetrag dargestellt werden kann.
     * @param eurocent
     * @return
     */
    public static boolean istEingabeGueltig(String eurocent)
    {
        return eurocent.matches("[0-9]+(,[0-9]{2})?");
    }

    /**
     * Überprüft ob der übergebene Geldbatrag aufadiert werden kann. 
     * @param g
     * @return
     */
    public boolean istAddierenMoegelich(Geldbetrag g)
    {
        return this._eurocent + g._eurocent >= 0;
    }

    /**
     * Addiert den übergebenen Geldbetrag auf
     * @param g
     * @assert istAddierenMoegelich(g)
     * @return
     */
    public Geldbetrag addiere(Geldbetrag g)
    {
        assert istAddierenMoegelich(
                g) : "Vorbedingung verletzt: istAddierenMoegelich(g)";
        return new Geldbetrag(this._eurocent + g._eurocent);
    }

    /**
     * Überprüft ob der übergebene Geldbatrag g subtrahiert werden kann.
     * @param g
     * @return
     */
    public boolean istSubtrahierenMoegelich(Geldbetrag g)
    {
        return this._eurocent - g._eurocent >= 0;
    }

    /**
     * Subtrahiert den übergebenen Geldbetrag ab
     * @param g
     @assert istSubtrahierenMoegelich(g)
     * @return
     */
    public Geldbetrag subtrahiere(Geldbetrag g)
    {
        assert istSubtrahierenMoegelich(
                g) : "Vorbedingung verletzt: istSubtrahierenMoegelich(g)";
        return new Geldbetrag(this._eurocent - g._eurocent);
    }

    /**
     * Überprüft ob mit dem übergebenen faktor multipliziert werden kann.
     * @param faktor
     * @assert istMultiplizierenMoegelich(faktor)
     * @return
     */
    public boolean istMultiplizierenMoegelich(int faktor)
    {
        // Wie wird der Fall faktor = 0 behandelt
        return this._eurocent * faktor >= 0;
    }

    /**
     * Multipliziert mid dem übergebenen faktor
     * @param faktor
     * @return
     */
    public Geldbetrag multipliziere(int faktor)
    {
        assert istMultiplizierenMoegelich(
                faktor) : "Vorbedingung verletzt: istMultiplizierenMoegelich(faktor)";
        return new Geldbetrag(this._eurocent * faktor);
    }

    /**
     * @see
     */
    @Override
    public String toString()
    {
        String cent = String.valueOf(this._eurocent % 100);
        if (cent.length() < 2)
        {
            cent = "0" + cent;
        }
        String euro = String.valueOf(this._eurocent / 100);
        return euro + "," + cent;
    }

    @Override
    public int compareTo(Geldbetrag geldbetrag)
    {
        return Integer.compare(this._eurocent, geldbetrag._eurocent);
    }

}
