import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Die Test-Klasse PalindromNeuronTest.
 *
 * @author Fiete Klotzbuecher
 * @version 2022-01-09
 */
public class PalindromNeuronTest
{
    // Instanzvariablen
    List<String> _palindrome;
    List<String> _keinePalindrome;

    /**
     * Konstruktor für Objekte der Test-Klasse PalindromNeuronTest.
     */
    public PalindromNeuronTest()
    {
        // erzeuge Wortliste mit Palindromen
        _palindrome = new ArrayList<String>();
        _palindrome.add("a");
        _palindrome.add("aa");
        _palindrome.add("aba");
        _palindrome.add("abba");
        _palindrome.add("abcba");
        _palindrome.add("ab  ba");
        _palindrome.add("a b b a");
        _palindrome.add("a bccb a");
        // erzeuge Wortliste ohne Palindrome
        _keinePalindrome = new ArrayList<String>();
        _keinePalindrome.add("");
        _keinePalindrome.add(" ");
        _keinePalindrome.add("  ");
        _keinePalindrome.add("ab");
        _keinePalindrome.add("aab");
        _keinePalindrome.add("aaab");
        _keinePalindrome.add("abab");
        _keinePalindrome.add("abbab");
        _keinePalindrome.add("abbbab");
        _keinePalindrome.add("abcbac");
        _keinePalindrome.add("ab bca");
        _keinePalindrome.add("a b bc a");
        _keinePalindrome.add("a bcbc a");
    }
    /**
     * Testet mit einer Wortliste, ob der Ausgangswert der Eingabe entspricht.
     */
    @Test
    public void testNeuesNeuron()
    {
        // teste auf Standardrueckgabe NULL
        PalindromNeuron neuron = new PalindromNeuron(false);
        assertNull(neuron.getAusgangswert());
    }

    @Test
    public void testErkennungPalindrom()
    {
        // lokale Variablen
        Signal signal;
        // fuer jedes Palindrom
        for (String wort : _palindrome)
        {
            // neues Palindrom Neuron
            PalindromNeuron neuron = new PalindromNeuron(true);
            // fuege Signaleingang hinzu
            signal = new Signal(wort);
            neuron.eingangHinzufuegen(signal);
            // pruefe Ausgabe des Neurons
            assertEquals(wort, neuron.getAusgangswert());
        }
    }

    @Test
    public void testErkennungKeinPalindrom()
    {
        // lokale Variablen
        Signal signal;
        // fuer jedes falsche Palindrom
        for (String wort : _keinePalindrome)
        {
            // neues Palindrom Neuron
            PalindromNeuron neuron = new PalindromNeuron(true);
            // fuege Signaleingang hinzu
            signal = new Signal(wort);
            neuron.eingangHinzufuegen(signal);
            // pruefe Ausgabe des Neurons
            assertNull(neuron.getAusgangswert());
        }
    }

    @Test
    public void testErkennungPalindromGross()
    {
        // lokale Variablen
        Signal signal;
        int wortmitte;
        // fuer jedes Palindrom
        for (String wort : _palindrome)
        {
            // neues Palindrom Neuron
            PalindromNeuron neuron = new PalindromNeuron(false);
            // schreibe letzte Haelfte des Wortes gross
            wortmitte = (int)(wort.length() / 2);
            wort = wort.substring(0, wortmitte)
                 + wort.substring(wortmitte).toUpperCase();
            // fuege Signaleingang hinzu
            signal = new Signal(wort);
            neuron.eingangHinzufuegen(signal);
            // pruefe Ausgabe des Neurons
            assertEquals(wort, neuron.getAusgangswert());
        }
    }

    @Test
    public void testErkennungLaengstesPalindrom()
    {
        // lokale Variablen
        Signal signal;
        List<String> eingaben = _keinePalindrome;
        // fuer jedes Palindrom
        for (String laengstesPalindrom : _palindrome)
        {
            // neues Palindrom Neuron
            PalindromNeuron neuron = new PalindromNeuron(false);
            // fuege Palindrom zu Eingaben hinzu
            eingaben.add(laengstesPalindrom);
            // fuege Signaleingang fuer jede Eingabe hinzu
            for (String eingabe : eingaben)
            {
                signal = new Signal(eingabe);
                neuron.eingangHinzufuegen(signal);
            }
            // pruefe Ausgabe des Neurons
            assertEquals(laengstesPalindrom, neuron.getAusgangswert());
        }
    }
}
