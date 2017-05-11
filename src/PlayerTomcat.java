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
		
		target = new Reticle(x, y + 50, z);
		
		try {
			mid = ImageIO.read(new File("res/plane.png"));
			up  = ImageIO.read(new File("res/planeup.png"));
			down = ImageIO.read(new File("res/planedown.png"));
		} catch (IOException e) {}
		
		sprite = mid;
	}
	
	public void update(){
		super.update();
		
		yV = 0;
		
		xV = 0;
		
		if(Main.getGame().getUp() && y > 100){
			sprite = up;
			yV = -50000f;
		}
		else if(Main.getGame().getDown() && y + h< 800){
			sprite = down;
			yV = 50000f;
		}
		else{
			sprite = mid;
		}
		
		if(Main.getGame().getRight() && x + w < 1500){
			xV = 50000f;
		}
		else if(Main.getGame().getLeft() && x > 100){
			xV = -50000f;
		}
		
		if(Main.getGame().getShoot() && shotCount < 1){
			System.out.println(shotCount);
			shotCount++;
			Tracer t = new Tracer(x + 244, y + 72, 95, 10, 10);//change z to go towards target
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
}
