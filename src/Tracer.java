import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tracer extends Entity{
	
	public Tracer(float nX, float nY, float nZ, float nXV, float nYV) {
		super(nX, nY, nZ);
		
		zV = -50000;
		
		yV = -5;
		
		nXV = xV;
		nYV = yV;
		
		w = 44;
		h = 24;
		
		try {
			sprite = ImageIO.read(new File("res/tracer.png"));
		} catch (IOException e) {}
		sprite.setAccelerationPriority(1);
	}
	
	public void update(){
		super.update();
	}
	
	public int getType(){
		return 1;
	}
}
