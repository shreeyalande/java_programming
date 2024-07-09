import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100;
        int secretNumber;
        int attempts;
        int maxAttempts = 7;
        int rounds = 0;
        int totalAttempts = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            attempts = 0;
            secretNumber = random.nextInt(maxRange) + 1;
            System.out.println("Round " + rounds + ": I'm thinking of a number between 1 and " +maxRange);
            
            while (true) {
                System.out.print("Guess a number: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly!");
                    System.out.println("It took you " + attempts + " attempts.");
                    break;
                }
                
                if (attempts >= maxAttempts) {
                    System.out.println("Oops! You've reached the maximum number of attempts (" + maxAttempts + ").");
                    System.out.println("The number I was thinking of was " + secretNumber + ".");
                    break;
                }
            }
            
            totalAttempts += attempts;
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
            
        } while (playAgain);
        
        System.out.println("Game Over! You played " + rounds + " rounds.");
        System.out.println("Your total score is based on total attempts: " + totalAttempts);
        
        scanner.close();
    }
}

