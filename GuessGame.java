import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Random number generator
        Random random = new Random();

        // Setting the range for the generated number
        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 0;
        int score = 0;
        int userGuess;

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have eight attempts to guess the number.Good Luck!!");
        // Generate a random number within the specified range
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        do {
            // Prompt user to guess the number
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ": ");
            userGuess = scanner.nextInt();
            numberOfAttempts++;

            // Check if the guess is correct
            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the number.");
                score += 10; // You can adjust the scoring system as needed
                System.out.println("Your score for this round: " + score);
                System.out.println("Number of attempts: " + numberOfAttempts);

                // Ask if the user wants to play again
                System.out.println("Do you want to play again? (1 for yes, 0 for no): ");
                int playAgain = scanner.nextInt();

                // Reset attempts for a new round or exit the game
                if (playAgain == 1) {
                    numberOfAttempts = 0;
                } else {
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                }
            } 
            if (userGuess > generatedNumber) {
                System.out.println("Go Lower");
            } else {
                System.out.println("Go Higher");
            }

            // Limiting the number of attempts
            if (numberOfAttempts >= 8) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
                System.out.println("Do you want to play again? (1 for yes, 0 for no): ");
                int playAgain = scanner.nextInt();

                // Reset attempts for a new round or exit the game
                if (playAgain == 1) {
                    numberOfAttempts = 0;
                     generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;//reset the random number

                } else {
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                }
            }
        } while (true);

        // Close the scanner
        scanner.close();
    }
}
