
import java.util.*;

public class Deck {

	public static ArrayList<Card> initilizeDeck(){
		ArrayList<Card> returnDeck = new ArrayList<Card>();
			int i2 = 1;
			int i3 = 0;
			for(int i = 0; i<55; i++) {
				if(i2 < 4) {
					i2++;
				} else if(i2 == 4) {
					i2 = 1;
					i3 = i3 + 1;
				}
				if(i3 == 1) {
					Card card= new Card("Ace");
					returnDeck.add(card);
				}
				if(i3 == 2) {
					Card card= new Card("Two");
					returnDeck.add(card);
				}
				if(i3 == 3) {
					Card card= new Card("Three");
					returnDeck.add(card);
				}
				if(i3 == 4) {
					Card card= new Card("Four");
					returnDeck.add(card);
				}
				if(i3 == 5) {
					Card card= new Card("Five");
					returnDeck.add(card);
				}
				if(i3 == 6) {
					Card card= new Card("Six");
					returnDeck.add(card);
				}
				if(i3 == 7) {
					Card card= new Card("Seven");
					returnDeck.add(card);
				}
				if(i3 == 8) {
					Card card= new Card("Eight");
					returnDeck.add(card);
				}
				if(i3 == 9) {
					Card card= new Card("Nine");
					returnDeck.add(card);
				}
				if(i3 == 10) {
					Card card= new Card("Ten");
					returnDeck.add(card);
				}
				if(i3 == 11) {
					Card card= new Card("Jack");
					returnDeck.add(card);
				}
				if(i3 == 12) {
					Card card= new Card("Queen");
					returnDeck.add(card);
				}
				if(i3 == 13) {
					Card card= new Card("King");
					returnDeck.add(card);
				}
				
			}
			Collections.shuffle(returnDeck);
		return returnDeck;
	}//END DECK INITIALIZATION
	
}
