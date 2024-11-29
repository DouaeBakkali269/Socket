package exam.tokenService;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class Serveur {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // Création du serveur sur le port spécifié
            int port = Integer.parseInt(args[0]); // Port en argument
            serverSocket = new ServerSocket(port);
            System.out.println("Serveur démarré sur le port " + port);

            while (true) {
                // Attente d'une connexion
                System.out.println("En attente de connexion...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion interceptée.");

                // Création d'un thread pour gérer le client
                new Thread(() -> handleClient(clientSocket)).start();
                //Thread thread = new Thread(new handleClient(clientSocket));
                //Si vous utilisez un classe that implements Runnable
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // Lecture du message envoyé par le client
            String clientMessage = input.readLine();
            System.out.println("Message reçu du client : " + clientMessage);

            // Génération d'un token unique
            String token = generateToken();
            System.out.println("Token généré : " + token);

            // Envoi du token au client
            output.println(token);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateToken() {
        // Génération d'un token unique basé sur la date actuelle
        String baseString = "token-" + LocalDateTime.now();
        int hash = baseString.hashCode();
        return baseString + "-" + hash;
    }
}

