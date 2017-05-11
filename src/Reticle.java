import java.awt.Color;
import java.awt.image.BufferedImage;

public class Reticle extends Entity{

	public Reticle(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		w = 50;
		h = 50;
		
		sprite = new BufferedImage(50, 50, BufferedImage.TRANSLUCENT);
		
		sprite.getGraphics().setColor(Color.DARK_GRAY);
		sprite.getGraphics().drawRect((int)0, (int)0, (int)w, (int)h);
	}
	
	public void update(){
		super.update();
		
		yV = 0;
		
		xV = 0;
		
		if(Main.getGame().getUp() && y > 100){
			yV = -50000f;
		}
		else if(Main.getGame().getDown() && y + h< 800){
			yV = 50000f;
		}
		
		if(Main.getGame().getRight() && x + w < 1500){
			xV = 50000f;
		}
		else if(Main.getGame().getLeft() && x > 100){
			xV = -50000f;
		}
	}

}
