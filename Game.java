package guessTheMovie;

import java.util.Scanner;

public class Game {

	private static String usersGuess;
	private static boolean isGameFinished = false;
	private static final Scanner inputScanner = new Scanner(System.in);
	private static int guessesLeft = 0;
	private static String lettersAlreadyGuesses = "";
	private static boolean isLetterFound;

	public static void main(String[] args) {

		InitializeNewGame newMovieGame = new InitializeNewGame();
		guessesLeft =newMovieGame.getGuessCount();

		while (guessesLeft > 0 && !isGameFinished) {
			//reads use's input
			usersGuess = inputScanner.next();

			if (usersGuess.length()==1) {
				if (!Character.isLetter(usersGuess.charAt(0))) {
					System.out.println("Enter only letters.\n");
					continue;
				} else if (lettersAlreadyGuesses.indexOf(usersGuess) > -1) {
					System.out.println(usersGuess + " was already guessed. Please guess another letter.\n");
					continue;
				}
				lettersAlreadyGuesses += usersGuess;

				//		System.out.println(usersGuess);
				isLetterFound = newMovieGame.makeNewGuess(usersGuess.charAt(0));
				isGameFinished = newMovieGame.isGameFinished();

				if (!isLetterFound) {
					guessesLeft--;
					newMovieGame.setGuessCount(guessesLeft);
				}
				// increments the guess counter

				if (isGameFinished) {
					System.out.println("WOOHOO! You guessed it right. " + newMovieGame.getRandomMovie().toUpperCase());
				} else if (guessesLeft == 0){
					System.out.println("OOPS! you are out of guesses. Correct movie name was : " + newMovieGame.getRandomMovie().toUpperCase());
				}else {
					System.out.println(newMovieGame.getGuessCount() + " guess(es) left. : " + newMovieGame.getRandomMovieHidden());
				}
			} else { 
				System.out.println("Enter only a single letter.\n");
			}
		}
	}
}
