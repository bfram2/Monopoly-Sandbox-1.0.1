package events;
//Player turn and movement
import pieces.*; //board,dice,images
import tile.*; properties, utilities, vias
import events.Players;
import java.util.*;

public class Turn {
	int tdplimg; //title deed cards index in tile package
	int titledeed;
	int dice1 = 0;   //dice class
	int dice2 = 0;   //0 is no visible dice image
	int Prev;    //position
	int Pos;     //new position
	int j = 0;   //jail
	int k = 0;   //doubles
	int money;   //pull adjust into it from chance and chest
	int Bal;     //output to players as(Bal - money)
	String statustxt; //Pos status text
	int checard;      //theChance.getChanceNo
	String chaimg;    //         .getImgName
	String chaout;    //         .getOutcome
	int chaadj;       //         .getAdjust
	int checard;      //theChest.getChestNo
	String cheimg;    //        .getImgName
	String cheout;    //        .getOutcome
	int cheadj;       //        .getAdjust
	Players thePlayer = new Players(); //add Player to board
	
	public Turn() {
		TurnAction(); //activate player turn
		
	}
	public Turn(int tdplimg, int Pos, String statustxt) {
		this.tdplimg = tdplimg;
		this.Pos = Pos;
		this.statustxt = statustxt;
	}
	public void TurnAction() {
		for (int i=0; i<1; i++) {
		Prev = thePlayer.getPosition();
		tdplimg = 28; //blank slate
		money = 0;
		int[] jail = new int[4];
		int[] doubles = new int[3]; //test for errors when doubles > 3
		
		Dice theDice = new Dice();
	    dice1 = theDice.getDie1();
	    dice2 = theDice.getDie2();
		Pos = (Prev + dice1 + dice2) % 40; //token position
		thePlayer.setPosition(Pos); //set position early for Chance & Chest
		
		//Properties[] regions
		//if (Properties[Pos].tileNumber == Pos) {
		//Properties[Pos].name;
		//Properties[Pos].imgname;
		//}
		//if (Vias[Pos].tileNumber == Pos) {
		//Vias[Pos].name;
		//Vias[Pos].imgname;
		//}
		//if (Utilities[Pos].tileNumber == Pos) {
		//Utilities[Pos].name;
		//Utilities[Pos].imgname;
		//}
		
		Chance theChance = new Chance(); //chance class
		chacard = theChance.getChanceNo();
		chaimg = theChance.getImgName();
		chaout = theChance.getOutcome();
		chaadj = theChance.getAdjust();
		
		CommunityChest theChest = new CommunityChest(); //community class
		checard = theChest.getChestNo();
		cheimg = theChest.getImgName();
		cheout = theChest.getOutcome();
		cheadj = theChest.getAdjust();
		
		j = j % 4; //jail 0 not, 4 leave
	    k = (dice1 == dice2) ? k + 1 : 0; //if matching: k++
		k = k % 3; //doubles 0 none, 3 jail
		
		if (k == 1) {
		statustxt = "Doubles! Roll again.";
		//disable all, but rolling in board
		}
		if (k > 2 && k < 1) {
			statustxt = "You have rolled doubles 3 times, Go to the Arena.";
			Pos = 11; //go to the arena
			k = 0;    //roll doubles within 3 turns
		}
		if (j == 0) {
	    	if (Prev < 10 && Pos > 10) {
				Pos+= 1;
				if (Pos > 39) {
					Pos = 40 - Pos; //don't go out of bounds
				}
				thePlayer.setPosition(Pos);
			} //if Pos is less than 10 and will become greater than 10, add one to skip jail (Pos = 11)
			if (Pos != 0) {
			    if ((Prev > Pos) && (j == 0)) {
			    statustxt = "Pass Rome, Collect 200 denarius.";
				money += 200;
			    }
		    } //pass go
			if (Pos == 0) {
				statustxt = "Enter Rome, Collect 200 denarius.";
				money += 200;
			} //Rome
			if (Pos == 1) {
				statustxt = "Germania Inferior.";
				titledeed = 0; //properties[Pos].name;
				tdplimg = 0;   //properties[Pos].imgname;
			} //Germania Inferior
			if (Pos == 3) {
				titledeed = 1;
			} //Germania Superior
			if (Pos == 4) {
				money += 200; 
			} //Render unto Ceasar
			if (Pos == 5) {titledeed = 24;}  //Via Appia
	    	if (Pos == 6) {titledeed = 2;}   //Alpes Poeniae
			if (Pos == 8) {titledeed = 3;}   //Alpes Cottiae
			if (Pos == 9) {titledeed = 4;}   //Alpes Maritimae
			if (Pos == 11) {Pos = 10;} //add objects below this to update Pos
			if (Pos == 10) {statustxt = "See a battle.";} //see a battle
			if (Pos == 12) {titledeed = 5;}  //Aquitania
			if (Pos == 13) {titledeed = 22;} //Sewers
			if (Pos == 14) {titledeed = 6;}  //Belgica
			if (Pos == 15) {titledeed = 7;}  //Raetia
			if (Pos == 16) {titledeed = 25;} //Via Flaminia
			if (Pos == 17) {titledeed = 8;}  //Africa Proconsularis
			if (Pos == 19) {titledeed = 9;}  //Asia
			if (Pos == 20) {titledeed = 10;} //Britannia
			if (Pos == 21) {statustxt = "Free market.";} //free market
			if (Pos == 22) {titledeed = 11;} //Cilicia
			if (Pos == 24) {titledeed = 12;} //Galatia
			if (Pos == 25) {titledeed = 13;} //Cappadocia
			if (Pos == 26) {titledeed = 26;} //Via Aemilia
			if (Pos == 27) {titledeed = 14;} //Aegyptus
			if (Pos == 28) {titledeed = 15;} //Arabia Petraea
			if (Pos == 29) {titledeed = 23;} //aqueducts
			if (Pos == 30) {titledeed = 16;} //Syria
			if (Pos == 31) {
				statustxt = "Go to the Arena.";
				Pos = 11;
	    		j = 1;
			}
			if (Pos == 32) {titledeed = 17;} //Macedonia
			if (Pos == 33) {titledeed = 18;} //Epirus
			if (Pos == 35) {titledeed = 19;} //Achaia
			if (Pos == 36) {titledeed = 27;} //Via Popillia
			if (Pos == 38) {titledeed = 20;} //Sicilia
			if (Pos == 39) {
				money = 100;
				statustxt = "Citizen's Tax";
			}
			if (Pos == 40) {titledeed = 21;} //Italia
			if (Pos == 2 || Pos == 18 || Pos == 34) {
				money += adjust; //add to money, logic: chance > turn > player
				statustxt = "Draw a Community Chest card. "+chaout;
			} //chest card
			if (Pos == 7 || Pos == 23 || Pos == 37) {
				money += adjust;
				statustxt = "Draw a Chance card."+cheout;
			} //chance card
			
		} //j=0; if not in jail
		if(j > 0 && j < 4) {
			Pos = 11;
			statustxt = "You are in the Arena. Turns until free: "+(4-j);
			j++;
			if (k == 1) {
				statustxt = "You rolled a double, escape the Arena.";
				j = 0;
			}
		}
		if (j > 3) {
			statustxt = "You paid a fine, leave the Arena.";
			money += -50;
			j = 0;
		}
		if (k > 3) {
			k = 4 - k;
		} //keep doubles from going out of bounds
		jail[j]++;
	    doubles[k]++;
		Bal += money;
		thePlayer.setDoubles(k); //doubles counter
		thePlayer.setJail(j); //jail counter
		thePlayer.setBalance(Bal); //player balance
		
		if (Bal == 0) {
			statustxt = "Game over.";
		}
		
		} //end of loop
	} //end of turn
	//gets: tdplimg, Pos, statustxt
	public int getTdplimg() {return tdplimg;}
	public int getPos() {return Pos;}
	public String getStatustxt() {return statustxt;}
}