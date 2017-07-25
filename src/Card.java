import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Card {

	private Suit mySuit;
	private int myRank;
	private ImageIcon img;

	public Card(Suit s, int r) throws InvalidMoveException, IOException {
		this.mySuit = s;

		// ensure number is valid
		if (r >= 1 && r <= 13)
			this.myRank = r;
		else {
			throw new InvalidMoveException("rank out of bounds");
		}
		
		img = new ImageIcon("src/cards/" + myRank + "_of_" + mySuit + ".png");
		img = scaleImg(img);
	}

	public Suit getSuit() {
		return this.mySuit;
	}

	public int getRank() {
		return this.myRank;
	}
	
	public ImageIcon getImg(){
		return img;
	}

	public String toString() {
		String number = Integer.toString(myRank);
		return number + " of " + mySuit.toString();
	}
	
	public ImageIcon scaleImg(ImageIcon img){
		ImageIcon imageIcon = img; // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(46, 60,  java.awt.Image.SCALE_FAST); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		return imageIcon;
	}
}
