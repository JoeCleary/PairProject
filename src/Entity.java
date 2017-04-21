import java.awt.Graphics;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.imageio.*;

public class Entity {
	protected float x, y, z;// make these vectors
	protected float xV, yV, zV;
	protected BufferedImage sprite;
	protected long timeCreated;
	
	private static ArrayList<Entity> allEntities = new ArrayList<Entity>();
	
	public Entity(float nX, float nY, float nZ){
		x = nX;
		y = nY;
		z = nZ;
		
		timeCreated = System.nanoTime();
		
		allEntities.add(this);
		
		try {
			sprite = ImageIO.read(new File("res/img.png"));
		} catch (IOException e) {}
	}
	
	public static void updateAll(Graphics g){
		for(Entity e : Entity.getEntities()){
			e.update();
			
			//e.changeState();
		}
		
		sortEntities();
		
		for(Entity e : Entity.getEntities()){
			//System.out.println("(" + e.x + "," + e.y + "," + e.z + ")");
			
			g.drawImage(e.sprite, (int)e.x - ((int)e.z/2), (int)e.y - ((int)e.z/2), (int)e.z, (int)e.z, null);
			
			//g.drawImage(e.sprite, (int)e.x - ((int)e.z/2), (int)e.y - ((int)e.z/2), null);
		}
	}
	
	protected void update(){
		
		/*
		x = x + (xV / (System.nanoTime() - timeCreated));
		y = y + (yV / (System.nanoTime() - timeCreated));
		z = z + (zV / (System.nanoTime() - timeCreated));
		*/
		
		
		x = x + xV;
		y = y + yV;
		z = z + zV;
	}
	
	public BufferedImage getSprite(){
		return sprite;
	}
	
	private static void sortEntities(){
		allEntities.sort(new Comparator<Entity>(){
			public int compare(Entity one, Entity two) {
				return ((int) one.z - (int) two.z);
			}
		});
	}
	
	public static ArrayList<Entity> getEntities(){
		return allEntities;
	}
	
	public void changeState(){}
}