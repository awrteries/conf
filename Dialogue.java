import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {

    // constructors

    private String dialogueFile, dialogueDesc, cDialogue, removeSubStr;
    private Entities speaker;
    private ArrayList<String> dialogueList;

    public Dialogue(){
        dialogueFile = "";
        cDialogue = "";
        dialogueDesc = "";
            }

    public Dialogue (String dd, String df){
        dialogueDesc = dd;
        dialogueFile = df;
        dialogueList = setDialogue();


    }

    // methods

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
                }
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



    
}
