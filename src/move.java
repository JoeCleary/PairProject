import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class move extends Entity{

	public move(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		w = 100;
		h = 100;
		
		
		zV = (float) (Math.random() * 100000);
		
		try {
			sprite = ImageIO.read(new File("res/kloud.png"));
		} catch (IOException e) {}
		sprite.setAccelerationPriority(1);
	}
	
	public void update(){
		super.update();
		
		//if(z <= 1 || z >= 300)
			//zV = - zV;
		
		//if(z > 1){
			//Entity.getEntities().remove(this);
			//new move((float) (Math.random() * 1600),(float) (Math.random() * 600),0);
			
			//new move((float) (Math.random() * 1600),(float) (Math.random() * 900),0);
			
		
	}
	
	public int getType(){
		return 3;
	}
}
