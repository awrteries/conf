import java.util.ArrayList;

public class Player extends Entities {


    public Player(){
        super();
    }

    public Player(int x, int y){
        super("Player", x, y, 0, 0, 59, 100, 
        " ", "assets/baseidlel.gif", "assets/baseidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif"
        );
        super.setSprite(getIdleL());
        
    }
    // methods

    public boolean inProximity(Npcs e){
        
        if (e.getX()-100 <= getX()+ getW()&&e.getX()+100 >= getX()){
            return true;
        } else
        e.setInteraction(false);
        return false;
    }

  

    public void Move(){
        super.moveEntity();

        int wi = 1420;
        int hi = 750;
        if( getX() < 0){
            setX(0);
        }
        else if (getX()+getW()>wi) {

            setX(wi-getW());
        }

        if (getY()< -20) {
            setY(-20);
        }
        else if (getY()+getH()> hi-35){
            setY(hi-35-getH());
        }
    }

    public void Interact(Entities e, ArrayList<Stickers> s){
    Stickers sticker = new Stickers("assets/eSticker.png", 13, 13);
    if (e instanceof Npcs){
        System.out.println(((Npcs) e).isInteraction());
         if (inProximity((Npcs)e)&&!((Npcs) e).isInteraction()){
        
        s.add(sticker);
    } else if (!inProximity((Npcs)e)||((Npcs) e).isInteraction()){
       while (s.size()>1) { 
            s.remove(s.get(1));
       }
       

    } 

    }
  

    }

}
