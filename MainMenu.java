//The Main Menu for the game to start and to pick the players, type of game, citation, and help.
//This is the main file
/* Trademark of Hasboro and Parker Brothers */

//guide to implement folders into master
//import pieces.*;
//import menu.*;
//import events.*;
//import cards.*;

import pieces.Board; //activate board
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;


class MainMenu extends JFrame implements ActionListener {
JButton game, set, help, bear;

	public MainMenu() {
	setTitle("Monopoly");
	setSize(743,743); //window size
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	//debugging size by content
	//pack();
	setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("src/menu/menuman.jpg"));
	add(background);
	background.setLayout(new FlowLayout());
	//background.setOpaque(true);
	
	//style and location of buttons
	game=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>S</u>tart New Game</div>");
	set=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>S</u>ettings</div>");
	help=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>H</u>elp</div>");
	bear=new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px;\"><u>E</u>xit</div>");
	game.setBackground(new Color(73,175,47));
	//game.setVerticalAlignment(AbstractButton.CENTER);
	set.setBackground(new Color (128,0,0));
	help.setBackground(Color.BLACK);
	bear.setBackground(new Color(244,31,31));
	
	//add listeners
	game.addActionListener(this);
	set.addActionListener(this);
	help.addActionListener(this);
	bear.addActionListener(this);
	
	//add button to jpanel
	background.add(game);
	background.add(set);
	background.add(help);
	background.add(bear);

	// refresh, DO NOT remove
	//setSize(744,744); redundancy
	setSize(744,744);
	
	//debugging button locations
	//System.out.println("getLocation: " + game.getLocation());
	}
	
	public void actionPerformed(ActionEvent e)
    {
		if(e.getSource() == game) {
			//start game button
			//activate Board.java, close menu
			dispose();
			new Board();
		}
		else if(e.getSource() == set) {
			//settings for coding set 2
			System.out.println("Monopoly is Awesome, settings!");
		}
		else if(e.getSource() == help) {
			//settings for user guide
			System.out.println("Monopoly is Awesome, help!");
		}
		else if(e.getSource() == bear) {
			//close the program.. exit bear, stage left
			dispose();
            System.exit(0);
		}
		
        //applies to all buttons for debugging
    }
	//main for Monopoly
	public static void main(String args[]) {
		new MainMenu(); //open menu page
		
		}
}
