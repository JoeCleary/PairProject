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
	public int score = 0;
	public int hits;
	public int missiles;
	public HeadUp() {
		hudText = new Font("Impact", Font.PLAIN, 44);
		
		try {
			hud = ImageIO.read(new File("res/hud.png"));
			missileMajor = ImageIO.read(new File("res/missilemajor.png"));
			missileMinor = ImageIO.read(new File("res/missileminor.png"));
		} catch (IOException e) {
		}
		
		
	}
	
	public void update(){
		sprite = new BufferedImage(1600, 900, BufferedImage.TRANSLUCENT);
		score++;
		Graphics gui = sprite.getGraphics();
		
		gui.drawImage(hud, 0, 0, null);
		
		gui.setFont(hudText);
		gui.setColor(Color.YELLOW);
		gui.drawString(""+score, 310, 67);
		gui.drawString(""+ hits, 810, 67);

	}
	
	public void addToScore(int add){
		score += add;
	}

}
