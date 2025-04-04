import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

public class Items extends Entities{

    private String thumbnail, selected, ground;
    // private boolean isselected;
    public Items(){
        super();
    }
    public Items(String s, String t, String sel, String gr, int x1, int y1, int dx1, int dy1, int width, int height, boolean in){
        super(s, x1, y1, dx1, dy1, width, height,in);
        thumbnail = t;
        selected = sel;
        ground = gr;
    }

    public void inv(ArrayList<Items> item, ArrayList<Entities> en){
        if (isInteraction()){
            item.add(this);
            en.remove(en.indexOf(this));
            setSprite(thumbnail);
            try {
                BufferedImage temp = ImageIO.read(new File(getSprite()));
                setH(temp.getHeight());
                setW(temp.getWidth());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setInteraction(false);
            
        }
    }

    public void notinv(ArrayList<Items> item, ArrayList<Entities> en, Player player){
        if (isInteraction()){

            en.add(this);
            item.remove(item.indexOf(this));
            setSprite(ground);
            try {
                BufferedImage temp = ImageIO.read(new File(getSprite()));
                setH(temp.getHeight());
                setW(temp.getWidth());

                if (player.getSprite().equals(player.getIdleL())){
                    setX(player.getX()-20);
                } else if (player.getSprite().equals(player.getIdleR())){
                    setX(player.getX()+player.getW()+20);
                }  else {
                    setX(player.getX());
                }
                setY(player.getY()+player.getH()*2-getH());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (int i = 0; i < en.size(); i++) {
                Entities e = en.get(i);
                if(getY()+getH()*2>e.getY()+e.getH()*2&&en.indexOf(this)<i){
                
                Collections.swap(en, en.indexOf(this), i);
            } else if (getY()+getH()*2<e.getY()+e.getH()*2&&en.indexOf(this)>i){
                // C
                Collections.swap(en, en.indexOf(this), i);
        
            }
            }
            setInteraction(false);
            
        }
    }

    public void invSel(ArrayList<Items> item, int sel, ArrayList<Entities> en, Player player){
        // System.out.println(isInteraction());
        if (!(item==null)){

            
          if (item.indexOf(this)==sel){
            setSprite(selected);
            notinv(item, en, player);
        } else {
            setSprite(thumbnail);
            setInteraction(false);
         }  
        }
        
    }

    
    
    public void drawItems(Graphics g2d, int x1, int y1){
        setX(x1);
        setY(y1);
        super.drawEntity(g2d);
    }

}
