package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
    int getQuantity(String description) throws RemoteException;
    String getProductDetails(String productName) throws RemoteException;
}
