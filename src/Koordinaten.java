
public class Koordinaten {
	
	private int x;
	private int y;
	
	java.util.Random zufall = new java.util.Random();

	Koordinaten (int a, int b ) 
	{
		this.x = a ;// liefert 0 - 8
		this.y = b;	// liefert 0 - 6
	}

//	Getter-Methoden hier werden benötigt um auf Attribute außerhalb der Klasse Koordinaten pruefen zu koennen
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	
	public boolean equals(Koordinaten obj)
	{
		return this.x == obj.x && this.y== obj.y;
	}
	
	public String toString()
	{
		return ("x : " + this.x + ",  y : " + this.y);
	}
	
	public boolean istNachbar (Koordinaten ob1) 
	{
		boolean temp = false;
		
		/**
		 *   Ueberprueft ob die Koordinate über,unter, neben oder diagonal von sich einen Nachbarn hat
		 */
		
		if ((ob1.y == this.y) &&  ((ob1.x == (this.x + 1)) || (ob1.x == (this.x - 1))))
			temp = true;
		else if((ob1.x == this.x) &&  ((ob1.y == (this.y + 1)) || (ob1.y == (this.y - 1))))
			temp = true;
		else if(((ob1.x == (this.x + 1)) && (ob1.y == (this.y + 1))) ||  ((ob1.x == (this.x - 1)) && (ob1.y == (this.y - 1))))
			temp = true;
		else if(((ob1.x == (this.x + 1)) && (ob1.y == (this.y - 1))) ||  ((ob1.x == (this.x - 1)) && (ob1.y == (this.y + 1))))
			temp = true;
		return temp;
	}
}
