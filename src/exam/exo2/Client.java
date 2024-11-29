package exam.exo2;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage : java Client <operation>");
            System.out.println("operation = 1 (Calcul TVA), 2 (Calcul Salaire Net), 3 (Lire Salaire Brut)");
            System.exit(1);
        }

        double salaire_brute = Double.parseDouble(args[0]);
        int operation = Integer.parseInt(args[1]);
        try {
            CalculateurSensorInterface service = (CalculateurSensorInterface) Naming.lookup("rmi://services.ensias.ma:2456/calculateurSensor");
            service.setSalaire_brute(salaire_brute);
            switch (operation) {
                case 1:
                    double tva = service.CalculTva(0.3); // Le serveur utilise sa propre valeur de salaire brut
                    System.out.println("TVA : " + tva);
                    break;
                case 2:
                    double salaireNet = service.Calcul_Salaire_nett(0.3); // Idem
                    System.out.println("Salaire Net : " + salaireNet);
                    break;
                case 3:
                    double salaireBrute = service.lire_Salaire_brute(); // Retourne la valeur prédéfinie du serveur
                    System.out.println("Salaire Brut : " + salaireBrute);
                    break;
                default:
                    System.out.println("Opération inconnue !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
