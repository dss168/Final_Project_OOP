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
		
		//dummyvar is used in for loops to allow for manual cancelation of the for loops
		//For loops will dump their changes into the dummyvar, thus not actually changing anything
		//This prevents infinite loops
		int dummyvar = 0;
		
		//Call to and print out player hand test
		//System.out.println("Your hand: " + Human.hand);
		//System.out.println("Computer Hand: " + Computer.hand);
		
		
		//Starting main program loop
		
		System.out.println("CPU: Hello. Would you like to play a game of Go Fish?");
		
		for(int introloop = 0; introloop < 1; dummyvar = 0) {
			
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
					//Automating the computer's turn.
					
					//### MAIN GAME CODE GOES BELOW ###
					
					//If cardloop = 0, cardloop is in progress
					//If cardloop = 1, cardloop has ended
					//The for statement will reset cardloop to 0 at the start of each player's turn.
					
					for(int cardloop = 0; cardloop < 1; dummyvar = 0) {
						//Communicate to player what their possible actions are.
						System.out.println("It's your turn!");
						System.out.println("What would you like to ask for? Please capitalize and enter the card names in plural.");
						System.out.println("You have [" + Human.points + "] books. The Computer has [" + Computer.points + "] books.");
						System.out.println("Your hand: " + Human.hand);
						
						//DEBUG CODE
						//System.out.println("Computer's hand: " + Computer.hand);
					
						//Collect input from player
						playerinput = playerscan.nextLine();
					
						//Check if player has requested cards.
					
						//Series of if statements check if player typed in the name of a card
						//If so, validcard is set to 1 and the code sequence continues.
						//If not, the cardloop initiates and requests a proper card type.
						
						int validcard = 0;
						if(playerinput.equals("Aces")) {
							validcard = 1;
						} else if (playerinput.equals("Twos")) {
							validcard = 1;
						} else if (playerinput.equals("Threes")) {
							validcard = 1;
						} else if (playerinput.equals("Fours")) {
							validcard = 1;
						} else if (playerinput.equals("Fives")) {
							validcard = 1;
						} else if (playerinput.equals("Sixes")) {
							validcard = 1;
						} else if (playerinput.equals("Sevens")) {
							validcard = 1;
						} else if (playerinput.equals("Eights")) {
							validcard = 1;
						} else if (playerinput.equals("Nines")) {
							validcard = 1;
						} else if (playerinput.equals("Tens")) {
							validcard = 1;
						} else if (playerinput.equals("Jacks")) {
							validcard = 1;
						} else if (playerinput.equals("Queens")) {
							validcard = 1;
						} else if (playerinput.equals("Kings")) {
							validcard = 1;
						} else {
							System.out.println("I'm sorry, that's not a card type. Please try again.");
						}
												
						//Below if statement contains second half of card loop
						//Activates if player asks for a valid card type.	
						if(validcard == 1) {
							
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
								validcard = 0;
							
							} else if(Human.hand.contains(playercardrequest)) {
								
								System.out.println("You: Do you have any " + playerinput + "?");
								validcard = 0;
								
								//Below code checks if opponent has card that was asked for.
								if(!Computer.hand.contains(playercardrequest)) {
									
									//If the opponent doesn't have the card asked for, the player draws a card from the deck.
									System.out.println("CPU: No, go fish.");
									
									//If the deck is empty, the game ends
									//The below code ends the card loop and skips the computer's turn
									if(finalDeck.size() == 0) {
										System.out.println("The deck is empty. Game over!");
										cardloop = 1;
										gamestatus = 1;
										
									//Otherwise, the code checks which card is on the top of the deck and adds it to the player's hand.
									} else {										
										if(finalDeck.get(0).rank == "Ace") {
											System.out.println("You got an Ace.");
										} else if(finalDeck.get(0).rank == "Eight") {
											System.out.println("You got an Eight.");
										} else {
											System.out.println("You got a " + finalDeck.get(0).rank);
										}
									}
									if(finalDeck.size() > 0) {	
									
									Human.hand.add(finalDeck.get(0));
									finalDeck.remove(0);		
									
									}
									//Here the program checks to see if the player has any other cards of the drawn type
									//If they have four of a kind, those cards are removed from their hand and they get to go again.
									//The player also gets a book							
									
										//The nested for loops here systematically crawls through the player's hand and checks if the card at the given location
										//has more 4 or more of it's type in the player's hand.
										//If so, it looks at the remainder of the hand, finds those cards,
										//compares them to the initial card it checked the frequency of, and if they match, removes them
										//The program then goes back and removes the original card.
									
									int secondTurn = 0;
									for(int index = 0; index < Human.hand.size(); index++) {
										if(Collections.frequency(Human.hand, Human.hand.get(index)) >= 4) {
											Human.points++;
											System.out.println("You got a book!");
											System.out.println("You have " + Human.points + " books!");
											while(Human.hand.remove(playercardrequest)) {
												
											}
											secondTurn = 1;
										}
									}
									if(secondTurn != 1) {
										cardloop = 1;		
										
									} else {
										System.out.println("You get to go again!");
										secondTurn = 0;
									}
									
								} else {
									
									//The below code takes the requested cards from the opponent and gives them to the player.
									System.out.println("CPU: Yeah, I've got " + Collections.frequency(Computer.hand, playercardrequest) + " of them.");

									//The below code checks and displays the proper grammar for the type of cards recieved.
									if(playercardrequest.rank.equals("Six")) {
										if(Collections.frequency(Computer.hand, playercardrequest) > 1) {
											System.out.println("You got " + Collections.frequency(Computer.hand, playercardrequest) + " Sixes!");
										} else {
											System.out.println("You got a Six!");
										}
									} else {
										if(Collections.frequency(Computer.hand, playercardrequest) > 1) {
											System.out.println("You got " + Collections.frequency(Computer.hand, playercardrequest) + " " + playercardrequest + "s!");
										} else {
											System.out.println("You got a " + playercardrequest.rank + "!");
										}
									}
									
									
									//Below For loop checks the amount of requested cards that are in the Computer's hand, then adds that many to the player's hand
									for(int index = Collections.frequency(Computer.hand, playercardrequest); index > 0; index--) {
										Human.hand.add(playercardrequest);										
									}
									
									//The below For loop crawls through the Computer's hand and Systematically removes the requested cards.
									for(int index = 0; index < Computer.hand.size(); index++) {
										if(playercardrequest.rank.equals(Computer.hand.get(index).rank)) {
											while(Computer.hand.remove(playercardrequest)) {
												
											}
										}
									}
									
									//This code checks to see if the player obtained any books after receiving cards from the opponent.
									for(int index = 0; index < Human.hand.size(); index++) {
										if(Collections.frequency(Human.hand, Human.hand.get(index)) >= 4) {
											Card toRemove = new Card(Human.hand.get(index).rank);
											Human.points++;
											System.out.println("You got a book!");
											System.out.println("You have " + Human.points + " books!");
											while(Human.hand.remove(toRemove)) {
												
											}
										}
									}
									
									//Here the code checks if the player's hand is empty. If it isn't, they get to go again.
									//If the player's hand is empty, the cardloop is broken and the game ends.
									if(Human.hand.size() > 0) {
										System.out.println("You get to go again!");
									} else {
										System.out.println("You're out of cards. Game over!");
										cardloop = 1;
										gamestatus = 1;
									}
									
									
								}
								
								
							}
							
						}
							
					} // END PLAYER CARDLOOP
					
					//Below code is a modified version of the Player's turn to allow the Computer's turn to be automated
					// ### PLEASE REMEMBER TO WORK HERE ###
					if(gamestatus == 0) {
						
						System.out.println("CPU: Alright, it's my turn");
						
						for(int cardloop = 0; cardloop < 1; dummyvar = 0) {
							
							System.out.println("You have [" + Human.points + "] books. The Computer has [" + Computer.points + "] books.");
							Collections.shuffle(Computer.hand);
							
							if(Computer.hand.get(0).rank.equals("Six")) {
								System.out.println("CPU: Do you have any Sixes?");
							} else {
								System.out.println("CPU: Do you have any " + Computer.hand.get(0).rank + "s?");
							}
							
							
							//Below code checks if player's hand has the cards requested by the computer.
							//If so, the code checks how many cards the player has, and adds that many to the computer's hand
							//The code then removes that many cards from the player's hand.
							if(Human.hand.contains(Computer.hand.get(0))) {
								System.out.println("You: Yes, I have " + Collections.frequency(Human.hand, Computer.hand.get(0)) + " of them.");
								if(Computer.hand.get(0).rank.equals("Six")) {
									System.out.println("You gave the Computer your Sixes.");
								} else {
									System.out.println("You gave the Computer your " + Computer.hand.get(0) + "s.");
								}
								
								for(int index = Collections.frequency(Human.hand, Computer.hand.get(0)); index > 0; index--) {
									Computer.hand.add(Computer.hand.get(0));
									
								}
								
								for(int index = 0; index < Human.hand.size(); index++) {
									if(Computer.hand.get(0).rank.equals(Human.hand.get(index).rank)) {
										Card toRemove = new Card(Human.hand.get(index).rank);
										while(Human.hand.remove(toRemove)) {
											
										}
									}
								}
								Card computerRemove = new Card(Computer.hand.get(0).rank);						
								if(Collections.frequency(Computer.hand, computerRemove) >= 4) {
									
									Computer.points++;
									System.out.println("The computer got a book!");
									
									
									for(int index = 0; index < Computer.hand.size(); index++) {
										if(computerRemove.rank.equals(Computer.hand.get(index).rank)) {
											Card toRemove = new Card(Computer.hand.get(index).rank);
											while(Computer.hand.remove(toRemove)) {
												
											}
										}
									}
									
								}
								
								System.out.println("The Computer gets to go again!");
								
							} else {
								
								int secondturn = 0;
								System.out.println("You: No, go fish.");
								
								if(finalDeck.size() == 0) {
									System.out.println("The deck is empty. Game over!");
									cardloop = 1;
									gamestatus = 1;
								} else {
									System.out.println("The Computer drew a card.");
								
									Card computerRemove = new Card(Computer.hand.get(0).rank);
									Computer.hand.add(finalDeck.get(0));
									finalDeck.remove(0);
									
								
								
									if(Collections.frequency(Computer.hand, Computer.hand.get(0).rank) >= 4) {
									
										Computer.points++;
										secondturn = 1;
										System.out.println("The Computer got a book!");								
									
										for(int index = 0; index < Computer.hand.size(); index++) {
											if(computerRemove.rank.equals(Computer.hand.get(index).rank)) {
												Card toRemove = new Card(computerRemove.rank);
												while(Computer.hand.remove(toRemove)) {
													
												}
											}
										}
									//Computer.hand.remove(Computer.hand.size());
										
									}
									if(finalDeck.size() == 0) {
										System.out.println("The deck is empty. Game over!");
									}
								}
								if(Computer.hand.size() > 0) {
								
									if(secondturn != 1) {
										cardloop = 1;
									} else {
										System.out.println("The Computer gets to go again!");
									}
								} else {
									System.out.println("The Computer is out of cards. Game over!");
									cardloop = 1;
									gamestatus = 1;
								}
								
							}
							
							
						} //END OF COMPUTER CARDLOOP
						
					} //END OF COMPUTER GAMESTATUS CATCH
						
					//### MAIN GAME CODE GOES ABOVE ###
					
					
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
					
					//FINAL CHECK THAT DISPLAYS WINNER IF GAMESTATUS = 1
					if(gamestatus == 1) {
						System.out.println("Let's see who won!");
						System.out.println("You have [" + Human.points + "] books!");
						System.out.println("The Computer has [" + Computer.points + "] books!");
						if(Human.points > Computer.points) {
							System.out.println("You win!");
						} else if (Computer.points > Human.points) {
							System.out.println("The Computer wins!");
						} else {
							System.out.println("It's a draw!");
						}
					}
					
					
				} while(gamestatus == 0);
				
				//Code for determining winner goes here.
				
				//End game and terminate program
				introloop++;
				//return;
				
			}
			if(playerinput.equals("No")) {
				System.out.println("CPU: Okay. Goodbye.");
				introloop++;
				return;
			}
			if(!playerinput.equals("Yes")) {
				if(!playerinput.equals("No")) {
					if(gamestatus != 1) {
						System.out.println("CPU: I'm sorry, I didn't understand your answer.");
					} else {
						System.out.println("Thank you for playing!");
					}
				}
			}
		}
	
		//Close scanner
		playerscan.close();
	}

}
