package week11;

public class Family {
    private Person[] family;
    private int numberOfPeople;
    private static final int MAX_NUMBER_OF_MEMBERS = 10;

    // Default constructor
    public Family() {
        family = new Person[MAX_NUMBER_OF_MEMBERS];
        numberOfPeople = 0;
    } // end of default constructor

    // Mutator method to display each person within the Person array
    public void display() {
        for (int position = 0; position < numberOfPeople; position++) {
            System.out.println(family[position]);
        } // end of for loop
    } // end of display method

    // Mutator method to add a person to the family
    public boolean addPerson(String name, int age) {
        if (numberOfPeople < MAX_NUMBER_OF_MEMBERS) {
            family[numberOfPeople] = new Person(name, age);
            numberOfPeople++;
            return true;
        }
        else {
            return false; // No more space in the family
        } // end of if-else statement
    } // end of addPerson method

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
