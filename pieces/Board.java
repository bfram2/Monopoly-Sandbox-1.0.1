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
import pieces.Dice;
import events.Players;

public class Board extends JFrame implements ActionListener {
	JButton rolling, buying, mortgage, ending, mmenu, hmenu;
	int width = 1013;
	int height = 1037;
	//board spaces
	int chPos = 0; //cards for build 2
	int ccPos = 0;
	int tdPos = 0;
	int titledeed = 0; //buy picks
	int[] tdeed = new int[27];
	int buymort = 0; //counter for buy or mortgage
	int Pos = 0; //board positions
	int Prev = 0;
	int k = 0; //doubles counter
	int j = 0; //jail counter
	Random dice = new Random();
	int dice1 = 1; //the dice
	int dice2 = 1;
	
	
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
	front.setOpaque(false);
	front.setPreferredSize(new Dimension(50, 400));
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	add(background);
	
	background.setSize(1000,1000);
	//background.setLayout(new BorderLayout());
	background.setLayout(null);
	
	//if not applicable grey out buttons, remember to add
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>R</u>oll Dice</div>");
	buying = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>B</u>uy Property</div>");
	mortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>M</u>ortgage</div>");
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 5px 5px 5px;\"><u>E</u>nd Turn</div>");
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 5px 5px 5px;\"><u>H</u>elp Menu</div>");
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 0px 5px 0px 5px;\"><u>E</u>nd Game<br/><span style=\"font-size: 9pt\">Return to Main Menu</span></div>");
	JLabel blank = new JLabel("<html><br/><div style=\"color: white; border: none; padding: 0; width: 110px; height: 50px; text-align:center;\"></div><br/>");
	//JLabel paction = new JLabel("<html><br/><div style=\"color: black; border: none; padding: 0; width: 100px; text-align:center;\"></div><br/>");
		rolling.setBackground(new Color(73,175,47));
		buying.setBackground(new Color(71,71,255));
		mortgage.setBackground(new Color(247, 153, 22));
		ending.setBackground(new Color(0, 0, 0));
		hmenu.setBackground(new Color(0, 0, 0));
		mmenu.setBackground(new Color(0, 0, 0));
	
	//dice animation
	JLabel die1=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice1+".png"));
	JLabel die2=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
	add(die1);
	add(die2);

	rolling.addActionListener(this);
	buying.addActionListener(this);
	mortgage.addActionListener(this);
	ending.addActionListener(this);
	mmenu.addActionListener(this);
	hmenu.addActionListener(this);
	
	background.add(front, BorderLayout.SOUTH);
	front.setBounds(240, 540, 550, 400);
	//front.add(blank);
	front.add(rolling);
	front.add(buying);
	front.add(mortgage);
	front.add(ending);
	front.add(hmenu);
	front.add(mmenu);
	front.add(blank);
	front.add(die1);
	front.add(die2);

	
	//debugging, finding x,y positions on the board for every click
	/*
    background.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
		}
	}); */
	
	rolling.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    front.revalidate();
	    //die2.setIcon(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
	    }
	});
	
	// refresh image
	setSize(1013,1037);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rolling) {
			//start game button
			//activate Board.java, close menu
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(false);
			Turn();
			//front.revalidate();
		}
		if(e.getSource() == buying) {
			//start game button
			//activate Board.java, close menu
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(true);
			buymort = 0;
			Buy();
		}
		if(e.getSource() == mortgage) {
			//start game button
			//activate Board.java, close menu
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(true);
			buymort = 1;
			Buy();
		}
		if(e.getSource() == hmenu) {
			new HelpMenu();
		}
		if(e.getSource()== mmenu){
			dispose();
			new MainMenu();
		}
		if(e.getSource()== ending){
			//here it goes again
			rolling.setEnabled(true);
		}
    }

		public void Turn() {
			int samples = 1; //one turn per button, player one only right now
		    //int doubles = 0;
			for (int i = 0; i < samples; i++) {
			//loop until end of max turns  
			//array for spaces on the board
			int[] board = new int[40];
			int[] jail = new int[5];
			int[] doubles = new int[4];
			
			dice1 = dice.nextInt(6) + 1;
	        dice2 = dice.nextInt(6) + 1;
	        
	      //remainder operators
	       System.out.println("Previous Position: "+Prev);
	        Pos = (Prev + dice1 + dice2) % 40;
	        Prev = Pos;
	        //System.out.println("Previous Position: "+Prev); //debugging
	        j = j % 4;
	        //for build 2
	       k = (dice1 == dice2) ? k + 1 : 0;
	       if (k == 1) {
	    	   System.out.println("Doubles! Roll again.");
	    	   rolling.setEnabled(true);
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
	    	  if (Pos == 1) {
	    		  System.out.println("Buy/Mortgage: Germania Inferior");
	    		  buying.setEnabled(true);
	    		  mortgage.setEnabled(true);
	    		  titledeed = 0;
	    	  }
	    	  if (Pos == 3) {
	    		  System.out.println("Buy/Mortgage: Germania Superior");
	    		  buying.setEnabled(true);
	    		  mortgage.setEnabled(true);
	    		  titledeed = 1;
	    	  }
	    	  if (Pos == 6) {
	    		  System.out.println("Buy/Mortgage: Belgica");
	    		  buying.setEnabled(true);
	    		  mortgage.setEnabled(true);
	    		  titledeed = 6;
	    	  }
	    	  if (Pos == 4 || Pos == 39) {
	    		  System.out.println("Taxes");
	    		  //pay
	    	  }
	    	  if (Pos == 5 || Pos == 16 || Pos == 26 || Pos == 36) {
	    		//Via (Roads)
	    		  System.out.println("Buy/Mortgage: Via (Road)");
	    		  buying.setEnabled(true);
	    		  mortgage.setEnabled(true);
	    		  titledeed = 24;
	    	  }
	    	  if (Pos == 7 || Pos == 22 || Pos == 36) {
	    		  System.out.println("Randomly draw a chance card.");
	    		  //chance is build 2
	    		  ending.setEnabled(true);
	    	  }
	    	  if (Pos == 2 || Pos == 17 || Pos == 33) {
	    		  System.out.println("Randomly draw a community chest card.");
	    		  //community chest is build 2
	    		  ending.setEnabled(true);
	    	  }
	    	  if (Pos == 10) {
	    		  Pos = 11;
	    		  System.out.println("Rolled a 10. ");
	    	  }
	    	  if (Pos == 11 && j == 0) {
	    		  //see a battle
	    		  System.out.println("See a battle.");
	    		  ending.setEnabled(true);
	    	  }
	    	  if (Pos == 30) {
	    		  System.out.println("Go to the Arena.");
	    		  Pos = 11;
	    		  j = 1;
	    	  }
	        }
	      if(j > 0 && j < 4) {
	    	Pos = 11;
		    System.out.println("You are still in jail. Turns until free: "+(4-j)); //stay in jail for three turns or j=3
		    j++;
		    ending.setEnabled(true);
	      }
	      if (j > 3) {
	    	  System.out.println("Pay 50.");
	    	  ending.setEnabled(true);
	      }
	      board[Pos]++;
	      jail[j]++;
	      doubles[k]++;
	      tdeed[titledeed]++;
	      //ending.setEnabled(true);
	      System.out.println("-Dice 1: "+dice1+", Dice 2: "+dice2);
	      System.out.println("-Move to position: "+Pos);
	      System.out.println("-Jail Counter: "+j);
	      System.out.println("-Doubles counter: "+k);
		}
	}
		public void Buy() {
			int tdbuy = 0;
			int tdmort = 0;
			if (titledeed == 0 || titledeed == 1) {tdbuy = 60;}
			if (titledeed == 2 || titledeed == 3) {tdbuy = 100;}
			if (titledeed == 4) {tdbuy = 120;}
			if (titledeed == 5 || titledeed == 6) {tdbuy = 140;}
			if (titledeed == 7) {tdbuy = 160;}
			if (titledeed == 8 || titledeed == 9) {tdbuy = 180;}
			if (titledeed == 10) {tdbuy = 200;}
			if (titledeed == 11 || titledeed == 12) {tdbuy = 220;}
			if (titledeed == 13) {tdbuy = 240;}
			if (titledeed == 14 || titledeed == 15) {tdbuy = 260;}
			if (titledeed == 16) {tdbuy = 280;}
			if (titledeed == 17 || titledeed == 18) {tdbuy = 300;}
			if (titledeed == 19) {tdbuy = 320;}
			if (titledeed == 20) {tdbuy = 350;}
			if (titledeed == 21) {tdbuy = 400;}
			if (titledeed == 22 || titledeed == 23) {tdbuy = 150;}
			if (titledeed > 23) {tdbuy = 200;}
			//set mortgage
			if (tdbuy != 0 && buymort == 1) {
				tdmort = (tdbuy/2);
				System.out.println("-Place: "+titledeed+", Mortgage: "+tdmort);
				}
			if(buymort == 0) {
				System.out.println("-Place: "+titledeed+", Pay: "+tdbuy);
			}
			//tdmort or tdbuy minus players money total
		}
}



