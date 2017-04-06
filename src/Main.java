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
				
				//try {
					//img = ImageIO.read(new File("PictureProject/res/img.png"));
				//}catch (IOException e) {}
				
				g.drawImage(img, 0, 0, null);
			}
		};
		
		panel.repaint();
		
		frame.setContentPane(panel);
		
		frame.setVisible(true);
	}
	
	
	
	
	
	class Imag extends VolatileImage{

		@Override
		public boolean contentsLost() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Graphics2D createGraphics() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ImageCapabilities getCapabilities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getHeight() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public BufferedImage getSnapshot() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int validate(GraphicsConfiguration arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getHeight(ImageObserver arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getProperty(String arg0, ImageObserver arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getWidth(ImageObserver arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}
	
}


