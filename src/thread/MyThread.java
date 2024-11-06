package thread;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Vérifier périodiquement si le thread a été interrompu
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread was interrupted! Stopping...");
                return;  // Arrêter l'exécution du thread
            }
            System.out.println("Thread is running: " + i);
            try {
                Thread.sleep(1000);  // Simuler un travail avec une pause
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted during sleep.");
                return;  // Arrêter le thread après interruption
            }
        }
        System.out.println("Thread completed normally.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();

        // Attendre un peu avant d'interrompre le thread
        Thread.sleep(3000);
        thread.interrupt();  // Interrompre le thread après 3 secondes
    }
}
