import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField playerScore;
	private JTextField dealerScore;

	private JButton dealButton;
	private JButton hitButton;
	private JButton standButton;

	// fields to keep track of what slots are in use
	private int playerSlotIndex;
	private int dealerSlotIndex;
	private JLabel[] pSlot;
	private JLabel[] dSlot;
	private JLabel endGame;
	private static GUI frame;
	private Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		playerSlotIndex = 0;
		dealerSlotIndex = 0;
		pSlot = new JLabel[10];
		dSlot = new JLabel[5];

		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		dealButton = new JButton("Deal");

		hitButton = new JButton("Hit");
		hitButton.setEnabled(false);

		standButton = new JButton("Stand");
		standButton.setEnabled(false);

		playerScore = new JTextField();
		playerScore.setText("Player: ");
		playerScore.setColumns(10);

		dealerScore = new JTextField();
		dealerScore.setText("Dealer:");
		dealerScore.setColumns(10);

		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(dealButton)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(hitButton)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(standButton)
										.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
										.addComponent(dealerScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(8).addComponent(playerScore, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(dealButton)
						.addComponent(hitButton).addComponent(standButton)
						.addComponent(dealerScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(playerScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(null);

		JLabel dSlot1 = new JLabel("");
		dSlot1.setBounds(10, 5, 46, 60);
		panel.add(dSlot1);
		dSlot[0] = dSlot1;

		JLabel dSlot2 = new JLabel("");
		dSlot2.setBounds(66, 5, 46, 60);
		panel.add(dSlot2);
		dSlot[1] = dSlot2;

		JLabel dSlot3 = new JLabel("");
		dSlot3.setBounds(122, 5, 46, 60);
		panel.add(dSlot3);
		dSlot[2] = dSlot3;

		JLabel dSlot4 = new JLabel("");
		dSlot4.setBounds(178, 5, 46, 60);
		panel.add(dSlot4);
		dSlot[3] = dSlot4;

		JLabel dSlot5 = new JLabel("");
		dSlot5.setBounds(234, 5, 46, 60);
		panel.add(dSlot5);
		dSlot[4] = dSlot5;

		JLabel pSlot1 = new JLabel("");
		pSlot1.setBounds(10, 143, 46, 60);
		panel.add(pSlot1);
		pSlot[0] = pSlot1;

		JLabel pSlot2 = new JLabel("");
		pSlot2.setBounds(66, 143, 46, 60);
		panel.add(pSlot2);
		pSlot[1] = pSlot2;

		JLabel pSlot3 = new JLabel("");
		pSlot3.setBounds(122, 143, 46, 60);
		panel.add(pSlot3);
		pSlot[2] = pSlot3;

		JLabel pSlot4 = new JLabel("");
		pSlot4.setBounds(178, 143, 46, 60);
		panel.add(pSlot4);
		pSlot[3] = pSlot4;

		JLabel pSlot5 = new JLabel("");
		pSlot5.setBounds(234, 143, 46, 60);
		panel.add(pSlot5);
		pSlot[4] = pSlot5;

		JLabel pSlot6 = new JLabel("");
		pSlot6.setBounds(290, 143, 46, 60);
		panel.add(pSlot6);
		pSlot[5] = pSlot6;

		JLabel pSlot7 = new JLabel("");
		pSlot7.setBounds(346, 143, 46, 60);
		panel.add(pSlot7);
		pSlot[6] = pSlot7;

		JLabel pSlot8 = new JLabel("");
		pSlot8.setBounds(402, 143, 46, 60);
		panel.add(pSlot8);
		pSlot[7] = pSlot8;

		JLabel pSlot9 = new JLabel("");
		pSlot9.setBounds(458, 143, 46, 60);
		panel.add(pSlot9);
		pSlot[8] = pSlot9;

		JLabel pSlot10 = new JLabel("");
		pSlot10.setBounds(514, 143, 46, 60);
		panel.add(pSlot10);
		pSlot[9] = pSlot10;

		this.endGame = new JLabel("");
		endGame.setVisible(false);
		endGame.setForeground(Color.GRAY);
		endGame.setBounds(0, 0, 586, 253);
		panel.add(endGame);

		contentPane.setLayout(gl_contentPane);

		dealButton.addActionListener(new ActionListener()

		{

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == dealButton) {
					try {
						game = new Game(frame);
					} catch (InvalidMoveException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					dealEnabled(false);
				}
			}
		});

		hitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == hitButton) {

					try {
						game.hit(game.getPlayer());
					} catch (InvalidMoveException e1) {
						e1.printStackTrace();
					}

				}
			}

		});

		standButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == standButton) {

					try {
						game.stand();
					} catch (InvalidMoveException e1) {
						e1.printStackTrace();
					}

				}
			}

		});
	}

	public void setCard(Player p, Card c) throws InvalidMoveException {

		if (p.getName().equals("player")) {
			// update text to show card
			
			//pSlot[playerSlotIndex].setText(c.toString().substring(0, 7));
			ImageIcon imageIcon = c.getImg();
			pSlot[playerSlotIndex].setIcon(imageIcon);
			// increment player slot
			if (playerSlotIndex < pSlot.length) {
				playerSlotIndex++;
			}
		} else if (p.getName().equals("dealer")) {
			// update text to show card
			ImageIcon imageIcon = c.getImg();
			dSlot[dealerSlotIndex].setIcon(imageIcon);
			// increment player slot
			if (dealerSlotIndex < dSlot.length) {
				dealerSlotIndex++;
			}
		}
	}

	public void hitEnabled(boolean b) {
		hitButton.setEnabled(b);
	}

	public void dealEnabled(boolean b) {
		dealButton.setEnabled(b);
	}

	public void standEnabled(boolean b) {
		standButton.setEnabled(b);
	}

	public void enableButtons(boolean b) {
		hitEnabled(b);
		standEnabled(b);
	}

	public void endOfGame(Player player) {

		// enable end game screen
		endGame.setVisible(true);
		if (player != null) {
			endGame.setText(player.getName() + " has won");
		}
		else {
			endGame.setText("tie");
		}
		endGame.setHorizontalAlignment(SwingConstants.CENTER);
		endGame.setVerticalAlignment(SwingConstants.CENTER);
		setFont(endGame);
	}

	public void setFont(JLabel label) {
		Font labelFont = label.getFont();
		String labelText = label.getText();

		int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = label.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double) componentWidth / (double) stringWidth;

		int newFontSize = (int) (labelFont.getSize() * widthRatio);
		int componentHeight = label.getHeight();

		// Pick a new font size so it will not be larger than the height of
		// label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
	}

	public void updateScore(Player p, int sum) {
		if (p.getName().equals("player"))
			playerScore.setText("Player: " + sum);
		else if (p.getName().equals("dealer"))
			dealerScore.setText("Dealer : " + sum);
	}
}
