package week9;

import java.util.Scanner;

/**
 * The BandOfTheHour class represents an application for managing musicians in a stadium.
 * It allows users to add and remove musicians from different rows and positions within the stadium.
 * The application ensures that weight limits for each row are not exceeded.
 *
 * @author Timileyin Ajayi
 * @version 1
 * @see BandOfTheHour
 */
public class BandOfTheHour {
//-----------------------------------------------------------------------------
    /**
     Scanner input.
     */
    private static final Scanner keyboard = new Scanner(System.in);
    /**
     * Maximum number of row.
     */
    private static final int MAX_ROWS = 10;
    /**
     * Maximum number of positions.
     */
    private static final int MAX_POSITIONS = 8;
    /**
     * Minimum weight requirement.
     */
    private static final double MIN_WEIGHT = 45.0;
    /**
     * Maximum weight requirement.
     */
    private static final double MAX_WEIGHT = 200.0;
    /**
     * 2D array to store weight assignments for each row and position..
     */
    private static double[][] weightAssignments;
    /**
     * Number of rows in the stadium.
     */
    private static int numberOfRows;

    //-----------------------------------------------------------------------------
    /**
     Default constructor.
     */
    public BandOfTheHour() {
        initializeStadium();
    }
    //-----------------------------------------------------------------------------
    /**
     * Initializes the stadium by prompting the user to input the number of rows
     * and positions in each row.
     */
    private static void initializeStadium() {
        // Variables to hold system values
        int numberOfPositions;
        char rowLetter;

        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");
        System.out.printf("Please enter the number of rows               : ");

        /** Input validation for number of rows */
        do {
            numberOfRows = keyboard.nextInt();
            if (numberOfRows <= 0 || numberOfRows > MAX_ROWS) {
                System.out.print("ERROR: Out of range, try again                : ");
            } // end of if statement
        } while (numberOfRows <= 0 || numberOfRows > MAX_ROWS);

        weightAssignments = new double[numberOfRows][];

        // The for loop will allow an input for the number of positions per rows
        for (int index = 0; index < numberOfRows; index++) {
            rowLetter = (char) ('A' + index);

            System.out.print("Please enter the number of positions in row " + rowLetter + " : ");
            do {
                /** Input validation for whther the input is a positive integer */
                while (!keyboard.hasNextInt()) {
                    System.out.print("ERROR: Invalid input. try again               : ");
                    keyboard.next();
                } // end of while loop
                numberOfPositions = keyboard.nextInt();

                if (numberOfPositions <= 0 || numberOfPositions > MAX_POSITIONS) {
                    System.out.print("ERROR: Out of range, try again                : ");
                } // end of if statement
            } while (numberOfPositions <= 0 || numberOfPositions > MAX_POSITIONS);

            weightAssignments[index] = new double[numberOfPositions];
        } // end of the for loop

    } // end of initializeStadium method

    //-----------------------------------------------------------------------------
    /**
     * Displays the main menu options.
     */
    private static void printMenu() {
        System.out.print("\n(A)dd, (R)emove, (P)rint,              e(X)it : ");
    } // end of printMenu method

    //-----------------------------------------------------------------------------
    /**
     * Prints the current assignment of musicians in the stadium, along with total and average weights for each row.
     */
    private static void printAssignment() {
        // Variables to hold system values
        double totalWeight, averageWeight;
        int totalPositions;

        // The for loop will check each row and find the total positions, then print the row letter
        for (int index = 0; index < numberOfRows; index++) {
            totalWeight = 0.0;
            totalPositions = weightAssignments[index].length;
            System.out.print((char) ('A' + index) + ":   ");

            // The for loop will check each position within the row, print the weight of
            // the musician in that current position, and
            // calculate the total weight of musicians in the row
            for (int columns = 0; columns < totalPositions; columns++) {
                System.out.print(weightAssignments[index][columns] + "   ");
                totalWeight += weightAssignments[index][columns];
            } // end of the for loop

            averageWeight = (totalPositions > 0) ? totalWeight / totalPositions : 0.0;
            System.out.println("                        [    " + totalWeight + ",     " + averageWeight + "]");
        } // end of the nested for loop

    } // end of printAssignment method

