package thread;

public class Test implements Runnable{
    public void run(){
        System.out.println("thread2 going to sleep for 5000");
    }
    public static void main(String[] args){
        Test obj = new Test();
        Helper obj2 = new Helper();

        //create threads
        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj2);
        thread1.start();
        thread2.start();

        //loading thread 1 in class 1
        ClassLoader loader = thread1.getContextClassLoader();
        //getting the number of active threads
        System.out.println(Thread.activeCount());
        // Fetching an instance of this thread
        Thread t = Thread.currentThread();

        // Print and display commands
        System.out.println(t.getName());
        // Fetching the priority and state of thread1
        System.out.println("Priority of thread1 = " + thread1.getPriority());

        // Getting the state of thread 1 using getState() method
        // and printing the same
        System.out.println(thread1.getState());

    }
}
