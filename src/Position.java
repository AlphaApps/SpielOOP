
public class Position {

	/**
	 * erstellt ein Koordinaten Array
	 */
	private Koordinaten koord_array[];
	java.util.Random zufall = new java.util.Random();
	
	Position (int anzahlelemente, int hoehe, int breite)
	{
		koord_array = new Koordinaten[anzahlelemente];
		for (int i = 0; i < anzahlelemente; i++) 
		{
			int p = zufall.nextInt(hoehe);
			int q = zufall.nextInt(breite);
			koord_array[i] = new Koordinaten(p, q);
			
			for (int j=0; j<i; j++) 
			{
				// Ist die gezogene Koordinate mit einer
				// vorher gezogenen gleich?
				if (koord_array[i].equals(koord_array[j]))    //&& koord_array[i].getY()==koord_array[j].getY()) 
				{
					i--;
				}
			}
		}
				
	}
	
	Koordinaten get(int idx)
	{
	    return koord_array[idx];
	}
}
