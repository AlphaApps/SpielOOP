
public class Koordinaten {
	
	private int x;
	private int y;
	
	java.util.Random zufall = new java.util.Random();

	Koordinaten (int a, int b ) 
	{
		this.x = a ;// liefert 0 - 8
		this.y = b;	// liefert 0 - 6
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Koordinaten obj)
	{
		return this.x == obj.x && this.y== obj.y;
	}
	
	public String toString()
	{
		return ("x : " + this.getX() + ",  y : " + this.getY());
	}
}
