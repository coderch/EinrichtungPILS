package schreiber;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Properties;

/**
 *  * Diese Klasse dient dem Erstellen der Konfigurationsdatei. Es ist nicht möglich, eine Instanz dieser Klasse zu erzeugen.
 * @author rrose
 * @see #Dateischreiber()
 *
 */
public class Dateischreiber {

    private static Properties properties = new Properties();

    /**
     * Dieser private Konstruktor verhindert eine Instanzierung dieser Klasse.
     */
    private Dateischreiber() {
    }

    /**
     * Diese Methode schreibt die übergebenen Parameter
     * in das Properies-Objekt und erzeugt aus ihr die gewünschte info.config-Datei.
     * Anhand eines JFileChoosers kann der Pfad für diese Datei angegeben werden.
     * Dieser JFileChooser überprüft, ob bereits eine Datei mit dem angegebenen Namen existiert.
     * Im Falle einer bereits vorhandenen Datei erscheint ein Dialog, welcher nach dem Ersetzen dieser Datei fragt.
     * @param url IP des Computers auf dem die postgresql-Datenbank ausgeführt wird.
     * @param nutzer Datenbanknutzer
     * @param password Password für den angegebenen Datenbanknutzer
     */
    public static void dateiSchreiben(String url, String nutzer, String password) {
        String urlgesamt = "jdbc:postgresql://" + url + "/db_pils";
        properties.setProperty("url", urlgesamt);
        properties.setProperty("user", nutzer);
        properties.setProperty("password", password);
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Konfigurationsdateien", "config"));
        fc.setSelectedFile(new File("D:/info.config"));
        int returnVal = fc.showSaveDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();
            /*
             * Hier findet die Prüfung auf bereits vorhandene Dateien mit gleichem Namen statt.
             */
            if (file.exists()) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Wollen Sie die Datei ersetzen?",
                        "Bestätigen", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (response != JOptionPane.YES_OPTION) {
                    return;
                }
            } else {
                try {
                    /*
                     * Nach erfolgreichem Dialog oder nicht bereits vorhandener Datei wird nun der Inhalt des Properties-Objekt in eine Datei mit dem
                     * angegebenen Namen geschrieben und gespeichert.
                     */
                    properties.store(new BufferedWriter(new FileWriter(file)), "Diese Daten sind zur Verbindung mit der Datenbank notwendig");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
