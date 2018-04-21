/**
 * Program filename: HiLow.java
 * Author: Cory Ringer
 * Last Updated: 17 February 2018
 */
import java.util.Scanner;

public class HiLow
{
    final int QUIT_GAME = -1;
    int randNum;
    int counter;
    private int runCounter = 0;

    public static void main(String[] args) {
        final int LOW_LIMIT  = 1;
        final int HIGH_LIMIT = 100;

        final int NO      = 0;
        final int YES     = 1;
        final int INVALID = 2;

        char playAgain;
        int keepPlaying;

        Scanner userInput = new Scanner(System.in);

        do {
            // Create a new game.
            HiLow newGame = new HiLow();

            // Set random number value.
            newGame.setRandNum(LOW_LIMIT, HIGH_LIMIT);

            // Start screen
            System.out.println("I'm thinking of a number between " +
                               LOW_LIMIT + " and " + HIGH_LIMIT + "."
                );

            newGame.resetCounter();

            // Start game.
            newGame.run(LOW_LIMIT, HIGH_LIMIT);

            do {
                // Query user to play again after game finished.
                System.out.print("\nYou finished the game with " +
                                 newGame.getCounter() +
                                 " guess(es). Do you wish to play " +
                                 "again? (Y/n)\n> "
                    );
                playAgain = userInput.next().charAt(0);

                switch(playAgain)
                {
                case 'n':
                    keepPlaying = NO;
                    break;
                case 'N':
                    keepPlaying = NO;
                    break;
                case 'y':
                    keepPlaying = YES;
                    break;
                case 'Y':
                    keepPlaying = YES;
                    break;
                default:
                    System.out.println("ERROR: Invalid entry.");
                    keepPlaying = INVALID;
                }
            }
            while (keepPlaying == INVALID);
        }
        while (keepPlaying == YES);  // Loop game if player wants
        // to play again.

        System.out.println("Goodbye\n");
    }

    public void run(int low, int high) {
        int guess;

        // Test
        System.out.println("entering run: " + ++runCounter);

        Scanner scan = new Scanner(System.in);

        System.out.print("\nPick a number between " +
                         low + " and " + high + ".\n> "
            );
        guess = scan.nextInt();

        // User exits program.
        if (guess == QUIT_GAME) {
            System.out.println("Goodbye\n");
            System.exit(0);
        }
        // Guess matches value.
        else if (guess == randNum) {
            System.out.println("Correct.");
            counter++;
            return;
        }
        // Guess is too low.
        else if (guess < randNum) {
            System.out.println("Incorrect. Too low.");
            counter++;

            // Bring up low limit.
            if (guess > low)
                run(guess, high);
            else
                run(low, high);
        }
        // Guess is too high.
        else if (guess > randNum) {
            System.out.println("Incorrect. Too high.");
            counter++;

            // Bring down high limit.
            if (guess < high)
                run(low, guess);
            else
                run(low, high);
        }

        // Test
        System.out.println("entering run: " + runCounter--);
    }

    public void setRandNum(int low, int high) {
        randNum = (int) (Math.random() * (high - low)) + low;
    }

    public void resetCounter() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }
}
