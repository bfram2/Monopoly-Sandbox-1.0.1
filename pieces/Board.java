package pieces;
//Loading the board [fonts for board.jpg: Verdana 8pt, 6pt, 8pt bold]
import javax.swing.*;
import java.awt.*;
//debugging tokens
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import menu.HelpMenu;
import menu.MainMenu;
import events.Players;

public class Board extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JButton rolling, buying, mortgage, ending, mmenu, hmenu, spaces;
	final JButton dicez;
	final JButton dice2thereckoning;
	final JButton tdbtn;
	Players thePlayer = new Players(); //build 2, gaggle of Players[]
	
	//board spaces
	int chPos = 0; //cards for build 2
	int ccPos = 0;
	int tdPos = 0;
	int titledeed = 0; //buy picks
	//int[] tdeed = new int[27];
	int buymort = 0; //counter for buy or mortgage
	int Pos = 0; //board positions
	int money = 0;
	int Prev = thePlayer.getPosition();
	int Bal = thePlayer.getBalance();
	int k = 0; //doubles counter
	int j = 0; //jail counter
	int g = 0; //pass go counter
	Random chancez = new Random(); //build 2
	Random chestz = new Random();
	Random dice = new Random(); //the dice
	int dice1 = 0;
	int dice2 = 0;
	
	//buying or mortgaging properties
	int[] tdBuy = {60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400,150,150,200,200,200,200};
    String[] tdPlaces = {"Germania Inferior","Germania Superior","Alpes Poeniae","Alpes Cottiae","Aples Maritimae","Aquitania","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia","Sewers","Aqueducts","Via Appia","Via Flaminia","Via Aemilia","Via Popillia"};
	String[] tdimages = {"Purple_GermaniaI","Purple_GermaniaS","BBlue_APoeniae","BBlue_ACottiae","BBlue_AMaritimae","DPink_Aquitania","DPink_Belgica","DPink_Raetia","Orange_AProconsularis","Orange_Asia","Orange_Britannia","Red_Cilicia","Red_Cappadocia","Yellow_Aegyptus","Yellow_APetraea","Yellow_Syria","Green_Macedonia","Green_Epirus","Green_Achaia","Blue_Sicilia", "Blue_Italia","Utility_Sewers","Utility_Aqueducts","Via_Appia","Via_Flaminia","Via_Aemilia","Via_Popillia"};
    
	//token movement
    int[] x = {880,818,740,662,581,498,413,336,253,180,35,125,130,130,130,130,130,130,130,130,86,181,263,343,421,501,581,662,741,820,928,874,874,874,874,874,874,874,874,874};
    int[] y = {860,880,880,880,880,880,880,880,880,880,970,845,770,690,605,526,447,370,287,207,93,129,129,129,129,129,129,129,129,129,77,208,285,362,448,527,608,687,766,848};
    
	public Board() {
	setTitle("Board");
	getContentPane();
	setLocationRelativeTo(null);
	pack();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setSize(1013,1036);
	setResizable(false);
	setLayout(new BorderLayout());
	JPanel front = new JPanel();
	front.setOpaque(false);
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	add(background);
	
	background.setSize(1000,1000);
	background.setLayout(null);
	
	//if not applicable grey out buttons, remember to add
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>R</u>oll Dice</div>");
	buying = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>B</u>uy Property</div>");
	mortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 20px 5px 20px;\"><u>M</u>ortgage</div>");
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 5px 5px 5px;\"><u>E</u>nd Turn</div>");
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 5px 5px 5px 5px;\"><u>H</u>elp Menu</div>");
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 14pt; padding: 0px 5px 0px 5px;\"><u>E</u>nd Game<br/><span style=\"font-size: 9pt\">Return to Main Menu</span></div>");
	JLabel blank = new JLabel("<html><br/><div style=\"color: white; border: none; padding: 0; width: 100px; height: 50px;\"></div><br/>");
	//JLabel paction = new JLabel("<html><br/><div style=\"color: black; border: none; padding: 0; width: 100px; height: 50px; text-align:center;\"></div><br/>");
		rolling.setBackground(new Color(73,175,47));
		buying.setBackground(new Color(71,71,255));
		mortgage.setBackground(new Color(247, 153, 22));
		ending.setBackground(new Color(0, 0, 0));
		hmenu.setBackground(new Color(0, 0, 0));
		mmenu.setBackground(new Color(0, 0, 0));

	//dice animation	
	JLabel die1=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice1+".png"));
	JLabel die2=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
	JLabel token1 = new JLabel(new ImageIcon("src/pieces/images/"+thePlayer.getToken()));
	JLabel tdimg = new JLabel(new ImageIcon(""));
	
	dicez = new JButton();
	dice2thereckoning = new JButton();
	spaces = new JButton();
	tdbtn = new JButton();
	

	rolling.addActionListener(this);
	buying.addActionListener(this);
	mortgage.addActionListener(this);
	ending.addActionListener(this);
	mmenu.addActionListener(this);
	hmenu.addActionListener(this);
	spaces.addActionListener(this);
	tdbtn.addActionListener(this);
	
	background.add(front);
	background.add(spaces);
	background.add(tdbtn);
	background.add(dicez);
	background.add(dice2thereckoning);
	
	front.setBounds(240, 540, 525, 400);
	spaces.setBorder(null);
	dicez.setBorder(null);
	tdbtn.setBorder(null);
	dice2thereckoning.setBorder(null);
	spaces.setBounds(x[Pos],y[Pos], 100, 130); //move based on Position on the board
	dicez.setBounds(400, 200, 100, 100);
	dice2thereckoning.setBounds(500, 200, 100, 100);
	tdbtn.setBounds(145,147,201,297);
	
	front.add(rolling);
	front.add(buying);
	front.add(mortgage);
	front.add(ending);
	front.add(hmenu);
	front.add(mmenu);
	front.add(blank);
	front.add(die1);
	front.add(die2);
	spaces.add(token1);
	dicez.add(die1);
	dice2thereckoning.add(die2);
	tdbtn.add(tdimg);
	
	//nope totally not buttons
	dicez.setOpaque(false);
	dice2thereckoning.setOpaque(false);
	spaces.setOpaque(false);
	spaces.setFocusPainted(false);
	dicez.setFocusPainted(false);
	dicez.setContentAreaFilled(false);
	dice2thereckoning.setContentAreaFilled(false);
	tdbtn.setContentAreaFilled(false);
	
	rolling.setEnabled(true);
	buying.setEnabled(false);
	mortgage.setEnabled(false);
	ending.setEnabled(false);
	spaces.setEnabled(false); //lock forever
	dicez.setEnabled(false);  //whatever you do, don't free it, but it makes the dice light grey
	dice2thereckoning.setEnabled(false); //oh no the sequel is never as good as the first

	
	//debugging, finding x,y positions on the board for every click
    background.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
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
			dicez.setIcon(new ImageIcon("src/pieces/images/Dice"+dice1+".png")); //refresh img dice
			dice2thereckoning.setIcon(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
			spaces.setBounds(x[Pos], y[Pos], 100, 130); //move based on Position on the board
			tdbtn.setIcon(new ImageIcon("src/cards/images/"+tdimages[titledeed]+".PNG"));
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
			//tdbtn.setIcon(new ImageIcon("src/cards/images/"+tdimages[titledeed]+".PNG"));
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
			tdbtn.setIcon(new ImageIcon("")); //you get nothing
		}
    }

		public void Turn() {
			int samples = 1; //one turn per button, player one only right now
		    //int doubles = 0;
			
			for (int i = 0; i < samples; i++) {
			//loop until end of max turns  
			//array for spaces on the board
			String[] board = {"Go", "Germania Inferior", "Community Chest", "Germania Superior", "Render unto Caesar", "Via Appia", "Alpes Poeniae", "Chance", "Alpes Cottiae", "Alpes Maritimae", "See a battle", "Arena", "Aquitania", "Sewers", "Belgice", "Raetia", "Via Flaminia", "Africa Proconsularis", "Community Chest", "Asia", "Britannia", "Free Market", "Cilicia", "Chance", "Galatia", "Cappadocia", "Via Aemilia", "Aegyptus", "Arabia Petraea", "Aqueducts", "Syria", "Go to the Arena", "Macedonia", "Epirus", "Community Chest", "Achaia", "Via Popillia", "Chance", "Sicilia", "Citizens Tax", "Italia"};
			int[] jail = new int[5];
			int[] doubles = new int[4];
			
			dice1 = dice.nextInt(6) + 1;
	        dice2 = dice.nextInt(6) + 1;

	        //remainder operators
	        //System.out.println("Previous Position: "+Prev);
	        Pos = (Prev + dice1 + dice2) % 40;
	        
	        //System.out.println("Previous Position: "+Prev); //debugging
	        j = j % 4;
	        //for build 2
	        k = (dice1 == dice2) ? k + 1 : 0;
	        if (k == 1) {
	    	   System.out.println("Doubles! Roll again.");
	    	   rolling.setEnabled(true);
			   ending.setEnabled(false);
	        }
	        if (k > 2 && k < 1) {
	        	System.out.println("You have rolled doubles 3 times, Go to the Arena.");
	        	//go to the arena
	        	Pos = 11;
	        	k = 0;
	        	//roll doubles within 3 turns
	        }
	        
	        //checking the spaces token as moved to
	       if (j == 0) {
	    	  if (Pos != 0) {
			    if ((Prev > Pos) && (g == 0)) {
			    System.out.println("Pass Rome, Collect 200."); //receive
			    System.out.println("Prev:"+Prev+", Pos: "+Pos);
				money = -200;
			    }
		      }
	    	  if (Pos == 0) {
	    		  System.out.println("Pass Rome, Collect 200."); //receive
				  money = -200;
	    	  }
	    	  if (Pos == 1) {
	    		  buying.setEnabled(true);
	    		  mortgage.setEnabled(true);
	    		  ending.setEnabled(true);
	    		  titledeed = 0; //Germania Inferior
	    	  }
	    	  if (Pos == 3) {titledeed = 1;}   //Germania Superior
	    	  if (Pos == 6) {titledeed = 2;}   //Alpes Poeniae
			  if (Pos == 8) {titledeed = 3;}   //Alpes Cottiae
			  if (Pos == 9) {titledeed = 4;}   //Alpes Maritimae
			  if (Pos == 12) {titledeed = 5;}  //Aquitania
			  if (Pos == 14) {titledeed = 6;}  //Belgica
			  if (Pos == 15) {titledeed = 7;}  //Raetia
			  if (Pos == 17) {titledeed = 8;}  //Africa Proconsularis
			  if (Pos == 19) {titledeed = 9;}  //Asia
			  if (Pos == 20) {titledeed = 10;} //Britannia
			  if (Pos == 22) {titledeed = 11;} //Cilicia
			  if (Pos == 24) {titledeed = 12;} //Galatia
			  if (Pos == 25) {titledeed = 13;} //Cappadocia
			  if (Pos == 27) {titledeed = 14;} //Aegyptus
			  if (Pos == 28) {titledeed = 15;} //Arabia Petraea
			  if (Pos == 30) {titledeed = 16;} //Syria
			  if (Pos == 32) {titledeed = 17;} //Macedonia
			  if (Pos == 33) {titledeed = 18;} //Epirus
			  if (Pos == 35) {titledeed = 19;} //Achaia
			  if (Pos == 38) {titledeed = 20;} //Sicilia
			  if (Pos == 40) {titledeed = 21;} //Italia
			  
			  if(Pos == 21) {ending.setEnabled(true);} //free market
	    	  if (Pos == 4 || Pos == 39) {
				money = 100;
	    		System.out.println("Taxes"); //pay, expand later
	    	  }
	    	  
	    	  if (Pos == 5 || Pos == 16 || Pos == 26 || Pos == 36) {
				  titledeed = 24; //Via, expand later
			  }
	    	  if (Pos == 7 || Pos == 23 || Pos == 37) {
	    		  
	    		  ending.setEnabled(true);
	    		  } //chance
	    	  if (Pos == 2 || Pos == 18 || Pos == 34) {
	    		  
	    		  ending.setEnabled(true);
	    		  } //chest
	    	  if (Pos == 13) {titledeed = 22;} //sewers
	    	  if (Pos == 29) {titledeed = 23;} //aqueducts
	    	  if (Pos == 10) {Pos = 11;} //keep from losing 1 when going past Arena
	    	  if (Pos == 11 && j == 0) {
	    		  System.out.println("See a battle."); //see a battle
	    		  ending.setEnabled(true);
	    	  }
	    	  if (Pos == 31) {
	    		  System.out.println("Go to the Arena.");
	    		  Pos = 11;
	    		  j = 1;
	    		  g = 1;
	    	  }
	        }
	       
	       //not j = 0 is in jail
	      if(j > 0 && j < 4) {
	    	Pos = 11;
		    System.out.println("You are still in the Arena. Turns until free: "+(4-j)); //stay in jail for three turns or j=3
		    j++;
		    ending.setEnabled(true);
	      }
	      if (j > 3) {
	    	  System.out.println("Pay 50.");
			  money = 50;
			  g = 0;
	    	  ending.setEnabled(true);
	      }
		  if(titledeed != 0) {
			buying.setEnabled(true);
	    	mortgage.setEnabled(true);
	    	ending.setEnabled(true);
		  }
	      jail[j]++;
	      doubles[k]++;
	      x[Pos]++;
	      y[Pos]++;
	      //tdimg[Pos]++;
		  Bal -= money;
		  money = 0;
		  Prev = Pos;
		  thePlayer.setPosition(Pos);
		  thePlayer.setBalance(Bal);
		  System.out.println("-Space: "+board[Pos]+", Dice 1: "+dice1+", Dice 2: "+dice2);
	      System.out.println("-Jail Counter: "+j+", Doubles counter: "+k);
		  System.out.println("Player's balance: "+thePlayer.getBalance());
		}
	}
		public void Buy() {
			int ttbuy = 0;
			int tdmort = 0;
			ttbuy = tdBuy[titledeed];
			//set mortgage
			if (ttbuy != 0 && buymort == 1) {
				tdmort = (ttbuy/2);
				Bal -= tdmort;
				System.out.println("-Place: "+tdPlaces[titledeed]+", Mortgage: "+Bal+" - "+tdmort);
			}
			if(buymort == 0) {
				System.out.println("-Place: "+tdPlaces[titledeed]+", Pay: "+Bal+" - "+ttbuy);
				Bal -= ttbuy;
			}
			//lock the item as bought and by which player
			thePlayer.setBalance(Bal);
			System.out.println("Player's balance: "+thePlayer.getBalance());
		}
}


