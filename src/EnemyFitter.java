// basic jet- comes from behind or the front, has no weapons. moves diagonally from one end of the screen to the other
public class EnemyFitter extends EnemyPlane{
	private boolean behind;
	
	public EnemyFitter(float nX, float nY, float nZ, boolean inBehind) {
		super(nX, nY, nZ);
		
		behind = inBehind;
		if (behind){
			// z = closest to camera
		}
		else{
			// z = furthest to camera
		}
	}
}
