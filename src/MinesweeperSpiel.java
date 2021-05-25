
public class MinesweeperSpiel implements KlickBrettSpiel
{
	final int X = 12;
	final int Y = 16;
	final int MINEN = 20;
	static final char MARK = '/' ;

	char[][] markierenfeld;
	boolean[][] offenesminefeld;
	
	private char resultat;
	private char tester;

	private char symbol;
	private int count;
	
	private Position minen = new Position(MINEN, X, Y);
	private Anzeige anzeige = new Anzeige(X, Y);

	MinesweeperSpiel ()
	{
		this.markierenfeld = new char[X][Y];
		this.offenesminefeld = new boolean[X][Y];
	}


	@Override
	public void set(int x, int y) 
	{
		symbol = minen.suche(new Koordinaten(x,y));
		anzeige.setSpielfeld(x, y, symbol);
	}
	
	@Override
	public void markiere(int x, int y) 
	{
		
	}
	
	@Override
	public char get(int x, int y) 
	{
		resultat = anzeige.getSpielfeld(x, y);
		return resultat;
	}
	
	@Override
	public boolean gewonnen() 
	{
		this.count = 0;
		for (int i = 0; i < X; i++) 
		{
			for (int j = 0; j < Y; j++) 
			{
				if( getOffenesMinefeld(i, j) == true)
				{
					this.count++;
				}
			}			
		}
		if(this.count == ((X * Y) - MINEN))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean verloren() 
	{		
		for (int i = 0; i < X; i++) 
		{
			for (int j = 0; j < Y; j++) 
			{
				if( getOffenesMinefeld(i, j) == true && anzeige.getSpielfeld(i, j) == Anzeige.TREFFER)
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	public void Nullautomat(int x, int y) 
	{
		int a = x - 1;
		int b = y - 1; 

		tester = anzeige.getSpielfeld(x, y);
		if (tester == Anzeige.LEER) 
		{
			for (int i = a; i < (a + 3); i++) 
			{
				for (int j = b; j < (b + 3); j++) 
				{
					if ((-1 < i && i < X) && ((-1 < j && j < Y)))
					{
						tester = anzeige.getSpielfeld(i, j);
						if (tester == Anzeige.LEER)
						{
							setOffenesMinefeld( i, j, true);
						}
					}
				}
			}
		}
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
	
	public char getMarkieren(int x, int y)
	{
		return this.markierenfeld[x][y];
	}
	
	public void setMarkieren(int x, int y , char val)
	{
		this.markierenfeld[x][y] = val;
	}
	
	public boolean getOffenesMinefeld(int x, int y)
	{
		
		return this.offenesminefeld[x][y];
	}

	public void setOffenesMinefeld(int x, int y, boolean val)
	{
		this.offenesminefeld[x][y] = val;
		
		// if( getOffenesMinefeld(x, y) != true )
		// {
		// 	this.offenesminefeld[x][y] = val;			
		// }
		// else
		// {
		// 	Nullautomat(x, y);
		// }
	}

}
