import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {

    // constructors

    private String dialogueFile, dialogueDesc, cDialogue, removeSubStr;
    private Entities speaker;
    private Boolean moveon;
    private ArrayList<String> dialogueList;

    public Dialogue(){
        dialogueFile = "";
        cDialogue = "";
        dialogueDesc = "";
        
        moveon = true;
    }

    public Dialogue (String dd, String df, boolean mo){
        dialogueDesc = dd;
        dialogueFile = df;
        dialogueList = setDialogue();


        moveon = mo;

    }

    // methods

    public void runDialogue(ArrayList<Entities> entities){

        if (dialogueList == null){
            dialogueList.add(" ");
        } else {
            for (int i = 0; i < entities.size(); i++) {
                Entities entity = entities.get(i);
                String ba = dialogueList.get(0);

                if (ba.startsWith(entity.getName())){ // if the dialogue starts with a character's name the program will set the current speaker to that character
                    speaker = entity;
                    removeSubStr = entity.getName();
                }

                cDialogue = ba.replace(removeSubStr, ""); // this will remove the character's name from the string we got from the text file, and add the rest of the dialogue to the current dialogue  
        }
        }        
                   
    }

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

    public ArrayList<String> getDialogueList() {
        return dialogueList;
    }

    public void setDialogueList(ArrayList<String> dialogueList) {
        this.dialogueList = dialogueList;
    }



    
}
