// 2 6-sided dice rolls
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 2 random numbers between 1-6 to simulate dice
public void roll() {
  int d6result = 0;
  int d6result2 = 0;
  JLabel d6one = new JLabel(getter.getIcon("dice1.jpeg")); //create images later
  JLabel d6two = new JLabel(getter.getIcon("dice1.jpeg"));
  JButton button = new JButton("Roll");
  JLabel text = new JLabel("Two");
  JFrame window = new JFrame("Roll the dice");
  Container cp = window.getContentPane();
  
  d6result = (int)(Math.random() * 6) + 1;
  d6result2 = (int)(Math.random() * 6) + 1;
  int d6move = d6result + d6result2;
  //debugging: System.out.println("Roll: total= " + d6move)
  //insert call to dice images that match the number
}
//return dice total to move total spaces
public int getValue() {
  
  return d6move;
}

//check for doubles, if true it is a double
public boolean Doubles() {
 return d6result == d6result2 & d6result + d6result2 != 0;
 //check for true, then activate movement using d6move
 //player rolls again or gets out of jail
}
