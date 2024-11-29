package rmi;

import java.rmi.Naming;


public class WarehouseClient {
    public static void main(String[] args) {
        try {
            // Recherche du stub dans le RMI Registry
            Warehouse warehouse = (Warehouse) Naming.lookup("rmi://localhost:1099/WarehouseService");

            // Appels distants via le stub
            int quantity = warehouse.getQuantity("Ordinateur portable");
            System.out.println("Quantité disponible : " + quantity);

            String details = warehouse.getProductDetails("Smartphone");
            System.out.println("Détails du produit : " + details);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

