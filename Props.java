import java.awt.Graphics;

public class Props extends Entities{

    public Props(){
        super();
    }

    public Props(String s, int x, int y, int dx, int dy, int w, int h, boolean in){
        super(s, x, y, dx, dy, w, h, in);
    }

    public void drawProps(Graphics g2d){
        super.drawEntity(g2d);
    }

   
}
