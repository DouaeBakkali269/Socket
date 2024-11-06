package thread;

public class producer implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<5;i++){
            System.out.println("producer number:"+i);
            Thread.yield();
        }
    }

}
