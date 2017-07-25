import java.io.IOException;

public class Game {

	private Deck deck;
	private Player player;
	private Player dealer;
	private GUI gui;

	public Game(GUI gui) throws InvalidMoveException, IOException {
		this.gui = gui;
		this.deck = new Deck(1, true);
		player = new Player("player", this);
		dealer = new Player("dealer", this);
		player.setOther(dealer);
		dealer.setOther(player);
		initialDeal();
		this.gui.enableButtons(true);

	}

	public void initialDeal() throws InvalidMoveException {

		// deal players first 2 cards
		dealCard(player, deck.dealNextCard());
		dealCard(player, deck.dealNextCard());

		// deals dealers first 2 cards
		dealCard(dealer, deck.dealNextCard());
		holdCard(dealer, deck.dealNextCard());

		// check if dealer of player have won
		checkIfWon();

	}

	public void checkIfWon() throws InvalidMoveException {
		Player temp = player.checkScore();
		if (temp != null) {		
			gui.setCard(dealer, dealer.getHoldCard());
		
			if (temp.equals(player))
				gui.endOfGame(player);
			else if (temp.equals(dealer))
				gui.endOfGame(dealer);
		}
		// dealer
		temp = dealer.checkScore();
		if (temp != null) {		
			gui.setCard(dealer, dealer.getHoldCard());

			if (temp.equals(dealer))
				gui.endOfGame(dealer);
			else if (temp.equals(player))
				gui.endOfGame(player);
		}
	}

	

	public void dealCard(Player p, Card c) throws InvalidMoveException {
		gui.setCard(p, c);
		p.addCard(c);
	}

	public void holdCard(Player p, Card c) throws InvalidMoveException {
		p.addCard(c);
	}

	public void hit(Player p) throws InvalidMoveException {
		Card c = deck.dealNextCard();
		dealCard(p, c);
		checkIfWon();
		this.gui.enableButtons(true);
	}

	public void stand() throws InvalidMoveException {
		this.gui.enableButtons(false);
		endOfGame();
	}

	public void endOfGame() throws InvalidMoveException {
		gui.setCard(dealer, dealer.getHoldCard());

		// check if dealer hand is <= 16
		if (dealer.getHandSum() <= 16) {
			Card c = deck.dealNextCard();
			dealCard(dealer, c);
			this.gui.enableButtons(false);
		}

		getWinningPlayer();
	}

	public Player getPlayer() {
		return player;
	}

	public void getWinningPlayer() {
		int dealerScore = dealer.getHandSum();
		int playerScore = player.getHandSum();

		if (dealerScore < playerScore)
			gui.endOfGame(player);
		else if (dealerScore > playerScore)
			gui.endOfGame(dealer);
		else if (dealerScore == playerScore)
			gui.endOfGame(null);

	}

	public GUI getGUI() {
		return this.gui;
	}
	
	public void updateScore(Player p){
		gui.updateScore(p, p.getHandSum());
	}

}
