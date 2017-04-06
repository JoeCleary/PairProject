// basic jet- comes from behind or the front, has no weapons. moves diagonally from one end of the screen to the other
public class EnemyFitter extends EnemyPlane{

	private int x;
	private int y;
	private int z;
	private boolean behind;
	
	public EnemyFitter(int nX, int nY, int nZ, boolean inBehind) {
		super(nX, nY, nZ);
		x = nX;
		y = nX;
		behind = inBehind;
		if (behind){
			// z = closest to camera
		}
		else{
			// z = furthest to camera
		}
	}
}
