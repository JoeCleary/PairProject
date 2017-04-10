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
	
	boolean up = false, down = false;
	
	int w = 300;
	
	
	
	
	
	public static void main(String args[]){
		new Main().startGame();
	}
	
	public void startGame(){
		frame = new JFrame();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				BufferedImage img = new BufferedImage(100, 100, BufferedImage.SCALE_FAST);
				
				try {
					img = ImageIO.read(new File("res/img.png"));
				}catch (IOException e) {}
				
				if(up){
					w++;
				}else if(down){
					w--;
					
				}
				
				g.drawImage(img, 0, 0, w, w, null);
			}
		};

		frame.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP)
					up = true;
				
				if(ke.getKeyCode() == KeyEvent.VK_DOWN)
					down = true;
				
				panel.repaint();
			}

			
			public void keyReleased(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP)
					up = false;
				
				if(ke.getKeyCode() == KeyEvent.VK_DOWN)
					down = false;
				
				panel.repaint();
			}

			
			public void keyTyped(KeyEvent ke) {}
		});
		
		
		panel.repaint();
		
		frame.setContentPane(panel);
		
		frame.setVisible(true);
	}
	
	
	
}


