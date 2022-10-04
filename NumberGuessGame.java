import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {
        int number_to_be_guessed = (int)(Math.random() * 21);

        System.out.println(number_to_be_guessed);

        Scanner input = new Scanner(System.in);
        System.out.println("Guess a number between 0 and 20");

        int guess = -1;

        while (guess != number_to_be_guessed) {
            System.out.print("\nEnter your guess: ");
            guess = input.nextInt();

            if (guess > number_to_be_guessed) {
                System.out.println("Your guess is too high");
            } else if (guess < number_to_be_guessed) {
                System.out.println("Your guess it too low");
            }
        }
        System.out.println("Your guess is correct!");

    }
}
