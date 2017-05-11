import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class PlayerTomcat extends Entity{
	//z should almost always be 0 for the player
	long lastTime;
	BufferedImage mid, up, down;
	public int shotCount = 0;
	Reticle target;
	
	public PlayerTomcat(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		xV = 0;
		yV = 0;
		zV = 0;
		
		w = 498;
		h = 144;
		
		r = 205;
		
		target = new Reticle(x, y + 25, z);
		
		try {
			mid = ImageIO.read(new File("res/plane.png"));
		} catch (IOException e) {}
		
		sprite = mid;
	}
	
	public void update(){
		super.update();
		
		yV = 0;
		
		xV = 0;
		
		if(Main.getGame().getUp() && y > 0){
			sprite = up;
			yV = -50000f;
		}
		else if(Main.getGame().getDown() && y + h< 900){
			//sprite = down;
			yV = 50000f;
		}
		else{
			sprite = mid;
		}
		
		if(Main.getGame().getRight() && x + w < 1700){
			xV = 50000f;
		}
		else if(Main.getGame().getLeft() && x > 0){
			xV = -50000f;
		}
		
		if(Main.getGame().getShoot() && !Main.getGame().getBurn() &&shotCount < 1){
			System.out.println(shotCount);
			shotCount++;
			//Tracer t = new Tracer(x + 244, y + 72, 95, 10, 10);//change z to go towards target
			new Tracer(target.x, target.y, 99);
			
			for(Entity e : Entity.getEntities()){
				if(e.getType() == 2 && target.x < e.x + e.h && target.x > e.x && target.y < e.y + e.h && target.y > e.y && target.z > e.z){
					e.marked = true;
					Main.getGame().getHud().score += 100;
					Main.getGame().getHud().hits += 1;
					
					new EnemyPlane((float) (Math.random() * 1600),(float) (Math.random() * 600),0);
				}
			}
			
			//t.update();
		}
	}
	
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public float getZ(){
		return z;
	}
	
	public int getType(){
		return 4;
	}
}
