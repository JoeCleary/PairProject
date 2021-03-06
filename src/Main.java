import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
	public static Main game;
	private JFrame frame;
	private JPanel panel;
	
	BufferedImage first;
	BufferedImage second;
	BufferedImage off;
	
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean shoot = false;
	private boolean burn = false;
	
	private boolean flop = true;
	private int skip = 0;
	
	private long lastTime;
	
	private PlayerTomcat bigBoy;
	private HeadUp hud;
	
	public static void main(String args[]){
		game = new Main();
		
		game.startGame();
	}
	
	public void startGame(){
		//window = new Windy();
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600, 900);
		
		frame.setVisible(true);
		
		frame.setResizable(false);

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
				
				if(ke.getKeyCode() == KeyEvent.VK_SPACE)
					burn = true;
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
				
				if(ke.getKeyCode() == KeyEvent.VK_SPACE)
					burn = false;
			}
			
			public void keyTyped(KeyEvent ke) {}
		});	
		
		frame.setContentPane(panel);
		
		bigBoy = new PlayerTomcat(800,450,100);
		
		hud = new HeadUp();
		
		new EnemyPlane((float) (Math.random() * 1600),(float) (Math.random() * 900),0);
		new EnemyPlane((float) (Math.random() * 1600),(float) (Math.random() * 900),0);
		new EnemyPlane((float) (Math.random() * 1600),(float) (Math.random() * 900),0);
		new move((float) (Math.random() * 1600),(float) (Math.random() * 600),0);
		new move((float) (Math.random() * 1600),(float) (Math.random() * 600),0);
		boolean swetch = true;
		
		first = new BufferedImage(1600,900, BufferedImage.SCALE_FAST);
		second = new BufferedImage(1600,900, BufferedImage.SCALE_FAST);
		
		Graphics2D g = (Graphics2D) first.getGraphics();
		
		GradientPaint horizon;
		
		
		while(true) {
			lastTime = System.nanoTime();
			
			Entity.updateAll();
			
			
			if(swetch)
				g = (Graphics2D) first.getGraphics();
			else
				g = (Graphics2D) second.getGraphics();
			
			g.setColor(new Color(153,204,255));
			g.fillRect(0, 0, 1600, 900);
			
			horizon = new GradientPaint(0, 900 - ((int)bigBoy.getY()), Color.WHITE, 0, 100, new Color(153,204,255));
			g.setPaint(horizon);
			g.fillRect(0, 000, 1600, 900 -((int)bigBoy.getY()/2));
			
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
			
			hud.update();
			g.drawImage(hud.sprite, 0, 0, null);
			
			if(swetch)
				panel.getGraphics().drawImage(first, 0, 0, null);
			else
				panel.getGraphics().drawImage(second, 0, 0, null);
		}
	 
	}
	
	public long getTime(){
		
		long no = System.nanoTime() - lastTime;
		
		if(no == 0L)
			no = Long.MIN_VALUE;
			
		return no;
	}
	
	public static Main getGame(){
		return game;
	}
	
	public PlayerTomcat getPlayer(){
		return bigBoy;
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

	public HeadUp getHud() {
		return hud;
	}
	
	public boolean getBurn(){
		return burn;
	}
}
