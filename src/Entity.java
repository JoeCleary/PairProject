import java.awt.image.*;
import java.util.ArrayList;

public class Entity {
	private int x, y, z;
	private int xV, yV, zV;
	
	public static ArrayList<Entity> allEntities = new ArrayList<Entity>();
	
	public Entity(int nX, int nY, int nZ){
		x = nX;
		y = nY;
		z = nZ;
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
	
	public VolatileImage getSprite(){
		
	}
}