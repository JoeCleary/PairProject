import java.awt.*;

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
				
				//g.
			}
		};
		
		
		
		frame.show
	}
}
