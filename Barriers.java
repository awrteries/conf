import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Barriers extends Backgrounds{
    

    public Barriers(){
        super();
    }

    public Barriers(String p, int x1, int y1, int width, int height, int dx1, int dy1){
        super(p, x1, y1, width, height, dx1, dy1);
    }


    public void collision(Player p, Backgrounds b){

        // i dont even know.
       if (p.getX()+p.getW()*2>getX()&&p.getX()<getX()+(getW()*2)){
            if ((p.getY()+p.getH()*2)-20<getY()+getH()*2&&p.getY()+50>getY()+getH()){
                p.setY(((getY()+getH()*2)-p.getH()*2)+20);
                System.out.println("coll1" + this.getPic());

            } else if (p.getY()+p.getH()*2>getY()&&p.getY()+p.getH()*2<getY()+getH()){

                p.setY(getY()-p.getH()*2);
            }
        }
        
    }

    public void drawBarrier(Graphics g2d){
        g2d.drawImage(new ImageIcon(getPic()).getImage(), getX(), getY(),getW()*2, getH()*2, null);
    }
}
