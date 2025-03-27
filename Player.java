public class Player extends Entities {

    public Player(){
        super();
    }

    public Player(int x, int y){
        super(x, y, 0, 0, 59, 100, 
        " ", "assets/baseidlel.gif", "assets/baseidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif"
        );
        super.setSprite(getIdleL());
    }

}
