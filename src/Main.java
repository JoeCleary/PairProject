import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
	private static Main game;
	private JFrame frame;
	private JPanel panel;
	
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean shoot = false;
	
	private boolean gameOn = true;
	
	private long lastTime;
	
	
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
				//ground things
				
				BufferedImage img = new BufferedImage(1600, 900, BufferedImage.SCALE_FAST);
				img.setAccelerationPriority(1f);
				
				Graphics gg = img.getGraphics();
				
				//get color
				gg.setColor(new Color(153,204,255));
				gg.fillRect(0, 0, 1600, 900);
				
				//make ground
				gg.setColor(Color.GREEN);
				gg.fillRect(0, 600, 1600, 900);
				
				Entity.updateAll(gg);
				
				
				ColorModel cm = img.getColorModel();
				g.drawImage(new BufferedImage(cm, img.copyData(null), cm.isAlphaPremultiplied(), null), 0, 0, null);
				
				//copy = panel.createVolatileImage(1600, 900);
				
				//Graphics ggg = copy.createGraphics();
				//ggg.drawImage(img, 0, 0, null);
				
				//g.drawImage(copy, 0, 0, null);
				
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
				
				if(ke.getKeyCode() == KeyEvent.VK_Z)
					shoot = true;
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
				
				if(ke.getKeyCode() == KeyEvent.VK_Z)
					shoot = false;
			}
			
			public void keyTyped(KeyEvent ke) {}
		});	
		
		frame.setContentPane(panel);
		
		new PlayerTomcat(800,450,100);
		
		//new dont(300, 100, 150);
		
		//new dont(500, 100, 50);
		//new Entity(100,100,50);
		
		//new Entity(500, 100, 150);
		
		while(gameOn){
			
			lastTime = System.nanoTime();
			
			panel.repaint();
		}
	}
	
	public long getTime(){
		long no = System.nanoTime() - lastTime;
		
		if(no == 0L)
			no = 1000;
		
		return no;
	}
	
	public static Main getGame(){
		return game;
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
	
	public boolean getShoot(){
		return shoot;
	}
}


