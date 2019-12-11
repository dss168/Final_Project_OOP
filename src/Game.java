import java.util.*;
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Deck is initialized and shuffled through call to Deck class, then stored locally in Game class as finalDeck
		ArrayList<Card> finalDeck = new ArrayList<Card>();
		finalDeck = Deck.initializeDeck();

		//Initialize players
		Player Human = new Player();
		Player Computer = new Player();
		
		//Deal player hands
		for(int i=0; i<7; i++) {
			Human.hand.add(finalDeck.get(0));
			finalDeck.remove(0);
		}
		for(int i=0; i<7; i++) {
			Computer.hand.add(finalDeck.get(0));
			finalDeck.remove(0);
		}
		
		//Call to and print out player hand test
		System.out.println("Your hand: " + Human.hand);
		System.out.println("Computer Hand: " + Computer.hand);
	}

}
