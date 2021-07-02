import java.util.*;
//Author: Mohammed
//Purpose: Prompt a credit card number (ex: 1234 5678 0123 4567) and separate the code
//         in the form: Industry ID     1
//                      Issuer ID       23456
//                      Account Number  780123456
//                      Checksum ID     7

public class JavaCreditCardProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean errorOccured = true;
        int industryID = 0;
        int issuerID = 0;
        int accountNumber = 0;
        int checksum = 0;
        long entry;

        //Enter a credit card code
        System.out.println("Enter a credit card (16 digits)");

        //while an error occured
        while (errorOccured) {
            //try-catch for non-long inputs
            try {
                entry = input.nextLong();
                //repeat loop if more or less than 16 digits
                if (entry <= 999999999999999l || entry >= 10000000000000000l) {
                    System.out.println("Please enter a 16-digit number");
                    continue;
                }
                //Separate the credit card code in the form:
                else {
                    checksum = (int) (entry % 10);
                    entry /= 10;
                    accountNumber = (int) (entry % 1000000000);
                    entry /= 1000000000;
                    issuerID = (int) (entry % 100000);
                    entry /= 100000;
                    industryID = (int) entry;
                    //no error occured, may skip loop
                    errorOccured = false;
                }
            }
            catch (Exception e) {
                System.out.println("Please enter a valid credit card number.");
                System.out.println(e);
                //Next token
                input.next();
            }
        }
        System.out.println("Industry ID: " + industryID);
        System.out.println("Issuer ID: " + issuerID);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Checksum: " + checksum);


    }
}
