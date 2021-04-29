
import java.awt.Graphics;

import javax.swing.JPanel;


public class MinePanel extends JPanel 
{
	
	final int X = 12;
	final int Y = 16;
	final int MINEN = 20;
	
	private Position minen = new Position(MINEN, X, Y);
	private Anzeige anzeige = new Anzeige(X, Y);
	
	private char symbol;
	private int p;

	@Override
	public void paint(Graphics gr) 
	{
		super.paint(gr);
		
		p = getHeight()/Y;
		
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				gr.drawRect(p * i, p * j, p, p);
				symbol = minen.suche(new Koordinaten(i,j));
				anzeige.set(i,j, symbol);
				gr.drawString(anzeige.get(i, j), p * i + (p/2) , p * j + (p/2));
			}
		}		
	}
	
	

}
