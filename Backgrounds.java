import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Backgrounds {

    int x, y, dx, dy, w, h;
    String pic, fpic;
    boolean isMovingW, isMovingH, collmoveW;
    ArrayList<Barriers> barriers;
    ArrayList<Props> props;


    public Backgrounds(){

    }
    public Backgrounds(String p, String f,int x1, int y1, int width, int height, int dx1, int dy1){
        pic= p;
        fpic = f;
        x = x1;
        y = y1;
        w = width;
        h = height;
        dx = dx1;
        dy = dy1;
        isMovingW = true;
        isMovingH = true;
        barriers = new ArrayList<Barriers>();
        props = new ArrayList<Props>();
    }


    public Backgrounds(String p, int x1, int y1, int width, int height, int dx1, int dy1){
        pic= p;
        x = x1;
        y = y1;
        w = width;
        h = height;
        dx = dx1;
        dy = dy1;
        isMovingW = true;
        isMovingH = true;
        collmoveW = true;
    }

    // methods

    public void addtoMain(ArrayList<Entities> entities){
       while (props.size()>0){
        for (int i = 0; i < props.size(); i++) {
            entities.add(props.get(i));
            props.remove(props.get(i));
        }
       }
        
    }


    public void drawBG(Graphics g2d, Player p){
        g2d.drawImage(new ImageIcon(pic).getImage(), x, y, w*2, h*2, null);
    
        if (!barriers.isEmpty()){
          for (int i = 0; i < barriers.size(); i++) {
            Barriers barrier = barriers.get(i);
            barrier.drawBarrier(g2d);
            barrier.collision(p, this);
        }  
        }
        
    }

    public void drawFW(Graphics g2d){
        g2d.drawImage(new ImageIcon(fpic).getImage(), x, y, w*2, h*2, null);

    }

    public void moveBG(ArrayList<Entities> en, Player p){

        int wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hi = Toolkit.getDefaultToolkit().getScreenSize().height;

        if (!p.isMovingH()){
            for (int i = 0; i < en.size(); i++) {
                if (!(en.get(i) instanceof Player)){
                    en.get(i).setY(en.get(i).getY()+dy);
                }
                
            }

            if (!barriers.isEmpty()){
               for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).setY(barriers.get(i).getY()+dy);
            } 
            }

            
           
            y += dy;
            setMovingH(true);
        } if (!p.isMovingW()){

            for (int i = 0; i < en.size(); i++) {
                if (!(en.get(i) instanceof Player)){
                    en.get(i).setX(en.get(i).getX()+dx);
                }
                
            }

            if (!barriers.isEmpty()){
                for (int i = 0; i < barriers.size(); i++) {
                 barriers.get(i).setX(barriers.get(i).getX()+dx);
             } 
             }

            x += dx;
            setMovingW(true);
        }
      

       if (y>=0){
        y = 0;
        setMovingH(false);
       } else if (y+(h*2)<=hi){
        y = hi-(h*2);
        setMovingH(false);
       } else {
        setMovingH(true);
       }
       
       if (x>=0){
        x = 0;
        setMovingW(false);

       } else if (x+(w*2)<=wi){
        x = wi-(w*2);
        setMovingW(false);

       } else {
        setMovingW(true);
       }
  

        
       
        
        
    }



    // getters and setters

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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFpic() {
        return fpic;
    }

    public void setFpic(String fpic) {
        this.fpic = fpic;
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
    public ArrayList<Barriers> getBarriers() {
        return barriers;
    }
    public void setBarriers(ArrayList<Barriers> barriers) {
        this.barriers = barriers;
    }
    public boolean isCollmoveW() {
        return collmoveW;
    }
    public void setCollmoveW(boolean collmoveW) {
        this.collmoveW = collmoveW;
    }
    public ArrayList<Props> getProps() {
        return props;
    }
    public void setProps(ArrayList<Props> props) {
        this.props = props;
    }

   

    

}