/*
Token positions
x: 951, y: 929
x: 818, y: 875
x: 740, y: 876
x: 662, y: 876
x: 581, y: 880
x: 498, y: 880
x: 413, y: 878
x: 336, y: 880
x: 253, y: 880
x: 180, y: 879
x: 35, y: 970
x: 125, y: 845
x: 126, y: 770
x: 130, y: 690
x: 126, y: 605
x: 127, y: 526
x: 126, y: 447
x: 125, y: 370
x: 125, y: 287
x: 126, y: 207
x: 86, y: 93
x: 181, y: 129
x: 263, y: 126
x: 343, y: 124
x: 421, y: 124
x: 501, y: 125
x: 581, y: 125
x: 662, y: 126
x: 741, y: 127
x: 820, y: 128
x: 928, y: 77
x: 870, y: 208
x: 872, y: 285
x: 872, y: 362
x: 868, y: 448
x: 873, y: 527
x: 870, y: 608
x: 869, y: 687
x: 875, y: 766
x: 874, y: 848

board array
0: Go
1: Germania Inferior
2: Community Chest
3: Germania Superior
4: Render unto Caesar
5: Via Appia
6: Alpes Poeniae
7: Chance
8: Alpes Cottiae
9: Alpes Maritimae
10: See a battle
11: Arena
12: Aquitania
13: Sewers
14: Belgice
15: Raetia
16: Via Flaminia
17: Africa Proconsularis
18: Community Chest
19: Asia
20: Britannia
21: Free Market
22: Cilicia
23: Chance
24: Galatia
25: Cappadocia
26: Via Aemilia
27: Aegyptus
28: Arabia Petraea
29: Aqueducts
30: Syria
31: Go to the Arena
32: Macedonia
33: Epirus
34: Community Chest
35: Achaia
36: Via Popillia
37: Chance
38: Sicilia
39: Citizen's Tax
40: Italia

/* Buy array
0:  Mediterranean Avenue = Germania Inferior ($60, $30 mortgaged)
1:	Baltic Avenue = Germania Superior ($60, $30 mortgaged)
2:	Oriental Avenue = Alpes Poeniae ($100, $50 mortgaged)
3:	Vermont Avenue = Alpes Cottiae ($100, $50 mortgaged)
4:	Connecticut Avenue = Aples Maritimae ($120, $60 mortgaged)
5:	St. Charles Place = Aquitania ($140, $70 mortgaged)
6:	States Avenue = Belgica ($140, $70 mortgaged)
7:	Virginia Avenue = Raetia ($160, $80 mortgaged)
8:	St. James Place = Africa Proconsularis ($180, $90 mortgaged)
9:	Tennessee Avenue = Asia ($180, $90 mortgaged)
10:	New York Avenue = Britannia ($200, $100 mortgaged)
11:	Kentucky Avenue = Cilicia ($220, $110 mortgaged)
12:	Indiana Avenue = Galatia ($220, $110 mortgaged)
13:	Illinois Avenue = Cappadocia ($240, $120 mortgaged)
14:	Atlantic Avenue = Aegyptus ($260, $130 mortgaged)
15:	Ventnor Avenue = Arabia Petraea ($260, $130 mortgaged)
16:	Marvin Gardens = Syria ($280, $140 mortgaged)
17:	Pacific Avenue = Macedonia ($300, $150 mortgaged)
18:	North Carolina Avenue = Epirus ($300, $150 mortgaged)
19:	Pennsylvania Avenue = Achaia ($320, $160 mortgaged)
20:	Park Place = Sicilia ($350, $175 mortgaged)
21:	Boardwalk = Italia ($400, $200 mortgaged)
22: Sewers $150 buy, $75 mortgaged
23: Aqueducts
24: Via Appia $200 buy, $100 mortgaged
25: Via Flaminia
26: Via Aemilia
27: Via Popillia
*/
