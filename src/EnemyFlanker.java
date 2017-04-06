// jet- comes from the front, flies straight until half-way to the player, then launches missile & moves diagonally to one corner of the screen
public class EnemyFlanker extends EnemyPlane{

	private int x;
	private int y;
	private int z;
	
	public EnemyFlanker(int nX, int nY, int nZ) {
		super(nX, nY, nZ);
		x = nX;
		y = nX;
		// z = furthest from camera
		
	}
	
}
