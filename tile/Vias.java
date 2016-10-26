package tile;
import pieces.*;


	public class Vias{

		private int tileNumber;
		private String name;
		private int group;
		private int cost;
		private int mortgage;
		private int owner;
		
		public Vias(int tileNumber,String name, int group,int cost,int mortgage,int owner,int singleRent,int doubleRent,int tripleRent,int quadRent){
			//tileNumber is the number of the property in order starting with Go as 0
			//name is the name of the property
			//group is the color grouping which have been assigned numbers 1-10
			//cost is the initial purchase price
			//mortgage is the amount a player can have added to their bank by mortgaging the property
			//owner is the player that owns the property with 0 as the default no owner/bank owned
			
			tileNumber = this.tileNumber;
			name = this.name;
			group = this.group;
			cost = this.cost;
			mortgage = this.mortgage;
			owner = this.owner;
			singleRent = 100;
			doubleRent = 200;
			tripleRent = 300;
			quadRent = 300;
		}
		public static int getTile(Vias[] holder, int index){
			Vias findByIndex = holder [index];
			int t = findByIndex.tileNumber;
			return t;
		}
		public static String getName(Vias[] holder, int index){
			Vias findByIndex = holder [index];
			String n= findByIndex.name;
			return n;
		}
		public static int getGroup(Vias[] holder, int index){
			Vias findByIndex = holder [index];
			int g = findByIndex.group;
			return g;
		}
		public static int getCost(Vias[] holder, int index){
			Vias findByIndex = holder [index];
			int c= findByIndex.cost;
			return c;
		}
		public static int getMortgage(Vias[] holder, int index){
			Vias findByIndex = holder [index];
			int m= findByIndex.mortgage;
			return m;
		}
		public static int getOwner(Vias[] holder, int index){
			Vias findByIndex = holder [index];
			int o = findByIndex.owner;
			return o;
		}
}
