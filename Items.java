import java.util.ArrayList;

public class Items extends Entities{

    private String thumbnail;
    public Items(){
        super();
    }
    public Items(String s, String t, int x1, int y1, int dx1, int dy1, int width, int height, boolean in){
        super(s, x1, y1, dx1, dy1, width, height,in);
        thumbnail = t;
    }

    public void inv(ArrayList<Items> item, ArrayList<Entities> en){
        if (isInteraction()){
            item.add(this);
            en.remove(en.indexOf(this));
        }
    }
}
