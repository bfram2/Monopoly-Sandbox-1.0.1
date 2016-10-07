package menu;
//User Friendly summaried version of the User Manual

/*
depending on what move the player is on is which paragraph will appear as the main page,
can still sift through clicking on titles and expanding to the descriptions
*/

//The Main Menu for the game to start and to pick the players, type of game, citation, and help.
/* Trademark of Hasboro and Parker Brothers */

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import pieces.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

public class HelpMenu extends JFrame implements ActionListener {

	public HelpMenu() {
		setTitle("User Guide");
		setSize(609, 743); // window size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		setLayout(new BorderLayout());
		JPanel hpanel = new JPanel(new BorderLayout());
		add(hpanel);
		// hpanel.setOpaque(true);

		// style and location of text
		JLabel titl = new JLabel(
				"<html><div style=\"color: black; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 20px 0 5px 30px;\">" +
				"<u>S</u>tart New Game</div><br/>"+
						"<div style=\"padding-left: 20px;\">This is to start the game with the default settings that come with the game. One player against computer players.</div><br/>"+
				"<div style=\"color: black; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 20px 0 5px 30px;\"><u>S</u>ettings</div><br/>"+
						"<div style=\"padding-left: 20px;\">This is to change the game's default settings, including the amount of computer and human players.</div><br/>"+
				"<div style=\"color: black; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 20px 0 5px 30px;\"><u>B</u>asic Rules</div><br/>");
		// JLabel sect=new JLabel("<html><center><div style=\"color: black; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>S</u>ettings</div>");
		JButton backt = new JButton(
				"<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>B</u>ack</div>");
		backt.addActionListener(this);
		backt.setBackground(Color.BLACK);
		hpanel.add(titl, BorderLayout.NORTH);
		// hpanel.add(sect);
		hpanel.add(backt, BorderLayout.SOUTH);
		backt.setPreferredSize(new Dimension(40, 40));

		// refresh, DO NOT remove
		setSize(610, 744);
	}

	public void actionPerformed(ActionEvent e) {
		// close help menu
		dispose();
	}
}
