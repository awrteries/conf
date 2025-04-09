public class Doors extends Props{

    String bg;

    public Doors(){
        super();
    }

    public Doors(String s, String b, int x, int y ,int dx, int dy, int w, int h, boolean in){
        super(s, x, y, dx, dy, w, h, in);
        bg = b;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

  

    

}
