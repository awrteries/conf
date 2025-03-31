
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Stickers {

    private String pic;
    private int x, y, w, h;
    private boolean pressed;
    private Entities entity;

    public Stickers(){
        pic = "";
        x = 0;
        y = 0;
        w = 0;
        h = 0;
        pressed = false;
    }

    public Stickers(String p, int width, int height){
        pic = p;
        w = width;
        h= height;
    }

    // methods

    public void Move(Npcs e){ // locks the sticker to an entity
        if (e.getSprite().equals(e.getIdleR())){
        x = (e.getX()+e.getW());   
        } else if (e.getSprite().equals(e.getIdleL())){
        x = (e.getX()+e.getW()-25);  
        }
        
        y = (e.getY()+e.getH()*2)-70;
        entity = e;
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public Entities getEntity() {
        return entity;
    }

    public void setEntity(Entities entity) {
        this.entity = entity;
    }

    

}
