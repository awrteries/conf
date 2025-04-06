
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, invsel, hi, wi; 
	private String screen, objective;
	private Player player;
	private Fern fern;
	private Valentino val;
	private Blythe blythe;
	private Lien peng;
	// private CBox box; 
	private ArrayList <Entities> speakable, entities, opening, test;
	private ArrayList<Stickers> stickers;
	private ArrayList<Interface> inter;
	private Dialogue dialogue, openingDialogue, die;
	private boolean raction;
	private Apartment1 APT1;
	private Backgrounds BG;



	
	public Game() {

		wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        hi = Toolkit.getDefaultToolkit().getScreenSize().height;
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		player = new Player((wi/2), hi/2);
		player.setX((wi/2)-player.getW());
		player.setY((hi/2)-player.getH());
		fern = new Fern(725,390);
		val = new Valentino(800, 300);
		blythe = new Blythe(1000,310);
		peng = new Lien(500, 485);
		stickers = setStickers();
		opening = setOpening();
		test = setTest();
		openingDialogue = new Dialogue("", "assets/dialogue/blytheBox");
		die = new Dialogue("", "assets/dialogue/die");
		dialogue = new Dialogue();
		// dialogue.setDialogueList();	
		inter = setInter();
		raction = false;
		invsel = 0;
		APT1 = new Apartment1();	
		
		
		
		entities = new ArrayList<Entities>();
		BG = new Backgrounds();

		screen = "opening";
		objective = "collect [3] boxes.";
	
	}

	// setting arraylists

	
	public ArrayList<Entities> setOpening(){
		ArrayList<Entities> temp = new ArrayList<Entities>();
		temp.add(player);

		temp.add(new sBox(1000, 260));
		temp.add(new sBox(800, 700));
		temp.add(new sBox(400,600));

		return temp;
	}

	public ArrayList<Entities> setTest(){
		ArrayList<Entities> temp = new ArrayList<Entities>();
		temp.add(player);

		temp.add(peng);
				temp.add(val);


		return temp;
	}

	public ArrayList<Stickers> setStickers(){
		ArrayList<Stickers> temp = new ArrayList<Stickers>();
		temp.add(new Stickers());
		return temp;
	}
	public ArrayList<Interface> setInter(){
		ArrayList<Interface> temp = new ArrayList<Interface>();
        temp.add(new Interface("assets/boxes/invbox.png", 400, hi-100, 350, 108));
		temp.get(0).setY(hi-70-temp.get(0).getH()*2);
		return temp;
	}
	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);

		// Set the font to be used for the dialogue text (example font)
		Font font = new Font("Arial", Font.PLAIN, 35);
		g2d.setFont(font);
	
		// Get the FontMetrics for the current font
		FontMetrics fm = g2d.getFontMetrics();
		
		raction = Interaction();
		// BG.drawBG(g2d, player);
		// BG.moveBG(active, player);
		// drawSprites(g2d);

		drawScreens(g2d);
		template(g2d);
		
		twoDgraph.drawImage(back, null, 0, 0);

	}

	// methods

	private void template(Graphics g2d){
		BG.drawBG(g2d, player);
		BG.moveBG(entities, player);
		drawENTS(g2d, entities, BG);
		checkInteraction(g2d, entities);
		inventorySelection(entities);
		BG.drawFW(g2d);
		drawBottomBox(g2d);
	}

	private void drawScreens(Graphics g2d){

		
		// if (screen.equals("opening")){
			
		// }
		switch (screen){

			case "opening":
			opening();
			break;
			case "test":
				entities = test;
			break;
		}
	}

	public void opening(){

				BG = APT1;
				entities = opening;
				objectiveBox();
				// dialogue = openingDialogue;
	}

	public void objectiveBox(){
		if (objective.equals("collect [3] boxes.")){
			int countbox = 0;

			setdia(openingDialogue);

			for (int i = 0; i < entities.size(); i++) {
				if (entities.get(i) instanceof sBox){
					((sBox)entities.get(i)).setActive(true);
				}
			}
			for (int i = 0; i < player.getInventory().size(); i++) {
				if (player.getInventory().get(i) instanceof sBox){
					countbox++;
				}
			}

			if (countbox == 3){
				objective = "idk go die";
				setdia(die);

				player.setInteraction(true);
				
			}
		} else if (objective.equals("idk go die")){
		}
		
	}
	
	public void setdia(Dialogue d){
		if (!raction){
				dialogue = d;
		}

	}

	public void drawENTS(Graphics g2d, ArrayList<Entities> ent, Backgrounds b){
		for (int i = 0; i < ent.size(); i++) {
			Entities e = ent.get(i);

			e.drawEntity(g2d);

			if (e instanceof Player){
				((Player) e).Move(ent, b);
			}
		}
	}

	public void checkInteraction(Graphics g2d, ArrayList<Entities> ent){
		for (int i = 0; i < ent.size(); i++) {
			Entities e = ent.get(i);


			if (!(e instanceof Player)){
				
				player.Interact(e, stickers); // please check to see what stickers is because i haven't a clue
				if (e.isInteraction()){

					
				for (int j = 0; j < stickers.size(); j++) {
				Stickers s = stickers.get(j);
				s.Move(e);	
				s.drawSticker(g2d);
			}
				} else if (!e.isInteraction()){
	
				}

				for (int j = 0; j < stickers.size(); j++) {
					Stickers s = stickers.get(j);
					s.Move(e);
					s.drawSticker(g2d);
				}
				
			} 
			
		}
	}

	public void inventorySelection(ArrayList<Entities> ent){
		if (!(player.getInventory()==null)){ // inventory selection
			for (int l = 0; l < player.getInventory().size(); l++) {
				player.getInventory().get(l).invSel(player.getInventory(), invsel, ent, player);
			}	
			}
	}
	
	public void drawBottomBox(Graphics g2d){
	
		for (int l = 0; l < inter.size(); l++) {
				
	
			Interface in = inter.get(l);
			in.drawInterface(g2d);	
		}

		Interface bottomBox = inter.get(0);
		if (raction){ // checking if any of the sprites are having an interaction
			
			bottomBox.setPic("assets/boxes/silverdbox.png"); // sets the image to the dialogue box
			bottomBox.setH(108);
			bottomBox.setY(hi-70-bottomBox.getH()*2);
			dialogue(g2d);
			
		} else if (!raction){
			bottomBox.setPic("assets/boxes/invbox.png"); // sets the image to the inventory box
			bottomBox.setH(62);
			bottomBox.setY(hi-70-bottomBox.getH()*2);
			g2d.setFont(new Font("Jersey 10", Font.PLAIN, 25));
			g2d.setColor(Color.white);
			g2d.drawString("[OBJECTIVE]: " + objective, 410, hi-200);

			drawItems(g2d);
		}
			
		
	}

	public void drawItems(Graphics g2d){ // implemented in drawBottomBox()
		ArrayList<Items> temp = player.getInventory();
		int sX = 466;
		
		if (!(temp == null)){
				for (int i = 0; i < temp.size(); i++) {
					temp.get(i).drawItems(g2d, sX-temp.get(i).getW(), (hi-132)-temp.get(i).getH());
					sX += 142;
			}
		}
	}

	public void dialogue(Graphics g2d){ // implemented in drawBottomBox() but maybe will edit
		dialogue.runDialogue(entities, inter, dialogue.getDialogueList().get(0), player); // dialogue idk i forgot
		if (dialogue.getDialogueList().size()>1){
			// hi move this idk what this is help
			
			dialogue.drawDialogue(g2d);
		
		}
	}

	public boolean Interaction(){ // implemented in drawBottomBox()
		boolean temp = false;
		
		for (int i = 0; i < entities.size(); i++) {
			// System.out.println( active.get(i).getName() + " " + active.get(i).isInteraction());

			// if (!(entities.get(i) instanceof Items)){
				if ((entities.get(i).isInteraction())){

					if (entities.get(i) instanceof Items){
						if (((Items)entities.get(i)).isActive()){
							temp = false;				 

						}else if (!((Items)entities.get(i)).isActive()){
							// System.out.println("WHYYY");
							temp = true;
						}
					} else{
						temp = true;
					}
					return temp;
				} else {
					temp = false;				 
				} 
			// }
		}

		return temp;
	}


	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		// System.out.println(testDialogue.isaChoosing());

				if (!dialogue.isaChoosing()){
					if (key == 68 || key == 39){ // D
						player.setDx(2);
						player.setDy(0);
						player.setW(51);
						player.setSprite(player.getWalkR());

						BG.setDx(-2);
						BG.setDy(0);
						
					} 
					else if (key == 65 || key == 37){ // A
						player.setDx(-2);
						player.setDy(0);
						player.setW(51);
						player.setSprite(player.getWalkL());

						BG.setDx(2);
						BG.setDy(0);
						
					}
					else if (key == 87 || key == 38) { // W
						player.setDy(-2);
						player.setDx(0);
						player.setW(56);
						player.setSprite(player.getWalkU());

						BG.setDx(0);
						BG.setDy(2);
					}
					else if (key == 83 || key == 40){ // S
						player.setDy(2);
						player.setDx(0);
						player.setW(56);
						player.setSprite(player.getWalkD());

						BG.setDx(0);
						BG.setDy(-2);
					}
				} else if (dialogue.isaChoosing()) {
					
					if (key == 83 || key == 40){ // S
						dialogue.setSel(dialogue.getSel()+1);
						
					} 
					else if (key == 87 || key == 38) { // W
						dialogue.setSel(dialogue.getSel()-1);
						
					}
				}
			




		// player movement
		

		if (key == 32){ // [SPACE]	
			ArrayList<String> dl = dialogue.getDialogueList();
			
				if (dl.size()>1){
				dl.remove(0);	
				
				}
				
				
	
        //  System.out.println(testDialogue.getSpeaker().getName() + ": " + testDialogue.getcDialogue());
		}

		if (key ==69){ // E
			for (int i = 0; i < entities.size(); i++) {
				Entities en = entities.get(i);
				if (!(en instanceof Player)){
					
					if (player.inProximity(en)){
						(en).setInteraction(true);
						if (en instanceof Npcs){
							dialogue=((Npcs) en).getcDialogue();

						} else if (en instanceof Items){
							dialogue = ((Items)en).getDialogue();
							dialogue.setDialogue();
						}
						dialogue.setDialogueList();
						dialogue.setcW();
						// player.eyeContact((Npcs)en);
					}
				}
				
				// if(en instanceof Npcs){
					
				// }
			}
		}

		for (int i = 49; i < 54; i++) { // checking for 1, 2, 3, 4, 5
			char c = (char) i;
			int num = c - '0';

			if (key == i){
				invsel = num-1;
			}
			
		}

		if (key == 8){
			if (!(player.getInventory()==null)){
			for (int i = 0; i < player.getInventory().size(); i++) {
				if (invsel==i){
					player.getInventory().get(i).setInteraction(true);
					// System.out.println("happening");

				}
			}
		}
		}

		
		if (key == 70){
			screen = "test";
		}
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		// player movement

		if (!dialogue.isaChoosing()){
			if (key == 68 || key == 37){ // D
				player.setDx(0);
				player.setX(player.getX()-16);
				player.setW(59);
				player.setSprite(player.getIdleR());
				
				BG.setDx(0);
	
			} 
			else if (key == 65 || key == 39){ // A
				player.setDx(0);
				player.setW(59);
				player.setSprite(player.getIdleL());

				BG.setDx(0);
				
			}
			else if (key == 87 || key == 83 || key == 38 || key == 40) { // W, S
				player.setDy(0);
				player.setW(59);
				player.setSprite(player.getIdleL());

				BG.setDy(0);
	
			}
		}
		

		if (key == 32){ // [SPACE]	
			ArrayList<String> dl = dialogue.getDialogueList();
			dialogue.setcW();
			dialogue.changeInter(inter);
		
		}
		if (key ==69){ // E
			for (int i = 0; i < entities.size(); i++) {
				Entities en = entities.get(i);

				if(en instanceof Items){
					((Items) en).inv(player.getInventory(), entities);
				}
			}
		
		}
		
		
		
		
		
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at x: "+ arg0.getX() + ", y: " + arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
