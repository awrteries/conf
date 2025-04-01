

public class Blythe extends Npcs{

    public Blythe(){
        super();
    }

    public Blythe(int x, int y){
        super("Blythe", x, y, 0, 0, 61, 100, 
        "assets/player/baseidlel.gif", "assets/player/baseidlel.gif", "assets/player/baseidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif",
        false,
        new Dialogue("valentino's dialogue", "assets/dialogue/blytheDialogue"));
    }
}
