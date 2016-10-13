//Loading the Background image of the board
package pieces;
import javax.swing.*;
import java.awt.*;


public class Board extends JFrame {
	public Board() {
	setTitle("Board");
	setSize(1024,1044);
	getContentPane();
	setLocationRelativeTo(null);
	//debugging size by content
	//pack();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	add(background);
	background.setLayout(new FlowLayout());
	
	// refresh to add JLabel
	setSize(1023,1043);
	}
}
