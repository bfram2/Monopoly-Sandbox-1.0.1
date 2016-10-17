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
import menu.MainMenu;


public class Board extends JFrame implements ActionListener {
	JButton rolling, buying, ending, mmenu, hmenu;
	int width = 1013;
	int height = 1037;
	//board spaces
	Random dice = new Random();
	int chPos = 0; //cards for build 2
	int ccPos = 0;
	int tdPos = 0;
	int Pos = 0; //board positions
	int k = 0; //doubles counter
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
	JPanel front = new JPanel();
	//JPanel front = new JPanel(new GridLayout());
	front.setOpaque(false);
	//front.setSize(new Dimension(500, 500));
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	add(background);
	
	background.setSize(1000,1000);
	background.setLayout(new GridLayout());
	
	//if not applicable grey out buttons, remember to add
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; border: none; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>R</u>oll Dice</div>");
	rolling.setBackground(new Color(73,175,47));
	
	buying = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>B</u>uy Property</div>");
	buying.setBackground(new Color(217, 217, 217));
	
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 5px 5px 5px;\"><u>E</u>nd Turn</div>");
	ending.setBackground(new Color(0, 0, 0));
	
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 5px 5px 5px;\"><u>H</u>elp Menu</div>");
	hmenu.setBackground(new Color(0, 0, 0));
	
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 0px 5px 0px 5px;\"><u>E</u>nd Game<br/><span style=\"font-size: 9pt\">Return to Main Menu</span></div>");
	mmenu.setBackground(new Color(0, 0, 0));
	
	JLabel blank = new JLabel("<html><div style=\"color: white; padding: 250px 0 0 0; text-align:center;\"></div><br/>");
	//JLabel paction = new JLabel("<html><br/><div style=\"color: black; border: 1px solid black; padding: 10px 50px 10px 150px; text-align:center;\">Paction</div><br/>");
	
	rolling.addActionListener(this);
	buying.addActionListener(this);
	ending.addActionListener(this);
	mmenu.addActionListener(this);
	hmenu.addActionListener(this);
	
	background.add(front, BorderLayout.SOUTH);
	front.add(blank);
	front.add(rolling);
	front.add(buying);
	front.add(ending);
	//front.add(paction);
	front.add(hmenu);
	front.add(mmenu);

	//front.add(blank);
	//front.add(paction);
	
	//debugging, finding x,y positions on the board for every click
    /*background.addMouseListener(new MouseAdapter() {

	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
		}
	});*/
	
	// refresh image
	setSize(1013,1037);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rolling) {
			//start game button
			//activate Board.java, close menu
			Turn();
		}
		if(e.getSource() == hmenu) {
			new HelpMenu();
		}
		if(e.getSource()== mmenu){
			dispose();
			new MainMenu();
		}
    }


		public void Turn() {
			int samples = 1; //one turn per button, player one 
		    //int doubles = 0;
			for (int i = 0; i < samples; i++) {
			//loop until end of max turns  
			//array for spaces on the board
			int[] board = new int[40];
			int[] jail = new int[5];
			int[] doubles = new int[4];
			
			int dice1 = dice.nextInt(6) + 1;
	        int dice2 = dice.nextInt(6) + 1;
	      //remainder operators
	        Pos = (Pos + dice1 + dice2) % 40;
	        j = j % 4;
	        //for build 2
	       k = (dice1 == dice2) ? k + 1 : 0;
	       if (k == 1) {
	    	   System.out.println("Doubles! Roll again.");
	       }
	        if (k > 2 && k < 1) {
	        	System.out.println("You have rolled doubles 3 times, Go to the Arena.");
	        	//go to the arena
	        	Pos = 11;
	        	k=0;
	        	//roll doubles within 3 turns
	        }
	        
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
	      doubles[k]++;
	      System.out.println("-Dice 1: "+dice1+", Dice 2: "+dice2);
	      System.out.println("-Move to position: "+Pos);
	      System.out.println("-Jail Counter: "+j);
	      System.out.println("-Doubles counter: "+k);
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
