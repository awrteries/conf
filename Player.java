import java.util.ArrayList;
import java.util.Collections;

public class Player extends Entities {

    private ArrayList<Items> inventory;
    public Player(){
        super();
    }

    public Player(int x, int y){
        super("Player", x, y, 0, 0, 59, 100,
        "assets/player/baseidlel.gif", "assets/player/baseidlel.gif", "assets/player/baseidler.gif", "assets/player/basewalkd.gif", "assets/player/basewalku.gif", "assets/player/basewalkl.gif", "assets/player/basewalkr.gif"
        );
        inventory = new ArrayList<Items>();

        
    }
    // methods


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
         if (!(e instanceof Player)){

            // System.out.println((n.getY()+(n.getH()*2)) + " " + (getY()+getH()));

            if(getY()+getH()*2>e.getY()+e.getH()*2&&en.indexOf(this)<i){
                
                Collections.swap(en, en.indexOf(this), i);
            } else if (getY()+getH()*2<e.getY()+e.getH()*2&&en.indexOf(this)>i){
                // C
                Collections.swap(en, en.indexOf(this), i);
        
            }
        }   
        }

        
    }

    public void eyeContact(Npcs n){

        if (inProximity(n)){
          if (this.getX()<n.getX()){
            n.setSprite(n.getIdleL());
            setSprite(getIdleR());
        }else if(this.getX()>n.getX()+n.getW()){
            n.setSprite(n.getIdleR());
            setSprite(getIdleL());
        }     
        }
      
        
        
    }

    public void Interact(Entities e, ArrayList<Stickers> s){
    Stickers sticker = new Stickers("assets/stickers/eSticker.png", 13, 13);
    if( !(e instanceof Player)){
        // System.out.println(((Npcs) e).isInteraction());
         if (inProximity(e)&&!(e).isInteraction()){
           
        
        s.add(sticker);
    } else if (!inProximity(e)||(e).isInteraction()){
       while (s.size()>1) { 
            s.remove(s.get(1));
       }
       

    } 

    }
  

    }

    public boolean inProximity(Entities e){
        boolean temp = false;

        if (!(e instanceof Player)){
        if ((e.getX()-30 <= getX()+ getW()*2&&(e.getX()+e.getW()*2)+30 >= getX())&&(((e.getY()+e.getH()*2)+30>getY()+getH()*2)&&((e.getY()+e.getH()*2)-30<getY()+getH()*2))){
            temp = true;
        } else if (!((e.getX()-30 <= getX()+ getW()*2&&(e.getX()+e.getW()*2)+30 >= getX())&&(((e.getY()+e.getH()*2)+30>getY()+getH()*2)&&((e.getY()+e.getH()*2)-30<getY()+getH()*2)))){
        
          e.setInteraction(false); 
          temp = false; 
        }
        }
        return temp;
        
    }

  

    // getters and setters

    public ArrayList<Items> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Items> inventory) {
        this.inventory = inventory;
    }

    

}
