// helicopter- very slowly moves forwards. launches one missile half-way to the player
public class EnemyHip extends EnemyPlane{

	private int x;
	private int y;
	private int z;
	
	public EnemyHip(int nX, int nY, int nZ) {
		super(nX, nY, nZ);
		x = nX;
		y = nX;
		// z = furthest from camera
		
	}
	
}
