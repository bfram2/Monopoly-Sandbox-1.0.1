package pieces;
//Loading the board [fonts for board.jpg: Verdana 8pt, 6pt, 8pt bold]
//position vs titledeed cards need to be fixed
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
	
	JButton rolling, buying, mortgage, ending, mmenu, hmenu, spaces, plbtn;
	final JButton dicez;
	final JButton dice2thereckoning;
	final JButton tdbtn;
	Players thePlayer = new Players(); //build 2, gaggle of Players[]
	int ttbuy = 0;
	int tdmort = 0;
	//board spaces
	int chPos = 0; //cards for build 2
	int ccPos = 0;
	int tdPos = 0;
	int titledeed = 0; //buy picks
	int tdplimg = 28; //titledeed card counter
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
	int chacard = 0;
	int checard = 0;
	Random dice = new Random(); //the dice
	int dice1 = 0;
	int dice2 = 0;
	
	//buying price for title deeds
	int[] tdBuy = {60,60,100,100,120,140,140,160,180,180,200,220,220,240,260,260,280,300,300,320,350,400,150,150,200,200,200,200};
	//the name of the spaces with titledeeds
    String[] tdPlaces = {"Germania Inferior","Germania Superior","Alpes Poeniae","Alpes Cottiae","Aples Maritimae","Aquitania","Belgica","Raetia","Africa Proconsularis","Asia","Britannia","Cilicia","Galatia","Cappadocia","Aegyptus","Arabia Petraea","Syria","Macedonia","Epirus","Achaia","Sicilia","Italia","Sewers","Aqueducts","Via Appia","Via Flaminia","Via Aemilia","Via Popillia",""};
	//title deed card image names
	String[] tdimages = {"Purple_GermaniaI","Purple_GermaniaS","BBlue_APoeniae","BBlue_ACottiae","BBlue_AMaritimae","DPink_Aquitania","DPink_Belgica","DPink_Raetia","Orange_AProconsularis","Orange_Asia","Orange_Britannia","Red_Cilicia","Red_Galatia","Red_Cappadocia","Yellow_Aegyptus","Yellow_APetraea","Yellow_Syria","Green_Macedonia","Green_Epirus","Green_Achaia","Blue_Sicilia", "Blue_Italia","Utility_Sewers","Utility_Aqueducts","Via_Appia","Via_Flaminia","Via_Aemilia","Via_Popillia",""};
	//all spaces
	String[] board = {"Go", "Germania Inferior", "Community Chest", "Germania Superior", "Render unto Caesar", "Via Appia", "Alpes Poeniae", "Chance", "Alpes Cottiae", "Alpes Maritimae", "See a battle", "Arena", "Aquitania", "Sewers", "Belgica", "Raetia", "Via Flaminia", "Africa Proconsularis", "Community Chest", "Asia", "Britannia", "Free Market", "Cilicia", "Chance", "Galatia", "Cappadocia", "Via Aemilia", "Aegyptus", "Arabia Petraea", "Aqueducts", "Syria", "Go to the Arena", "Macedonia", "Epirus", "Community Chest", "Achaia", "Via Popillia", "Chance", "Sicilia", "Citizens Tax", "Italia"};
	
	//token movement setBounds(x[Pos],y[Pos])
    int[] x = {601,544,488,432,376,320,264,208,152,96,33,2, 63,63,63,63,63,63,63,63,63,144,226,306,384,464,543,624,703,785,885,865,865,865,865,865,865,865,865};
    int[] y = {600,600,600,600,600,600,600,600,600,600,600,600, 546,488,430,372,256,198,264,140,153,82,24,32,32,32,32,32,32,32,32,27,144,224,302,383,461,542,702,784};
    //buy
    int[] buycounter = {}; //0 bank, 1 buy, 2 mortgage --> 28 spaces
    
    //layout
	public Board() {
	setTitle("Board");
	getContentPane();
	setLocationRelativeTo(null);
	pack();
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setSize(700,729);
	setResizable(false);
	setLayout(new BorderLayout());
	//add(new JLabel(new ImageIcon("src/pieces/board.jpg")));
	JPanel front = new JPanel();
	front.setOpaque(false);
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	//JLabel background=new JLabel();
	add(background);
	//background.setSize(700,700);
	background.setLayout(null);
	
	//if not applicable grey out buttons
	rolling = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px 15px 5px 15px;\"><u>R</u>oll Dice</div>");
	buying = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>B</u>uy Property</div>");
	mortgage = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>M</u>ortgage</div>");
	ending = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>E</u>nd Turn</div>");
	hmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 5px;\"><u>H</u>elp Menu</div>");
	mmenu = new JButton("<html><center><div style=\"color: white; font-weight: bold; font-family: verdana; font-size: 12pt; padding: 0px 5px 0px 5px;\"><u>E</u>nd Game<br/><span style=\"font-size: 9pt\">Return to Main Menu</span></div>");
		rolling.setBackground(new Color(73,175,47));
		buying.setBackground(new Color(71,71,255));
		mortgage.setBackground(new Color(247, 153, 22));
		ending.setBackground(new Color(0, 0, 0));
		hmenu.setBackground(new Color(0, 0, 0));
		mmenu.setBackground(new Color(0, 0, 0));

	//dice, cards, and token images	
	JLabel die1=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice1+".png"));
	JLabel die2=new JLabel(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
	JLabel token1 = new JLabel(new ImageIcon("src/pieces/images/"+thePlayer.getToken()));
	JLabel tdimg = new JLabel(new ImageIcon(""));
	
	//where images are stored
	dicez = new JButton();
	dice2thereckoning = new JButton();
	spaces = new JButton();
	tdbtn = new JButton();
	plbtn = new JButton("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+thePlayer.getBalance()+" denarius <br/>Space: "+board[Pos]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"</div></html>");
	
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
	front.setBounds(120, 365, 450, 200);
	spaces.setBorder(null);
	dicez.setBorder(null);
	tdbtn.setBorder(null);
	plbtn.setBorder(null);
	dice2thereckoning.setBorder(null);
	spaces.setBounds(x[Pos],y[Pos], 56, 56); //move based on Position on the board
	dicez.setBounds(259, 266, 50, 50);
	dice2thereckoning.setBounds(309, 266, 50, 50);
	tdbtn.setBounds(98,98,155,230);
	plbtn.setBounds(118,450,100,100);
	
	front.add(rolling);
	front.add(buying);
	front.add(mortgage);
	front.add(ending);
	front.add(hmenu);
	front.add(mmenu);
	front.add(plbtn);
	front.add(die1);
	front.add(die2);
	spaces.add(token1);
	dicez.add(die1);
	dice2thereckoning.add(die2);
	tdbtn.add(tdimg);
	//plbtn.add(plscreen);
	
	//nope totally not buttons
	dicez.setOpaque(false);
	dice2thereckoning.setOpaque(false);
	spaces.setOpaque(false);
	spaces.setFocusPainted(false);
	spaces.setContentAreaFilled(false);
	dicez.setFocusPainted(false);
	dicez.setContentAreaFilled(false);
	dice2thereckoning.setContentAreaFilled(false); //the sequel is never as good as the first
	dice2thereckoning.setFocusPainted(false);
	tdbtn.setContentAreaFilled(false); //totally not a button
	plbtn.setFocusPainted(false);
	plbtn.setContentAreaFilled(false);
	plbtn.setOpaque(false);
	
	rolling.setEnabled(true);
	buying.setEnabled(false);
	mortgage.setEnabled(false);
	ending.setEnabled(false);
	//plscreen.setEnabled(false); //in case of clicking

	//debugging, finding x,y positions on the board for every click
    background.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
			System.out.println("x: "+e.getX()+", y: "+e.getY());
			return;
		}
	});
	
	// refresh images after adding panels
	setSize(701,728);
	}
	
	//button actions
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rolling) {
			//start turn
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(false);
			Turn();
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"</div></html>");
			dicez.setIcon(new ImageIcon("src/pieces/images/Dice"+dice1+".png")); //refresh img dice
			dice2thereckoning.setIcon(new ImageIcon("src/pieces/images/Dice"+dice2+".png"));
			spaces.setBounds(x[Pos], y[Pos], 70, 77);
			tdbtn.setIcon(new ImageIcon("src/cards/images/"+tdimages[tdplimg]+".PNG"));
			
			if (Bal < (ttbuy/2)) {
				mortgage.setEnabled(false);
			}
			if (Bal < ttbuy) {
				buying.setEnabled(false);
			}
			tdplimg = 28; //reset to blank
		}
		if(e.getSource() == buying) {
			if (Bal > ttbuy) {
			//buy property
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(true);
			buymort = 0;
			Buy();
			} else {
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			System.out.println("You do not have enough money to purchase this property.");
			} //backup if able to get around rolling
		}
		if(e.getSource() == mortgage) {
			if (Bal > (ttbuy/2)) {
			//mortgage property
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(true);
			buymort = 1;
			Buy();
			} else {
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			System.out.println("You do not have enough money to mortgage this property.");
			} //backup if able to get around rolling
		}
		if(e.getSource() == hmenu) {
			//user guide
			new HelpMenu();
		}
		if(e.getSource()== mmenu){
			//exit for main menu
			dispose();
			new MainMenu();
		}
		if(e.getSource()== ending){
			//here it goes again
			rolling.setEnabled(true);
			tdbtn.setIcon(new ImageIcon("")); //you get nothing
		} //ends current turn
    }

		public void Turn() {
			int samples = 1; //one turn per button, player one only right now
			for (int i = 0; i < samples; i++) {
			tdplimg = 28;
			//loop until end of max turns  
			//array for spaces on the board
			int[] jail = new int[5];
			int[] doubles = new int[4]; //errors when doubles are over 3, fix
			dice1 = dice.nextInt(6) + 1;
	        dice2 = dice.nextInt(6) + 1;
	        
	        //remainder operators for arrays, need one for k
	        //System.out.println("Prev: "+Prev); //debugging
	        Pos = (Prev + dice1 + dice2) % 40;
	        System.out.println("Prev:"+Prev+", Pos: "+Pos); //debugging
	        
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
	    	   if (Pos > 10) {
		        	Pos+= 1;
		        	if (Pos > 39) {
		        		Pos = 40 - Pos;
		        	}
		        }
	    	  if (Pos != 0) {
			    if ((Prev > Pos) && (g == 0)) {
			    	plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"<br/>Pass Rome, Collect 200 denarius.</div></html>");
			    //System.out.println("Pass Rome, Collect 200."); //receive
			    //System.out.println("Prev:"+Prev+", Pos: "+Pos);
				money = -200;
			    }
		      }
	    	  if (Pos == 0) {
	    		  plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"<br/>Pass Rome, Collect 200 denarius.</div></html>");
	    		  //System.out.println("Pass Rome, Collect 200."); //receive
				  money = -200;
	    	  }
	    	  if (Pos == 1) {
	    		  buying.setEnabled(true);
	    		  mortgage.setEnabled(true);
	    		  ending.setEnabled(true);
	    		  titledeed = 0; //Germania Inferior
	    		  tdplimg = 0;
	    	  }
	    	  if (Pos == 3) {titledeed = 1;}   //Germania Superior
			  if (Pos == 4) {
				money = 200;
				plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
				thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
						k+"<br/>Render unto Caesar, pay 200 denarius.</div></html>");
				//System.out.println("Render unto Caesar"); //pay
	    		ending.setEnabled(true);
			  }
			  if (Pos == 5) {titledeed = 24;}  //Via Appia
	    	  if (Pos == 6) {titledeed = 2;}   //Alpes Poeniae
			  if (Pos == 8) {titledeed = 3;}   //Alpes Cottiae
			  if (Pos == 9) {titledeed = 4;}   //Alpes Maritimae
			  if (Pos == 12) {titledeed = 5;}  //Aquitania
			  if (Pos == 13) {titledeed = 22;} //Sewers
			  if (Pos == 14) {titledeed = 6;}  //Belgica
			  if (Pos == 15) {titledeed = 7;}  //Raetia
			  if (Pos == 16) {titledeed = 25;} //Via Flaminia
			  if (Pos == 17) {titledeed = 8;}  //Africa Proconsularis
			  if (Pos == 19) {titledeed = 9;}  //Asia
			  if (Pos == 20) {titledeed = 10;} //Britannia
			  if(Pos == 21) {ending.setEnabled(true);} //free market
			  if (Pos == 22) {titledeed = 11;} //Cilicia
			  if (Pos == 24) {titledeed = 12;} //Galatia
			  if (Pos == 25) {titledeed = 13;} //Cappadocia
			  if (Pos == 26) {titledeed = 26;} //Via Aemilia
			  if (Pos == 27) {titledeed = 14;} //Aegyptus
			  if (Pos == 28) {titledeed = 15;} //Arabia Petraea
			  if (Pos == 29) {titledeed = 23;} //aqueducts
			  if (Pos == 30) {titledeed = 16;} //Syria
			  if (Pos == 31) {
				  plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+k+"<br/>Go to the Arena.</div></html>");
	    		  System.out.println("Go to the Arena.");
	    		  Pos = 11;
	    		  j = 1;
	    		  g = 1;
				  ending.setEnabled(true);
	    	  }
			  if (Pos == 32) {titledeed = 17;} //Macedonia
			  if (Pos == 33) {titledeed = 18;} //Epirus
			  if (Pos == 35) {titledeed = 19;} //Achaia
			  if (Pos == 38) {titledeed = 20;} //Sicilia
			  if (Pos == 39) {
				money = 100;
				plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
						thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
								k+"<br/>Citizen's Tax, pay 100 denarius.</div></html>");
	    		//System.out.println("Citizen's Tax"); //pay
	    		ending.setEnabled(true);
	    	  }
			  if (Pos == 40) {titledeed = 21;} //Italia
	    	  
	    	  if (Pos == 36) {titledeed = 27;} //Via Popillia
	    	  if (Pos == 7 || Pos == 23 || Pos == 37) {
	    		  ending.setEnabled(true);
				  chacard = chancez.nextInt(16) + 1;
				  plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
							thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
									k+"<br/>Draw a Chance Card: Chance"+chacard+"</div></html>");
				  //System.out.println("Draw a Chance Card: "+chacard);
				  //Chance(); //build 2
	    		  } //chance
	    	  if (Pos == 2 || Pos == 18 || Pos == 34) {
	    		  ending.setEnabled(true);
	    		  checard = chestz.nextInt(16) + 1;
	    		  plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
							thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
									k+"<br/>Draw a Chest Card: Chest"+checard+"</div></html>");
	    		  //System.out.println("Draw a Chest Card: "+checard);
				  //CommunityChest(); //build 2
	    		  } //chest
	    	  if (Pos == 10) {
	    		  ending.setEnabled(true);
	    		  } //greater than 10 add one, due to Arena
	    	  if (Pos == 11 && j == 0) {
	    		  plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
							thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
									k+"<br/>See a battle.</div></html>");
	    		  //System.out.println("See a battle."); //see a battle
	    		  ending.setEnabled(true);
				  Pos = 10;
	    	 }
	       }
	       //not j = 0 is in jail
	      if(j > 0 && j < 4) {
	    	Pos = 11;
	    	plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
					thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
							k+"<br/>You are still in the Arena. Turns until free: "+(4-j)+"</div></html>");
		    //System.out.println("You are still in the Arena. Turns until free: "+(4-j)); //stay in jail for three turns or j=3
		    j++;
		    ending.setEnabled(true);
		    if (k == 1) {
		    	plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
						thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
								k+"<br/>You rolled a double, escape the Arena.</div></html>");
		    	//System.out.println("You rolled a double, escape the Arena.");
		    	j = 0;
		    }
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
	    	tdplimg = titledeed;
		  }
		  if (Pos == 2 || Pos == 7 || Pos == 10 || Pos == 11 || Pos == 18 || Pos == 21 || Pos == 23 || Pos == 31 || Pos == 34 || Pos == 37 || Pos == 39) {
			  tdplimg = 28; //do not display card if on these positions
		  }
		  if (k > 3) {
			  k = 3-k;
		  } //keep doubles from going out of bounds
		  x[Pos]++;
	      y[Pos]++;
	      jail[j]++;
	      doubles[k]++;
		  Bal -= money;
		  money = 0;
		  Prev = Pos;
		  thePlayer.setPosition(Pos);
		  thePlayer.setBalance(Bal);
		  ttbuy = tdBuy[titledeed];
		  
		  //System.out.println("-Space: "+board[Pos]+", "+titledeed+", Dice: "+(dice1+dice2));
	      //System.out.println("-Jail Counter: "+j+", Doubles counter: "+k+", Card counter: "+tdplimg);
		  //System.out.println("Player's balance: "+thePlayer.getBalance());
		  //System.out.println("x: "+x[Pos]+", y:"+y[Pos]); //debugging
		  
		  if (Bal == 0) {
			System.out.println("Game over.");
			rolling.setEnabled(false);
			buying.setEnabled(false);
			mortgage.setEnabled(false);
			ending.setEnabled(false);
			mmenu.setEnabled(true);
			hmenu.setEnabled(false);
			plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
					thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
							k+"<br/>Game over.</div></html>");
		  } //end game at end of roll if balance is zero	
	  } //end loop
   } //turn end
		
		public void Buy() {
			//ttbuy = tdBuy[titledeed];
			//set mortgage
			 if ((ttbuy != 0) && (buymort == 1)) {
				tdmort = (ttbuy/2);
				Bal -= tdmort;
				plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
						thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
								k+"<br/>You have mortgaged this space for: "+tdmort+" denarius </div></html>");
				//System.out.println("-Place: "+tdPlaces[titledeed]+", Mortgage: "+Bal+" - "+tdmort);
			} //balance cannot be lower than property
			 if(buymort == 0) {
				 //set buy
				 plbtn.setText("<html><div style=\"color: black; font-family: verdana; width: 300px; font-size: 11pt; padding: 0;\">Player's Balance: "+
							thePlayer.getBalance()+" denarius <br/>Title Deed Space: "+tdPlaces[titledeed]+", Buy cost: "+ttbuy+" denarius <br/>Jail Counter: "+j+", Doubles Counter: "+
									k+"<br/>You have bought this space for: "+ttbuy+" denarius </div></html>");
				//System.out.println("-Place: "+tdPlaces[titledeed]+", Pay: "+Bal+" denarius - "+ttbuy+" denarius");
				Bal -= ttbuy;
			} //balance cannot be lower than property
			//lock the item as bought and by which player
			thePlayer.setBalance(Bal);
			//System.out.println("Player's balance: "+thePlayer.getBalance());
			
		}
}
