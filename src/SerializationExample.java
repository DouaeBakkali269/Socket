import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String nom;
    int age;

    public Person(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Âge: " + age;
    }
}
public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person); // Sérialiser l'objet 'person'
            System.out.println("Objet sérialisé et sauvegardé dans person.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn);
        ) { Person deserializedPerson = (Person) in.readObject();
            System.out.println("l'objet déserailisé"+deserializedPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}