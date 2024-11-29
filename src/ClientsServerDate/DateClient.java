package ClientsServerDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DateClient {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'adresse IP ou le nom d'hôte du serveur : ");
        String ServerAdress = scanner.nextLine();

        try(Socket socket = new Socket(ServerAdress,8182)){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = (String) in.readLine();
            System.out.println("Message reçu du serveur : " + message);
        }catch(UnknownHostException e){
            System.out.println("Hôte inconnu :"+ e.getMessage());
        }catch (IOException e) {
            System.out.println("Erreur d'entrée/sortie : " + e.getMessage());
        }
    }
}