/*
Token positions
x: 951, y: 880
x: 818, y: 880
x: 740, y: 880
x: 662, y: 880
x: 581, y: 880
x: 498, y: 880
x: 413, y: 880
x: 336, y: 880
x: 253, y: 880
x: 180, y: 880
x: 35, y: 970
x: 125, y: 845
x: 130, y: 770
x: 130, y: 690
x: 130, y: 605
x: 130, y: 526
x: 130, y: 447
x: 130, y: 370
x: 130, y: 287
x: 130, y: 207
x: 86, y: 93
x: 181, y: 129
x: 263, y: 129
x: 343, y: 129
x: 421, y: 129
x: 501, y: 129
x: 581, y: 129
x: 662, y: 129
x: 741, y: 129
x: 820, y: 129
x: 928, y: 77
x: 874, y: 208
x: 874, y: 285
x: 874, y: 362
x: 874, y: 448
x: 874, y: 527
x: 874, y: 608
x: 874, y: 687
x: 874, y: 766
x: 874, y: 848

board array (Pos)
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

Buy array (titledeed)
0:  Germania Inferior ($60, $30 mortgaged)
1:	Germania Superior ($60, $30 mortgaged)
2:	Alpes Poeniae ($100, $50 mortgaged)
3:	Alpes Cottiae ($100, $50 mortgaged)
4:	Aples Maritimae ($120, $60 mortgaged)
5:	Aquitania ($140, $70 mortgaged)
6:	Belgica ($140, $70 mortgaged)
7:	Raetia ($160, $80 mortgaged)
8:	Africa Proconsularis ($180, $90 mortgaged)
9:	Asia ($180, $90 mortgaged)
10:	Britannia ($200, $100 mortgaged)
11:	Cilicia ($220, $110 mortgaged)
12:	Galatia ($220, $110 mortgaged)
13:	Cappadocia ($240, $120 mortgaged)
14:	Aegyptus ($260, $130 mortgaged)
15:	Arabia Petraea ($260, $130 mortgaged)
16:	Syria ($280, $140 mortgaged)
17:	Macedonia ($300, $150 mortgaged)
18:	Epirus ($300, $150 mortgaged)
19:	Achaia ($320, $160 mortgaged)
20:	Sicilia ($350, $175 mortgaged)
21:	Italia ($400, $200 mortgaged)
22: Sewers ($150 buy, $75 mortgaged)
23: Aqueducts
24: Via Appia ($200 buy, $100 mortgaged)
25: Via Flaminia
26: Via Aemilia
27: Via Popillia
*/
