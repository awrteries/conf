import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {

    // constructors

    private String dialogueFile, dialogueDesc, cDialogue, removeSubStr;
    private Entities speaker;
    private Boolean moveon;

    public Dialogue(){
        dialogueFile = "";
        cDialogue = "";
        dialogueDesc = "";
        
        moveon = true;
    }

    public Dialogue (String dd, String df, boolean mo){
        dialogueDesc = dd;
        dialogueFile = df;

        moveon = mo;

    }

    // methods

    public void runDialogue(ArrayList<Entities> characters){
        
        // try {
        File file = new File (dialogueFile);
        Scanner scan;
        try {
            scan = new Scanner(file);

            while(scan.hasNextLine()){
                if (moveon){ // moveon will depend on a keypress in main, this makes it so that the dialogue doesn't progess without the player
    
                    String ba = scan.nextLine();

                    boolean characterFound = false; 
                    
                    for (int i = 0; i < characters.size(); i++) {
                        Entities character = characters.get(i);
    
                        if (ba.startsWith(character.getName())){ // if the dialogue starts with a character's name the program will set the current speaker to that character
                            speaker = character;
                            removeSubStr = character.getName();
                        }
    
                        cDialogue = ba.replace(removeSubStr, ""); // this will remove the character's name from the string we got from the text file, and add the rest of the dialogue to the current dialogue
                        moveon = false;
                    }
                    
                } 
                else if (!moveon){
                    break; // stops my dumbass program from crashing
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         

        
        //    } catch (FileNotFoundException e) {
        //   e.printStackTrace();
        //   }
   
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

    public Boolean getMoveon() {
        return moveon;
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

    public void setMoveon(Boolean moveon) {
        this.moveon = moveon;
    }



    
}
