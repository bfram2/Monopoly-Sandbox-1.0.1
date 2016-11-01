package pieces;
// 8 Tokens and their movement across the board
// Tokens: 8 in pieces/images/Token_[].png

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import events.Players;
import javax.swing.*;

public class Tokens extends JPanel {
	private static final long serialVersionUID = 1L;
	Players thePlayer = new Players();
   public Tokens() {
	   JLabel token1 = new JLabel(new ImageIcon("src/pieces/images/"+thePlayer.getToken()));
       add(token1);
   }
}