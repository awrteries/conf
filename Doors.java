public class Doors extends Props{

    Backgrounds bg;

    public Doors(){
        super();
    }

    public Doors(String s, Backgrounds b, int x, int y ,int dx, int dy, int w, int h, boolean in){
        super(s, x, y, dx, dy, w, h, in);
        bg = b;
    }

    public Backgrounds getBg() {
        return bg;
    }

    public void setBg(Backgrounds bg) {
        this.bg = bg;
    }

    

}
