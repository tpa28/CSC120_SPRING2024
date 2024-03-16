package week10;

public class Particle {
    // Variables to hold system values
    private int tag;
    private double xCoordinate;
    private double yCoordinate;

    // Default constructor
    public Particle(int tag) {
        this.tag = tag;
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
    }

    // Setter method to set the position on the particles to move
    public void moveParticle(double changeInXCoordinate, double changeInYCoordinate){
        xCoordinate += changeInXCoordinate;
        this.yCoordinate += changeInYCoordinate;
    }

    // Overridden toString method for printing the object
    public String toString() {
        return "Particle " + tag + " is at (" + xCoordinate + "," + yCoordinate + ")";
    }


}
