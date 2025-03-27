import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
	private static final int WIDTH =1800;
	private static final int HEIGHT=1600;
	
	public Main () {
		super("conf");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);

		
		setBackground(Color.white);
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}
