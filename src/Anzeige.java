
public class Anzeige 
{
	static final char LEER = ' ' ;
	static final char TREFFER = 'X' ;
	
	
	char[][] spielfeld;
//	char[][] markierenfeld;
//	boolean[][] offenesminefeld;
	
	Anzeige (int X, int Y)
	{
		this.spielfeld = new char [X][Y];
//		this.markierenfeld = new char[X][Y];
//		this.offenesminefeld = new boolean[X][Y];
		
		for (int i= 0; i < X; i++) 
		{
			for(int j = 0; j < Y; j++) 
			{
				this.spielfeld[i][j] = LEER;
			}
		}		
	}
	

	public void setSpielfeld(int x, int y, char symbol) 
	{
		if(symbol == LEER)
		{
			this.spielfeld[x][y] = LEER;
		}
		else
		{
			this.spielfeld[x][y] = symbol;
		}
	}

	public char getSpielfeld(int x, int y) 
	{
		return this.spielfeld[x][y];
	}

	public int leerefelder()
	{
		int zaehler = 0;

		for (int i= 0; i < spielfeld.length; i++) //laeuft vertikal
		{
			for(int j = 0; j < spielfeld[0].length; j++) //laeuft horizontal
			{
				if (spielfeld[i][j] == LEER)
				{
					zaehler ++;	
			    }  
	        }
		}
		return zaehler;
	}
	
//	public char getMarkieren(int x, int y)
//	{
//		return markierenfeld[x][y];		
//	}
//	
//	public void setMarkieren(int x, int y)
//	{
//		this.markierenfeld[x][y] = MARK;
//	}
//	
//	public boolean getOffenesMinefeld(int x, int y)
//	{
//		return this.offenesminefeld[x][y];		
//	}
//
//	public void setOffenesMinefeld(int x, int y)
//	{
//		this.offenesminefeld[x][y] = true;		
//	}
	
	
	public boolean erfolg()
	{
		/**
		 * Should fulfil two conditions 
		 * 1. Uncovered tiles should be (Total Tiles - Mined Tiles) 
		 * 2. Don't lose
		 */
		return false;
	}
	
	public boolean misserfolg()
	{
		/**
		 * uncovered Tile is a Mine
		 */
		for (int i = 0; i < 12; i++) 
		{
			for (int j = 0; j < 16; j++) 
			{
				if(spielfeld[i][j] == TREFFER)
				{
					return true;
				}
			}
			
		}
		return false;
	}
}
