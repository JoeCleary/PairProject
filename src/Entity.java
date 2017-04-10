import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.*;

public class Entity {
	protected float x, y, z;
	protected float xV, yV, zV;
	
	private static ArrayList<Entity> allEntities = new ArrayList<Entity>();
	
	public Entity(float nX, float nY, float nZ){
		x = nX;
		y = nY;
		z = nZ;
		
		allEntities.add(this);
	}
	
	public static void updateAll(){
		for(Entity e : allEntities)
			e.update();
	}
	
	private void update(){
		x = x + xV;
		y = y + yV;
		z = z + zV;
	}
	
	public BufferedImage getSprite(){
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("PictureProject/res/img.png"));
		}catch (IOException e) {}
		
		return img;
	}
}