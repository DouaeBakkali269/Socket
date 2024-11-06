package TCPServerExample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Adresse du serveur
        int port = 8189; // Port d'écoute du serveur

        try (Socket socket = new Socket(serverAddress, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            System.out.println("Date reçue du serveur : " + serverResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

