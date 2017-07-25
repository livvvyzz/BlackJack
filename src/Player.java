
/**
 * An implementation of a blackjack player
 * 
 * @author olivia
 *
 */
public class Player{

	private String name;
	private Player other;
	
	private Card[] hand = new Card[10];

	private int numCards;
	
	private Game game;

	public Player(String name, Game game) {
		this.name = name;
		this.game = game;
		// init an empty hand
		this.emptyhand();
	}

	public void emptyhand() {

		for (int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;
	}

	/**
	 * Add a card to the players hand
	 * 
	 * @param c
	 *            the card to add
	 * @return whether the sum of the new hand is below or equal to 21
	 * @throws InvalidMoveException
	 */
	public boolean addCard(Card c) throws InvalidMoveException {

		// print error if we already have the max num of cards
		if (this.numCards == 10) {
			throw new InvalidMoveException(name + "already has 10 cards in hand");
		}

		// add new card in next slot and increment number of cards
		this.hand[this.numCards] = c;
		this.numCards++;
		game.updateScore(this);
		return (this.getHandSum() <= 21);
	}

	public int getHandSum() {

		int handSum = 0;
		int cardNum;
		int numAces = 0;

		// calc each card contribution to hand sum
		for (int c = 0; c < this.numCards; c++) {

			// get the rank of current card
			cardNum = this.hand[c].getRank();

			if (cardNum == 1) { // acce
				numAces++;
				handSum += 11;
			} else if (cardNum > 10) { // face card
				handSum += 10;
			} else {
				handSum += cardNum;
			}

		}

		// if we have aces and out sum is > 21, set some/all of them to the
		// value 1
		// instead of 11
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		return handSum;
	}

	/**
	 * print the cards in the players hand
	 * 
	 * @param showFirstCard
	 *            whether the first card is hidden or not
	 */
	public void printHand(boolean showFirstCard) {

		System.out.printf("%s's cards :\n", this.name);
		for (int c = 0; c < this.numCards; c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println("  [hidden]  ");
			} else {
				System.out.printf("  %s\n", this.hand[c].toString());
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public Player checkScore(){
		int sum = getHandSum();
		if(sum == 21){
			return this;
		}
		else if (sum > 21){
			return other;
		}
		return null;
	}
	
	public void setOther(Player p){
		this.other = p;
	}
	
	public Card getHoldCard() throws InvalidMoveException{
		if(getName().equals("dealer")){
			return hand[1];
		}
		else {
			throw new InvalidMoveException("Cannot get a hold card for player");
		}
	}
}
