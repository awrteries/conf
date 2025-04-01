
public class Valentino extends Npcs{

    public Valentino(){
        super();
    }

    public Valentino(int x, int y){
        super("Valentino", x, y, 0, 0, 61, 100, 
        "assets/npcs/vampire/validler.gif", "assets/npcs/vampire/validlel.gif", "assets/npcs/vampire/validler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif",
        false,
        new Dialogue("valentino's dialogue", "assets/dialogue/valDialogue"));
    }
}
