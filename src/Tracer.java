import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tracer extends Entity{
	public Tracer(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		zV = -10f;
		
		
		
		try {
			sprite = ImageIO.read(new File("res/tracer.png"));
		} catch (IOException e) {}
	}
	
	public void update(){
		super.update();
		
		
		if(z <= 0)
			Entity.getEntities().remove(this);
	}
}
