
public class BestMove {

	private Game game;
	private Deck deck;
	
	private int count;
	private int index;
		
	public BestMove(Game g){
		this.game = g;
		this.deck = game.getDeck();
	}
	
	public void newPack(Deck d){
		this.deck = d;
		initialiseDeck();
	}
	
	public void initialiseDeck(){
		count = 0;
		index = 0;
	}
	
	public void updateCount(Card cardPlayed){
		
		index++;
		if(cardPlayed.getRank() >= 2 && cardPlayed.getRank() <= 6){
			count++;
		}
		else if (cardPlayed.getRank() == 0 || cardPlayed.getRank() >= 9 && cardPlayed.getRank() <= 13){
			count--;
		}
	}
}

