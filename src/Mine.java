
public class Mine extends Koordinaten {
	Mine (int a, int b ) 
	{ 
		super( a,  b);
	}
	@Override
	public boolean equals(Koordinaten obj)
	{
		return super.getX() == obj.getX() && super.getY()== obj.getY();
	}
	
	@Override
	public String toString()
	{
		return (("x : " + super.getX() + ",  y : " + super.getY()));
	}
}
