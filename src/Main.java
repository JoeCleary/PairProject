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
	
	private BufferStrategy strategy;
	private Graphics gg;
	private Windy window;
	
	BufferedImage first;
	BufferedImage second;
	BufferedImage off;
	
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean shoot = false;
	
	private boolean gameOn = true;
	
	private boolean flop = true;
	private int skip = 0;
	
	private long lastTime;
	
	public PlayerTomcat bigBoy;
	
	
	public static void main(String args[]){
		game = new Main();
		
		game.startGame();
	}
	
	@SuppressWarnings("serial")
	public void startGame(){
		//window = new Windy();
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600, 900);
		
		frame.setVisible(true);
		
		frame.setResizable(false);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//frame.createBufferStrategy(3);
		
		//strategy = frame.getBufferStrategy();
		
		/*
		BufferedImage cursorImg = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		
		frame.setCursor(blankCursor);
		 */
		
		
		panel = new JPanel();
		
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
		
		bigBoy = new PlayerTomcat(800,450,100);
		
		new move(300, 100, 50);
		
		new move(500, 100, 50);
		
		new move(300, 100, 50);
		new move(300, 100, 50);
		
		new move(500, 100, 50);
		
		new move(300, 100, 50);
		
		new move(500, 100, 50);
		new move(500, 100, 50);
		new move(300, 100, 50);
		
		new move(500, 100, 50);
		
		new move(300, 100, 50);
		new move(300, 100, 50);
		
		new move(500, 100, 50);
		
		new move(300, 100, 50);
		
		new move(500, 100, 50);
		new move(500, 100, 50);
		//new Entity(100,100,50);
		
		//new Entity(500, 100, 150);
		
		boolean swetch = true;
		
		first = new BufferedImage(1600,900, BufferedImage.SCALE_FAST);
		second = new BufferedImage(1600,900, BufferedImage.SCALE_FAST);
		
		Graphics g = first.getGraphics();
		//Graphics gg= second.getGraphics();
				
		while(true) {
			lastTime = System.nanoTime();
			
			Entity.updateAll();
			
			
			if(swetch)
				g = first.getGraphics();
			else
				g = second.getGraphics();
			//else if(swetch == 1)
			//	g = third.getGraphics();
			
			g.setColor(new Color(153,204,255));
			g.fillRect(0, 0, 1600, 900);
			
			//make ground
			if(skip == 0){
				for(int counter = 700; counter <= 1000; counter += 50){
					if(flop){
						g.setColor(new Color(12, 122, 14));
						flop = false;
					}
					else{
						g.setColor(new Color(22,132,24));
						flop = true;
					}
					g.fillRect(0, counter-((int)bigBoy.getY()/2), 1600, 900);
				}
			}
			else{
				for(int counter = 700; counter <= 1000; counter += 50){
					if(flop){
						g.setColor(new Color(12, 122, 14));
						flop = false;
					}
					else{
						g.setColor(new Color(22,132,24));
						flop = true;
					}
					g.fillRect(0, counter-((int)bigBoy.getY()/2), 1600, 900);
				}
			}
			skip ++;
			if(skip > 50){
				skip = 0;
			}
			Entity.drawAll(g);
			
			//draw hud here
			
			if(swetch)
				panel.getGraphics().drawImage(first, 0, 0, null);
			else
				panel.getGraphics().drawImage(second, 0, 0, null);
		}
	 
	}
	
	public long getTime(){
		
		long no = System.nanoTime() - lastTime;
		
		if(no == 0L)
			no = 1;
		
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
