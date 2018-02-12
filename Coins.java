/*
 * Filename: Coins.java
 * Author: Cory Ringer
 * Date: 29 January 2018
 */ 
import java.util.Scanner;
import java.text.NumberFormat;

public class Coins
{
  final double PENNY_VAL   = 0.01;
  final double NICKEL_VAL  = 0.05;
  final double DIME_VAL    = 0.10;
  final double QUARTER_VAL = 0.25;

  int numOfPennies;
  int numOfNickels;
  int numOfDimes;
  int numOfQuarters;

  /*
   * Main program 
   */
  public static void main(String[] args)
  {
    double totalMoney;

    Scanner scan = new Scanner(System.in);
    NumberFormat formatStream = NumberFormat.getCurrencyInstance();
    Coins total = new Coins();

    // Query user for number of change.
    System.out.print("Enter the number of pennies: ");  // pennies
      total.setNumOfPennies(scan.nextInt());
    System.out.print("Enter the number of nickels: ");  // nickels
      total.setNumOfNickels(scan.nextInt());
    System.out.print("Enter the number of dimes: ");    // dimes
      total.setNumOfDimes(scan.nextInt());
    System.out.print("Enter the number of quarters: "); // quarters
      total.setNumOfQuarters(scan.nextInt());

    // Add up total amount of change.
    totalMoney = total.calculateSum();
    
    // Output total value in currency mode.
    System.out.println("Total: " + formatStream.format(totalMoney));
  }

  /*
   * Mutator functions
   */
  public void setNumOfPennies(int newNumOfPennies)
  { numOfPennies = newNumOfPennies; }

  public void setNumOfNickels(int newNumOfNickels)
  { numOfNickels = newNumOfNickels; }

  public void setNumOfDimes(int newNumOfDimes)
  { numOfDimes = newNumOfDimes; }

  public void setNumOfQuarters(int newNumOfQuarters)
  { numOfQuarters = newNumOfQuarters; }

  /*
   * Calculate total amount of money (unformatted)
   */
  public double calculateSum()
  {
    return ((PENNY_VAL * numOfPennies) +
            (NICKEL_VAL * numOfNickels) +
            (DIME_VAL * numOfDimes) +
            (QUARTER_VAL * numOfQuarters)
    );
  }
}
