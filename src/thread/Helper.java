package thread;

public class Helper implements Runnable {
        @Override
        public void run() {
            System.out.println("thread2 going to sleep for 5000");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread2 interrupted");
                throw new RuntimeException(e);
            }
        }
}

