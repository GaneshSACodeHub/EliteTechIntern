import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rangeStart = 1, rangeEnd = 100;  // The range of the number
        int attempts = 5;  // Maximum number of attempts allowed
        
        // Random number generation
        int secretNumber = rangeStart + (int)(Math.random() * (rangeEnd - rangeStart + 1));
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + rangeStart + " and " + rangeEnd + ".");
        System.out.println("You have " + attempts + " attempts to guess the number.");
        
        boolean hasWon = false;

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            int userGuess = scanner.nextInt();
            
            if (userGuess == secretNumber) {
                hasWon = true;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed the number.");
        } else {
            System.out.println("Sorry, you've used all attempts. The number was " + secretNumber + ".");
        }

        scanner.close();
    }
}
