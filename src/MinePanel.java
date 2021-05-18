import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MinePanel extends JPanel implements MouseListener
{
	private int mx = -10;
	private int my = -10;

	private KlickBrettSpiel spiel = new MinesweeperSpiel();
	private int X = spiel.getSpaltenZahl();
	private int Y = spiel.getZeilenZahl(); 

	private int h;
	private boolean gewinn;
	private boolean verlorn;
	private char temp; 
	
	public MinePanel()
	{
		this.addMouseListener(this);
		
		this.gewinn = false;
		this.verlorn = false;
		
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				spiel.set(i,j);
				((MinesweeperSpiel) spiel).setMarkieren(i,j, ' ');
				((MinesweeperSpiel) spiel).setOffenesMinefeld(i, j, false);
			}
		}
	}

	@Override
	public void paint(Graphics gr) 
	{
		super.paint(gr);
		if(this.gewinn)
		{
			gr.setColor(Color.green);
			gr.fillRect(0, 0, getWidth(), getHeight());
			gr.setColor(Color.black);			
			gr.drawString("You've won", getWidth()/2-50 , getHeight()/2);
		}
		else if(this.verlorn)
		{
			gr.setColor(Color.red);
			gr.fillRect(0, 0, getWidth(), getHeight());
			gr.setColor(Color.black);			
			gr.drawString("You have Lost", getWidth()/2-50 , getHeight()/2);			
		}
		else
		{
			h = getHeight()/Y;		
			for (int i = 0; i < X; i++)
			{
				for (int j = 0; j < Y; j++)
				{
					gr.drawRect(h * i, h * j, h, h);
					if( ((MinesweeperSpiel) spiel).getOffenesMinefeld(i,j) == true)
					{
						gr.setColor(Color.lightGray);
						gr.fillRect((h * i)+1, (h * j)+1, h-1, h-1);
						gr.setColor(Color.black);
						temp =  spiel.get(i, j);
						gr.drawString(temp+" ", h * i + (h/2) , h * j + (h/2));	
					}
					else if( ((MinesweeperSpiel) spiel).getMarkieren(i, j) == '/')
					{
						gr.setColor(Color.cyan);
						gr.fillRect((h * i)+1, (h * j)+1, h-1, h-1);
						gr.setColor(Color.black);
						gr.drawString("/", h * i + (h/2) , h * j + (h/2));
					}
				}
			}
		}	
	}
	
	@Override
	public void mouseClicked(MouseEvent evt) 
	{	
		mx = (int) Math.ceil(evt.getX()/h);
		my = (int) Math.ceil(evt.getY()/h);
		if(evt.getButton() == 1)
		{			
			((MinesweeperSpiel) spiel).setOffenesMinefeld(mx, my, true);
			this.gewinn = spiel.gewonnen();
			this.verlorn = spiel.verloren();
			System.out.println("x : " + mx + ", y : " + my);
		}
		else if(evt.getButton() == 3)
		{
			((MinesweeperSpiel) spiel).setMarkieren(mx,my, MinesweeperSpiel.MARK);
			System.out.println("-------- ");
//			spiel.markiere(mx, my);			//  möchte dies verwenden, hat aber keinen entsprechenden Getter
		}		
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		repaint();		
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		repaint();
	}
	
}
