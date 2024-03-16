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
    private final static Scanner keyboard = new Scanner(System.in);
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
     * Initializes the stadium by prompting the user to input the number of rows and positions in each row.
     */
    private static void initializeStadium() {
        System.out.println("Welcome to the Band of the Hour");
        System.out.println("-------------------------------");
        System.out.printf("Please enter the number of rows               : ");
        do {
            numberOfRows = keyboard.nextInt();
            if (numberOfRows <= 0 || numberOfRows > MAX_ROWS) {
                System.out.print("ERROR: Out of range, try again                : ");
            }
        } while (numberOfRows <= 0 || numberOfRows > MAX_ROWS);


        weightAssignments = new double[numberOfRows][];
        for (int index = 0; index < numberOfRows; index++) {
            int numberOfPositions;
            char rowLetter = (char) ('A' + index);

            System.out.print("Please enter the number of positions in row " + rowLetter + " : ");
            do {
                while (!keyboard.hasNextInt()) {
                    System.out.print("ERROR: Invalid input. Please enter a valid integer.");
                    keyboard.next(); // consume invalid input
                }
                numberOfPositions = keyboard.nextInt();

                if (numberOfPositions <= 0 || numberOfPositions > MAX_POSITIONS) {
                    System.out.print("ERROR: Out of range, try again                : ");
                }
            } while (numberOfPositions <= 0 || numberOfPositions > MAX_POSITIONS);

            weightAssignments[index] = new double[numberOfPositions];
        }
    }
//-----------------------------------------------------------------------------
    /**
     * Displays the main menu options.
     */
    private static void printMenu() {
        System.out.print("\n(A)dd, (R)emove, (P)rint,              e(X)it : ");
    }
//-----------------------------------------------------------------------------
    /**
     * Prints the current assignment of musicians in the stadium, along with total and average weights for each row.
     */
    private static void printAssignment() {
        double totalWeight, averageWeight;
        int totalPositions;

        for (int index = 0; index < numberOfRows; index++) {
            totalWeight = 0.0;
            totalPositions = weightAssignments[index].length;

            System.out.print((char) ('A' + index) + ":   ");
            for (int columns = 0; columns < totalPositions; columns++) {
                System.out.print(weightAssignments[index][columns] + "   ");
                totalWeight += weightAssignments[index][columns];
            }

            averageWeight = (totalPositions > 0) ? totalWeight / totalPositions : 0.0;
            System.out.println("                        [    " + totalWeight + ",     " + averageWeight + "]");
        }

    }
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
        int position, totalPositions;
        double weight, rowTotalWeight;
        char rowLetter;

        System.out.print("Please enter row letter                       : ");
        rowLetter = keyboard.next().toUpperCase().charAt(0);

        while (rowLetter < 'A' || rowLetter > ('A' + numberOfRows - 1)) {
            System.out.print("ERROR: Out of range, try again                : ");
            rowLetter = keyboard.next().toUpperCase().charAt(0);;
        }
        totalPositions = weightAssignments[rowLetter - 'A'].length;

        System.out.print("Please enter position number (1 to " + totalPositions + ")         : ");
        position = keyboard.nextInt();
        while (position < 1 || position > totalPositions) {
                System.out.print("ERROR: Out of range, try again                : ");
                position = keyboard.nextInt();
        }

        if (weightAssignments[rowLetter - 'A'][position - 1] != 0.0) {
            System.out.println("ERROR: There is already a musician there.");
            return;
        }

        System.out.print("Please enter weight (" + MIN_WEIGHT + " to " + MAX_WEIGHT + ")           : ");
        weight = keyboard.nextDouble();

        while (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            System.out.print("ERROR: Out of range, try again                : ");
            weight = keyboard.nextDouble();
        }

        rowTotalWeight = 0.0;

        /**
         * This loop iterates over each weight (w) in the array weightAssignments[rowLetter - 'A'],
         * where rowLetter - 'A' is used to get the index of the row corresponding to the input rowLetter.
         * Each w represents the weight of a musician in the specified row.
         * */
        for (double musicianWeight : weightAssignments[rowLetter - 'A']) {
            rowTotalWeight += musicianWeight;
        }
        if (rowTotalWeight + weight > (totalPositions*100)) {
            System.out.println("ERROR: Adding this musician would exceed the row weight limit.");
            return;
        }

        weightAssignments[rowLetter - 'A'][position - 1] += weight;
        System.out.println("****** Musician added.");
    }
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
        int position, totalPositions;
        char rowLetter;

        System.out.print("Please enter row letter                       : ");
        rowLetter = keyboard.next().toUpperCase().charAt(0);

        if (rowLetter < 'A' || rowLetter > ('A' + numberOfRows - 1)) {
            System.out.print("ERROR: Out of range, try again:");
            rowLetter = keyboard.next().toUpperCase().charAt(0);
        }
        totalPositions = weightAssignments[rowLetter - 'A'].length;

        System.out.print("Please enter position number (1 to " + totalPositions + ")         : ");
        position = keyboard.nextInt();

        if (position < 1 || position > totalPositions) {
            System.out.print("ERROR: Out of range, try again                : ");
            position = keyboard.nextInt();
        }

        if (weightAssignments[rowLetter - 'A'][position - 1] == 0.0) {
            System.out.println("ERROR: That position is vacant.");
            return;
        }

        weightAssignments[rowLetter - 'A'][position - 1] = 0.0;
        System.out.println("****** Musician removed.");
    }
//-----------------------------------------------------------------------------
    /**
     * The main method of the BandOfTheHour class.
     * Instantiates a BandOfTheHour object and repeatedly displays the menu, prompts the user for input,
     * and executes the corresponding action until the user chooses to exit.
     *
     * @param args to run main method
     */
    public static void main(String[] args) {
        BandOfTheHour bandOfTheHour = new BandOfTheHour();

        char option;
        option = ' ';

        do {

            printMenu();
            String optionInput = keyboard.next().toUpperCase();

            if (!optionInput.matches("[ARPX]")) {
                System.out.print("ERROR: Invalid option, try again              : ");
                optionInput = keyboard.next();
            }

            option = optionInput.charAt(0);

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
            }

        } while (option != 'X');
    }
}

