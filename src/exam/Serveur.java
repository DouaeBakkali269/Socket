package exam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.*;

public class Serveur {
    public static void main(String[] args) {
        ServerSocket serveur=null;
        try {
            serveur = new ServerSocket(8182);
            while(true){
                Socket client = serveur.accept();
                //recevoir message du client
                Scanner in = new Scanner(client.getInputStream());
                String line= in.nextLine();
                String token = "%s%s".formatted(line.hashCode(), LocalDateTime.now());
                //envoyer un message au client
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                out.println(token);
                //fermeture de la socket
                client.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {e.printStackTrace();}
       finally {
        try{
        serveur.close();}
        catch (IOException e) {e.printStackTrace();}}
    }
}