    //-----------------------------------------------------------------------------
    /**
     * Adds a musician to the specified row and position, checking for weight limits.
     * Prompts the user to enter the row letter and position number of the musician to be added.
     * If the input row or position is out of range, the user is prompted to try again.
     * If the specified position is already vacant, an error message is displayed.
     * If a musician is successfully added, their weight at the specified position is set to the user input.
     * @see BandOfTheHour
     */
    private static void addMusician() {
        // Variables to hold system values
        int position, totalPositions;
        double weight, rowTotalWeight;
        char rowLetter;

        System.out.print("Please enter row letter                       : ");
        rowLetter = keyboard.next().toUpperCase().charAt(0);
        /** Input validation for whether that row exists or if the input is wrong */
        while (rowLetter < 'A' || rowLetter > ('A' + numberOfRows - 1)) {
            System.out.print("ERROR: Out of range, try again                : ");
            rowLetter = keyboard.next().toUpperCase().charAt(0);;
        } // end of the while loop
        totalPositions = weightAssignments[rowLetter - 'A'].length;

        System.out.print("Please enter position number (1 to " + totalPositions + ")         : ");
        position = keyboard.nextInt();
        /** Input validation for choosing a position in a row */
        while (position < 1 || position > totalPositions) {
                System.out.print("ERROR: Out of range, try again                : ");
                position = keyboard.nextInt();
        } // end of the while loop

        // Checking if there is already a musician at that position */
        if (weightAssignments[rowLetter - 'A'][position - 1] != 0.0) {
            System.out.println("ERROR: There is already a musician there.");
            return;
        } // end of if statement

        System.out.print("Please enter weight (" + MIN_WEIGHT + " to " + MAX_WEIGHT + ")           : ");
        weight = keyboard.nextDouble();
        /** Input validation for weight at that position */
        while (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.print("ERROR: Out of range, try again                : ");
            weight = keyboard.nextDouble();
        } // end of the while loop

        rowTotalWeight = 0.0;

        // This for loop iterates over each musicianWeight at each postion in weightAssignments[rowLetter - 'A'],
        //  to find the total weight within that row
        for (double musicianWeight : weightAssignments[rowLetter - 'A']) {
            rowTotalWeight += musicianWeight;
        } // end of the for loop

        // Checking if the new musician wiil make the row overweight
        if (rowTotalWeight + weight > (totalPositions*100)) {
            System.out.println("ERROR: Adding this musician would exceed the row weight limit.");
            return;
        } // end of if statement

        weightAssignments[rowLetter - 'A'][position - 1] += weight;
        System.out.println("****** Musician added.");
    } // end of addMusician method
    //-----------------------------------------------------------------------------

    /**
     * Removes a musician from the stadium seating.
     * Prompts the user to enter the row letter and position number of the musician to be removed.
     * If the input row or position is out of range, the user is prompted to try again.
     * If the specified position is already vacant, an error message is displayed.
     * If a musician is successfully removed, their weight at the specified position is set to 0.0.
     *
     * @see BandOfTheHour
     */
    private static void removeMusician() {
        // Variables to hold system values
        int position, totalPositions;
        char rowLetter;

        System.out.print("Please enter row letter                       : ");
        rowLetter = keyboard.next().toUpperCase().charAt(0);
        /** Input validation for whether that row exists or if the input is wrong */
        while (rowLetter < 'A' || rowLetter > ('A' + numberOfRows - 1)) {
            System.out.print("ERROR: Out of range, try again                : ");
            rowLetter = keyboard.next().toUpperCase().charAt(0);;
        } // end of the while loop
        totalPositions = weightAssignments[rowLetter - 'A'].length;

        System.out.print("Please enter position number (1 to " + totalPositions + ")         : ");
        position = keyboard.nextInt();
        /** Input validation for choosing a position in a row */
        while (position < 1 || position > totalPositions) {
            System.out.print("ERROR: Out of range, try again                : ");
            position = keyboard.nextInt();
        } // end of the while loop

        // Checking if there is a musician at that position
        if (weightAssignments[rowLetter - 'A'][position - 1] == 0.0) {
            System.out.println("ERROR: That position is vacant.");
            return;
        } // end of if statement

        weightAssignments[rowLetter - 'A'][position - 1] = 0.0;
        System.out.println("****** Musician removed.");
    } // end of removeMusician method

    //-----------------------------------------------------------------------------
    /**
     * The main method of the BandOfTheHour class.
     * Instantiates a BandOfTheHour object and repeatedly displays the menu, prompts the user for input,
     * and executes the corresponding action until the user chooses to exit.
     *
     * @param args to run main method
     */
    public static void main(String[] args) {
        // Variables to hold system values
        char option;
        BandOfTheHour bandOfTheHour = new BandOfTheHour();

        option = ' ';

        do {
            printMenu();
            String optionInput = keyboard.next().toUpperCase();

            /** Input validation to for optionInput*/
            while (!optionInput.matches("[ARPX]")) {
                System.out.print("ERROR: Invalid option, try again              : ");
                optionInput = keyboard.next();
            } // end of while loop

            option = optionInput.charAt(0);

            // Use switch statement to perform the corresponding action based on the chosen option
            switch (option) {
                case 'a':
                case 'A':
                    bandOfTheHour.addMusician();
                    break;
                case 'r':
                case 'R':
                    bandOfTheHour.removeMusician();
                    break;
                case 'p':
                case 'P':
                    bandOfTheHour.printAssignment();
            } // end of switch statement
        } while (option != 'X');
    } // end of main method

} // end of BandOfTheHour class

