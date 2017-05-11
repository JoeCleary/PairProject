import java.awt.Color;
import java.awt.image.BufferedImage;

public class Reticle extends Entity{

	public Reticle(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		w = 50;
		h = 50;
		
		sprite = new BufferedImage(50, 50, BufferedImage.TRANSLUCENT);
		
		sprite.getGraphics().setColor(Color.BLACK);
		sprite.getGraphics().draw3DRect((int)0, (int)0, (int)w, (int)h, false);
	}
	
	public void update(){
		super.update();
		
		x = Main.getGame().getPlayer().x + 225;
		y = Main.getGame().getPlayer().y + 25;
	}

	
	public int getType(){
		return 4;
	}
}
