package week11;

public class Family {
    private Person[] family;
    private int numberOfPeople;

    // Default constructor
    public Family() {
        this.family = new Person[10];
        this.numberOfPeople = 0;
    }

    // Mutator method to display each person within the Person array
    public void display() {
        for (int position = 0; position < numberOfPeople; position++) {
            System.out.println(family[position]);
        } // end of for loop
    }

    // Mutator method to add a person to the family
    public boolean addPerson(String name, int age) {
        if (numberOfPeople < 10) {
            family[numberOfPeople] = new Person(name, age);
            numberOfPeople++;
            return true;
        }
        else {
            return false; // No more space in the family
        } // end of if-else statement
    }

    // Mutator method for a birthday
    public void birthday(String name) {
        for (int personInPosition = 0; personInPosition < numberOfPeople; personInPosition++) {
            if (family[personInPosition].getName().equalsIgnoreCase(name)) {
                family[personInPosition].incrementAge();
                break;
            } // end of if statement
        } // end of for loop
    } // end of birthday method

    // Accessor method to return the number of people
    public int getNumberOfPeople() {
        return numberOfPeople;
    } // end of getNumberOfPeople method

    // Accessor method to return the total age of the people
    public int getTotalAge() {
        int totalAge = 0;
        for (int personInPosition = 0; personInPosition < numberOfPeople; personInPosition++) {
            totalAge += family[personInPosition].getAge();
        } // end of for loop
        return totalAge;
    } // end of getNumberOfPeople method

} // end of Family class
