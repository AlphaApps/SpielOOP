
public class MinesweeperSpiel implements KlickBrettSpiel
{
	final int X = 12;
	final int Y = 16;
	final int MINEN = 20;
	
	private char resultat;
//	private int x, y;
	private char symbol;
	private char mark;
	
	private Position minen = new Position(MINEN, X, Y);
	private Anzeige anzeige = new Anzeige(X, Y);
	
	@Override
	public void set(int x, int y) 
	{
		symbol = minen.suche(new Koordinaten(x,y));
		anzeige.setSpielfeld(x, y, symbol);
	}
	
	@Override
	public void markiere(int x, int y) 
	{
//		if(anzeige.getMarkieren(x, y) != Anzeige.MARK)
//		{
//			anzeige.setMarkieren(x, y);
//		}
	}
	
	@Override
	public char get(int x, int y) 
	{
//		mark = anzeige.getMarkieren(x, y);
//		if( mark == Anzeige.MARK)
//		{
//			return mark; 
//		}
		resultat = anzeige.getSpielfeld(x, y);
//		if(resultat == Anzeige.LEER)
//		{
//			return ' ';
//		}
		return resultat;
	}
	
	@Override
	public boolean gewonnen() 
	{
		return false;
	}
	
	@Override
	public boolean verloren() 
	{			
		return false;
	}
	
	@Override
	public int getZeilenZahl() 
	{
		return Y;
	}
	
	@Override
	public int getSpaltenZahl() 
	{
		return X;
	}
	
}
