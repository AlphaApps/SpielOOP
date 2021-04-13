
public class Anzeige {

	static final char LEER = ' ' ;
	static final char TREFFER = 'X' ;
	char[][] spielfeld;
	
		Anzeige (int X, int Y)
	{
		this.spielfeld = new char [X][Y];
		
		for (int i= 0; i < X; i++) {
			for(int j = 0; j < Y; j++) {
				spielfeld[i][j] = LEER;
			}
		}
		
	}
	
	
	public void set(int x, int y, char symbol) {
		this.spielfeld[x][y] = symbol;

		
	}
		
	public char get(int x, int y) {
		return this.spielfeld[x][y];
	}

		
}
