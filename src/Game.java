import java.util.*;
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize scanner
		Scanner playerscan = new Scanner(System.in);
		
		//Deck is initialized and shuffled through call to Deck class, then stored locally in Game class as finalDeck
		ArrayList<Card> finalDeck = new ArrayList<Card>();
		finalDeck = Deck.initializeDeck();
		
		//Initialize players
		Player Human = new Player();
		Player Computer = new Player();
		
		//Deal player hands
		//Code removes dealt cards from deck
		for(int i=0; i<7; i++) {
			Human.hand.add(finalDeck.get(0));
			finalDeck.remove(0);
		}
		for(int i=0; i<7; i++) {
			Computer.hand.add(finalDeck.get(0));
			finalDeck.remove(0);
		}
		
		//Establishing game as unfinished
		//0 = unfinished/in progress
		//1 = finished
		int gamestatus = 0;
		
		//Call to and print out player hand test
		//System.out.println("Your hand: " + Human.hand);
		//System.out.println("Computer Hand: " + Computer.hand);
		
		
		//Starting main program loop
		
		System.out.println("CPU: Hello. Would you like to play a game of Go Fish?");
		
		for(int introloop=0; introloop<1; introloop=0) {
			
			//Invite player to play game
			System.out.println("CPU: Please answer 'Yes' or 'No'");
		
			//Accept and parse input
			String playerinput = playerscan.nextLine();
		
			//Check player input
			if(playerinput.equals("Yes")) {
				System.out.println("CPU: Okay, let's begin the game.");
				System.out.println("CPU: You can go first.");
				
				
				//### ENTIRE GAME IS CONTAINED IN BELOW DO WHILE LOOP ###
				do {
					
					//REMAINING ASPECTS TO BE CODED:
					//Requesting opponents cards
						//Includes checking if player has requested cards, checking if opponent has requested cards, and moving the cards to the players hand.
						//Checking if player has any completed 'books,' and giving them a point if they do.
						//Drawing a card if the opponent doesn't have the requested cards.
					//Automating the computer's turn.
					
					//### MAIN GAME CODE GOES BELOW ###
					
					//If cardloop = 0, cardloop is in progress
					//If cardloop = 1, cardloop has ended
					//The for statement will reset cardloop to 0 at the start of each player's turn.
					
					for(int cardloop = 0; cardloop < 1; cardloop = 0) {
						//Communicate to player what their possible actions are.
						System.out.println("What would you like to ask for? Please capitalize and enter the card names in plural.");
						System.out.println("Your hand: " + Human.hand);
					
						//Collect input from player
						playerinput = playerscan.nextLine();
					
						//Check if player has requested cards.
					
						//Nested if statements check if player typed in the name of a card
						//If not, the cardloop initiates and requests a proper card type.
						if(!playerinput.equals("Aces")) {
							if(!playerinput.equals("Twos")) {
								if(!playerinput.equals("Threes")) {
									if(!playerinput.equals("Fours")) {
										if(!playerinput.equals("Fives")) {
											if(!playerinput.equals("Sixes")) {
												if(!playerinput.equals("Sevens")) {
													if(!playerinput.equals("Eights")) {
														if(!playerinput.equals("Nines")) {
															if(!playerinput.equals("Tens")) {
																if(!playerinput.equals("Jacks")) {
																	if(!playerinput.equals("Queens")) {
																		if(!playerinput.equals("Kings")) {
																			System.out.println("I'm sorry, that's not a card type. Please try again.");
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
							
						//Below if statement contains second half of card loop
						//Activates if player asks for a valid card type.
						
						} else if(!playerinput.equals("")) {
							
							//Adjusts the input string to compensate for entry in plurals.
							String playercardcheck = "";
							if(playerinput.equals("Sixes")) {
								playercardcheck = playerinput.substring(0, playerinput.length()-2);
							} else if(!playerinput.equals("Sixes")) {
								playercardcheck = playerinput.substring(0, playerinput.length()-1);
							}
							
							//Compares the adjusted player input to the hand of the player to check if they own those cards
							//Functions by converting the player input into a Card object and then seeing if the player's hand contains an equivalent Card object.
							Card playercardrequest = new Card(playercardcheck);
							if(!Human.hand.contains(playercardrequest)) {
								
								System.out.println("I'm sorry, you don't have those cards. Please try again.");
							
							} else if(Human.hand.contains(playercardrequest)) {
								
								//Test message
								System.out.println("It works.");
							}
							
							// ### NEEDS TO BE FIXED. COMPARISON DOESN'T WORK AT THE MOMENT ###
							
						}
							
					}
						
					//### MAIN GAME CODE GOES ABOVE
					
					
					//Requirement check to end game.
					//Code checks to see if deck is empty, or if either player has no remaining cards.
					if(finalDeck.size() == 0) {
						gamestatus = 1;
					}
					if(Human.hand.size() == 0) {
						gamestatus = 1;
					}
					if(Computer.hand.size() == 0) {
						gamestatus = 1;
					}
					
				} while(gamestatus == 0);
				
				//Code for determining winner goes here.
				
				//End game and terminate program
				introloop++;
				return;
				
			}
			if(playerinput.equals("No")) {
				System.out.println("CPU: Okay. Goodbye.");
				introloop++;
				return;
			}
			if(!playerinput.equals("Yes")) {
				if(!playerinput.equals("No")) {
				System.out.println("CPU: I'm sorry, I didn't understand your answer.");
				}
			}
		}
		
	playerscan.close();
	}

}
