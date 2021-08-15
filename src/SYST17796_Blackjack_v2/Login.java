package SYST17796_Blackjack_v2;

import java.util.Scanner;

/**
 * This class is to demonstrate unit testing and is for Exercise 3 assignment.
 * It is a password validator and requires the password inputted by the user
 * should contains at least 8 characters, at least one special character and at
 * least one upper case letter.
 *
 * @author Paul Bonenfant
 * @author Xianjun Wang Student ID:991439820 July, 2021
 * 
 * Reference: Paul Bonenfant(July, 2021) In class code for course SYST 17796 Fundamentals of
 * Software Design and Development.
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean isValid = false;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please enter a password, the password has at least 8 characters,");
            System.out.println("it contains at least one upper case letter and  at least one special character.");

            //user input a password
            String password = input.nextLine();

            //check if the input password is valid
            isValid = checkLength(password) && checkSpecialChar(password) && checkUpperCase(password);
        } while (!isValid);
    }

    public static boolean checkLength(String password) {
        return password.length() >= 8;
    }

    public static boolean checkSpecialChar(String password) {
        int specialCharCount = 0;

        //iterate over each character of the password to see if it has a special character
        for (int i = 0; i < password.length(); i++) {
            if (!(Character.isLetterOrDigit(password.charAt(i)))) {
                //now we know there is at least one special character
                specialCharCount++;
            }
        }

        return specialCharCount > 0;
    }

    public static boolean checkUpperCase(String password) {
        int upperCaseCount = 0;

        //iterate over each character of the password to see if it has a upper case letter character.
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                //now we know there is at least one upper case letter.
                upperCaseCount++;
            }
        }

        return upperCaseCount > 0;
    }
}

