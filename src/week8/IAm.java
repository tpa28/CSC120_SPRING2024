package week8;

import java.util.Scanner;

public class IAm {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter sentences, . to end.");

        String sentence = keyboard.nextLine();
        String qualities = "";

        while (!sentence.equals(".")) {

            if (sentence.startsWith("I am ")) {
                qualities += sentence.substring(5) + ", ";
            }
            sentence = keyboard.nextLine();

        } // end of while loop

        System.out.println("The qualities are " + qualities);
    } // end of main method

} // end of IAm class