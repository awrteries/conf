import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {

    // constructors

    private String dialogueFile, dialogueDesc, cDialogue, removeSubStr, cWord, dInstruction;
    private String[] splitAC;
    private Entities speaker;
    private ArrayList<String> dialogueList, cWList, aCList;
    private ArrayList<Interface> inter;

    // private ArrayList<Interface> 

    public Dialogue(){
        dialogueFile = "";
        cDialogue = "";
        dialogueDesc = "";
            }

    public Dialogue (String dd, String df){
        dialogueDesc = dd;
        dialogueFile = df;
        dialogueList = setDialogue();
        cWList = new ArrayList<String>();
        aCList = new ArrayList<String>();
        aCList.add("");
        inter = new ArrayList<Interface>();
        inter.add(new Interface("assets/boxes/silverdbox.png", 400, 580, 350, 108));
        splitAC = "".split("");
        dInstruction = "press [SPACE] to continue.";


    }

    // methods
    public void changeInter (){
        int iy = 596;
        if (aCList.size()>1){
            for (int j = 0; j < aCList.size()-1 ; j++) {
                
                inter.add(new Interface("assets/boxes/silverdAC.png",407+350*2, iy, 108, 32 ));
                iy += 34*2;
                dInstruction = "[ARROW KEYS] to select.";
     
        }
        } else {
            dInstruction = "press [SPACE] to continue.";
        }
        System.out.println(inter.size());

    }

    public void drawDialogue(Graphics g2d){
        for (int i = 0; i < inter.size(); i++) {
            Interface in = inter.get(i);
            in.drawInterface(g2d);

            

            
        }
            g2d.setFont(new Font("Jersey 10", Font.PLAIN, 35));
			g2d.drawString(getSpeaker().getName(), 420, 612);
			g2d.setColor(Color.white);
			g2d.setFont(new Font("Jersey 10", Font.PLAIN, 15)); // please figure out a more efficient font size changer thing
			g2d.drawString(dInstruction, 940, 770);
			
            g2d.setFont(new Font("Jersey 10", Font.PLAIN, 30));
			
            drawcW(g2d, 430, 660);
            drawAC(g2d);
            
            
    }

    public void drawAC(Graphics g2d){
        // FontMetrics fm = g2d.getFontMetrics();
        g2d.setFont(new Font("Jersey 10", Font.PLAIN, 25)); 
        int iy = 635;
        for (int i = 1; i < aCList.size(); i++) {
            g2d.drawString(aCList.get(i), 1130, iy);
            iy += 68;
        }
    }

    public void runDialogue(ArrayList<Entities> entities){

        if (dialogueList == null){

            setDialogueList();

        } else {
            for (int i = 0; i < entities.size(); i++) {
                Entities entity = entities.get(i);
                String ba = dialogueList.get(0);

                if (ba.startsWith(entity.getName())){ // if the dialogue starts with a character's name the program will set the current speaker to that character
                    speaker = entity;
                    removeSubStr = speaker.getName();
                    cDialogue = ba.replace(removeSubStr, ""); // this will remove the character's name from the string we got from the text file, and add the rest of the dialogue to the current dialogue 
                    setcW();
                } else if (ba.startsWith("AC")){
                    splitAC = (ba.replace("AC ", "")).split("_");
                    for (int j = 0; j < splitAC.length; j++) {
                        aCList.add(splitAC[j]);
                        // System.out.println(aCList.size());
                    }
                    dialogueList.remove(0);
                    

                }
                }

               
        }        
                   
    }

    public void setcW(){
        emptycW();

        String[] word = cDialogue.split(" "); 

       for (int i = 0; i < word.length; i++) {
                cWList.add(word[i]);
            
       }
    }

    public void emptycW(){
        if(cWList.size()>1){
            for (int i = cWList.size()-1; i > -1   ; i--) {
                cWList.remove(i);
            }
        }
    }

    public void drawcW(Graphics g2d, int startx, int starty){
        FontMetrics fm = g2d.getFontMetrics(); 
            int wordSpacing = 10; 
            int sx = startx;
            for (int i = 0; i < cWList.size(); i++) {
            String word = cWList.get(i);
    
            int wordWidth = fm.stringWidth(word);
    
            if (sx + wordWidth > 1080) {
                sx = startx; // Reset to the left margin
                starty += fm.getHeight()-5; // Move down by the height of the font
            }
    
            g2d.drawString(word, sx, starty);
                sx += wordWidth + wordSpacing; 
        }
    }

    // public ArrayList<String> setcWList(){
    //     ArrayList<String> temp = new ArrayList<String>();

    //     return temp;
    // }

    public ArrayList<String> setDialogue(){
        ArrayList<String> temp = new ArrayList<String>();
        
        // try {
        File file = new File (dialogueFile);
        Scanner scan;
        try {
            scan = new Scanner(file);

            while(scan.hasNextLine()){

                
                String ba = scan.nextLine();
                temp.add(ba);

               
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        temp.add(" ");
        return temp;
    }

    // getters and setters

    public String getDialogueFile() {
        return dialogueFile;
    }

    public void setDialogueFile(String dialogueFile) {
        this.dialogueFile = dialogueFile;
    }

    public String getDialogueDesc() {
        return dialogueDesc;
    }

    public void setDialogueDesc(String dialogueDesc) {
        this.dialogueDesc = dialogueDesc;
    }

    public String getcDialogue() {
        return cDialogue;
    }

    public Entities getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Entities speaker) {
        this.speaker = speaker;
    }

    public void setcDialogue(String cDialogue) {
        this.cDialogue = cDialogue;
    }


    public ArrayList<String> getDialogueList() {
        return dialogueList;
    }

    public void setDialogueList() {
        this.dialogueList = setDialogue();
    }

    public String getcWord() {
        return cWord;
    }

    public void setcWord(String cWord) {
        this.cWord = cWord;
    }

    public void setDialogueList(ArrayList<String> dialogueList) {
        this.dialogueList = dialogueList;
    }

    public ArrayList<String> getcWList() {
        return cWList;
    }

    public void setcWList(ArrayList<String> cWList) {
        this.cWList = cWList;
    }



    
}
