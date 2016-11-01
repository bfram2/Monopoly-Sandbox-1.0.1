package pieces;
import java.util.Random;

public class Dice {
	//JButton roll;
	private int die1;   // first die
    private int die2;   // second die
    private int diet;   // total die
    Random dice = new Random();
	
        public Dice() {
            roll(); 
        	//die1 = dice.nextInt(6) + 1;
            //die2 = dice.nextInt(6) + 1;
            //diet = die1 + die2;
        }
        
        public void roll() {
                // Roll the dice by setting each of the dice to be
                // a random number between 1 and 6.
        	
            //die1 = (int)(Math.random()*6) + 1;
        	//die2 = (int)(Math.random()*6) + 1;
        	die1 = dice.nextInt(6) + 1;
            die2 = dice.nextInt(6) + 1;
            diet = die1 + die2;
        }
        public int getDie1() {
        	return die1;
        }
        
        public int getDie2() {
        	return die2;
        }
        
        public int getTotal() {
              // Return the total showing on the two dice.
           return diet;
        }
}
