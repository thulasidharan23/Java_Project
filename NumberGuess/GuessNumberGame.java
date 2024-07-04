
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberGame {

  private static final int MIN_NUMBER=1;//Min number to guess
  private static final int MAX_NUMBER=100;//Max number to guess

  public static void main(String[] args)
  {
    GuessNumberGame game=new GuessNumberGame();
    game.startGame();
  }

  public void startGame()
  {
    boolean Guess=false;
    int numberofGuesses=0;
    // computer thinks a number
    int RandamNO=Random();

    // Program continues till user guesses the number correctly
    while(!Guess)
    {
      int userNumber=getUserGuessedNumber();
      if (userNumber>RandamNO){
        System.out.println("Sorry, the number you guessed is too high");
      } 
      else if (userNumber<RandamNO){
        System.out.println("Sorry, the number you guessed is too low");
      } 
      else if (userNumber==RandamNO){
          System.out.println("Congratulations! Your guess is correct!");
          Guess = true;
      }
      numberofGuesses++;
    }
    System.out.println("You found the number in " + numberofGuesses + " guesses");

  }

  public int Random(){
    return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER+1);
  }

  public int getUserGuessedNumber(){
      @SuppressWarnings("resource")
      Scanner sn=new Scanner(System.in);
      System.out.println("Please guess the number: ");
      return sn.nextInt();
    }
}