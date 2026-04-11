import java.util.Scanner;
import java.util.ArrayList;
public class Game {
    int guesses;
    int numToGuess;
    static Scanner sc = new Scanner(System.in);
ArrayList<Integer> previousGuesses = new ArrayList<>();
    Game(int low, int high) {
      numToGuess = (int)(Math.random() * (high - low + 1) + low);
        
        System.out.println("I'm thinking of a number between " + low + " and " + high);
        // when we create a game, we get a random number between low to high.
        // assign numToGuess to that random number.
    }

    void play() {

     int guess=getGuess();
       guesses++;
      System.out.println(guesses);
        // you can remove these println statements, they are just here for you to
        // understand how we call this code.
      
        // gets the user guess by calling getGuess()
        System.out.println("You guessed " + guess);


    

        if(guess < numToGuess){
            System.out.println("The number is higher than " + guess);
            play();
        } else if(guess > numToGuess){
            System.out.println("The number is lower than " + guess);
            play();

        } else {
            System.out.println("You guessed the number in " + guesses + " guesses!");
        }
       
       
        // When user guesses incorrectly, says whether the number is higher or lower.
        // When user guesses correctly, finishes the game and tells them how many
        // guesses they had.
        
    }

    int getGuess() {
        int guess;
        if(sc.hasNextInt()){
     guess = sc.nextInt();
        } else {
            System.out.println("Character not recognized, please enter an integer");
            sc.next(); 
            return getGuess();
        }
if (previousGuesses.contains(guess)){
    System.out.println("you already guessed " + guess);
   return getGuess();
}
        previousGuesses.add(guess);
            return guess;


        
        // get user input from a Scanner.
        // bonus: go back to your BuzzFeedQuiz code and recurse to not allow invalid
        // input.
        
    }

    int getNumGuesses() {
        return guesses;

    }
   
}
