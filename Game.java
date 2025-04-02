
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y; 
	private Player player;
	private Fern fern;
	private Valentino val;
	private Blythe blythe;
	private Lien peng;
	private CBox box; 
	private ArrayList <Entities> speakable, active;
	private ArrayList<Stickers> stickers;
	private ArrayList<Interface> inter;
	private Dialogue testDialogue;
	private boolean raction;



	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		player = new Player(450, 450);
		fern = new Fern(400,200);
		val = new Valentino(800, 300);
		blythe = new Blythe(1000,310);
		peng = new Lien(200, 400);
		box = new CBox(800,200);
		active = setActive();
		stickers = setStickers();
		testDialogue = new Dialogue();
		testDialogue.setDialogueList();	
		inter = setInter();
		raction = false;
	}

	// setting arraylists

	

	public ArrayList<Entities> setActive(){
		ArrayList<Entities> temp = new ArrayList<Entities>();		
		
		temp.add(val);
		temp.add(player);
		temp.add(fern);
		temp.add(peng);
		temp.add(blythe);
		temp.add(box);
		
		
		return temp;
	}

	public ArrayList<Stickers> setStickers(){
		ArrayList<Stickers> temp = new ArrayList<Stickers>();
		temp.add(new Stickers());
		return temp;
	}
	public ArrayList<Interface> setInter(){
		ArrayList<Interface> temp = new ArrayList<Interface>();
        temp.add(new Interface("assets/boxes/silverdbox.png", 400, 580, 350, 108));

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
		System.out.println(raction);
		drawSprites(g2d);
		// System.out.println(raction);
		// testDialogue.runDialogue(speakable);
		// if (testDialogue.getDialogueList().size()>1){
		// 	g2d.drawString(testDialogue.getSpeaker().getName() + ": "+testDialogue.getcDialogue(), 200, 200);

		// }

	
		twoDgraph.drawImage(back, null, 0, 0);

	}

	// methods

	public void drawSprites(Graphics g2d){
		// player.drawEntity(g2d);
		player.Move(active);
		Interface minter = inter.get(0);

		// drawing sprites and setting dialogue
		

		
		
		for (int i = 0; i < active.size(); i++) {
			Entities npc = active.get(i);

		
			npc.drawEntity(g2d);

			
			
			
			

			if (!(npc instanceof Player)){
				
				player.Interact(npc, stickers);
				if (npc.isInteraction()){

					
				for (int j = 0; j < stickers.size(); j++) {
				Stickers s = stickers.get(j);
				s.Move(npc);	
				s.drawSticker(g2d);

				if (npc instanceof Items){
					((Items) npc).inv(player.getInventory(), active);
					// System.out.println(player.getInventory());
				}
			}
			
				} else if (!npc.isInteraction()){
	
				}

				for (int j = 0; j < stickers.size(); j++) {
					Stickers s = stickers.get(j);
					s.Move(npc);
					s.drawSticker(g2d);
				}
				
			} 
			
		}

		// drawing the interface

		if (raction){
			for (int l = 0; l < inter.size(); l++) {
				
	
				Interface in = inter.get(l);
				in.drawInterface(g2d);	
		}


		testDialogue.runDialogue(active, inter);
		if (testDialogue.getDialogueList().size()>1){

			
			testDialogue.drawDialogue(g2d);
		
	}
			
		}
		
		
		
		
		
	}

	

	public boolean Interaction(){
		boolean temp = false;
		
		for (int i = 0; i < active.size(); i++) {
			// System.out.println( active.get(i).getName() + " " + active.get(i).isInteraction());

			if (!(active.get(i) instanceof Player)){
				if ((active.get(i).isInteraction())){
					// System.out.println("should be true");
					temp = true;
					return temp;
				} else {
					temp = false;				 
				} 
			}
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

				if (!testDialogue.isaChoosing()){
					if (key == 68 || key == 39){ // D
						player.setDx(2);
						player.setDy(0);
						player.setW(51);
						player.setSprite(player.getWalkR());
						
					} 
					else if (key == 65 || key == 37){ // A
						player.setDx(-2);
						player.setDy(0);
						player.setW(51);
						player.setSprite(player.getWalkL());
						
					}
					else if (key == 87 || key == 38) { // W
						player.setDy(-2);
						player.setDx(0);
						player.setW(56);
						player.setSprite(player.getWalkU());
					}
					else if (key == 83 || key == 40){ // S
						player.setDy(2);
						player.setDx(0);
						player.setW(56);
						player.setSprite(player.getWalkD());
					}
				} else if (testDialogue.isaChoosing()) {
					
					if (key == 83 || key == 40){ // S
						testDialogue.setSel(testDialogue.getSel()+1);
						
					} 
					else if (key == 87 || key == 38) { // W
						testDialogue.setSel(testDialogue.getSel()-1);
						
					}
				}
			




		// player movement
		

		if (key == 32){ // [SPACE]	
			ArrayList<String> dl = testDialogue.getDialogueList();
			
				if (dl.size()>1){
				dl.remove(0);	
				
				}
				
				
	
        //  System.out.println(testDialogue.getSpeaker().getName() + ": " + testDialogue.getcDialogue());
		}

		if (key ==69){ // E
			for (int i = 0; i < active.size(); i++) {
				Entities en = active.get(i);
				
				(en).setInteraction(true);
				if(en instanceof Npcs){
					if (player.inProximity((Npcs)en)){
						testDialogue=((Npcs) en).getcDialogue();
						testDialogue.setDialogueList();
						testDialogue.setcW();
						player.eyeContact((Npcs)en);
					}
				}
			}
		}
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		// player movement

		if (!testDialogue.isaChoosing()){
			if (key == 68 || key == 37){ // D
				player.setDx(0);
				player.setW(59);
				player.setSprite(player.getIdleR());
				
	
			} 
			else if (key == 65 || key == 39){ // A
				player.setDx(0);
				player.setW(59);
				player.setSprite(player.getIdleL());
				
			}
			else if (key == 87 || key == 83 || key == 38 || key == 40) { // W, S
				player.setDy(0);
				player.setW(59);
				player.setSprite(player.getIdleL());
	
			}
		}
		

		if (key == 32){ // [SPACE]	
			ArrayList<String> dl = testDialogue.getDialogueList();
			testDialogue.setcW();
			testDialogue.changeInter(inter);
		
		}
		if (key ==69){ // E
			for (int i = 0; i < active.size(); i++) {
				Entities en = active.get(i);

				if(en instanceof Npcs){
					player.eyeContact((Npcs)en);
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
