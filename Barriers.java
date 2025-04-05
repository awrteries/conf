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

       int pTop = p.getY();
       int pBottom = p.getY()+p.getH()*2;
       int pLeft = p.getX();
       int pRight = p.getX()+p.getW()*2;

       int top = getY();
       int bottom = getY()+getH()*2;
       int left =getX();
       int right = getX()+getW()*2;
       
       
      if (pLeft<right-20&&pRight>left+20){
         if (pBottom<bottom+20 && pBottom>getY()+getH()){
                p.setY((bottom-p.getH()*2)+20);
            } else if (pBottom>top&&pBottom<getY()+getH()){
                p.setY(top-p.getH()*2);
            }
      }
           
       

       if (pBottom>=top+5&&pBottom<=bottom-5){
        System.out.println("kysw");
            if (pLeft<right && pLeft>getX()+getW()){
                p.setX(right);
            } else if (pRight>left && pRight<getX()+getW()){
                p.setX(left-p.getW()*2);
            }
       } 


      
        
    }

    public void drawBarrier(Graphics g2d){
        g2d.drawImage(new ImageIcon(getPic()).getImage(), getX(), getY(),getW()*2, getH()*2, null);
    }
}
