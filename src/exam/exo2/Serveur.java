package exam.exo2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args){
        try {
            CalculateurSensor calculateurSensor = new CalculateurSensor();

            LocateRegistry.createRegistry(2456);
            System.out.println("RMI Registry démarré...");

            Naming.rebind("calculateurSensor",calculateurSensor);
            System.out.println("Service Warehouse enregistré avec succès !");

        } catch(Exception e){ e.printStackTrace();}
    }
}
