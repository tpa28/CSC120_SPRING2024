package week10;

import java.util.Scanner;
public class ParticleDriver {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int tag;
        double xCoordinate, yCoordinate;
        Particle particle;

        //----Get particle information
        System.out.print("Particle tag id? : ");
        tag = keyboard.nextInt();

        //----Create object
        particle = new Particle(tag);
        System.out.println(particle);

        //----Use a do-while loop to change the position of the particle
        // while the position isn't (0.0,0.0). The do-while will allow the code to be executed at least once
        do {
            System.out.print("Enter movement   : ");
            xCoordinate = keyboard.nextDouble();
            yCoordinate = keyboard.nextDouble();

            particle.moveParticle(xCoordinate, yCoordinate);
            System.out.println(particle);
        } while (xCoordinate != 0.0 || yCoordinate != 0.0);

    } // end of Main Method

} // end of ParticleDriver Class
