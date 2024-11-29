import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiClientServer {
    public static void main(String[] args) {
        int port = 8189; // Port d'écoute du serveur
        try (ServerSocket listener = new ServerSocket(port)) {
            System.out.println("Le serveur est en attente de connexions...");

            while (true) {
                Socket socket = listener.accept(); // Accepte la connexion du client
                Runnable clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start(); // Démarre un nouveau thread pour le client
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket; // Le constructeur conserve la référence à la socket
    }

    @Override
    public void run() {
        try {
            InputStream inS = socket.getInputStream();
            OutputStream outS = socket.getOutputStream();
            Scanner in = new Scanner(inS);
            PrintWriter out = new PrintWriter(outS, true);

            out.println("Bienvenue! Tapez un message pour le serveur :");
            String inputLine;
            while (in.hasNextLine()) {
                inputLine = in.nextLine();
                if ("exit".equalsIgnoreCase(inputLine)) {
                    out.println("Déconnexion...");
                    break;
                }
                out.println("Echo : " + inputLine); // Réponse du serveur
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // Ferme la connexion avec le client
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
