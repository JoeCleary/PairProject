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
	
	boolean up = false, down = false, left = false, right = false;
	
	boolean gameOn = true;
	
	
	public static void main(String args[]){
		new Main().startGame();
	}
	
	
	@SuppressWarnings("serial")
	public void startGame(){
		frame = new JFrame();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false);
		
		frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		
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
				
				//BufferedImage img = new BufferedImage(100, 100, BufferedImage.SCALE_FAST);
				test = new Entity(0,0,0);
				
				if(down){
				
				}else if(up){
					
				}
				
				if(right){
					
				}else if(left){
					
				}
				
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
		
		
		panel.repaint();
		
		frame.setContentPane(panel);
		
		frame.setVisible(true);
		
		while(gameOn){
			panel.repaint();
		}
	}
}


