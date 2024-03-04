package week4;
import java.util.Scanner;

//=============================================================================
//-----------------------------------------------------------------------------
public class NitroxScuba {
    private static Scanner keyboard = new Scanner(System.in);

    //----The "feet per atmosphere" constant
    private static final int FEET_PER_ATMOSPHERE_CONSTANT = 33;
    private static final double MAXIMAL_OXYGEN_PRESSURE_CONSTANT = 1.4;
    private static final double CONTINGENCY_OXYGEN_PRESSURE_CONSTANT = 1.6;

    public static void main(String[] args) {

        //----Variables to hold system values
        int depth, o2Percentage;
        double ambientPressure, partialPressureOfO2;
        boolean maximalO2Pressure, contingencyO2Pressure;
        char oxygenPressureGroup;

        //----Getting 2 inputs from keyboard/user
        System.out.print("Enter depth and percentage O2   : ");
        depth = keyboard.nextInt();
        o2Percentage = keyboard.nextInt();

        /*----Get the ambientPressure, partialPressureOfO2, and oxygenPressureGroup
         using the computeAmbientPressure, computePartialPressureOxygen, and
         computeOxygenPressureGroup methods
        */

        ambientPressure = computeAmbientPressure(depth);
        partialPressureOfO2 = computePartialPressureOfO2(ambientPressure, o2Percentage);
        oxygenPressureGroup = computeO2PressureGroup(partialPressureOfO2);

        /*----Find the truth values of the booleans maximalO2Pressure and
        contingencyO2Pressure using the partialPressureOfO2
        */
        maximalO2Pressure = (partialPressureOfO2 > MAXIMAL_OXYGEN_PRESSURE_CONSTANT);
        contingencyO2Pressure = (partialPressureOfO2 > CONTINGENCY_OXYGEN_PRESSURE_CONSTANT);

        //----Display the ambient pressure, partial pressure of oxygen, O2 group, and warnings
        System.out.println("Ambient pressure                : " + ambientPressure);
        System.out.println("O2 pressure                     : " + partialPressureOfO2);
        System.out.println("O2 group                        : " + oxygenPressureGroup);
        System.out.println("Exceeds maximal O2 pressure     : " + maximalO2Pressure);
        System.out.println("Exceeds contingency O2 pressure : " + contingencyO2Pressure);

    } // end of the Main Method

    //----Calculate the ambient pressure for a given depth
    private static double computeAmbientPressure(int depth) {
        // Calculate the ambient pressure using the formula:
        // (depth / feet per atmosphere constant) + 1
        return (double)(depth / FEET_PER_ATMOSPHERE_CONSTANT) + 1;
    } // end of the Compute Ambient Pressure Method

    //----Calculate the partial pressure of oxygen
    private static double computePartialPressureOfO2(double ambientPressure, int o2Percentage) {
        // Calculate the ambient pressure using the formula:
        // (o2Percentage / 100.0) * ambientPressure
        return ((o2Percentage / 100.0) * ambientPressure);
    } // end of the Compute Partial Pressure of O2 Method

    //----Compute and find the oxygen pressure group

    private static char computeO2PressureGroup(double partialPressureOfO2) {
        // Determine the group by scaling the partialPressureOfO2 by 10 and adding 'A'
        return (char) ((int)'A' + (int) (partialPressureOfO2 * 10));
    } // end of the Compute O2 Pressure Group Method

} // end of the NitroxScuba class
//-----------------------------------------------------------------------------
//=============================================================================

