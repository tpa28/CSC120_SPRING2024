package week13;
public class Girl {
    // Variables to hold system values
    private String name;
    private Diamond diamond;

    // Girl constructor that gets the name of the girl and sets her diamond to be empty
    public Girl(String name) {
        this.name = name;
        diamond = null;
    }

    // Mutator method that allows the girl to receive or decline the diamond
    public void receiveDiamond(Diamond newDiamond) {
        if (diamond == null || newDiamond.getValue() > diamond.getValue()) {
            diamond = newDiamond;
            System.out.println("Woohoo, the girl took the diamond");
        } else {
            System.out.println("Aaargh, the diamond was rejected");
        } // end of if-else statement
    }

    // toString method to get display of the qualities of the girl's best friend
    public String getDiamondInfo() {
        if (diamond == null) {
            return (name + " has no best friend");        }
        else {
            return name + " has a diamond, " + diamond.getCarats() + " carats, worth $" + diamond.getValue();
        }
    }
}
