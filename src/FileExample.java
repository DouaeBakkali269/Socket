import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        // Créer un objet File qui pointe vers un fichier
        File file = new File("exemple.txt");

        // Vérifier si le fichier existe
        if (file.exists()) {
            System.out.println("Le fichier existe.");
            System.out.println("Nom : " + file.getName());
            System.out.println("Chemin : " + file.getPath());
            System.out.println("Chemin absolu : " + file.getAbsolutePath());
            System.out.println("Peut être lu : " + file.canRead());
            System.out.println("Peut être écrit : " + file.canWrite());
            System.out.println("Taille : " + file.length() + " octets");
        } else {
            System.out.println("Le fichier n'existe pas.");

            // Créer le fichier
            try {
                if (file.createNewFile()) {
                    System.out.println("Fichier créé avec succès !");
                } else {
                    System.out.println("Échec de la création du fichier.");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        }
    }
}
