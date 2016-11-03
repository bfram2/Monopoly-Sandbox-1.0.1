package cards;
import java.util.Random;
//import pieces.*;
import events.Players;
//For image Chance Cards and their events

	public class Chance {
		Players thePlayer = new Players();     //need position, balance, oj, k & j counters
		int PrevPos = thePlayer.getPosition(); //player's current position
		int PrevBal = thePlayer.getBalance();  //player's current balance
		int Outjail = thePlayer.getOutJail();  //get out of jail counter
		int jail = thePlayer.getJail();        //in jail, cannot pass go if(j=0)

		private int chanceno;
		private String imgname;
		private int adjust;
		Random chan = new Random();
		public Chance () {
			chanceno = 0;
			imgname = "";
			jail = 0;
		}
		public Chance(int chanceno, String imgname, int adjust) {
			pull(); //pick card
			chanceno = this.chanceno; //chanceno for random rolling 1-16
			imgname = this.imgname; //imgname is the image location
			adjust = this.adjust; //adjust is the amount Player Bal will change by
		}
		public void pull() {
		chanceno = chan.nextInt(16) + 1;
		imgname = "src/cards/images/Chance"+chanceno+".PNG"; //src/cards/images/Chance1-16.PNG
		if (jail == 0) {
			if (chanceno == 1) {
					if (PrevPos > 5) {PrevBal += 200;} //pass go
					PrevPos = 5; //Via Appia
			}
			if (chanceno == 2 || chanceno == 3) {
				if (PrevPos > 35 || PrevPos < 5) {
					PrevPos = 5; //Via Appia
					PrevBal += 200; //pass go
				}
				if (PrevPos > 4 || PrevPos < 16) {
					PrevPos = 16; //Via Flaminia
				}
				if (PrevPos > 15 || PrevPos < 26) {
					PrevPos = 26; //Via Aemilia
				}
				if (PrevPos > 25 || PrevPos < 36) {
					PrevPos = 36; //Via Popillia
				}
			} //nearest Via, if owned: pay 2(rent), if unowned can buy
			if (chanceno == 4) {
				Outjail++; //get out of jail for free
			}
			if (chanceno == 5) {
				if (PrevPos > 28 || PrevPos < 13) {
					PrevPos = 13; //sewers
				}
				if (PrevPos > 12 || PrevPos < 29) {
					PrevPos = 29; //aqueducts
				} 
			} //utilities
			if (chanceno == 6) {
				PrevPos = 0;
				PrevBal += 200;
			} //go to Rome
			if (chanceno == 7) {
				PrevBal += 150; //collect 150
			}
			if (chanceno == 8) {
				PrevPos -= 3; //go back 3 spaces
			}
			if (chanceno == 9) {
				PrevBal -= 100; //fine for now
				//Make general repairs on all of your properties:
				//player's villas times 25
				//player's pantheons times 100
			}
			if (chanceno == 10) {
				PrevPos = 40; //go to Italia
			}
			if (chanceno == 11) {
				PrevBal += 50; //collect 50
			}
			if (chanceno == 12) {
				PrevBal -= 15; //fine of 15
			}
			if (chanceno == 13) {
				PrevPos = 11;
				jail = 1; //go to jail
			}
			if (chanceno == 14) {
					if (PrevPos > 12) {PrevBal += 200;} //pass go
					PrevPos = 12; //Aquitania
			}
			if (chanceno == 15) {
					if (PrevPos > 25) {PrevBal += 200;} //pass go
					PrevPos = 25; //Cappadocia
			}
			if (chanceno == 16) {
				PrevBal -= 50; //fine of 50
			} //pay each player 50 later, count Players array

			thePlayer.setPosition(PrevPos); //set Player position, counters & balance
			thePlayer.setBalance(PrevBal);
			thePlayer.setOutJail(Outjail);
		 } //can't be in jail
		}  //end pull
		public int getChanceNo() {return chanceno;}
		public String getImgName() {return imgname;} 
		public int getAdjust() {return adjust;}
}
	/*
	1.Take a trip to Via Appia. If you pass Rome collect $200.
	2,3. Advance to the nearest Via. If UNOWNED, you may buy it from the Bank. 
	If OWNED, pay owner twice the rental to which they are otherwise entitled.

	4. Gain a favor with a Senator, get out of the Gladiatorial Arena for free. This card may be kept until needed or traded.
	5. Advance to the nearest Utility. If UNOWNED, you may buy it from the Bank. 
	If OWNED, throw dice and pay owner a total ten times amount thrown.

	6. Advance to Rome. Collect $200.
	7. A new road is built near your Villa raising its value, collect $150.
	8. Go back 3 spaces.
	9. Make general repairs on all of your properties: For villa pay $25, For pantheons pay $100.
	10. Advance to Italia.
	11. Recent investment in more merchant carts gains you $50.
	12. Your horses escape into the city. Pay a $15 fine.
	13. Go to the Gladiatorial Arena. Go directly to the arena, DO NOT pass Rome, DO NOT collect $200.
	14. Advance to Aquitania. If you pass Rome, Collect $200.
	15. Advance to Cappadocia. If you pass Rome, Collect $200.
	16. You have been elected a Senator, pay each player $50.
	*/
