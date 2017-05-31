package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Der Frameholder wird beim Start des Programms erzeugt und bildet das Hauptfenster des Programmes.
 * @author rrose
 * @see javax.swing.JFrame
 */

public class Frameholder {
    private final JFrame frame;

    public Frameholder() {
        frame = new JFrame("Einrichtung");
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        createContent();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Diese Methode erstellt ein Zugangsdaten-Panel und fügt es dem JFrame hinzu.
     *
     * @see Zugangsdaten
     * @see javax.swing.JPanel
     */
    private void createContent() {
        Zugangsdaten zugangsdaten = new Zugangsdaten();
        frame.add(zugangsdaten, BorderLayout.NORTH);


    }
}
