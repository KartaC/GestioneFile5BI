package gestionefile;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MC
 * @ 12/01/23
 */
public class Lettore extends Thread {

    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    /**
     * Legge il file senza tener conto del tipo di file e lo mostra in output
     */
    public void leggi() {
        int i;
        try (FileReader fr = new FileReader(nomeFile)) {
            //1) apro il file
            //2) leggo carattere per carattere e lo stampo 
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }

            System.out.print("\n\r");
            //3) chiudo il file

        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }

    public void run() {
        leggi();
    }
}
