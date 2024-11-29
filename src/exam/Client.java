package exam;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException {
        int port = 8182;
        InetAddress address = InetAddress.getByName("localhost");
        try{
          //création de socket
          Socket socket = new Socket(address,port);

          //envoyer un message au serveur
          PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
          System.out.println("Entrer le mot de passe");
          Scanner password = new Scanner(System.in);
          out.println(password.nextLine());

          //Recevoir la réponse at afficher message
          Scanner in = new Scanner(socket.getInputStream());
          while (in.hasNextLine()) {
              String line = in.nextLine();
              System.out.println("Reçu : " + line);
          }

          //fermer le flux du socket
          in.close();
          out.close();
          socket.close();


        } catch (Exception e){e.printStackTrace();}
    }
}
