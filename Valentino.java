

public class Valentino extends Npcs{

    public Valentino(){
        super();
    }

    public Valentino(int x, int y){
        super("Valentino", x, y, 0, 0, 59, 100, 
        "assets/player/baseidler.gif", "assets/player/baseidlel.gif", "assets/player/baseidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif",
        false,
        new Dialogue("valentino's dialogue", "assets/dialogue/valDialogue"));
    }
}
