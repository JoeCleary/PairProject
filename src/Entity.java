import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.imageio.*;

public class Entity {
	protected float x, y, z;
	protected float xV, yV, zV;
	protected BufferedImage sprite;
	
	private static ArrayList<Entity> allEntities = new ArrayList<Entity>();
	
	public Entity(float nX, float nY, float nZ){
		x = nX;
		y = nY;
		z = nZ;
		
		try {
			sprite = ImageIO.read(new File("PictureProject/res/img.png"));
		}catch (IOException e) {}
		
		allEntities.add(this);
	}
	
	public static void updateAll(Graphics g){
		for(Entity e : allEntities){
			e.update();
			
			sortEntities();
			
			g.drawImage(e.sprite, (int)e.x - ((int)e.z/2), (int)e.y - ((int)e.z/2), (int)e.z, (int)e.z, null);
		}
	}
	
	private void update(){
		x = x + xV;
		y = y + yV;
		z = z + zV;
	}
	
	public BufferedImage getSprite(){
		return sprite;
	}
	
	public static void sortEntities(){
		allEntities.sort(new Comparator<Entity>(){
			public int compare(Entity one, Entity two) {
				return ((int) one.z - (int) two.z);
			}
		});
	}
}