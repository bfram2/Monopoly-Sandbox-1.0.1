//Switching between Player and Computer Players in the amount choosen in the main menu
//each player starts with 1500 denarius
//Player 1 is first
//Start at Rome
//Roll, move that number of spaces
//buy, pay rent, draw card, pay taxes or go to the arena
//buy villas or pantheon
//end turn button
//Player 2, repeat onward
/* Later may have multiple players with computer players */

package events;
//Switch between player and computer player

public class Players {
	private String name;
	private String token;
	private int position;
	private int balance;
	String player;

	public Players() {
        name = "Player";       //default name, update from menu
        token = "Token_E.png"; //default image, update from menu
        position = 0;          //update from Prev in Board
        balance = 1500;        //update from Bal in Board
        player = (name+token+position+balance);
	}
	public Players(String name, String token, int position, int balance) {
	        this.name = name;
	        this.token = token;
	        this.position = position;
	        this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public String getToken() {
		return token;
	}
	public Integer getPosition() {
		return position;
	}
	public Integer getBalance() {
		return balance;
	}
}