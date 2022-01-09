
/**
 * Neuron-Klasse welche die Eingangssignale fuer das neuronale Netz erzeugt.
 * 
 * @author Fiete Klotzbuecher
 * @version 2022-01-08
 */
public class Signal implements Neuron
{
    // Instanzvariablen
    private String _eingabe;

    /**
     * Konstruktor für Objekte der Klasse Signal
     */
    public Signal(String eingabe)
    {
        // Instanzvariable initialisieren
        _eingabe = eingabe;
    }

    /**
     * @return Ausgangswert des Neurons als String.
     */
    public String getAusgangswert()
    {
        return _eingabe;
    }
}
