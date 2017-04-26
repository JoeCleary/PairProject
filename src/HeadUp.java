import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;

import javax.imageio.ImageIO;


public class HeadUp extends Entity{
	
	int score;
	int hits;
	int missiles;
	Font hudText;
	Graphics gui;
	//new HeadUp(600,500,1000);
	public HeadUp(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		try {
			sprite = ImageIO.read(new File("res/hud.png"));
		} catch (IOException e) {System.out.println();}
		gui = sprite.getGraphics();
		gui.setColor(Color.YELLOW);
		hudText = new Font("Impact", Font.PLAIN, 44);
		gui.setFont(hudText);
		gui.drawString(""+0, 310, 67);
		gui.drawString(""+0, 810, 67);
		//gui.drawString("missiles: " + 0, 300, 300);
	}
	
	public void update(){
		Graphics gui = sprite.getGraphics();
		gui.drawString("score: " + test.getScore(), 100, 100);
		gui.drawString("hits: " + test.getHits(), 100, 300);
	}

}
