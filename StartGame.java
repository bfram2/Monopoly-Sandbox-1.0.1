//start the game
import menu.MainMenu;
import tile.Properties;
import tile.Utilities;
import tile.Vias;

public class StartGame {
	//main
	Properties [] regions = {
            new Properties(1,"Germania Inferior","Purple_GermaniaI.PNG", 1, 60, 30, 0, 0, 0, 2, 4),
            new Properties(3,"Germania Superior","Purple_GermaniaS.PNG",1,60,30,0,0,0,4,8),
            new Properties(6,"Alps Poeniae","BBlue_APoeniae.PNG",2,100,50,0,0,0,6,12),
            new Properties(8,"Alps Cottiae","BBlue_ACottiae.PNG",2,100,50,0,0,0,6,12),
            new Properties(9,"Alps Maritimae","BBlue_AMaritimae.PNG",2,120,60,0,0,0,8,16),
            new Properties(12,"Aquitina","DPink_Aquitania.PNG",3,140,70,0,0,0,10,20),
            new Properties(13,"Belgice","DPink_Belgica.PNG",3,140,70,0,0,0,10,20),
            new Properties(15,"Raetia","DPink_Raetia.PNG",3,160,80,0,0,0,12,24),
            new Properties(17,"Africa Proconsularis","Orange_AProconsularis.PNG",4,180,90,0,0,0,14,28),
            new Properties(19,"Asia","Orange_Asia.PNG",4,180,90,0,0,0,14,28),
            new Properties(20,"Britannia","Orange_Britannia.PNG",4,200,100,0,0,0,16,32),
            new Properties(22,"Cilicia","Red_Cilicia.PNG",5,220,110,0,0,0,18,32),
            new Properties(24,"Galatia","Red_Galatia.PNG",5,220,110,0,0,0,18,32),
            new Properties(25,"Cappadocia","Red_Cappadocia.PNG",5,240,120,0,0,0,20,40),
            new Properties(27,"Aegyptus","Yellow_Aegyptus.PNG",6,260,130,0,0,0,22,44),
            new Properties(28,"Arabia Petraea","Yellow_APetraea.PNG",6,260,130,0,0,0,22,44),
            new Properties(30,"Suria","Yellow_Syria.PNG",6,280,140,0,0,0,24,48),
            new Properties(32,"Macedonia","Green_Macedonia.PNG",7,300,150,0,0,0,26,52),
            new Properties(33,"Epirus","Green_Epirus.PNG",7,300,150,0,0,0,26,52),
            new Properties(35,"Achaia","Green_Achaia.PNG",7,320,160,0,0,0,28,56),
            new Properties(38,"Sicilia","Blue_Sicilia.PNG",8,350,175,0,0,0,35,70),
            new Properties(40,"Italia","Blue_Italia.PNG",8,400,200,0,0,0,50,100),
        };  //tileNumber = Pos, name, image name, group, cost, mortgage, owner, villas, pantheons, rent, group rent
			
    Vias [] roads = {
        new Vias(5,"Via Appia","Via_Appia.PNG",10,200,100,0,0,0,0,0),
        new Vias(16,"Via Flaminia","Via_Flaminia.PNG",10,200,100,0,0,0,0,0),
        new Vias(26,"Via Aemilia","Via_Aemilia.PNG",10,200,100,0,0,0,0,0),
        new Vias(36,"Via Popilia","Via_Popillia.PNG",10,200,100,0,0,0,0,0),
    };
    Utilities [] services = {
            new Utilities(13,"Sewers","Utility_Sewers.PNG",10,150,75,0),
            new Utilities(29,"Aquaducts","Utility_Aqueducts.PNG",10,150,75,0),
    };
    
	public static void main(String args[]) {   
	new MainMenu(); //open menu page
	
	}
}
