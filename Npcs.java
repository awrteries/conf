public class Npcs extends Entities {

    private Dialogue cDialogue;

    public Npcs(){
        super();
    }

    public Npcs (String n, int x1, int y1, int dx1, int dy1, int width, int height,
    String s, String iL, String iR, String wD, String wU, String wL, String wR, boolean in, Dialogue d){
        super(n, x1, y1, dx1, dy1, width, height, s, iL, iR, wD, wU, wL, wR, in);
        cDialogue = d;
    }

   

    public Dialogue getcDialogue() {
        return cDialogue;
    }

    public void setcDialogue(Dialogue cDialogue) {
        this.cDialogue = cDialogue;
    }
}
