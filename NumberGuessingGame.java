import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            rounds++;
            int randomNumber = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\nRound " + rounds + ":");
            
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Guess a number between 1 and 100: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    hasWon = true;
                    break;
                }
            }

            if (!hasWon) {
                System.out.println("You've run out of attempts! The number was " + randomNumber + ".");
            }

            // Ask if the user wants to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
