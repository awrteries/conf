
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Stickers {

    private String pic;
    private int x, y, w, h;

    public Stickers(){
        pic = "";
        x = 0;
        y = 0;
        w = 0;
        h = 0;
    }

    public Stickers(String p, int width, int height){
        pic = p;
        w = width;
        h= height;
    }

    // methods

    public void Move(Entities e){ // locks the sticker to an entity
        x = (e.getX()+e.getW())-20;
        y = (e.getY()+e.getH()*2)-70;
    }

    public void drawSticker(Graphics g2d){  // draws the sticker
        g2d.drawImage(new ImageIcon(pic).getImage(), x, y, w*2, h*2, null);
    }

    // getters and setters
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    

}
