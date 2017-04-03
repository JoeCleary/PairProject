import java.util.ArrayList;

public class Entity {
	private int x, y, z;
	private int xV, yV, zV;
	
	public ArrayList<Entity> allEntities = new ArrayList<Entity>();
	
	public Entity(){
		
	}
	
	public void updateAll(){
		
	}
	
	private void update(){
		x = x + xV;
		y = y + yV;
		z = z + zV;
		
		
	}
}
