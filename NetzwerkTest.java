import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Die Test-Klasse NetzwerkTest.
 *
 * @author Fiete Klotzbuecher
 * @version 2022-01-09
 */
public class NetzwerkTest
{
    /**
     * Testet ein neuronales Netzwerk mit drei Eingaengen, zwei
     * Palindrom-Neuronen und einem Ketten-Neuron.
     */
    @Test
    public void testNetzwerk1()
    {
        // initialisiere Neuronen
        Neuron neuronA1 = new Signal("axa");
        Neuron neuronA2 = new Signal("Halle");
        Neuron neuronA3 = new Signal("Regallager");
        Neuron neuronB1 = new PalindromNeuron(true);
        Neuron neuronB2 = new PalindromNeuron(false);
        Neuron neuronC1 = new KettenNeuron();
        // Typenzusicherung
        PalindromNeuron palB1 = (PalindromNeuron) neuronB1;
        PalindromNeuron palB2 = (PalindromNeuron) neuronB2;
        KettenNeuron ketC1 = (KettenNeuron) neuronC1;
        // setze Eingaenge palB1
        palB1.eingangHinzufuegen(neuronA1);
        palB1.eingangHinzufuegen(neuronA2);
        palB1.eingangHinzufuegen(neuronA3);
        // setze Eingaenge palB2
        palB2.eingangHinzufuegen(neuronA1);
        palB2.eingangHinzufuegen(neuronA2);
        palB2.eingangHinzufuegen(neuronA3);
        // setze Eingaenge ketC1
        ketC1.eingangHinzufuegen(neuronB1);
        ketC1.eingangHinzufuegen(neuronB2);
        
        // pruefe erste Ausgabe
        assertEquals("axa Regallager", ketC1.getAusgangswert());
        // pruefe zweite Ausgabe
        assertEquals("axa Regallager axa Regallager", ketC1.getAusgangswert());
    }

    /**
     * Testet ein neuronales Netzwerk mit drei Eingaengen, zwei
     * Ketten-Neuronen und einem Palindrom-Neuron.
     */
    @Test
    public void testNetzwerk2()
    {
        // initialisiere Neuronen
        Neuron neuronA1 = new Signal("otto");
        Neuron neuronA2 = new Signal("OTTO");
        Neuron neuronA3 = new Signal("abba");
        Neuron neuronB1 = new KettenNeuron();
        Neuron neuronB2 = new KettenNeuron();
        Neuron neuronC1 = new PalindromNeuron(false);
        // Typenzusicherung
        KettenNeuron ketB1 = (KettenNeuron) neuronB1;
        KettenNeuron ketB2 = (KettenNeuron) neuronB2;
        PalindromNeuron palC1 = (PalindromNeuron) neuronC1;
        // setze Eingaenge ketB1
        ketB1.eingangHinzufuegen(neuronA1);
        ketB1.eingangHinzufuegen(neuronA2);
        // ketB1.eingangHinzufuegen(neuronA3);
        // setze Eingaenge ketB2
        // ketB2.eingangHinzufuegen(neuronA1);
        ketB2.eingangHinzufuegen(neuronA2);
        ketB2.eingangHinzufuegen(neuronA3);
        // setze Eingaenge palC1
        palC1.eingangHinzufuegen(neuronB1);
        palC1.eingangHinzufuegen(neuronB2);

        // pruefe erste Ausgabe
        assertEquals("otto OTTO", palC1.getAusgangswert());
        // pruefe zweite Ausgabe
        assertEquals("otto OTTO otto OTTO", palC1.getAusgangswert());
    }

    /**
     * Testet ein neuronales Netzwerk mit drei Eingaengen, zwei
     * Palindrom-Neuronen und drei Ketten-Neuronen.
     */
    @Test
    public void testNetzwerk3()
    {
        // initialisiere Neuronen
        Neuron neuronA1 = new Signal("otto");
        Neuron neuronA2 = new Signal("regal");
        Neuron neuronA3 = new Signal("LAGER");
        Neuron neuronB1 = new PalindromNeuron(true);
        Neuron neuronB2 = new KettenNeuron();
        Neuron neuronC1 = new KettenNeuron();
        Neuron neuronC2 = new PalindromNeuron(false);
        Neuron neuronD1 = new KettenNeuron();
        // Typenzusicherung
        PalindromNeuron palB1 = (PalindromNeuron) neuronB1;
        KettenNeuron ketB2 = (KettenNeuron) neuronB2;
        KettenNeuron ketC1 = (KettenNeuron) neuronC1;
        PalindromNeuron palC2 = (PalindromNeuron) neuronC2;
        KettenNeuron ketD1 = (KettenNeuron) neuronD1;
        // setze Eingaenge ketB1
        palB1.eingangHinzufuegen(neuronA1);
        palB1.eingangHinzufuegen(neuronA2);
        palB1.eingangHinzufuegen(neuronA3);
        // setze Eingaenge palB2
        ketB2.eingangHinzufuegen(neuronA1);
        ketB2.eingangHinzufuegen(neuronA2);
        ketB2.eingangHinzufuegen(neuronA3);
        // setze Eingaenge ketC1
        ketC1.eingangHinzufuegen(neuronB1);
        ketC1.eingangHinzufuegen(neuronB2);
        // setze Eingaenge palC2
        palC2.eingangHinzufuegen(neuronB1);
        palC2.eingangHinzufuegen(neuronB2);
        // setze Eingaenge ketD1
        ketD1.eingangHinzufuegen(neuronC1);
        ketD1.eingangHinzufuegen(neuronC2);

        // pruefe erste Ausgabe
        assertEquals("otto otto regal LAGER otto", ketD1.getAusgangswert());
        // pruefe zweite Ausgabe
        assertEquals((
            "otto otto regal LAGER otto otto otto regal LAGER otto otto " +
            "regal LAGER otto regal LAGER otto regal LAGER otto"
            ), ketD1.getAusgangswert());
    }
}