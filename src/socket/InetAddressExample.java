package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            // Résolution de nom d'hôte en adresse IP
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Nom d'hôte : " + address.getHostName());
            System.out.println("Adresse IP : " + address.getHostAddress());

            // Obtention de l'adresse IP locale
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Adresse locale : " + localAddress.getHostAddress());

            // Obtention de l'adresse de loopback
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Adresse loopback : " + loopback.getHostAddress());

            // Résolution d'une adresse IP en nom d'hôte
            InetAddress byIp = InetAddress.getByName("142.250.183.4");
            System.out.println("Nom d'hôte pour 142.250.183.4 : " + byIp.getHostName());

            // Toutes les adresses associées à un nom d'hôte
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            System.out.println("Toutes les adresses IP de www.google.com :");
            for (InetAddress addr : addresses) {
                System.out.println("- " + addr.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Erreur : Hôte inconnu !");
            e.printStackTrace();
        }
    }
}

