//Initializes Card class information
//Contains information on card rank/number
//Includes toString() method to translate card information for user display.

public class Card {
	//public String suit;
	public String rank;

	
	Card(String rank){
		this.rank = rank;
	}
	
	public String toString() {
		return this.rank;
	}
}
