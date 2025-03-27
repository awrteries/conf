public class Player extends Entities {

    public Player(){
        super();
    }

    public Player(int x, int y, int dx, int dy, int w, int h){
        super(400, 400, 0, 0, 59, 100);
    }

    public Player(String s, String iL, String iR, String wD, String wU, String wL, String wR){
        super(iL, "baseidleL.gif", "baseidleR.gif", "basewalkD.gif", "basewalkU.gif", "basewalkL.gif", "basewalkR.gif");
    }
}
