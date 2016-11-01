package tile;
import pieces.*;


public class Utilities {

	private int tileNumber;
	private String name;
	private String imgname;
	private int group;
	private int cost;
	private int mortgage;
	private int owner;
	
	public Utilities(int tileNumber, String name, String imgname, int group, int cost, int mortgage, int owner){
		//tileNumber is the number of the property in order starting with Go as 0
		//name is the name of the property
		//group is the color grouping which have been assigned numbers 1-10
		//cost is the initial purchase price
		//mortgage is the amount a player can have added to their bank by mortgaging the property
		//owner is the player that owns the property with 0 as the default no owner/bank owned
		
		tileNumber = this.tileNumber;
		name = this.name;
		imgname = this.imgname;
		group = this.group;
		cost = this.cost;
		mortgage = this.mortgage;
		owner = this.owner;
	}
	public static int getTile(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		int t = findByIndex.tileNumber;
		return t;
	}
	public static String getName(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		String n= findByIndex.name;
		return n;
	}
	public static String getImgName(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		String in= findByIndex.imgname;
		return in;
	}
	public static int getGroup(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		int g = findByIndex.group;
		return g;
	}
	public static int getCost(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		int c= findByIndex.cost;
		return c;
	}
	public static int getMortgage(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		int m= findByIndex.mortgage;
		return m;
	}
	public static int getOwner(Utilities[] holder, int index){
		Utilities findByIndex = holder [index];
		int o = findByIndex.owner;
		return o;
	}
	public static int calcSingleRent(Dice currentRoll){
		int totalValue = currentRoll.getTotal();
		int singleRent = totalValue * 4;
		return singleRent;
	}
	public static int calcGroupRent(Dice currentRoll){
		int totalValue = currentRoll.getTotal();
		int groupRent = totalValue * 10;
		return groupRent;
	}
}
