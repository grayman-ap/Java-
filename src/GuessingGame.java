import java.util.Scanner;
import java.util.Random;
public class GuessingGame{
    public static void main(String[] args){
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        boolean isCorrect = false;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess");
        while(!isCorrect){
            System.out.println("Welcome to the ultimate guessing game");
            int guess =  scanner.nextInt();
            System.out.println("Attempts: " + attempts++);
            //if Attempts is  5 Game over Sucker
             if(attempts > 5){
                System.out.print("Game over");
                isCorrect= true;
                break;
            }
            if(guess == secretNumber){
                System.out.println("Congratulation you  have Guessed the correct number");
                isCorrect = true;
            }
            else if(guess < secretNumber){
                System.out.println("Too low, try again");
            }
            else{
                System.out.println("Too high, try again");
            }
        }
    }
}