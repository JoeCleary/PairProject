import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class move extends Entity{

	public move(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		try {
			sprite = ImageIO.read(new File("res/img.png"));
		} catch (IOException e) {}
	}
	
	public void update(){
		
	}

}
