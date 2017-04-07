// jet- comes from behind, moves diagonally and does a roll, appears one at a time
public class EnemyFoxhound extends EnemyPlane{

	private int x;
	private int y;
	private int z;
	
	public EnemyFoxhound(int nX, int nY, int nZ) {
		super(nX, nY, nZ);
		x = nX;
		y = nX;
		// z = nearest to camera
		
	}
	
}
