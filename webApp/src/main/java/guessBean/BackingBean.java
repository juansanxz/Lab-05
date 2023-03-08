package guessBean;

import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
/**
 * Backing-Bean of session for each user, for  "guess the number" game
 * @author Santiago Arévalo y Juan Sánchez
 *
 */
public class BackingBean {
	private int numberToGuess;
	private int attempts;
	private int currentPrize;
	private String gameState;
	private Random randomNumber;
	
	public BackingBean () {
		setNumberToGuess();
		attempts = 0;
		currentPrize = 100000;
		gameState = "No";
		randomNumber = new Random();
	}

	/**
	 * Checks if user guesses the number
	 * @param numberAttempt the number attempted by user
	 */
	private void guess (int numberAttempt) {
		attempts++;
		if (numberToGuess == numberAttempt) {
			gameState = "Yes your prize is " + String.valueOf(currentPrize);
		} else {
			currentPrize -= 10000;
		}
	}
	
	/**
	 * Restarts the game
	 */
	private void restart() {
		setNumberToGuess();
		attempts = 0;
		currentPrize = 100000;
		gameState = "No";	
	}
	
	/**
	 * Sets the random number for the game
	 */
	private void setNumberToGuess() {
		numberToGuess = randomNumber.nextInt();
	}
	
	public int getNumberToGuess() {
		return numberToGuess;
	}
	
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getCurrentPrize() {
		return currentPrize;
	}

	public void setCurrentPrize(int currentPrize) {
		this.currentPrize = currentPrize;
	}

	public String getGameState() {
		return gameState;
	}

	public void setGameState(String gameState) {
		this.gameState = gameState;
	}

	
}
