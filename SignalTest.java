import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Die Test-Klasse SignalTest.
 *
 * @author Fiete Klotzbuecher
 * @version 2022-01-09
 */
public class SignalTest
{
    /**
     * Testet mit einer Wortliste, ob der Ausgangswert der Eingabe entspricht.
     */
    @Test
    public void testAusgangswertListe()
    {
        // erzeuge Wortliste
        Set<String> wortliste = new HashSet<String>();
        wortliste.add("");
        wortliste.add(" ");
        wortliste.add("  ");
        wortliste.add("hello");
        wortliste.add(" hello");
        wortliste.add("hello ");
        wortliste.add(" hello ");
        wortliste.add(" hel lo ");
        wortliste.add("Hello");
        wortliste.add("HELLO");

        // pruefe jeweils Ausgabe des Neurons
        for (String wort : wortliste)
        {
            Signal neuron = new Signal(wort);
            assertEquals(wort, neuron.getAusgangswert());
        }
    }

    /**
     * Testet mit zufaelligen Stings, ob der Ausgangswert der Eingabe entspricht.
     */
    @Test
    public void testAusgangswertZufall()
    {
        // lokale Variablen
        String wort = "";
        // wiederhole 1000 mal
        for (int i=0; i<1000; i++)
        {
            // erzeuge neues zufaelliges Wort
            wort = neuesWort();
            // pruefe jeweils Ausgabe des Neurons
            Signal neuron = new Signal(wort);
            assertEquals(wort, neuron.getAusgangswert());
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
