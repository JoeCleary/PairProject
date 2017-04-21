import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerTomcat extends Entity{
	//z should always be 0 for the player
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
		
		if(Main.game.getUp()) 
			y -= 2f;
		else if(Main.game.getDown())
			y += 2f;
		
		if(Main.game.getRight())
			x += 2f;
		else if(Main.game.getLeft())
			x -= 2f;
	}
	
	//add to score
}
