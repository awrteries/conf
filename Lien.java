
public class Lien extends Npcs{

    public Lien(){
        super();
    }

    public Lien(int x, int y){
        super("Liên", x, y, 0, 0, 59, 100, 
        "assets/npcs/penguin/pengidler.gif", "assets/npcs/penguin/pengidlel.gif", "assets/npcs/penguin/pengidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif",
        false,
        new Dialogue("peng's dialogue", "assets/dialogue/pengDialogue"));
    }
}
