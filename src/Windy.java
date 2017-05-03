import java.awt.Canvas;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Windy extends Canvas{
	private JFrame frame;
	private BufferStrategy strategy;
		
	
	Windy(){
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600, 900);
		
		frame.setVisible(true);
		
		frame.setResizable(false);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.createBufferStrategy(1);
		
		strategy = frame.getBufferStrategy();
	}
}
