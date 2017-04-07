import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
	JFrame frame;
	JPanel panel;
	
	public static void main(String args[]){
		new Main().startGame();
	}
	
	public void startGame(){
		frame = new JFrame();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				BufferedImage img = new BufferedImage(100, 100, BufferedImage.SCALE_DEFAULT);
				
				try {
					img = ImageIO.read(new File("res/img.png"));
				}catch (IOException e) {}
				
				
				
				g.drawImage(img, 0, 0, 300, 300, null);
			}
		};
		
		frame.setContentPane(panel);
		
		frame.setVisible(true);
	}
	
}


