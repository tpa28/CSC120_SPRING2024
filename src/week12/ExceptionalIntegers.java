package week12;
import java.util.ArrayList;

public class ExceptionalIntegers {
    public static void main(String[] args) {
        // Variable assignments
        ArrayList<Integer> convertedInteger = new ArrayList<>();
        int index;

        // for loop to check each argument in the String
        for (index = 0; index < args.length; index++) {
            try {
                Integer temporaryInteger = Integer.parseInt(args[index]); // converts the String to an Integer
                convertedInteger.add(temporaryInteger);
                System.out.println("Converter method says integer OK - " + temporaryInteger);
            } // end of try statement

            catch (NumberFormatException e) {
                System.out.println("Catch block says the argument \"" + args[index] + "\" is ignored because " + args[index]);
            } // end of catch statement

        } // end of for loop

        System.out.println("\nVector contents are:");
        // For loop iterates over the elements of integers in convertedInteger ArrayList
        for(Integer temporaryData : convertedInteger){
            System.out.println("Item " + convertedInteger.indexOf(temporaryData) + " is " + temporaryData);
        } // end of for loop

    } // end of main method

} // end of ExceptionalIntegers class
