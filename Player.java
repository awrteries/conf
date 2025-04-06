import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;

public class Player extends Entities {

    private ArrayList<Items> inventory;
    private boolean isMovingW, isMovingH;
    public Player(){
        super();
    }

    public Player(int x, int y){
        super("Player", x, y, 0, 0, 59, 100,
        "assets/player/baseidlel.gif", "assets/player/baseidlel.gif", "assets/player/baseidler.gif", "assets/player/basewalkd.gif", "assets/player/basewalku.gif", "assets/player/basewalkl.gif", "assets/player/basewalkr.gif"
        );
        inventory = new ArrayList<Items>();
        isMovingW = false;
        isMovingH = false;
        setInteraction(true);        
        
    }
    // methods


    public void Move(ArrayList<Entities> en, Backgrounds b){
        // System.out.println(getX() + " " + getY());

        int wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hi = Toolkit.getDefaultToolkit().getScreenSize().height;

    

        if (!b.isMovingH){
            setY(getY()+getDy());
            setMovingH(true);
        } 
        
        if (!b.isMovingW){
           setX(getX()+getDx());
            setMovingW(true); 
        }
        
        

        if (getY()<0){
            setY(0);
           } else if (getY()+(getH()*2)>hi){
            setY(hi-(getH()*2));
           } else if (getX()<0){
            setX(0);
           } else if (getX()+(getW()*2)>wi){
            setX(wi-(getW()*2));
           }

        if (getY()+getH()==hi/2){
            setMovingH(false);
        } 
        
        if (getX()+getW()==(wi/2)){
            setMovingW(false);
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

        // if (inProximity(n)){
          if (this.getX()<n.getX()){
            n.setSprite(n.getIdleL());
        }else if(this.getX()>n.getX()+n.getW()){
            n.setSprite(n.getIdleR());
        }     
        // }
      
        
        
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

    public boolean isMovingW() {
        return isMovingW;
    }

    public void setMovingW(boolean isMovingW) {
        this.isMovingW = isMovingW;
    }

    public boolean isMovingH() {
        return isMovingH;
    }

    public void setMovingH(boolean isMovingH) {
        this.isMovingH = isMovingH;
    }

  

    

}
