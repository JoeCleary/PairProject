import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerTomcat extends Entity{
	//z should almost always be 0 for the player
	int score;
	
	public PlayerTomcat(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		xV = 0;
		yV = 0;
		zV = 0;
		
		try {
			sprite = ImageIO.read(new File("res/plane.png"));
		} catch (IOException e) {}
	}
	
	public void update(){
		super.update();
		
		yV = 0;
		
		xV = 0;
		
		if(Main.game.getUp()) 
			yV = -200;
		else if(Main.game.getDown())
			yV = 200;
		
		if(Main.game.getRight())
			xV = 200;
		else if(Main.game.getLeft())
			xV = -200;
	}
	
	//add to score
	public void addToScore(int add){
		score += add;
	}
	
	public int getScore(){
		return score;
	}
}
