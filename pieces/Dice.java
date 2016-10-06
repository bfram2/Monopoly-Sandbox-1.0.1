// 2 6-sided dice rolls
//outputs text only, no images right now
package pieces;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.ImageIcon;
  
class Dice {
	//JButton roll;
	static int die1;   // Number showing on the first die.
    static int die2;   // Number showing on the second die.
    static int diet;   // Number showing on the total die.
	
        public Dice() {
        	//JLabel dice1 = new JLabel(new ImageIcon("src/DiceImages/Dice1.png"));
        	//JLabel dice2 = new JLabel(new ImageIcon("src/DiceImages/Dice2.png"));
        	//add(dice1);
        	//add(dice2);
        	
        	//roll = new JButton("Roll");
        	//JFrame window = new JFrame("Roll the dice");

        
                // Constructor.  Rolls the dice, so that they initially
                // show some random values.
            roll();  // Call the roll() method to roll the dice.
        }
        
        public void roll() {
                // Roll the dice by setting each of the dice to be
                // a random number between 1 and 6.
            die1 = (int)(Math.random()*6) + 1;
            die2 = (int)(Math.random()*6) + 1;
            diet = die1 + die2;
           
        }
                 
        public int getDie() {
              // Return the number showing on the first die.
           return die1 + die2;
           
        }
        
        public int getTotal() {
              // Return the total showing on the two dice.
           return diet;
        }

     
     public static void main(String args[]) {
 		new Dice(); //open menu page
 		System.out.println("Dice 1: "+die1);
 		System.out.println("Dice 2: "+die2);
 		System.out.println("Dice Total: "+diet);
 		if (die1 == die2) {
 			System.out.println("Doubles! Roll again.");
 			//turn active listener to true and wait for button to roll again
        }
 		else {
 			System.out.println("Move to next phase or end turn.");
 			//buy, pay, draw, end
 			}
 		}
     } 
