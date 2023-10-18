package Problems.Problem4_ObjectSerialization.src.main.java;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String citizenship;

    public Person(String name, int age, String citizenship) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
    }

    public Person(String name, int age) {
        this(name, age, "Canadian");
    }

    @Override
    public String toString() {
        return "PersonObject: {name='" + name + "', age=" + age + ", citizenship='" + citizenship + "'}";
    }
}
