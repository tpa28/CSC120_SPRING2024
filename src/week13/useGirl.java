package week13;

import java.util.Scanner;

public class useGirl {
    public static void main(String[] args) {
        // Variables to hold system values
        Girl girl;
        Diamond newDiamond;
        String girlName;
        int carats;
        double value;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the girl: ");
        girlName = keyboard.nextLine();
        girl = new Girl(girlName);
        System.out.println(girl.getDiamondInfo());

        // do while loop to continue to get the input values of carats and value until both equal 0 0
        do {
            System.out.print("Enter carats and value: ");
            carats = keyboard.nextInt();
            value = keyboard.nextDouble();

            newDiamond = new Diamond(carats, value);

            girl.receiveDiamond(newDiamond);
            System.out.println(girl.getDiamondInfo());
        } while (carats != 0 || value != 0);

    } // end of main mathod


}
