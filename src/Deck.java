import java.io.IOException;
import java.util.Random;

public class Deck {

	private Card[] myCards;
	private int numCards;
	private Game game;
	
	public Deck(int numDecks, boolean shuffle, Game game) throws InvalidMoveException, IOException{
		
		this.game = game;
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		//card index
		int c = 0;
		//for each deck
		for(int d = 0; d < numDecks; d++){
			
			//for each suit
			for(int s = 0; s < 4; s++){
				
				//for each num
				for(int n = 1; n <= 13; n++){
					
					//add a new card to deck
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
		}
		//shuffle if neccessary
		if(shuffle){
			this.shuffle();
		}
		
	}

	/**
	 * shuffle deck by randomly swapping pairs of cards
	 */
	public void shuffle(){
		
		//init random number generator
		Random ran = new Random();
		//temporary card
		Card temp;
		
		int j;
		for(int i = 0; i < this.numCards; i++){
			
			//get a random card to swap i's value with
			j = ran.nextInt(this.numCards);
			
			//do swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
	}
	
	public Card dealNextCard() throws InvalidMoveException, IOException{

		
		//get the top card
		Card top = this.myCards[0];
		
		//shift all the subsequent cards to the left by one index
		for(int c = 1; c<this.numCards; c++){
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;
		//decrement num of cards in deck
		this.numCards--;
		
		if(numCards <= 0){
			game.newDeck();
		}
		
		return top;
	}

	/**
	 * print the top cards in the deck
	 * @param numToPrint	the number of cards from the top of the deck to print
	 */
	public void printDeck(int numToPrint){
		
		for(int c = 0; c < numToPrint; c++){
			System.out.printf("% 3d/%d %s\n", c + 1, this.numCards, this.myCards[c].toString());
		}
		System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);
		
	}

}
