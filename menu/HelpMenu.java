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
	Action H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, H11, H12, H13, H14, H15, 
	H16, H17, H18, H19, H20, H21, H22, H23, H24, H25, H26, H27;
	
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
        helpMenuItem.setAction(H1);
        //Set Shortcut key
        helpMenuItem.setMnemonic(KeyEvent.VK_H);
        //add menu item to the menu
        helpMenu.add(helpMenuItem);

        helpMenu.addSeparator();
        
        //Movement Sub-menu
        helpSubmenu = new JMenu("Movement");
        helpSubmenu.setMnemonic(KeyEvent.VK_M);
        
        // First item
        helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H2);
        helpMenuItem.setMnemonic(KeyEvent.VK_D);
        helpSubmenu.add(helpMenuItem);
        
        // Second item
        helpMenuItem = new JMenuItem();
        helpMenuItem.setAction(H3);
        helpMenuItem.setMnemonic(KeyEvent.VK_R);
        helpSubmenu.add(helpMenuItem);
        
        // Add movement sub-menu to main help menu.
        helpMenu.add(helpSubmenu);
        
        //Next would be a new Sub-menu...
		
        // provide the entire help menu bar with menus, sub-menus, and menu items
        // at exit of this class
        return helpMenuBar;
    }

	public void createActions() {
		//All of the actions that occur when selecting the various menu items.
        H1 = new AbstractAction("How do I win this game?", null) {
        	public void actionPerformed(ActionEvent e1) {
        		output.setText("The object of the game is to have the most "
        				+ "money compared to any other player by buying, renting"
        				+ ", and selling property (MB Source cited).  The game "
        				+ "will end when any player reaches 0 remaining funds.  "
        				+ "The winner is the player with the most money at that "
        				+ "point.");
        	}
        };
        
        H2 = new AbstractAction("Rolling Dice and moving your token", null) {
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
        
        H3 = new AbstractAction("Passing or landing on Rome!", null) {
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
	}
	
	public void actionPerformed(ActionEvent e) {
		// close help menu
		this.setVisible(true);
	}
}