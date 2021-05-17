
public class MinesweeperSpiel implements KlickBrettSpiel 
{
	
	final int X = 12;
	final int Y = 16;
	final int MINEN = 20;
	
	private char resultat;
//	private int x, y;
	private char symbol;
	
	private Position minen = new Position(MINEN, X, Y);
	private Anzeige anzeige = new Anzeige(X, Y);
	
	
	
	@Override
	public void set(int x, int y) {
		symbol = minen.suche(new Koordinaten(x,y));
		anzeige.set(x, y, symbol);
	}
	@Override
	public void markiere(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public char get(int x, int y) {
		resultat = anzeige.get(x, y);
		if(resultat == Anzeige.LEER)
		{
			return UNGEKLICKT;
		}
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
