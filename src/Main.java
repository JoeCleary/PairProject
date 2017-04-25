import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
	public static Main game;
	JFrame frame;
	JPanel panel;
	
	Entity test;
	
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	
	boolean gameOn = true;
	
	long lastTime;
	
	
	public static void main(String args[]){
		game = new Main();
		
		game.startGame();
	}
	
	@SuppressWarnings("serial")
	public void startGame(){
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600, 900);
		
		frame.setVisible(true);
		
		frame.setResizable(false);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		/*
		BufferedImage cursorImg = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);

		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		
		frame.setCursor(blankCursor);
		 */
		
		
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				//get color
				g.setColor(new Color(153,204,255));
				g.fillRect(0, 0, 1600, 900);
				
				//make ground
				
				//ground things
				
				Entity.updateAll(g);
				
				//draw hud now? or maybe they should be entities but we will need to put in a special draw case for them
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
		
		test = new PlayerTomcat(800,450,100);
		
		
		new move((float) (Math.random() * 1600),(float) (Math.random() * 900),0);
		//new dont(300, 100, 150);
		
		//new dont(500, 100, 50);
		//new Entity(100,100,50);
		
		//new Entity(500, 100, 150);
		
		while(gameOn){
			
			
			lastTime = System.nanoTime();
			
			panel.repaint();
		}
	}
	
	public float getTime(){
		//float no = System.nanoTime() - lastTime;
		
		//if(no == 0)
			//no = 1;
		
		return 100f;
	}
	
	
	
	public boolean getUp(){
		return up;
	}
	
	public boolean getDown(){
		return down;
	}
	
	public boolean getLeft(){
		return left;
	}
	
	public boolean getRight(){
		return right;
	}
}


