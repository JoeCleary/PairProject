import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyPlane extends Entity{
	public EnemyPlane(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		w = 267;
		h = 83;
		
		if(Math.random() > 0.5){
			z = 120;
			
			y = (float) (Math.random() * 900);
			
			
			yV = (float) (Math.random() * 2000);
				
			zV = (float) -(Math.random() * 2000) - 1000;
			try {
				sprite = ImageIO.read(new File("res/fitterbehind.png"));
			} catch (IOException e) {}
		}else{
			z = 1;
			
			y = (float) (Math.random() * 300);
			
			yV = (float) -(Math.random() * 2000) ;
			
			zV = (float) (Math.random() * 2000) + 1000;
			try {
				sprite = ImageIO.read(new File("res/bleh.png"));
			} catch (IOException e) {}
			
		}
			
		
		xV = (float) (Math.random() * 20000) - 10000;
		
		sprite.setAccelerationPriority(1);
	}
	
	public int getType(){
		return 2;
	}
}
