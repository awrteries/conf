public class Apartment1 extends Backgrounds{

    public Apartment1(){
        super("assets/backgrounds/1stapt.png", "assets/backgrounds/1staptfrontwalls.png", -30,-30,800,550,0,0);
      
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB1.png", x, y, 385, 266, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB2.png", x, y, 152, 550, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB3.png", x, y+h*2-(98*2), 800, 102, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/red.png", x, y, 800, 108, 0, 0));


    }

}
