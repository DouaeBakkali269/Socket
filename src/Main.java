// A Java program to demonstrate working
// of a Class type object created by JVM
// to represent .class file in memory.
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.Runtime;


public class Main {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student();
        Class c1 = s1.getClass();  // object created by JVM.
        System.out.println(c1.getName());// Printing type of object using c1.
        Method m[] = c1.getDeclaredMethods();
        for (Method method:m)
            System.out.println(method.getName());
        Field f[] = c1.getDeclaredFields();
        for(Field field:f)
            System.out.println(field.getName());
        System.out.println(Main.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        Runtime runtime = Runtime.getRuntime();
        // Afficher la mémoire totale et libre
        System.out.println("Mémoire totale : " + runtime.totalMemory());
        System.out.println("Mémoire libre avant GC : " + runtime.freeMemory());
        runtime.gc();
        System.out.println("Mémoire totale : " + runtime.totalMemory());
        System.out.println("Mémoire libre avant GC : " + runtime.freeMemory());
        // Ajouter une tâche à exécuter avant la fermeture de la JVM
        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("La JVM est sur le point de se fermer.");
        }));


        Process process1 = Runtime.getRuntime().exec("cmd /c dir"); // Launch an external process (running 'dir' command)
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
        String line1;
        while ((line1 = reader1.readLine()) != null) {
            System.out.println(line1); // Read the output of the process
        }

    }

}
    class Student{
        private String name;
        private int Roll_No;

        public String getName(){ return this.name;}
        public int getRoll_No(){return this.Roll_No;}
        public void setName(String name){this.name=name;}
        public void  setRoll_No(int Roll_No){this.Roll_No=Roll_No;}
    }
