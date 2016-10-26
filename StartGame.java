//start the game


import menu.MainMenu;
import tile.Properties;
import tile.Utilities;
import tile.Vias;

public class StartGame {
	//main
	Properties [] regions = {
            new Properties(1,"Germania Inferior", 1, 60, 30, 0, 0, 0, 2, 4),
            new Properties(3,"Germania Superior",1,60,30,0,0,0,4,8),
            new Properties(6,"Alps Poeniae",2,100,50,0,0,0,6,12),
            new Properties(8,"Alps Cottiae",2,100,50,0,0,0,6,12),
            new Properties(9,"Alps Maritimae",2,120,60,0,0,0,8,16),
            new Properties(12,"Aquitina",3,140,70,0,0,0,10,20),
            new Properties(13,"Belgice",3,140,70,0,0,0,10,20),
            new Properties(15,"Raetia",3,160,80,0,0,0,12,24),
            new Properties(17,"Africa Proconsularis",4,180,90,0,0,0,14,28),
            new Properties(19,"Asia",4,180,90,0,0,0,14,28),
            new Properties(20,"Britannia",4,200,100,0,0,0,16,32),
            new Properties(22,"Cilicia",5,220,110,0,0,0,18,32),
            new Properties(24,"Galatia",5,220,110,0,0,0,18,32),
            new Properties(25,"Cappadocia",5,240,120,0,0,0,20,40),
            new Properties(27,"Aegyptus",6,260,130,0,0,0,22,44),
            new Properties(28,"Arabia Petraea",6,260,130,0,0,0,22,44),
            new Properties(30,"Suria",6,280,140,0,0,0,24,48),
            new Properties(32,"Macedonia",7,300,150,0,0,0,26,52),
            new Properties(33,"Epirus",7,300,150,0,0,0,26,52),
            new Properties(35,"Achaia",7,320,160,0,0,0,28,56),
            new Properties(38,"Sicilia",8,350,175,0,0,0,35,70),
            new Properties(40,"Italia",8,400,200,0,0,0,50,100),
        };  //Pos,"Name",rent,buy,mortgage,
    Vias [] roads = {
        new Vias(5,"Via Appia",10,200,100,0,0,0,0,0),
        new Vias(16,"Via Flaminia",10,200,100,0,0,0,0,0),
        new Vias(26,"Via Aemilia",10,200,100,0,0,0,0,0),
        new Vias(36,"Via Popilia",10,200,100,0,0,0,0,0),
    };
    Utilities [] services = {
            new Utilities(13,"Sewers",10,150,75,0),
            new Utilities(29,"Aquaducts",10,150,75,0),
    };
    
	public static void main(String args[]) {   
	new MainMenu(); //open menu page
	
	}
}