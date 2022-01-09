import java.util.*;

/**
 * Neuron-Klasse welche aus den Ausgabewerten ihrer Eingangs-Neuronen das
 *  laengste Palindrom findet.
 * 
 * @author Fiete Klotzbuecher
 * @version 2022-01-08
 */
public class PalindromNeuron implements Neuron
{
    // Instanzvariablen
    private boolean _beachteGrossschreibung;
    private Set<Neuron> _eingangsNeuronen;

    /**
     * Konstruktor für Objekte der Klasse PalindromNeuron.
     * @param beachteGrossschreibung Legt fest, ob Grosschreibung beachtet
     *  werden soll.
     */
    public PalindromNeuron(boolean beachteGrossschreibung)
    {
        // initialisiere Instanzvariablen
        _beachteGrossschreibung = beachteGrossschreibung;
        _eingangsNeuronen = new HashSet<Neuron>();
    }

    /**
     * Fuegt ein neues Neuron zu den Eingangs-Neuronen hinzu.
     * @param neuesNeuron Neues Neuron.
     */
    public void eingangHinzufuegen(Neuron neuesNeuron)
    {
        _eingangsNeuronen.add(neuesNeuron);
    }

    /**
     * Sucht aus den Ausgabewerten der Eingangs-Neuronen das laengste Palindrom.
     * @return Laengstes gefundenes Palindrom. NULL wenn keins gefunden wurde.
     */
    public String getAusgangswert()
    {
        String laengstesPalindrom = "";
        // iteriere ueber Liste von Eingangs-Neuronen
        for (Neuron aktuellesNeuron : _eingangsNeuronen)
        {
            // speichere Ausgangswert des aktuellen Neurons als Eingabe
            String eingabe = aktuellesNeuron.getAusgangswert();
            // wenn Eingabe Palindrom und gleich/laenger als der bisherige Kandidat
            if (istPalindrom(eingabe, _beachteGrossschreibung) 
                && eingabe.length() >= laengstesPalindrom.length())
            {
                // setze neuen Kandidaten
                laengstesPalindrom = eingabe;
            }
        }
        // wenn kein Palindrom gefunden
        if (laengstesPalindrom == "")
        {
            return null;
        }
        return laengstesPalindrom;
    }

    /**
     * Prueft ob der Text ein Palindrom ist.
     *  Leerzeichen am Anfang und Ende werden entfernt.
     * @param text Der zu pruefende Text.
     * @param beachteGrossschreibung Legt fest, ob Grosschreibung beachtet
     *  werden soll.
     * @return True wenn der Text ist ein Palindrom ist.
     */
    private boolean istPalindrom(String text, boolean beachteGrossschreibung)
    {
        // entferne Leerzeichen
        text = text.strip();
        // wenn Text leer
        if (text.isEmpty())
        {
            return false;
        }
        // wenn Grossschreibung beachtet werden soll
        if(!beachteGrossschreibung)
        {
            text = text.toLowerCase();
        }
        // iteriere ueber Laenge des Textes; gleichzeitig von beiden Seiten
        for (int i = 0, j = (text.length() - 1); i <= j; i++, j--)
        {
            // pruefe auf Gleichheit der Zeichen
            if (!(text.charAt(i) == text.charAt(j)))
            {
                return false;
            }
        }
        return true;
    }
}
