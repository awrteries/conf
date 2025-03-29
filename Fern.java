public class Fern extends Npcs {


    public Fern(){
        super();
    }

    public Fern(int x, int y){
        super("Fern", x, y, 0, 0, 59, 100, 
        "assets/npcs/fox/foxidlel.gif", "assets/npcs/fox/foxidlel.gif", "assets/npcs/fox/foxidler.gif", "assets/basewalkd.gif", "assets/basewalku.gif", "assets/basewalkl.gif", "assets/basewalkr.gif",
        false,
        new Dialogue("fern's test dialogue", "assets/dialogue/fernDialogue"));
    }
}
