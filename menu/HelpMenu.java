package menu;
//User Friendly summarized version of the User Manual

/* Trademark of Hasboro and Parker Brothers */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class HelpMenu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextArea output;
	JScrollPane scrollPane;
	Action H01, H02, H03, H04, H05, H06, H07, H08, H09, H10, H11, H12, H13, H14,
	H15, H16, H17, H18, H19, H20, H21, H22, H23, H24, H25, H26, H27;
	
	public HelpMenu() {
		setTitle("User Guide");
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
		//pack();
		//setLayout(new BorderLayout());
		setSize(575, 400); //window size
		setLocationRelativeTo(null);
		
		//HelpMenu hMenu = new HelpMenu();
		createActions();
		setContentPane(createContentPane());
		setJMenuBar(createMenuBar());
		
		setVisible(true);
	}
	
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        
        //All Text Strings as variables
        String defaultText = "Welcome to the user guide. Please click on the help menu above, and select the area you need help with.";

        //Create a scrolled text area.
        output = new JTextArea(1, 1);
        output.setEditable(false);
        output.setFont(new Font("Verdana", Font.PLAIN, 18));
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setText(defaultText);
        scrollPane = new JScrollPane(output);
        
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }
    
	public JMenuBar createMenuBar() {
		//Create variables of appropritate types
        JMenuBar helpMenuBar;
        JMenu helpMenu, helpSubmenu;
        JMenuItem helpMenuItem;

        //Create the menu bar.
        helpMenuBar = new JMenuBar();

        //Build the first menu.
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenuBar.add(helpMenu);

        //a group of JMenuItems
        helpMenuItem = new JMenuItem();
        //Set the action for the menu item
        helpMenuItem.setAction(H01);
        //Set Shortcut key
        helpMenuItem.setMnemonic(KeyEvent.VK_H);
        //add menu item to the menu
        helpMenu.add(helpMenuItem);

        helpMenu.addSeparator();
        
        //Movement Sub-menu
        helpSubmenu = new JMenu("Movement");
        helpSubmenu.setMnemonic(KeyEvent.VK_M);
        
        //Movement Items H02 - H15
        helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H02);
        helpMenuItem.setMnemonic(KeyEvent.VK_D);
        helpSubmenu.add(helpMenuItem);
        
        helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H03);
        helpMenuItem.setMnemonic(KeyEvent.VK_R);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H04);
        helpMenuItem.setMnemonic(KeyEvent.VK_A);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H05);
        helpMenuItem.setMnemonic(KeyEvent.VK_G);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H06);
        helpMenuItem.setMnemonic(KeyEvent.VK_U);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H07);
        helpMenuItem.setMnemonic(KeyEvent.VK_O);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H08);
        helpMenuItem.setMnemonic(KeyEvent.VK_P);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H09);
        helpMenuItem.setMnemonic(KeyEvent.VK_V);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H10);
        helpMenuItem.setMnemonic(KeyEvent.VK_T);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H11);
        helpMenuItem.setMnemonic(KeyEvent.VK_H);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H12);
        helpMenuItem.setMnemonic(KeyEvent.VK_C);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H13);
        helpMenuItem.setMnemonic(KeyEvent.VK_I);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H14);
        helpMenuItem.setMnemonic(KeyEvent.VK_E);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H15);
        helpMenuItem.setMnemonic(KeyEvent.VK_F);
        helpSubmenu.add(helpMenuItem);
        
        //Add movement sub-menu to main help menu.
        helpMenu.add(helpSubmenu);

        helpMenu.addSeparator();
        
        //Create player turn sub-menu
        helpSubmenu = new JMenu("Player Turn");
        helpSubmenu.setMnemonic(KeyEvent.VK_P);
        
        //Player Turn items H2, H16 - H18
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H02);
        helpMenuItem.setText("Begin Movement");
        helpMenuItem.setMnemonic(KeyEvent.VK_B);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H16);
        helpMenuItem.setMnemonic(KeyEvent.VK_L);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H17);
        helpMenuItem.setMnemonic(KeyEvent.VK_P);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H18);
        helpMenuItem.setMnemonic(KeyEvent.VK_E);
        helpSubmenu.add(helpMenuItem);
        
        //Add player turn sub-menu to main help menu.
        helpMenu.add(helpSubmenu);

        helpMenu.addSeparator();
        
        //Create board space sub-menu
        helpSubmenu = new JMenu("Board space");
        helpSubmenu.setMnemonic(KeyEvent.VK_B);
        
        //Board space items H19, H20, H07, H08, H11-H14
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H19);
        helpMenuItem.setMnemonic(KeyEvent.VK_G);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H20);
        helpMenuItem.setMnemonic(KeyEvent.VK_T);
        helpSubmenu.add(helpMenuItem);
        
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H13);
        helpMenuItem.setText("Citizen's Tax");
        helpMenuItem.setMnemonic(KeyEvent.VK_C);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H14);
        helpMenuItem.setText("Render unto Ceasar");
        helpMenuItem.setMnemonic(KeyEvent.VK_R);
        helpSubmenu.add(helpMenuItem);
        
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H08);
        helpMenuItem.setText("Utility – Aqueducts or Sewers");
        helpMenuItem.setMnemonic(KeyEvent.VK_U);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H07);
        helpMenuItem.setText("VIA’s");
        helpMenuItem.setMnemonic(KeyEvent.VK_V);
        helpSubmenu.add(helpMenuItem);
        
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H11);
        helpMenuItem.setText("Chance");
        helpMenuItem.setMnemonic(KeyEvent.VK_H);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H12);
        helpMenuItem.setText("Community Chest");
        helpMenuItem.setMnemonic(KeyEvent.VK_O);
        helpSubmenu.add(helpMenuItem);
        
        //Add player turn sub-menu to main help menu.
        helpMenu.add(helpSubmenu);

        helpMenu.addSeparator();
        
        //Create Property Management Sub-menu
        helpSubmenu = new JMenu("Property Management");
        helpSubmenu.setMnemonic(KeyEvent.VK_R);
        
        //Create Property Management items and add them to the submenu
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H06);
        helpMenuItem.setText("Buy property");
        helpMenuItem.setMnemonic(KeyEvent.VK_B);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H21);
        helpMenuItem.setMnemonic(KeyEvent.VK_U);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H22);
        helpMenuItem.setMnemonic(KeyEvent.VK_M);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H23);
        helpMenuItem.setMnemonic(KeyEvent.VK_U);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H24);
        helpMenuItem.setMnemonic(KeyEvent.VK_O);
        helpSubmenu.add(helpMenuItem);

     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H25);
        helpMenuItem.setMnemonic(KeyEvent.VK_D);
        helpSubmenu.add(helpMenuItem);
        
        //Add property management sub-menu to main help menu.
        helpMenu.add(helpSubmenu);
        
        /* Quick template for adding another menu item to this sub-menu
     	helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H##);
        helpMenuItem.setMnemonic(KeyEvent.VK_%Choose_a_shortcut_key_letter%);
        helpSubmenu.add(helpMenuItem);
        */
        
        //Next would be a new Sub-menu...
        /* quick template for adding another sub-menu
        helpSubmenu = new JMenu("Sub-Menu_Title");
        helpSubmenu.setMnemonic(KeyEvent.VK_%Choose_a_shortcut_key_letter%);
        
        //Add more help menu items using template found above
        
        helpMenu.add(helpSubmenu);
		*/
		
        // provide the entire help menu bar with menus, sub-menus, and menu items
        // at exit of this class
        return helpMenuBar;
    }

	public void createActions() {
		//All of the actions that occur when selecting the various menu items.
        H01 = new AbstractAction("How do I win this game?", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("The object of the game is to have the most "
        				+ "money compared to any other player by buying, renting"
        				+ ", and selling property (MB Source cited).  The game "
        				+ "will end when any player reaches 0 remaining funds.  "
        				+ "The winner is the player with the most money at that "
        				+ "point.");
        	}
        };
        
        H02 = new AbstractAction("Rolling Dice and moving your token", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Your turn will begin with the ability to roll "
        				+ "the dice and move your token to a new space on the "
        				+ "board.  Click the “Roll Dice” button near the top-"
        				+ "center of the screen to begin your movement, and "
        				+ "the game will automatically move your token to the "
        				+ "correct space. Any card that sends you to a specific"
        				+ " place on the board is reached by moving clockwise, "
        				+ "as normal. You will never move backwards, unless a "
        				+ "card specifically tells you to do so. This could "
        				+ "force you to go past Rome and collect $200.\n\nIf "
        				+ "you roll Doubles, you will be able to roll again. "
        				+ "However, if you roll doubles to get out of The "
        				+ "Arena, you do not get to roll again. If you roll "
        				+ "doubles a third time, you will be sent to The Arena"
        				+ " without passing Rome.");
        	}
        };
        
        H03 = new AbstractAction("Passing or landing on Rome!", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("The moment your token passes Rome, you will "
        				+ "automatically receive $200. If you happen to land "
        				+ "on Rome, you will receive $200 at that point.  "
        				+ "However, you will not receive another $200 for "
        				+ "leaving Rome after landing there.\n\nIf a chance "
        				+ "card sends you back to or through Rome, you will "
        				+ "receive another $200. Chance card movement is "
        				+ "clockwise, unless specifically stated otherwise.");
        	}
        };

        H04 = new AbstractAction("Landing on The Arena", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you land on The Arena, you are there to"
        				+ " simply “See a battle” and nothing happens. Your "
        				+ "turn continues as normal.");
        	}
        };

        H05 = new AbstractAction("Landing on \"Go To The Arena\"", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you land on the “Go To The Arena” "
        				+ "space, you must go to participate in The Arena. "
        				+ "Your turn immediately ends, and you will remain "
        				+ "in The Arena until you escape. See “Help – Board"
        				+ " Space – The Arena” for more information about "
        				+ "The Arena.");
        	}
        };

        H06 = new AbstractAction("Landing on Unowned Property", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you land on property that has not yet "
        				+ "been purchased, you will be given the choice of "
        				+ "purchasing it from the bank at the cost shown on"
        				+ " the board or to mortgage at the price shown on "
        				+ "the card.");
        	}
        };

        H07 = new AbstractAction("Landing on other’s owned property", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you land on property that has already "
        				+ "been purchased by another player, you will need "
        				+ "to pay them rent. This rent will change "
        				+ "depending upon many factors. If the property is "
        				+ "currently under Mortgage, no rent is due. If the"
        				+ " owner has all of the properties for that "
        				+ "section or color, the price will be doubled. A "
        				+ "Villa or Pantheon will also increase the price "
        				+ "of rent. This amount will automatically be "
        				+ "deducted from your total funds. If you do not "
        				+ "have enough money, you will be prompted with "
        				+ "options to acquire the necessary funds. If you "
        				+ "have no way of acquiring additional funds, you "
        				+ "have gone bankrupt and lost the game.");
        	}
        };

        H08 = new AbstractAction("Landing on Property you already own", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("If you already own the space you land on, "
        				+ "you pay no rent. You can finish your turn as "
        				+ "normal.");
        	}
        };

        H09 = new AbstractAction("Landing on other’s owned VIA", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("There are 4 VIAs in this game. The amount"
        				+ " of rent due for landing on a VIA owned by "
        				+ "someone else will change depending upon how "
        				+ "many VIAs that player owns at that time. Rent "
        				+ "is as follows: 1 owned - $25, 2 owned - $50, 3"
        				+ " owned - $100, 4 owned - $200.  There are no "
        				+ "Villa or Pantheon upgrades for railroads.");
        	}
        };

        H10 = new AbstractAction("Landing on other’s owned Utility", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("There are two utilities in this game, the"
        				+ " Aqueducts or the Sewers. They can be purchased"
        				+ " and mortgaged like any other property. However,"
        				+ " they do not have Villas or Pantheons. Rent on a"
        				+ " utility is paid by multiplying the die roll by "
        				+ "4 if the owner has just one utility, and "
        				+ "multiplying by 10 if he or she has both. This is"
        				+ " the die roll that forced the player to land on "
        				+ "a utility, and will automatically be calculated "
        				+ "and transferred.");
        	}
        };

        H11 = new AbstractAction("Landing on Chance", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When landing on Chance the top card of a "
        				+ "shuffled Chance Deck is shown to the player. "
        				+ "Whatever the card says, must be done immediately."
        				+ " If the card directs you to go to a specific "
        				+ "space and you pass or land on Rome moving c"
        				+ "lockwise, you will receive $200 for passing or "
        				+ "landing on Rome. However, if the card says to go "
        				+ "to The Arena, as stated on the card, you will not"
        				+ " collect $200 for passing Rome.");
        	}
        };

        H12 = new AbstractAction("Landing on Community Chest", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When landing on Chance the top card of a "
        				+ "shuffled Chance Deck is shown to the player.  "
        				+ "Whatever the card says, must be done immediately."
        				+ " If the card directs you to go to a specific "
        				+ "space and you pass or land on Rome moving "
        				+ "clockwise, you will receive $200 for passing or "
        				+ "landing on Rome. However, if the card says to go "
        				+ "to The Arena, as stated on the card, you will not"
        				+ " collect $200 for passing Rome.");
        	}
        };

        H13 = new AbstractAction("Landing on Citizen’s Tax", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Landing on this space will automatically "
        				+ "deduct $100, which is paid to the bank.");
        	}
        };

        H14 = new AbstractAction("Landing on Render Unto Ceasar", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Landing on this space will automatically "
        				+ "deduct $200, which is paid to the bank.");
        	}
        };

        H15 = new AbstractAction("Landing on Free Market", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Landing on this space cost no rent, and "
        				+ "forces no additional actions. You can finish "
        				+ "your turn as normal.");
        	}
        };

        H16 = new AbstractAction("Landing space decisions", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you land on a space, you will need "
        				+ "to take the appropriate action for that space"
        				+ ". Please refer to Movement and the specific "
        				+ "space for more detail.");
        	}
        };

        H17 = new AbstractAction("Property Management", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("There are many property management "
        				+ "options depending upon what you and others "
        				+ "currently own. Please refer to specific "
        				+ "actions in the Property Management section of"
        				+ " the Help Menu.");
        	}
        };

        H18 = new AbstractAction("End Turn", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you are ready to end your turn, "
        				+ "click the End Turn button near the bottom "
        				+ "right");
        	}
        };
        
        H19 = new AbstractAction("General", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Where you land on the board will "
        				+ "change the options that appear to you on "
        				+ "this turn. For information about a "
        				+ "specific space, please refer to the user "
        				+ "manual or help – board space section. "
        				+ "Choose the type of space from the help "
        				+ "menu for additional help.");
        	}
        };

        H20 = new AbstractAction("The Arena", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("If you land on The Arena, you are "
        				+ "just watching a battle. You will not pay "
        				+ "rent or fees, and you can finish your "
        				+ "turn as normal.\n\nYou can continue your "
        				+ "next turn as normal as well. However, if "
        				+ "you are sent to The Arena, you are stuck "
        				+ "inside and end your turn immediately. You"
        				+ " also do not collect $200, even if you "
        				+ "pass Rome to get to The Arena.\n\nYou "
        				+ "will need to roll a double (both dice "
        				+ "roll to the same number) in order to be "
        				+ "released free of charge. If you fail to "
        				+ "roll a double on your first or second "
        				+ "attempt, you will end your turn without "
        				+ "moving. Upon a third failed attempt to "
        				+ "roll a double, you will pay $50 to be "
        				+ "released from The Arena.\n\nWhen you are"
        				+ " released from The Arena, you will move "
        				+ "the number of spaces that you rolled. If"
        				+ " you rolled doubles to get out, you will"
        				+ " not roll again.");
        	}
        };
        
        H21 = new AbstractAction("Upgrading Property – Buying Villas"
        		+ " or Pantheons", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("When you own all of the properties of"
        				+ " a specific color, you own a monopoly. You"
        				+ " can now upgrade these properties by "
        				+ "purchasing a Villa or Pantheon. Each space"
        				+ " of a color group must have the same "
        				+ "number of Villas before any of them can be"
        				+ " further upgraded. After 4 Villas exist in"
        				+ " all of the properties of a color group, "
        				+ "you can upgrade to a Pantheon. You cannot "
        				+ "upgrade beyond Pantheon for any property.");
        	}
        };

        H22 = new AbstractAction("Mortgage your property", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("A property can be mortgaged if you "
        				+ "cannot afford rent of any other payment "
        				+ "due. You cannot mortgage a property that "
        				+ "currently has Villas or a Pantheon. You "
        				+ "will first need to downgrade the property "
        				+ "group to an unimproved state, which may "
        				+ "provide the funds you seek without a "
        				+ "mortgage.");
        	}
        };

        H23 = new AbstractAction("Buying another player’s mortgaged "
        		+ "property", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("A player may purchase another "
        				+ "player’s mortgaged property at an agreed "
        				+ "upon price. See Trade Property for more "
        				+ "details. The new owner of a mortgaged "
        				+ "property must immediately pay off the "
        				+ "mortgage, or pay %10 of the mortgage price"
        				+ ". See Pay off your mortgaged property for "
        				+ "more details. If you choose to pay 10% of "
        				+ "the mortgage, this amount is paid to the "
        				+ "bank immediately.");
        	}
        };

        H24 = new AbstractAction("Pay off your mortgaged property", 
        		null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("To pay off your mortgaged property, "
        				+ "you must pay the bank the mortgage amount "
        				+ "listed on the property, plus 10% interest.");
        	}
        };

        H25 = new AbstractAction("Downgrading Property – Selling "
        		+ "Villas or Pantheons ", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Downgrading your property involves "
        				+ "selling your existing Villas and/or "
        				+ "Pantheons for a color group. This must be"
        				+ " done equally amongst the color group, "
        				+ "the reverse of how it was upgraded. The "
        				+ "bank will pay the player half the cost of"
        				+ " a Villa or Pantheon when selling it.");
        	}
        };

        /*   Quick template for new action
        H## = new AbstractAction("Item_Text_Here", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("Output_this_text_to_the_textbox");
        	}
        };
         */
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(true);
	}
	
}