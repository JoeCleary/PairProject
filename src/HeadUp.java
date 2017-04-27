import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;

import javax.imageio.ImageIO;


public class HeadUp extends Entity{
	
	BufferedImage missileMajor;
	BufferedImage missileMinor;
	Font hudText;
	Graphics gui;
	//new HeadUp(600,500,1000);
	public HeadUp(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		hudText = new Font("Impact", Font.PLAIN, 44);
		
		try {
			sprite = ImageIO.read(new File("res/hud.png"));
			missileMajor = ImageIO.read(new File("res/missilemajor.png"));
			missileMajor = ImageIO.read(new File("res/missilemajor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		Graphics gui = sprite.getGraphics();
		int score = 421552;//test.getScore();
		int hits = 13;//test.getScore();
		int missiles = 33;//test.getScore();
		gui.setFont(hudText);
		gui.setColor(Color.YELLOW);
		gui.drawString("score: " + score, 310, 67);
		gui.drawString("hits: " + hits, 810, 67);
		int majorMissiles = missiles/10;
		int minorMissiles = missiles%10;
		int outsideCounter = 0;
		for(int counter = 0; counter < majorMissiles; counter++){
			System.out.println("DEBUG: drawing a major missile at " + (1500+(counter*3)));
			gui.drawImage(missileMajor, 1500+(counter*3), 650, null);
			outsideCounter = counter*5;
		}
		for(int counter = 0; counter < minorMissiles; counter++){
			System.out.println("DEBUG: drawing a minor missile at " + (1500+(counter*1)));
			gui.drawImage(missileMinor, 1500+(counter*1), 650, null);
		}
	}

}
