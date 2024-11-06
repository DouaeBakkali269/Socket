package thread;

public class exemple {
    public static void main(String[] args){
        Thread producer = new Thread(new producer());
        Thread consumer = new Thread(new Consumer());
       // producer.setPriority(Thread.MAX_PRIORITY);
        //consumer.setPriority(Thread.MIN_PRIORITY);
        producer.start();
        consumer.start();
    }
}
