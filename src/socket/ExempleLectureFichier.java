package socket;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

public class ExempleLectureFichier {
    public static void main(String[] args) {
        String cheminFichier = "chemin/vers/votre/fichier.txt"; // Remplacez par le chemin de votre fichier

        // Utilisation de try-with-resources pour s'assurer que les flux sont fermés automatiquement
        try (FileInputStream fis = new FileInputStream(cheminFichier);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            byte[] tampon = new byte[1024]; // Tampon de 1 Ko
            int bytesLu;

            // Lecture des données par blocs de 1024 octets
            //lit en premier temps 1024 et retourne le nombre les caractères lus et continue jusqu'à rien trouver qui retourne -1
            while ((bytesLu = bis.read(tampon)) != -1) {
                // Traitement des données lues
                //conversion d'un tableau de bytes (buffer) en une chaîne de caractères (String)
                //offset indice de départ où commmence la lecture départ
                String contenu = new String(tampon, 0, bytesLu);
                System.out.print(contenu);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
