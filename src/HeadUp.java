import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class HeadUp{
	BufferedImage sprite;
	BufferedImage missileMajor;
	BufferedImage missileMinor;
	BufferedImage hud;
	Font hudText;
	Graphics gui;
	int score = 0;
	//new HeadUp(600,500,1000);
	public HeadUp() {
		hudText = new Font("Impact", Font.PLAIN, 44);
		
		try {
			hud = ImageIO.read(new File("res/hud.png"));
			missileMajor = ImageIO.read(new File("res/missilemajor.png"));
			missileMinor = ImageIO.read(new File("res/missileminor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void update(){
		//BufferedImage imag = new BufferedImage(1600, 900, 0);
		sprite = new BufferedImage(1600, 900, BufferedImage.TRANSLUCENT);
		
		Graphics gui = sprite.getGraphics();
		//Graphics ggg = imag.getGraphics();//draw to a buffer maybe? 
		
		gui.drawImage(hud, 0, 0, null);
		
		score++;//test.getScore();
		int hits = 13;//test.getScore();
		int missiles = 33;//test.getScore();
		gui.setFont(hudText);
		gui.setColor(Color.YELLOW);
		gui.drawString("score: " + score, 310, 67);
		gui.drawString("hits: " + hits, 810, 67);
		int majorMissiles = missiles/10;
		int minorMissiles = missiles%10;
		int outsideCounter = 0;
		/*
		for(int counter = 0; counter < majorMissiles; counter++){
			System.out.println("DEBUG: drawing a major missile at " + (1400+(counter*3)));
			gui.drawImage(missileMajor, 1000+(counter*40), 650, null);
			outsideCounter = counter*40;
		}
		
		for(int counter = 0; counter < minorMissiles; counter++){
			System.out.println("DEBUG: drawing a minor missile at " + (1400+outsideCounter+(counter*1)));
			gui.drawImage(missileMinor, (1000+outsideCounter+40+(counter*25)), 691, null);
		}
		*/
	}
	
	public void addToScore(int add){
		score += add;
	}

}
