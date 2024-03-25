package week11;

public class Person {
    private String name;
    private int age;


    // Default constructor
    public Person(){
        name = null;
        age = 0;
    } // end of default constructtor

    // Constructor to accept name and age of a person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    } // end of Person constructor

    // toString for the output of a person
    public String toString(){
        return name + " is " + age + " years old";
    } // end of toString method

    // Mutator method to increase the age by one
    public void incrementAge() {
        age++;
    } // end of incrementAge method

    // Accessor method to get the age
    public int getAge() {
        return age;
    } // end of getAge method

    // Accessor method to get the name
    public String getName() {
        return name;
    } // end of getName method
}
