
public class Koordinaten {
	
	private int x;
	private int y;
	
	java.util.Random zufall = new java.util.Random();

	Koordinaten (int a, int b ) 
	{
		this.x = a ;// liefert 0 - 8
		this.y = b;	// liefert 0 - 6
	}

	/**
	 * 	Getter-Methoden hier werden benoetigt um auf Attribute ausserhalb der Klasse Koordinaten pruefen zu koennen
	 * @return
	 */
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	
	public boolean istGleich(Koordinaten obj)
	{
		return this.x == obj.x && this.y== obj.y;
	}
	
	public String toString()
	{
		return ("x : " + this.x + ",  y : " + this.y);
	}
	
	public boolean istNachbar (Koordinaten ob1) //wird in Position verwendet (l.52)
	{
		boolean temp = false;
		
		/**
		 *   Ueberprueft ob die Koordinate ueber,unter, neben oder diagonal von sich einen Nachbarn hat
		 */
		
		if ((ob1.y == this.y) &&  ((ob1.x == (this.x + 1)) || (ob1.x == (this.x - 1)))) //Ueberprueft beim selben y ob rechts oder links eine Mine liegt
			temp = true;
		else if((ob1.x == this.x) &&  ((ob1.y == (this.y + 1)) || (ob1.y == (this.y - 1)))) //Ueberprueft ob beim selben x oben oder unten eine Mine liegt
			temp = true;
		else if(((ob1.x == (this.x + 1)) && (ob1.y == (this.y + 1))) ||  ((ob1.x == (this.x - 1)) && (ob1.y == (this.y - 1)))) //Diagonale links unten, rechts oben
			temp = true;
		else if(((ob1.x == (this.x + 1)) && (ob1.y == (this.y - 1))) ||  ((ob1.x == (this.x - 1)) && (ob1.y == (this.y + 1)))) //Diagonale links oben, rechts unten
			temp = true;
		return temp;
	}
}
