public class Fern extends Entities {


    public Fern(){
        super();
    }

    public Fern(int x, int y){
        super("Fern", x, y, 0, 0, 59, 100, 
        " ", "assets/baseidlel.gif", "assets/baseidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif"
        );
        super.setSprite(getIdleL());
    }
}
