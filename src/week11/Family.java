package week11;

public class Family {
    private Person[] members;
    private int numberOfPeople;

    // Default constructor
    public Family() {
        this.members = new Person[10];
        this.numberOfPeople = 0;
    }

    public void display() {
        for (int position = 0; position < numberOfPeople; position++) {
            System.out.println(members[position]);
        }
    }

    // Mutator method to add a person to the family
    public boolean addPerson(String name, int age) {
        if (numberOfPeople < 10) {
            members[numberOfPeople] = new Person(name, age);
            numberOfPeople++;
            return true;
        } else {
            return false; // No more space in the family
        }
    }

    // Mutator method for a birthday
    public void birthday(String name) {
        for (int personInPosition = 0; personInPosition < numberOfPeople; personInPosition++) {
            if (members[personInPosition].getName().equalsIgnoreCase(name)) {
                members[personInPosition].incrementAge();
                break;
            }
        }
    }

    // Accessor method to return the number of people
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    // Accessor method to return the total age of the people
    public int getTotalAge() {
        int totalAge = 0;
        for (int personInPosition = 0; personInPosition < numberOfPeople; personInPosition++) {
            totalAge += members[personInPosition].getAge();
        }
        return totalAge;
    }
}
