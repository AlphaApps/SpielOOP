
public class Anzeige 
{
	static final char LEER = ' ' ;
	static final char TREFFER = 'X' ;
	
	char[][] spielfeld;
	
	Anzeige (int X, int Y)
	{
		this.spielfeld = new char [X][Y];		
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
		this.spielfeld[x][y] = symbol;		
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
}
