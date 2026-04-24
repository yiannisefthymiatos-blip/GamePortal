import java.util.Scanner;

import Game.GameWriteable;

import java.util.ArrayList;
public class NumberGuessGame implements GameWriteable {
    int guesses;
    int numToGuess;
    static Scanner sc = new Scanner(System.in);
ArrayList<Integer> previousGuesses = new ArrayList<>();
    NumberGuessGame(int low, int high) {
      numToGuess = (int)(Math.random() * (high - low + 1) + low);
        
        System.out.println("I'm thinking of a number between " + low + " and " + high);
        // when we create a game, we get a random number between low to high.
        // assign numToGuess to that random number.
    }
    public String getGameName(){
        return "numberguessgame";
    }

    

   public void play() {

    while (true) {
        int guess = getGuess();
        guesses++;

        System.out.println("You guessed " + guess);

        if (guess < numToGuess) {
            System.out.println("The number is higher than " + guess);
        } 
        else if (guess > numToGuess) {
            System.out.println("The number is lower than " + guess);
        } 
        else {
            System.out.println("You guessed the number in " + guesses + " guesses!");
            break; // 👈 THIS ends the game
        }
    }
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
    @Override
   public boolean isHighScore(String score, String currentHighScore){
   if (currentHighScore == null){
    return true;
   }
    try {
        int newScore = Integer.parseInt(score);
        int oldScore = Integer.parseInt(currentHighScore);
    
    return newScore < oldScore;
   }
catch (NumberFormatException e) {
    return false;
}
   }


public String getScore(){
return String.valueOf(guesses);
}

       
}
