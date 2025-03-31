
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
	private Lien peng;
	private ArrayList <Entities> speakable, active;
	private ArrayList<Stickers> stickers;
	private ArrayList<Interface> inter;
	private Dialogue testDialogue;
	private Interface sDBox;



	
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
		peng = new Lien(200, 400);
		speakable = setSpeakable();
		active = setActive();
		stickers = setStickers();
		inter = setInter();
		testDialogue = new Dialogue();
		testDialogue.setDialogueList();
		sDBox = new Interface("assets/boxes/silverdbox.png", 400, 580, 350, 108);
	
	}

	// setting arraylists

	

	public ArrayList<Entities> setActive(){
		ArrayList<Entities> temp = new ArrayList<Entities>();		
		
		temp.add(val);
		temp.add(player);
		temp.add(fern);
		temp.add(peng);
		
		
		return temp;
	}

	public ArrayList<Entities> setSpeakable(){
			ArrayList<Entities> temp = setActive();
			// temp.add(player);
			return temp;
		}

	public ArrayList<Stickers> setStickers(){
		ArrayList<Stickers> temp = new ArrayList<Stickers>();
		temp.add(new Stickers());
		return temp;
	}
	public ArrayList<Interface> setInter(){
		ArrayList<Interface> temp = new ArrayList<Interface>();
		temp.add(new Interface());
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
		

		drawSprites(g2d);
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

		// drawing sprites and setting dialogue

		for (int i = 0; i < active.size(); i++) {
			Entities npc = active.get(i);
			npc.drawEntity(g2d);
			

			if (npc instanceof Npcs){
				player.Interact(npc, stickers);
				if (((Npcs) npc).isInteraction()){for (int j = 0; j < stickers.size(); j++) {
				Stickers s = stickers.get(j);
				s.Move((Npcs)npc);
				s.drawSticker(g2d);
			}
					testDialogue.runDialogue(speakable);
					if (testDialogue.getDialogueList().size()>1){
	
						
						for (int j = 0; j < inter.size(); j++) {
						inter.get(j).drawInterface(g2d);
						g2d.setFont(new Font("Jersey 10", Font.PLAIN, 35));
						g2d.drawString(testDialogue.getSpeaker().getName(), 420, 612);
						g2d.setColor(Color.white);
						g2d.setFont(new Font("Jersey 10", Font.PLAIN, 15)); // please figure out a more efficient font size changer thing
						g2d.drawString("press [SPACE] to continue.", 940, 770);
						g2d.setFont(new Font("Jersey 10", Font.PLAIN, 30));
						for (int l = 0; l < testDialogue.getcWList().size(); l++) {
						String word = testDialogue.getcWList().get(l);
						// System.out.println(word);
						}
						testDialogue.drawcW(g2d, 430, 660);
		}
					
				}
				}

				for (int j = 0; j < stickers.size(); j++) {
					Stickers s = stickers.get(j);
					s.Move((Npcs)npc);
					s.drawSticker(g2d);
				}
				
			}
			
		}

		// drawing the interface
		
		
		
		
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



		// player movement
		if (key == 68){ // D
			player.setDx(2);
			player.setDy(0);
			player.setW(51);
			player.setSprite(player.getWalkR());
			
		} 
		else if (key == 65){ // A
			player.setDx(-2);
			player.setDy(0);
			player.setW(51);
			player.setSprite(player.getWalkL());
			
		}
		else if (key == 87) { // W
			player.setDy(-2);
			player.setDx(0);
			player.setW(56);
			player.setSprite(player.getWalkU());
		}
		else if (key == 83){ // S
			player.setDy(2);
			player.setDx(0);
			player.setW(56);
			player.setSprite(player.getWalkD());
		}

		if (key == 32){ // [SPACE]	
			ArrayList<String> dl = testDialogue.getDialogueList();
			
				if (dl.size()>1){
				dl.remove(0);	
				
				}
				
				
	
        //  System.out.println(testDialogue.getSpeaker().getName() + ": " + testDialogue.getcDialogue());
		}

		if (key ==69){ // E
			inter.add(sDBox);
			for (int i = 0; i < active.size(); i++) {
				Entities en = active.get(i);

				if(en instanceof Npcs){
					if (player.inProximity((Npcs)en)){
						((Npcs) en).setInteraction(true);
						testDialogue=((Npcs) en).getcDialogue();
						testDialogue.setDialogueList();
						testDialogue.setcW();

					}
				}
			}
		}
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		// player movement
		if (key == 68){ // D
			player.setDx(0);
			player.setW(59);
			player.setSprite(player.getIdleR());
			

		} 
		else if (key == 65){ // A
			player.setDx(0);
			player.setW(59);
			player.setSprite(player.getIdleL());
			
		}
		else if (key == 87 || key == 83) { // W, S
			player.setDy(0);
			player.setW(59);
			player.setSprite(player.getIdleL());

		}

		if (key == 32){ // [SPACE]	
			ArrayList<String> dl = testDialogue.getDialogueList();
			testDialogue.setcW();
		
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
