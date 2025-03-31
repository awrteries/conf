import java.util.ArrayList;
import java.util.Collections;

public class Player extends Entities {


    public Player(){
        super();
    }

    public Player(int x, int y){
        super("Player", x, y, 0, 0, 59, 100, 
        "assets/player/baseidlel.gif", "assets/player/baseidlel.gif", "assets/player/baseidler.gif", "assets/player/basewalkd.gif", "assets/player/basewalku.gif", "assets/player/basewalkl.gif", "assets/player/basewalkr.gif"
        );

        
    }
    // methods

    public boolean inProximity(Npcs e){
        
        if ((e.getX()-100 <= getX()+ getW()&&e.getX()+150 >= getX())&&((e.getY()-20<getY())&&(e.getY()+e.getH()*2+20>getY()+getH()*2))){
            return true;
        } else
        e.setInteraction(false);
        return false;
    }

  

    public void Move(ArrayList<Entities> en){
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
        for (int i = 0; i < en.size(); i++) {
            Entities e = en.get(i);
         if (e instanceof Npcs){
            Npcs n = (Npcs) e;

            // System.out.println((n.getY()+(n.getH()*2)) + " " + (getY()+getH()));

            if(getY()+getH()*2>n.getY()+n.getH()*2&&en.indexOf(this)<i){
                
                Collections.swap(en, en.indexOf(this), i);
            } else if (getY()+getH()*2<n.getY()+n.getH()*2&&en.indexOf(this)>i){
                // C
                Collections.swap(en, en.indexOf(this), i);
        
            }
        }   
        }

        
    }

    public void Interact(Entities e, ArrayList<Stickers> s){
    Stickers sticker = new Stickers("assets/stickers/eSticker.png", 13, 13);
    if (e instanceof Npcs){
        // System.out.println(((Npcs) e).isInteraction());
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
