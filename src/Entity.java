import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;

import javax.imageio.*;

public class Entity {
	protected float x, y, z;// make these vectors
	protected float xV, yV, zV;
	protected float w = 100, h = 100, r = 0;
	protected final float d = 10f;
	protected BufferedImage sprite;
	protected long timeCreated;
	
	public boolean marked = false;
	
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
	
	public static void updateAll(){
		try{
			for(Entity e : Entity.getEntities()){
				e.update();
				
				if(e.getType() != 4 && Main.getGame().getBurn())
					e.z += 5;
			}
			
			sortEntities();
			
			//check for collision here?
			
		}catch(ConcurrentModificationException cme){}
	}
	
	public static void drawAll(Graphics g){
		try{
			for(Entity e : Entity.getEntities()){
				
				
				if(e.z >= 0 && e.z < 300 && e.x < 1700 && e.y < 1000){//doesnt draw entity and deletes it if it gets to -1 or 150
					g.drawImage(e.sprite, (int)e.x - ((int)e.z/2), (int)e.y - ((int)e.z/2), ((int)e.z *(int)e.w) / 100, ((int)e.z *(int)e.h) / 100, null);
					 
				}else{
					if(e.getType() == 1)
						Main.getGame().getPlayer().shotCount--;
						
					e.marked = true;
					
					if(e.getType() == 2)
						new EnemyPlane((float) (Math.random() * 1600),(float) (Math.random() * 600),0);
					//allEntities.remove(e);
					
					if(e.getType() == 3)
						new move((float) (Math.random() * 1600),(float) (Math.random() * 600),0);
				}
			}
		}catch(ConcurrentModificationException cme){}
		
	}
	
	public float getW(){
		return w;
	}
	public float getH(){
		return h;
	}
	
	protected void update(){
		if(marked)
			allEntities.remove(this);
		
		x += (xV / Main.getGame().getTime());
		y += (yV / Main.getGame().getTime());
		z += (zV / Main.getGame().getTime());
		//x = x + xV;
		//y = y + yV;
		//z = z + zV;
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
	
	public int getType(){
		return 0;
	}
	
	public void changeState(){}
}