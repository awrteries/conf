public class OUTAPT1 extends Backgrounds{

    public OUTAPT1(){
       super("assets/backgrounds/outapt1.png", "assets/backgrounds/1staptfrontwalls.png", -30,-30,800,550,0,0);
      
    barriers.add(new Barriers("assets/backgrounds/barriers/1staptB1.png", x, y, 161, 297, 0, 0));
    barriers.add(new Barriers("assets/backgrounds/barriers/1staptB2.png", x, y, 443, 199, 0, 0));
    barriers.add(new Barriers("assets/backgrounds/barriers/1staptB3.png", x+592*2, y, 800, 102, 0, 0));

    props.add(new Props("assets/backgrounds/props/apt1stove.gif", x+547*2, y+94*2, 0, 0, 103, 36, false));  
    }
   
}
