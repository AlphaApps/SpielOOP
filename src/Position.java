
public class Position {
	/**
	 * erstellt ein Koordinaten Array
	 */
	private Mine koord_array[];
	java.util.Random zufall = new java.util.Random();
	
	Position (int anzahlelemente, int hoehe, int breite) //hier werden zufaellige Koordinaten generiert
	{
		koord_array = new Mine[anzahlelemente];
		for (int i = 0; i < anzahlelemente; i++) 
		{
			int p = zufall.nextInt(hoehe);
			int q = zufall.nextInt(breite);
			koord_array[i] = new Mine (p, q);
			
			for (int j=0; j<i; j++) 
			{
				// Ist die gezogene Koordinate mit einer
				// vorher gezogenen gleich?
				if (koord_array[i].equals(koord_array[j]))    
				{
					i--;
				}
			}
		}
				
	}
	
	Mine get(int idx)
	{
	    return koord_array[idx];
	}
	
	public char suche(Koordinaten koord) 
	{
		char rueckgabe = '0' ;
		int anzahl = 0;
		
		for (int i = 0; i < koord_array.length; i++) 
		{
				
			if ( koord_array[i].getX() == koord.getX() &&  koord_array[i].getY() == koord.getY()) //ueberprueft ob sich die Mine auf der gegenwaertigen Koordinaate befindet
			{
				rueckgabe = Anzeige.TREFFER;
				return rueckgabe;
			}
			
			boolean nachbarcheck = koord_array[i].istNachbar(koord);
			
			if(nachbarcheck == true)
			{
			 anzahl++;
			}
		}
		
		rueckgabe = (char)('0' + anzahl);
		return rueckgabe;
		}
}

