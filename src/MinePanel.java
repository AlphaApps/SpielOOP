
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class MinePanel extends JPanel implements MouseListener 
{
	
	private int x, y;

	private KlickBrettSpiel spiel = new MinesweeperSpiel();
	 private int X = spiel.getSpaltenZahl();
	 private int Y = spiel.getZeilenZahl(); 

	private int h;
	private boolean result;
	private String temp; 
	
	public MinePanel()
	{
		this.addMouseListener(this);
	}

	@Override
	public void paint(Graphics gr) 
	{
		super.paint(gr);
		
		h = getHeight()/Y;
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				gr.drawRect(h * i, h * j, h, h);
				spiel.set(i,j);
				temp =  spiel.get(i, j)+"";
				gr.drawString(temp, h * i + (h/2) , h * j + (h/2));
			}
		}
		
		gr.setColor(Color.PINK);
		gr.fillRect(x-(h/2), y-(h/2), h, h);
	}

	@Override
	public void mouseClicked(MouseEvent a) {
		result = spiel.gewonnen();
		System.out.println(result);				
		x = a.getX();
		y = a.getY();
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
