package Problems.Problem4_ObjectSerialization.src.main.java;

import java.io.*;

public class ObjectIO {
    public static void main(String[] args) {
        Person monica = new Person("Monica Geller", 24, "American");
        Person joey = new Person("Joey Tribbiani", 25, "American");
        Person rachel = new Person("Rachel Green", 25, "American");
        Person ross = new Person("Ross Geller", 26, "American");
        Person[] persons = {monica, joey, ross, rachel};

        String filePath = "/Users/daanandasilva/Java/JavaChatGPT/Folder of read and write files/PersonObjects.dat";

        // Serialization
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Person person : persons) {
                objectOutputStream.writeObject(person);
                System.out.println("Object has been serialized and written to: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));

        // Deserialization
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    Person deserializedPerson = (Person) objectInputStream.readObject();
                    System.out.println("Deserialized Person: " + deserializedPerson);
                } catch (EOFException eof) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
