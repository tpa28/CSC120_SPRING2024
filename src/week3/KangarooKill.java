package week3;

import java.util.Scanner;

//=============================================================================
public class KangarooKill {
    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    //----The calculated roadkill constant and
    // average Australian road width constant in meters
    private static final double ROADKILL_CONSTANT = 1.47;
    private static final int AVERAGE_AUSTRALIAN_ROAD_WIDTH = 10;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

        //----Variables to hold system values
        double lengthOfSide, lengthOfRoads, roadSurfaceArea;
        double kangarooDensity, expectedRooKills, expectedRooInjuries;
        int numberOfRoos;

        //----Getting 3 inputs from keyboard/user
        System.out.print("Enter side of square in km  : ");
        lengthOfSide = keyboard.nextDouble();
        System.out.print("Enter roads length in km    : ");
        lengthOfRoads = keyboard.nextDouble();
        System.out.print("Enter number of 'roos       : ");
        numberOfRoos = keyboard.nextInt();

        /*
        ----Calculate the kangarooDensity and road surface area
         using lengthOfSide, lengthOfRoads, numberOfRoos, and
         averageAustralianRoadWidth
        */
        kangarooDensity = numberOfRoos / (lengthOfSide * lengthOfSide);
        roadSurfaceArea = (lengthOfRoads * AVERAGE_AUSTRALIAN_ROAD_WIDTH);


        /*
        ----Calculate the expectedRooKills and expectedRoosInjuries
         using roadSurfaceArea, kangarooDensity, roadkillConstant in Kilometers
        */
        expectedRooKills = ((kangarooDensity * roadSurfaceArea * ROADKILL_CONSTANT)/1000);
        expectedRooInjuries = (int)(Math.ceil(expectedRooKills % 1));
        expectedRooKills = (int) expectedRooKills;


        /*----Output the expectedRooKills and
         expectedRoosInjuries result to the screen
         */
        System.out.println("Expected number of kills is : " + (int) expectedRooKills);
        System.out.print("Expected number of injuries : " + (int) expectedRooInjuries);
    }// end of the main method
} // end of the KangarooKill class
//-----------------------------------------------------------------------------
//=============================================================================
