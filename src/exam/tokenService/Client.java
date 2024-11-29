package exam.tokenService;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;

        try {
            // Connexion au serveur sur l'hôte et le port spécifiés
            String host = args[0]; // Adresse IP du serveur
            int port = Integer.parseInt(args[1]); // Port du serveur
            socket = new Socket(host, port);

            // Flux d'entrée/sortie
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            // Envoi d'un message au serveur
            output.println("Bonjour, je me connecte au serveur !");

            // Réception de la réponse du serveur (le token généré)
            String response = input.readLine();
            System.out.println("Token reçu du serveur : " + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

