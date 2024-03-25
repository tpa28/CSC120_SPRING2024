package week11;

public class Person {
    private String name;
    private int age;


    // Default constructor
    public Person(){
        this.name = null;
        this.age = 0;
    }

    // Constructor to accept name and age of a person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString for the output of a person
    public String toString(){
        return name + " is " + age + " years old";
    }

    // Mutator method to increase the age by one
    public void incrementAge() {
        age++;
    }

    // Accessor method to get the age
    public int getAge() {
        return age;
    }

    // Accessor method to get the name
    public String getName() {
        return name;
    }
}
