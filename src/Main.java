import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
	JFrame frame;
	JPanel panel;
	
	Entity test;
	
	static boolean up = false;
	static boolean down = false;
	static boolean left = false;
	static boolean right = false;
	
	boolean gameOn = true;
	
	
	public static void main(String args[]){
		new Main().startGame();
	}
	
	
	@SuppressWarnings("serial")
	public void startGame(){
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600, 900);
		
		frame.setVisible(true);
		
		frame.setResizable(false);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		BufferedImage cursorImg = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);

		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		
		frame.setCursor(blankCursor);
		
		
		/* Toolkit.createCustom 
		 * public Cursor createCustomCursor(Image cursor,
                        Point hotSpot,
                        String name)
                          throws IndexOutOfBoundsException,
                                 HeadlessException
		 */
		
		
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				//get color
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 1600, 900);
				
				//BufferedImage img = new BufferedImage(100, 100, BufferedImage.SCALE_FAST);
				
				Entity.updateAll(g);
				
				
			}
		};

		frame.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP)
					up = true;
				
				if(ke.getKeyCode() == KeyEvent.VK_DOWN)
					down = true;
				
				if(ke.getKeyCode() == KeyEvent.VK_LEFT)
					left = true;
				
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
					right = true;
			}
			
			public void keyReleased(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP)
					up = false;
				
				if(ke.getKeyCode() == KeyEvent.VK_DOWN)
					down = false;
				
				if(ke.getKeyCode() == KeyEvent.VK_LEFT)
					left = false;
				
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
					right = false;
			}
			
			public void keyTyped(KeyEvent ke) {}
		});	
		
		frame.setContentPane(panel);
		
		frame.revalidate();
		
		test = new PlayerTomcat(800,450,100);
		
		new dont(100,100,50);
		
		new dont(500, 100, 150);
		
		
		
		while(gameOn){
			panel.repaint();
		}
	}
	
	public void updateAll(){
		
	}
	
	public static boolean getUp(){
		return up;
	}
	
	public static boolean getDown(){
		return down;
	}
	
	public static boolean getLeft(){
		return left;
	}
	
	public static boolean getRight(){
		return right;
	}
}


