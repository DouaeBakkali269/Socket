package exam.exo2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculateurSensorInterface extends Remote{
    double CalculTva(double tva) throws RemoteException;;
    double Calcul_Salaire_nett(double tva) throws RemoteException;;

    void setSalaire_brute(double salaire_brute) throws RemoteException;

    double lire_Salaire_brute() throws RemoteException;;
}
