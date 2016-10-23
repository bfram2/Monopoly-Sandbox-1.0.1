package events;

//Switch between player and computer player
//Pricing properties Buy/Mortgage
public class BuyProperty {
private String property;
private int price;
private int mortgage;
private int rent;
private int owner;
String prop;

	public BuyProperty() {
        property = "";    //board[Pos]
        price = 0;        
        rent = 0;         //build 2
        mortgage = 0;     
        owner = 0;		//zero means it belongs to the bank
        prop = (property+price+rent+mortgage+owner);
	}
	
	public BuyProperty(String property, int price, int mortgage, int rent, int owner) {
	        this.property = property;
	        this.price = price;
	        this.mortgage = mortgage;
	        this.rent = rent;
	        this.owner = owner;
	}
	
	public String getProperty() {return property;}
	public void setProperty(String property) {this.property = property;}
	
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	
	public int getMortgage() {return mortgage;}
	public void setMortgage(int mortgage) {this.mortgage = mortgage;}
	
	public int getRent() {return rent;}
	public void setRent(int rent) {this.rent = rent;}
	
	public int getOwner() {return owner;}
	public void setOwner(int owner) {this.owner = owner;}
}

/*
0: Mediterranean Avenue = Germania Inferior ($60, $30 mortgaged)
1:	Baltic Avenue = Germania Superior ($60, $30 mortgaged)

2:	Oriental Avenue = Alpes Poeniae ($100, $50 mortgaged)
3:	Vermont Avenue = Alpes Cottiae ($100, $50 mortgaged)
4:	Connecticut Avenue = Aples Maritimae ($120, $60 mortgaged)

5:	St. Charles Place = Aquitania ($140, $70 mortgaged)
6:	States Avenue = Belgica ($140, $70 mortgaged)
7:	Virginia Avenue = Raetia ($160, $80 mortgaged)

8:	St. James Place = Africa Proconsularis ($180, $90 mortgaged)
9:	Tennessee Avenue = Asia ($180, $90 mortgaged)
10:	New York Avenue = Britannia ($200, $100 mortgaged)

11:	Kentucky Avenue = Cilicia ($220, $110 mortgaged)
12:	Indiana Avenue = Galatia ($220, $110 mortgaged)
13:	Illinois Avenue = Cappadocia ($240, $120 mortgaged)

14:	Atlantic Avenue = Aegyptus ($260, $130 mortgaged)
15:	Ventnor Avenue = Arabia Petraea ($260, $130 mortgaged)
16:	Marvin Gardens = Syria ($280, $140 mortgaged)

17:	Pacific Avenue = Macedonia ($300, $150 mortgaged)
18:	North Carolina Avenue = Epirus ($300, $150 mortgaged)
19:	Pennsylvania Avenue = Achaia ($320, $160 mortgaged)

20:	Park Place = Sicilia ($350, $175 mortgaged)
21:	Boardwalk = Italia ($400, $200 mortgaged)

22: Sewers $150 price, $75 mortgaged
23: Aqueducts $150 price, $75 mortgaged

24: Via Appia $200 price, $100 mortgaged
25: Via Flaminia
26: Via Aemilia
27: Via Popillia

*/
