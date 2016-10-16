package pieces;
//Loading the Background image of the board

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menu.HelpMenu;


public class Board extends JFrame implements ActionListener {
	JButton rolling;
	//board spaces
	Random dice = new Random();
	int chPos = 0; //cards for build 2
	int ccPos = 0;
	int tdPos = 0;
	int Pos = 0; //board positions
	int j = 0; //jail counter
	public Board() {
	setTitle("Board");
	
	getContentPane();
	setLocationRelativeTo(null);
	//debugging size by content
	pack();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setSize(1013,1036);
	setLayout(new BorderLayout());
	JPanel front = new JPanel(new GridLayout(0, 2));
	//JPanel glassPanel = new JPanel(new GridBagLayout());
	front.setOpaque(false);
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	add(background);
	
	background.setSize(1000,1000);
	background.setLayout(new FlowLayout());
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 50px 5px 50px;\"><u>R</u>oll</div>");
	rolling.setBackground(new Color(73,175,47));
	
	JLabel blank = new JLabel("<html><div style=\"color: white; padding: 250px 0 0 0;text-align:right;\"></div><br/>");
	JLabel paction = new JLabel("<html><div style=\"color: white; padding: 250px 0 0 0;text-align:right;\"></div><br/>");
	
	
	rolling.addActionListener(this);
	background.add(front);
	background.add(rolling);
	front.add(blank);
	front.add(paction);
	
	
	
	//rolling.setVerticalTextPosition(AbstractButton.CENTER);
	//rolling.setHorizontalTextPosition(AbstractButton.RIGHT);
	
	//debugging, finding x,y positions on the board for every click
    /*background.addMouseListener(new MouseAdapter() {

	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
		}
	});*/
	
	// refresh to add JLabel/JPanel
	setSize(1013,1037);
	//background.add(rolling);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rolling) {
			//start game button
			//activate Board.java, close menu
			
			Turn();
		}
    }


		public void Turn() {
			int samples = 1; //one turn per button, player one 
			//int k = 0; //doubles counter
		    //int doubles = 0;
			for (int i = 0; i < samples; i++) {
			//loop until end of max turns  
			//array for spaces on the board
			int[] board = new int[40];
			int[] jail = new int[5];
			
			
			int dice1 = dice.nextInt(6) + 1;
	        int dice2 = dice.nextInt(6) + 1;
	      //remainder operator
	        Pos = (Pos + dice1 + dice2) % 40;
	        j = j % 4;
	        //for build 2
	       /* doubles = (dice1 == dice2) ? doubles + 1 : 0;
	        if (doubles > 2 && doubles < 1) {
	        	//go to the arena
	        	Pos = 11;
	        	doubles=0;
	        	k++;
	        	//roll doubles within 3 turns
	        }
	        else {
	        	//move dice1 + dice2 positions
	        }*/
	        
	        //checking the spaces token as moved to
	        if (j == 0) {
	        	
	      if (Pos == 0) {
	    	  System.out.println("Pass Rome, Collect 200.");
	      }
	      if (Pos == 7 || Pos == 22 || Pos == 36) {
	    	  System.out.println("Randomly draw a chance card.");
	    	  //chance is build 2
	      }
	      if (Pos == 2 || Pos == 17 || Pos == 33) {
	    	  System.out.println("Randomly draw a community chest card.");
	    	  //community chest is build 2
	      }
	      if (Pos == 10) {
	    	  Pos = 11;
	    	  System.out.println("Rolled a 10. ");
	      }
	      if (Pos == 11 && j == 0) {
	    	  //see a battle
	    	  System.out.println("See a battle.");
	      }
	      if (Pos == 30) {
	    	  System.out.println("Go to the Arena.");
	    	  Pos = 11;
	    	  j = 1;
	    	  //System.out.println("You are still in jail. Turns until free: "+(4-j));
	      }
	        }
	      if(j > 0 && j < 4) {
	    	Pos = 11;
		    System.out.println("You are still in jail. Turns until free: "+(4-j));
		    //stay in jail for three turns or j=3
		    j++;
	      }
	      if (j > 3) {
	    	  System.out.println("Pay 50.");
	      }
	      board[Pos]++;
	      jail[j]++;
	      System.out.println("Dice 1: "+dice1+", Dice 2: "+dice2);
	      System.out.println("Move to position: "+Pos);
	      System.out.println("Jail Counter: "+j);
		}
	}
}

/*
Will change later. Initial pull.
-1: 979, 881 (x,y) starting point on go
0: 932, 881  Go
1: 828, 881  Germania Inferior
2: 750, 881  Community Chest
3: 666, 881  Germania Superior
4: 586, 881  Render unto Caesar
5: 503, 881  Via Appia
6: 419, 881  Alpes Poeniae
7: 341, 881  Chance
8: 254, 881  Alpes Cottiae
9: 170, 881  Alpes Maritimae
10: 22, 975  see a battle
11: 108, 881 jail
12: 112, 828 Aquitania
13: 112, 746 Sewers
14: 112, 661 Belgice
15: 112, 484 Raetia
16: 112, 401 Via Flaminia
17: 112, 316 Africa Proconsularis
18: 112, 238 Community Chest
19: 112, 151 Asia
20: 112, 74  Britannia
21: 70, 70   free market
22: 174, 120 Cilicia
23: 259, 120 Chance
24: 339, 120 Galatia
25: 422, 120 Cappadocia
26: 505, 120 Via Aemilia
27: 585, 120 Aegyptus
28: 664, 120 Arabia Petraea
29: 749, 120 Aqueducts
30: 830, 120 Syria
31: 927, 70  go to jail
32: 895, 173 Macedonia
33: 895, 257 Epirus
34: 895, 338 Community Chest
35: 895, 419 Achaia
36: 895, 504 Via Popillia
37: 895, 583 Chance
38: 895, 664 Sicilia
39: 895, 753 Citizen's Tax
40: 895, 828 Italia
 */
