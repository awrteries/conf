import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Items extends Entities{

    private String thumbnail, selected, ground;
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
            
        }
    }
    
    public void drawItems(Graphics g2d, int x1, int y1){
        setX(x1);
        setY(y1);
        super.drawEntity(g2d);
    }
}
