
public class TestKlassen {
	
//   static int a, b;
   
	public static void main(String[] args) {
		
		final int ANZAHL = 10;
		
		final int X = 9;
		final int Y = 7;
		
		Koordinaten a1 = new Koordinaten(1,3);
		Koordinaten b1 = new Koordinaten(1,3);
		
//		Damit wir aus der Klasse Koordinaten auf die Attribute dieser zugreifen können, benötigen wir Getter-Methode.
//		System.out.println(a1.getX() + "---- " + a1.getY());
		
		
		System.out.println("----------------------------------------");
	
		Position pos = new Position(ANZAHL, X, Y);

		
		for (int i=0; i<ANZAHL; i++) 
		{
			System.out.println(pos.get(i).toString());
		}
		System.out.println("----------------------------------------");
		
		for (int y=0; y<Y; y++) 
		{
			for (int x = 0; x < X; x++) 
			{
				System.out.print(pos.suche(new Koordinaten(x, y)));
				
			}
			System.out.println();
		}
		
}
}
