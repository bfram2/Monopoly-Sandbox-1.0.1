//The Main Menu for the game to start and to pick the players, type of game, citation, and help.

//The Main Menu for the game to start and to pick the players, type of game, citation, and help.
/* Trademark of Hasboro and Parker Brothers */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

class MainMenu extends JFrame {
JButton game;
JButton set;
JButton help;
JButton bear;
	public MainMenu() {
	setTitle("Monopoly");
	setSize(744,744);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("src/menu/menuman.jpg"));
	add(background);
	background.setLayout(new FlowLayout());
	game=new JButton(" Start New Game ");
	set=new JButton(" Settings ");
	help=new JButton(" Help ");
	bear=new JButton(" Exit ");
	game.setForeground(Color.WHITE);
	game.setBackground(new Color(73,175,47));
	set.setForeground(Color.BLACK);
	set.setBackground(Color.WHITE);
	help.setForeground(Color.BLACK);
	help.setBackground(Color.WHITE);
	bear.setForeground(Color.WHITE);
	bear.setBackground(new Color(244,31,31));
	background.add(game);
	background.add(set);
	background.add(help);
	background.add(bear);

	// refreshes page
	setSize(744,744);
	setSize(743,743);
	}
	public static void main(String args[]) {
		new MainMenu();
		}
}
