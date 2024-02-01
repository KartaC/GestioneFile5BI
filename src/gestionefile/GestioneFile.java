package gestionefile;

/**
 *
 * @author MC
 * @version 12/01/23
 */

import java.util.Scanner;


public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci username: ");
        String username = sc.nextLine();
        System.out.println("Inserisci passsword: ");
        String password = sc.nextLine();
        System.out.println("Inserisci chiave: ");
        String key = sc.nextLine();
        String encryptedPassword = encrypt(password, key);
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, encryptedPassword );
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
    public static String encrypt(String password, String key) {
        StringBuilder encryptedPassword = new StringBuilder();
        int passwordLength = password.length();
        int keyLength = key.length();

        for (int i = 0; i < passwordLength; i++) {
            char passwordChar = password.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            // Applica la cifratura di Vigenère
            char encryptedChar = (char) ((passwordChar + keyChar) % 128);

            encryptedPassword.append(encryptedChar);
        }

        return encryptedPassword.toString();
    }
    
}
