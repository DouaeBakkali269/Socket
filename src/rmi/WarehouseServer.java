package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class WarehouseServer {
    public static void main(String[] args) {
        try {
            // Créer l'objet distant
            WarehouseImpl warehouse = new WarehouseImpl();

            // Démarrer le RMI Registry sur le port 1099 (par défaut)
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry démarré...");

            // Enregistrer l'objet dans le RMI Registry
            Naming.rebind("WarehouseService", warehouse);
            System.out.println("Service Warehouse enregistré avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

