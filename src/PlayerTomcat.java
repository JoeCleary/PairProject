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
		
		if(Main.getGame().getUp()) 
			yV = -10;
		else if(Main.getGame().getDown())
			yV = 10;
		
		if(Main.getGame().getRight())
			xV = 10;
		else if(Main.getGame().getLeft())
			xV = -00;
		
		if(Main.getGame().getShoot())
			new Tracer(x, y, 99);
	}
	
	//add to score
	public void addToScore(int add){
		score += add;
	}
	
	public int getScore(){
		return score;
	}
}
