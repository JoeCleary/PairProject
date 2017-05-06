import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class PlayerTomcat extends Entity implements ActionListener{
	//z should almost always be 0 for the player
	int score;
	Timer timer;
	long lastTime;
	
	public PlayerTomcat(float nX, float nY, float nZ) {
		super(nX, nY, nZ);
		
		timer = new Timer(100, this);
		
		xV = 0;
		yV = 0;
		zV = 0;
		
		w = 498;
		h = 144;
		
		try {
			sprite = ImageIO.read(new File("res/plane.png"));
		} catch (IOException e) {}
		
		sprite.setAccelerationPriority(1);
	}
	
	public void update(){
		super.update();
		
		yV = 0;
		
		xV = 0;
		
		if(Main.getGame().getUp() && y > 100)
			yV = -100000f;
		else if(Main.getGame().getDown() && y + h< 800)
			yV = 100000f;
		
		if(Main.getGame().getRight() && x + w < 1500)
			xV = 100000f;
		else if(Main.getGame().getLeft() && x > 100)
			xV = -100000f;
	}
	
	//add to score
	public void addToScore(int add){
		score += add;
	}
	
	public int getScore(){
		return score;
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == timer)
			if(Main.getGame().getShoot()){
				System.out.println("hello");
				new Tracer(x + 100, y + 100, 99);
			}
			
	}
}
