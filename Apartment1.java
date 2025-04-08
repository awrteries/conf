public class Apartment1 extends Backgrounds{

    public Apartment1(){
        super("assets/backgrounds/1stapt.gif", "assets/backgrounds/1staptfrontwalls.png", -30,-30,800,550,0,0);
      
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB1.png", x, y, 385, 266, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB2.png", x, y, 152, 550, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB3.png", x, y+h*2-(98*2), 800, 102, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB3.png", x, y, 800, 108, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB3.png", x+650*2, y, 152, 550, 0, 0));
        barriers.add(new Barriers("assets/backgrounds/barriers/1staptB3.png", x+468*2, y+353*2, 147, 60, 0, 0));

        props.add(new Props("assets/backgrounds/props/apt1stove.gif", x+547*2, y+94*2, 0, 0, 103, 36, false));
        props.add(new Props("assets/backgrounds/props/apt1table.png", x+468*2, y+345*2, dx, dy, 147, 10, false));
    }

}
