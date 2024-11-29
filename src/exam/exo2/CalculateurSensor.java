package exam.exo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculateurSensor extends UnicastRemoteObject implements CalculateurSensorInterface {

    private double salaire_brute;
    public CalculateurSensor() throws RemoteException{
        super();
        this.salaire_brute=0;
    }

    @Override
    public void setSalaire_brute(double salaire_brute) throws RemoteException{
        if (salaire_brute <= 0) {
            throw new IllegalStateException("Salaire brut non défini ou incorrect !");
        }
        this.salaire_brute=salaire_brute;
    }

    @Override
    public double lire_Salaire_brute() throws RemoteException {return this.salaire_brute;}

    @Override
    public double CalculTva(double tva) throws RemoteException {
        if (this.salaire_brute <= 0) {
            throw new IllegalStateException("Salaire brut non défini ou incorrect !");
        }
        return tva * this.salaire_brute;
    }

    @Override
    public double Calcul_Salaire_nett(double tva) throws RemoteException {
        if (this.salaire_brute <= 0) {
            throw new IllegalStateException("Salaire brut non défini ou incorrect !");
        }
        return this.salaire_brute - (this.salaire_brute * tva);
    }


}
