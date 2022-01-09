import java.util.*;

/**
 * Neuron-Klasse welche die Ausgabewerte ihrer Eingangs-Neuronen verkettet.
 * Merkt sich die vorherige Ausgabe und stellt diese einer neuen voran.
 * 
 * @author Fiete Klotzbuecher
 * @version 2022-01-09
 */
public class KettenNeuron implements Neuron
{
    // Instanzvariablen
    private List<Neuron> _eingangsNeuronen;
    private String _alteAusgabe;

    /**
     * Konstruktor für Objekte der Klasse Signal.
     */
    public KettenNeuron()
    {
        // initialisiere Instanzvariablen
        _eingangsNeuronen = new ArrayList<Neuron>();
        _alteAusgabe = "";
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
     * Verkettet die Ausgabewerte der Eingangs-Neuronen getrennt durch Leerzeichen.
     *  Stellt eine vorherige Ausgabe voran.
     * @return Verkettete Werte mit vorangestellter vorheriger Ausgabe.
     */
    public String getAusgangswert()
    {
        // String neueAusgabe = _alteAusgabe;
        String neueEingabe = "";
        for (Neuron neuron : _eingangsNeuronen)
        {
            neueEingabe = neuron.getAusgangswert();
            if (!(neueEingabe == null) && !(neueEingabe.isEmpty()))
            {
                // _alteAusgabe += neueEingabe + " ";
                _alteAusgabe = String.join(" ", _alteAusgabe, neueEingabe);
                _alteAusgabe = _alteAusgabe.strip();
            }
        }
        // _alteAusgabe = neueAusgabe;
        return _alteAusgabe;
    }
}
