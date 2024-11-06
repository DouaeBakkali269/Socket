package thread;

public class Consumer implements Runnable{
    public void run(){
        for(int i=1;i<5;i++){
            System.out.println("Consumer number: "+i);
            Thread.yield();
        }
    }
}
