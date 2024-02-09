import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] xx) {
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        int gNum = 0;
        double rounds = 0;
        String guess1 = "too low";
        String guess2 = "too high";
        String guess3 = "Congratulations! You've guessed the number correctly.";
        boolean retry = true;

        while (retry) {
            int random = rand.nextInt(100) + 1;
            double attempts = 0;
            boolean guessright = false; // Initialize as false
            while (!guessright && attempts < 3) {
                System.out.println("Guess the number between 1-100:");
                gNum = kb.nextInt();
                attempts++;

                if (random == gNum) {
                    System.out.println(guess3 + " You completed the game in " + attempts + " attempts.");
                    rounds += 5 - attempts;
                    guessright = true; // Set to true when the guess is correct
                } else if (random < gNum) {
                    System.out.println(guess2 + " Try again.");
                } else {
                    System.out.println(guess1 + " Try again.");
                }
            }
            if (!guessright) {
                System.out.println("You didn't manage to guess the number correctly. It was " + random + ".");
            }
            // Add a way to exit the outer loop
            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = kb.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                retry = false;
            }
        }
        System.out.println("Thank you for playing!");
    }
}
