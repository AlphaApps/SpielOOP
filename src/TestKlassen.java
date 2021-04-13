
public class TestKlassen {
	
   static int a, b;
   
	public static void main(String[] args) {
		
		final int ANZAHL = 10;
		
		final int X = 9;
		final int Y = 7;
		
		Koordinaten a1 = new Koordinaten(1,3);
		Koordinaten b1 = new Koordinaten(1,3);
		
		System.out.println(a1.equals(b1));
		System.out.println("----------------------------------------");
		System.out.println(a1.toString());
		System.out.println("----------------------------------------");
	
		Position pos = new Position(ANZAHL, X, Y);

		
		for (int i=0; i<ANZAHL; i++) 
		{
			System.out.println(pos.get(i).toString());
		}
		
}
}
