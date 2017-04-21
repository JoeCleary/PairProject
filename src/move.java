import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class move extends Entity{

	public move(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		zV = .1f;
		
		try {
			sprite = ImageIO.read(new File("res/img.png"));
		} catch (IOException e) {}
	}
	
	public void update(){
		super.update();
		
		if(z <= 1 || z >= 200)
			zV = - zV;
			
	}

}
