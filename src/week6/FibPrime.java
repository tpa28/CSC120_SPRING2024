package week6;
import java.util.Scanner;

//=============================================================================
//-----------------------------------------------------------------------------
public class FibPrime {
    private static Scanner keyboard = new Scanner(System.in);

    private static final int MAX_ARRAY_SIZE = 10;

    private static final int STOP_INPUT_VALUE = 0;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {
        //----Variables to hold system values
        int[] candidates = new int[MAX_ARRAY_SIZE];
        int count = getCandidates(candidates);
        int index;
        boolean checkFibonacci, checkPrime;

        //----Do a for-loop to display the results of the array numbers and learn
        // if the inputed numbers are Fibonacci and/or prime
        for (index = 0; index < count; index++){
            int eachNumber = candidates[index];
            checkFibonacci = isItFibonacci(eachNumber);
            checkPrime = isItPrime(eachNumber);

            System.out.print(eachNumber + " is ");

            if (checkFibonacci) {
                System.out.print("Fibonacci and ");
            } else {
                System.out.print("not Fibonacci and ");
            }

            if (checkPrime) {
                System.out.println("is prime");
            } else {
                System.out.println("is not prime");
            }


        } // end of the for loop

    } // end of the main method

    // Compute readNumbers methods and use a do while loop to ensure
    // that the numbers inputed aren't zero and can be stored in the array
    private static int getCandidates(int[] candidates) {

        int index = 0;
        int inputedNumber;

        System.out.print("Please enter numbers (0 to stop): ");
        //----Use a do-while loop to allow the user to enter up to 10
        // integers into an array
        do {
            inputedNumber = keyboard.nextInt();

            if (inputedNumber > STOP_INPUT_VALUE) {

                candidates[index] = inputedNumber;
                index++;

            } // end of if loop
        // the do while checks to ensure the inputedNumber isn't 0 and the index of
        // inputed numbers is up to 10, not over
        } while (inputedNumber != STOP_INPUT_VALUE && index < MAX_ARRAY_SIZE);

        // Return the index of numbers entered
        return index;

    } // end of the getCandidates method

    // Compute isItFibonacci method to test whether aNumber in the array is a fibonacci number
    private static boolean isItFibonacci(int aNumber){
        //----Set variables to check for fibonacci sequence within the while loop
        int current, previous, next;
        previous = 1;
        current = 0;

        //----Based on how to find Fibonacci numbers, compute while and if loop to check
        // if the current is == to aNumber (the Fibonacci number)
        while (current < aNumber) {
            next = current + previous;
            previous = current;
            current = next;
        }

        if (current == aNumber){
            return true;
        }
        else{
            return false;
        }

    } // end of the isItPrime method

    // Compute isItPrime method to test whether aNumber in the array is a prime number
    private static boolean isItPrime(int aNumber){
        int divisor;

        for (divisor = 2; divisor <= Math.sqrt(aNumber); divisor++) {
            if (aNumber % divisor == 0) {
                return false;
            }
        } // end of the for loop

        return true;

    } // end of the isItPrime method
} // end of the FibPrime method
//-----------------------------------------------------------------------------
//=============================================================================