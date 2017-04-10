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
	
	boolean up = false, down = false, left = false, right = false;
	
	boolean gameOn = true;
	
	int w = 300;
	
	int p = 0;
	
	
	
	public static void main(String args[]){
		new Main().startGame();
	}
	
	public void startGame(){
		frame = new JFrame();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				BufferedImage img = new BufferedImage(100, 100, BufferedImage.SCALE_FAST);
				
				try {
					img = ImageIO.read(new File("res/img.png"));
				}catch (IOException e) {}
				
				if(down){
					w++;
				}else if(up && w >= 0){
					w--;
				}
				
				if(right){
					p++;
				}else if(left){
					p--;
				}
				
				g.drawImage(img, p - (w/2), 540 - (w/2), w, w, null);
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


