public class Npcs extends Entities {

    private boolean interaction;

    public Npcs(){
        super();
    }

    public Npcs (String n, int x1, int y1, int dx1, int dy1, int width, int height,
    String s, String iL, String iR, String wD, String wU, String wL, String wR, boolean in){
        super(n, x1, y1, dx1, dy1, width, height, s, iL, iR, wD, wU, wL, wR);
        interaction = in;
    }

    public boolean isInteraction() {
        return interaction;
    }

    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }
}
