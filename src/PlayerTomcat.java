import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerTomcat extends Entity{
	//z should always be 0 for the player
	
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
		
		if(Main.getUp()) 
			y -= 0.25f;
		else if(Main.getDown())
			y += 0.25f;
		
		if(Main.getRight())
			x += 0.25f;
		else if(Main.getLeft())
			x -= 0.25f;
	}
}
