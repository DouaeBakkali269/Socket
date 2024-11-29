package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {
    // Constructeur (nécessaire pour RMI)
    protected WarehouseImpl() throws RemoteException {
        super();
    }

    // Implémentation de la méthode distante
    @Override
    public int getQuantity(String description) throws RemoteException {
        System.out.println("Demande reçue pour l'article : " + description);
        return 42; // Simule une quantité fixe pour l'exemple
    }

    @Override
    public String getProductDetails(String productName) throws RemoteException {
        return "Produit: " + productName + ", Catégorie: Électronique";
    }
}
