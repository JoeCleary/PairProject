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
		if(Main.getUp())
			y--;
		else if(Main.getDown())
			y++;
		
		if(Main.getRight())
			x++;
		else if(Main.getLeft())
			x--;
	}
}
