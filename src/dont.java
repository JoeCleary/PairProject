import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class dont extends Entity{
	public dont(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		try {
			sprite = ImageIO.read(new File("res/kloud.png"));
		} catch (IOException e) {}
		sprite.setAccelerationPriority(1);
	}
}
