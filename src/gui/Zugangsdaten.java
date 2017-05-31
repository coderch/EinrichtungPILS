package gui;

import schreiber.Dateischreiber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diese Klasse erzeugt ein JPanel, welches beim Start des Programms vom Frameholder implementiert und genutzt wird.
 * Dieses Panel behinhaltet einen JButton und die Eingabefelder für URL, Login und Passwort.
 * @author rrose
 * @see javax.swing.JPanel
 */

public class Zugangsdaten extends JPanel {
    private final JTextField url = new JTextField(20);
    private final JTextField login = new JTextField(20);
    private final JPasswordField password = new JPasswordField(20);
    private final JButton erstellen = new JButton("Datei erstellen");

    /**
     * Der Konstruktor fügt JLabel, ToolTipText und die bereits instanzierten JTextFields diesem JPanel hinzu. Dem Button wird ein ActionListener hinzugefügt.
     */
    public Zugangsdaten() {
        this.add(new JLabel("URL"));
        this.add(url);
        url.setText("localhost");
        url.setToolTipText("Geben Sie hier die IP-Adresse des Datenbankservers an. Befindet sich die Datenbank auf diesem Computer, dann können Sie localhost nutzen.");

        this.add(new JLabel("Login"));
        this.add(login);
        login.setText("postgres");

        login.setToolTipText("Geben Sie hier den gewünschten Datenbanknutzer ein. Standard: postgres");
        this.add(new JLabel("Passwort"));
        this.add(password);
        password.setText("password");
        password.setToolTipText("Geben Sie hier das Passwort zum oben angegebenen Nutzer ein");
        this.add(erstellen);

        erstellen.addActionListener(new ActionListener() {
            /**
             * Dieser Actionlistener führt beim Betätigen des Buttons das Speichern aus.
             */
            public void actionPerformed(ActionEvent actionEvent) {
                Dateischreiber.dateiSchreiben(url.getText(), login.getText(), String.valueOf(password.getPassword()));
            }
        });
    }
}
