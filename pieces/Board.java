//Loading the Background image of the board

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Board extends JFrame {
	public Board() {
	setTitle("Monopoly");
	setSize(1024,750);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("src/pieces/board.jpg"));
	add(background);
	background.setLayout(new FlowLayout());

	// Just for refresh
	setSize(1023,749);
	setSize(1024,750);
	}
}
