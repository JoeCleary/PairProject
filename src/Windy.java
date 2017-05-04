import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Windy extends Canvas implements Runnable{
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
	
	public void draw(){
		Graphics g = strategy.getDrawGraphics();
		
		g.setColor(new Color(153,204,255));
		g.fillRect(0, 0, 1600, 900);
		
		//make ground
		g.setColor(new Color(12, 122, 14));
		g.fillRect(0, 600, 1600, 900);
		
		Entity.updateAll(g);
		
		g.dispose();
	}
	
	public void run(){
		this.draw();
	}
}
