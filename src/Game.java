import java.util.*;
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Deck is initialized and shuffled through call to Deck class, then stored locally in Game class as finalDeck
		ArrayList<Card> finalDeck = new ArrayList<Card>();
		finalDeck = Deck.initializeDeck();

	}

}
