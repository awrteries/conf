
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
	private ArrayList <Entities> NPCS, active;
	private ArrayList<Stickers> stickers;
	private Dialogue testDialogue;



	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		player = new Player(400, 400);
		fern = new Fern(400,400);
		NPCS = setNPCS();
		active = setActive();
		stickers = setStickers();
		testDialogue = new Dialogue("just testing to see if it works", "assets/dialogue/testDialogue", true);
	
	}

	// setting arraylists

	public ArrayList<Entities> setNPCS(){
		ArrayList<Entities> temp = new ArrayList<Entities>();
		temp.add(fern);
		return temp;
	}

	public ArrayList<Entities> setActive(){
		ArrayList<Entities> temp = new ArrayList<Entities>();
		temp.add(fern);
		temp.add(player);
		return temp;
	}

	public ArrayList<Stickers> setStickers(){
		ArrayList<Stickers> temp = new ArrayList<Stickers>();
		temp.add(new Stickers());
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
	

		drawSprites(g2d);
		// System.out.println(testDialogue.getDialogueList());
		testDialogue.runDialogue(active);
		// System.out.println(testDialogue.getSpeaker().getName() + ": "+testDialogue.getcDialogue());
		g2d.drawString(testDialogue.getSpeaker().getName() + ": "+testDialogue.getcDialogue(), 200, 200);

	
		twoDgraph.drawImage(back, null, 0, 0);

	}

	// methods

	public void drawSprites(Graphics g2d){
		player.drawEntity(g2d);
		player.Move();

		for (int i = 0; i < NPCS.size(); i++) {
			Entities npc = NPCS.get(i);
			npc.drawEntity(g2d);
			player.Interact(npc, stickers);

			for (int j = 0; j < stickers.size(); j++) {
				Stickers s = stickers.get(j);
				s.Move(npc);
				s.drawSticker(g2d);
			}
		}

		
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
		testDialogue.getDialogueList().remove(0);
        System.out.println(testDialogue.getSpeaker().getName() + ": " + testDialogue.getcDialogue());
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
