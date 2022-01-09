import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Die Test-Klasse KettenNeuronTest.
 *
 * @author Fiete Klotzbuecher
 * @version 2022-01-09
 */
public class KettenNeuronTest
{
    // Instanzvariablen
    private List<String> _wortliste;

    /**
     * Konstruktor für Objekte der Test-Klasse KettenNeuronTest.
     */
    public KettenNeuronTest()
    {
        // erzeuge Wortliste
        _wortliste = new ArrayList<String>();
        _wortliste.add("abc");
        _wortliste.add("def");
        _wortliste.add("ghi");
        _wortliste.add("jkl");
        _wortliste.add("mno");
        _wortliste.add("");
        _wortliste.add(" ");
        _wortliste.add("äüö");
        _wortliste.add("-_'");
    }

    /**
     * Testet mit einer Wortliste, ob der Ausgangswert der Eingabe entspricht.
     */
    @Test
    public void testNeuesNeuron()
    {
        // teste auf Standardrueckgabe ""
        KettenNeuron neuron = new KettenNeuron();
        assertEquals("", neuron.getAusgangswert());
    }

    /**
     * Testet die Verkettungsfunktion eines Neurons mit einer Wortliste.
     */
    @Test
    public void testVerkettungListe()
    {
        // lokale Variablen
        KettenNeuron neuron = new KettenNeuron();
        Signal signal;
        String verkettung = "";
        // fuer jedes Wort
        for (String wort : _wortliste)
        {
            // fuege Signaleingang hinzu
            signal = new Signal(wort);
            neuron.eingangHinzufuegen(signal);
            // wenn Wort nicht NULL oder leer ist
            if ((wort != null) && (!wort.isEmpty()))
            {
                // fuege Wort der erwarteten Verkettung hinzu
                verkettung = String.join(" ", verkettung, wort);
                verkettung = verkettung.strip();
            }
        }
        // pruefe Ausgabe des Neurons
        assertEquals(verkettung, neuron.getAusgangswert());
    }

    /**
     * Testet die Verkettungsfunktion eines Neurons 100 Mal hintereinander mit
     * zufaelligen Strings der Laenge 0 bis 9.
     */
    @Test
    public void testVerkettungZufall()
    {
        // lokale Variablen
        KettenNeuron neuron = new KettenNeuron();
        Signal signal;
        List<String> zufallsliste = new ArrayList<String>();
        String verkettung = "";
        // fuege 100 zufaellige Woerter zu Zufallsliste hinzu
        for (int i=0; i<100; i++)
        {
            zufallsliste.add(neuesWort());
        }
        // fuer jedes Wort
        for (String wort : zufallsliste)
        {
            // fuege Signaleingang hinzu
            signal = new Signal(wort);
            neuron.eingangHinzufuegen(signal);
            // wenn Wort nicht NULL oder leer ist
            if ((wort != null) && (!wort.isEmpty()))
            {
                // fuege Wort der erwarteten Verkettung hinzu
                verkettung = String.join(" ", verkettung, wort);
                verkettung = verkettung.strip();
            }
        }
        // pruefe Ausgabe des Neurons
        assertEquals(verkettung, neuron.getAusgangswert());
    }

    /**
     * Testet die Gedaechtnisfunktion eines Neurons mit einer Wortliste.
     */
    @Test
    public void testLetzteAusgabeListe()
    {
        // lokale Variablen
        KettenNeuron neuron = new KettenNeuron();
        Signal signal;
        String erwarteteAusgabe = "";
        String verketteteEingabe = "";
        String neueEingabe = "";
        // fuer jedes Wort
        for (String wort : _wortliste)
        {
            // fuege verkettete und neue Eingabe zur erwarteten Ausgabe hinzu
            erwarteteAusgabe = String.join(" ", erwarteteAusgabe, verketteteEingabe);
            erwarteteAusgabe = String.join(" ", erwarteteAusgabe, neueEingabe);
            erwarteteAusgabe = erwarteteAusgabe.strip();
            // fuege Signaleingang hinzu
            signal = new Signal(neueEingabe);
            neuron.eingangHinzufuegen(signal);
            // pruefe Ausgabe des Neurons
            assertEquals(erwarteteAusgabe, neuron.getAusgangswert());
            // erweitere verkettete Eingabe
            verketteteEingabe = String.join(" ", verketteteEingabe, neueEingabe);
            verketteteEingabe = verketteteEingabe.strip();
            // erzeuge neue Eingabe
            neueEingabe = wort;
        }
    }

    /**
     * Testet die Gedaechtnisfunktion eines Neurons 100 Mal hintereinander mit
     * zufaelligen Strings der Laenge 0 bis 9.
     */
    @Test
    public void testLetzteAusgabeZufall()
    {
        // lokale Variablen
        KettenNeuron neuron = new KettenNeuron();
        Signal signal;
        String erwarteteAusgabe = "";
        String verketteteEingabe = "";
        String neueEingabe = "";
        // wiederhole 100 mal
        for (int i=0; i<100; i++)
        {
            // fuege verkettete und neue Eingabe zur erwarteten Ausgabe hinzu
            erwarteteAusgabe = String.join(" ", erwarteteAusgabe, verketteteEingabe);
            erwarteteAusgabe = String.join(" ", erwarteteAusgabe, neueEingabe);
            erwarteteAusgabe = erwarteteAusgabe.strip();
            // fuege Signaleingang hinzu
            signal = new Signal(neueEingabe);
            neuron.eingangHinzufuegen(signal);
            // pruefe Ausgabe des Neurons
            assertEquals(erwarteteAusgabe, neuron.getAusgangswert());
            // erweitere verkettete Eingabe
            verketteteEingabe = String.join(" ", verketteteEingabe, neueEingabe);
            verketteteEingabe = verketteteEingabe.strip();
            // erzeuge neue Eingabe
            neueEingabe = neuesWort();
        }
    }

    /**
     * Erzeugt ein zufaelliges Wort mit 0 bis 9 Zeichen.
     * Moeglich sind alle Zeichen ASCII von ' ' bis '~'
     * @return Zufaelliges Wort
     */
    private String neuesWort()
    {
        // lokale Variablen
        Random ran = new Random();
        String wort = "";
        // zufaellige Wortlaenge 0-9
        int wortlaenge = ran.nextInt(10);
        // zufeallige ASCII Charaktere ' ' bis '~'
        for (int j=0; j<wortlaenge; j++)
        {
            wort = wort + (char)(ran.nextInt('~'-' ') + ' ');
        }
        // gebe Wort zurueck
        return wort;
    }
}
