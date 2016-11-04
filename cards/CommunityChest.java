package cards;
import java.util.Random;
//For Community Chest Cards & images

import events.Players;

public class CommunityChest {
	Players thePlayer = new Players();     //need position, balance, oj, k & j counters
	int PrevPos = thePlayer.getPosition(); //player's current position
	int PrevBal = thePlayer.getBalance();  //player's current balance
	int Outjail = thePlayer.getOutJail();  //get out of jail counter
	int jail = thePlayer.getJail();        //in jail, cannot pass go if(j=0)
	
	private int chestno;
	private String imgname;
	private int adjust;
	private String outcome;
	Random ches = new Random();
	public CommunityChest() {
		heartofcards(); //pick card
	}
	public CommunityChest(int chestno, String imgname, String outcome, int adjust) {
		this.chestno = chestno;
		this.imgname = imgname;
		this.outcome = outcome;
		this.adjust = adjust;
	}
	public void heartofcards() {
		chestno = ches.nextInt(16) + 1;
		imgname = "src/cards/images/Chest"+chestno+".PNG"; // src/cards/images/Chest1-16.PNG
		if (jail == 0) {
			//chestno 1-16
			if (chestno == 1) {
				outcome = "Bank error in your favor. Collect $200.";
				PrevBal += 200;
			}
			if (chestno == 2) {
				outcome = "Pay private physician fees of $100.";
				PrevBal -= 100;
			}
			if (chestno == 3) {
				outcome = "From sale of merchant carts, you get $50.";
				PrevBal += 50;
			}
			if (chestno == 4) {	
				outcome = "You inherit a small Villa, gain $100.";
				PrevBal += 100;
			}
			if (chestno == 5) {
				jail = 1;
				outcome = "Go to the Gladiatorial Arena. Go directly to the arena, DO NOT pass Rome, DO NOT collect $200.";
			}
			if (chestno == 6) {
				PrevPos = 0;
				outcome = "Advance to Rome. Collect $200.";
				PrevBal += 200;
			}
			if (chestno == 7) {
				outcome = "Render too much unto Caesar, Collect $200.";
				PrevBal += 200;
			}
			if (chestno == 8) {
				outcome = "Roman official assesses you for street repairs: $40 per villa, $115 per pantheon.";
				PrevBal -= 100; //needs to be: 40(villa), 115(pantheon)
			}
			if (chestno == 9) {
				outcome = "You have won the second price in the Campus Track & Field foot race. Collect $10.";
				PrevBal += 10;
			}
			if (chestno == 10) {
				outcome = "Your properties and assets mature, join the Equestrian Order. Collect $100.";
				PrevBal += 100;
			}
			if (chestno == 11) {
				outcome = "Sell bulk staples to the bank, receive $100.";
				PrevBal += 100;
			}
			if (chestno == 12) {
			outcome = "Pay farmer's tax of $25.";
			PrevBal -= 25;
			}
			if (chestno == 13) {
			outcome = "You have a coming of age party, Collect $10 from every player.";
			PrevBal += 10; //needs to be per player array
			}
			if (chestno == 14) {
			outcome = "Pay school fees of $50.";
			PrevBal -= 50;
			}
			if (chestno == 15) {
			outcome = "Medical institution fees, pay $50.";
			PrevBal -= 50;
			}
			if (chestno == 16) {
				Outjail++;
				outcome = "Gain a favor with a Senator, get out of the Gladiatorial Area for free. This card may be kept until needed or traded.";
			}
			thePlayer.setPosition(PrevPos); //set Player position, counters & balance
			thePlayer.setBalance(PrevBal);
			thePlayer.setJail(jail);
			thePlayer.setOutJail(Outjail);
		}
	}
	public int getChestNo() {return chestno;}
	public String getImgName() {return imgname;} 
	public String getOutcome() {return outcome;}
	public int getAdjust() {return adjust;}
}