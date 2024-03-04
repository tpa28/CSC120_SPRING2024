package week5;
import java.util.Scanner;

//=============================================================================
//-----------------------------------------------------------------------------
public class TaxTime {
    private static Scanner keyboard = new Scanner(System.in);

    // Add all the variables that will always remain constant
    private static final double STINKING_RICH = 500000;

    private static final double QUITE_RICH = 200000;

    private static final double MIAMI_POOR = 100000;

    private static final double AVERAGE = 50000;

    private static final double REALISTIC = 20000;

    private static final double HIGH_RATE = .25;

    private static final double MEDIUM_RATE = .10;

    private static final double LOW_RATE = .03;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {
        //----Variables to hold system values
        double valueAmount, income, deduction, taxableIncome, taxOwed;
        char taxGroup;

        //----Set income and deduction to 0 in order to give them value
        income = 0.0;
        deduction = 0.0;

        //----Implement a do-while loop in order to get the income and deductions
        // until the valueAmount implemented is 0
        do {
            System.out.print("Enter next amount: ");
            valueAmount = keyboard.nextDouble();

            if (valueAmount > 0) {
                income = income + valueAmount;
            }

            else {
                deduction = deduction + Math.abs(valueAmount);
            } // end of the if-else loop

        } while (valueAmount != 0); // end of the do-while loop

        /*
            Get the taxableIncome, taxGroup, and tax using the
            computeTaxableIncome, computeTaxGroup, and computeTax methods
        */

        taxableIncome = computeTaxableIncome(income, deduction);
        taxGroup = computeTaxGroup(taxableIncome);
        taxOwed = computeTax(taxableIncome, taxGroup);

        //----Implement the displayTaxInformation method to display the results
        displayTaxInformation(income, deduction, taxableIncome, taxGroup, taxOwed);

    } // end of the Main Method

    /*
          Compute the computeTaxableIncome as a double to return the
          total taxable income by subtracting the deduction from the income
          using an if-else statement
    */
    private static double computeTaxableIncome(double income, double deduction){
        if (income >= deduction) {
            return (income - deduction);
        }
        else {
            return 0.0;
        } // end of the if-else loop
    } // end of the computeTaxableIncome Method


    //----Compute the computeTaxGroup as a char to return a
    // character value based on the double taxableIncome
    private static char computeTaxGroup(double taxableIncome){
        if (taxableIncome >= STINKING_RICH) {
            return 'S';
        } else if (taxableIncome >= QUITE_RICH) {
            return 'Q';
        } else if (taxableIncome >= MIAMI_POOR) {
            return 'M';
        } else if (taxableIncome >= AVERAGE) {
            return 'A';
        } else if (taxableIncome >= REALISTIC) {
            return 'R';
        } else {
            return 'P';
        } // end of the if-else if loop
    } // end of the computeTaxGroup Method

    /*
        Compute the computeTax as a double to return the double
        value after taxes based on the char value of what tax group
        they are apart of
    */
      private static double computeTax(double taxableIncome, char taxGroup) {
        switch (taxGroup) {
            case 'S':
            case 'Q':
                return HIGH_RATE * taxableIncome;
            case 'M':
                return MEDIUM_RATE * taxableIncome;
            case 'A':
            case 'R':
                return LOW_RATE * taxableIncome;
            case 'P':
                return 0.0;
            default:
                System.out.println("Error!");
                return 0.0;
        } // end of the switch
    } // end of the computeTax Method

    //----Display the income, deduction, taxableIncome, taxGroup, and tax owed
    private static void displayTaxInformation(double income, double deduction, double taxableIncome, char taxGroup, double taxOwed) {
        System.out.println();
        System.out.println("Income         = $" + income);
        System.out.println("Deductions     = $" + deduction);
        System.out.println("Taxable income = $" + taxableIncome);
        System.out.println("Tax group      = " + taxGroup);
        System.out.println("Tax owed       = $" + taxOwed);
    } // end of the displayTaxInformation Method


} // end of the TaxTime class
//-----------------------------------------------------------------------------
//=============================================================================

