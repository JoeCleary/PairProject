// jet- comes from the front, flies straight, fires a missile when half-way to the player
public class EnemyFrogfoot extends EnemyPlane{

	private int x;
	private int y;
	private int z;
	
	public EnemyFrogfoot(int nX, int nY, int nZ) {
		super(nX, nY, nZ);
		x = nX;
		y = nX;
		// z = furthest from camera
		
	}
	
}
