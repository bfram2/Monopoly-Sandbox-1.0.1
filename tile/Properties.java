package tile;

public class Properties {
	
	private int tileNumber;
	private String name;
	private int group;
	private int cost;
	private int mortgage;
	private int owner;
	private int villas;
	private int pantheons;
	private int singleRent;
	private int groupRent;
	
	
	
	public Properties(int tileNumber,String name, int group,int cost,int mortgage,int owner,int villas,int pantheons,int singleRent,int groupRent){
		//tileNumber is the number of the property in order starting with Go as 0
		//name is the name of the property
		//group is the color grouping which have been assigned numbers 1-10
		//cost is the initial purchase price
		//mortgage is the amount a player can have added to their bank by mortgaging the property
		//owner is the player who currently owns the property, which is broken down into numbers so this will have to reflect somewhere in the player class
		//houses is the number of houses on the property defaulted to 0
		//hotels is the number of hotels on the property defaulted to 0
		//rent is the amount of rent for the single property without houses, hotels or grouping bonus
		tileNumber = this.tileNumber;
		name = this.name;
		group = this.group;
		cost = this.cost;
		mortgage = this.mortgage;
		owner = this.owner;
		villas = this.villas;
		pantheons = this.pantheons;
		singleRent = this.singleRent;
		groupRent =this.groupRent;
	}
	public static int getTile(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int tn= findByIndex.tileNumber;
		return tn;
	}
	public static String getName(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		String n= findByIndex.name;
		return n;
	}
	public static int getGroup(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int g= findByIndex.group;
		return g;
	}
	public static int getCost(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int c= findByIndex.cost;
		return c;
	}
	public static int getMortgage(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int m= findByIndex.mortgage;
		return m;
	}
	public static int getOwner(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int o = findByIndex.owner;
		return o;
	}
	public static int getVillas(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int v= findByIndex.villas;
		return v;
	}
	public static int getPantheons(Properties[] holder, int index){
		Properties findByIndex = holder [index];
		int p= findByIndex.pantheons;
		return p;
	}
}
