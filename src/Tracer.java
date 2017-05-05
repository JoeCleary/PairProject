import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tracer extends Entity{
	public Tracer(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		zV = -50f;
		
		yV = -5;
		
		
		w = 22;
		h = 12;
		
		try {
			sprite = ImageIO.read(new File("res/tracer.png"));
		} catch (IOException e) {}
		sprite.setAccelerationPriority(1);
	}
	
	public void update(){
		super.update();
		
		
		if(z <= 0)
			Entity.getEntities().remove(this);
	}
}
