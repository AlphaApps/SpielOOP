
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MinePanel extends JPanel implements MouseListener
{
	private int mx = -10;
	private int my = -10;

	private KlickBrettSpiel spiel = new MinesweeperSpiel();
	private int X = spiel.getSpaltenZahl();
	private int Y = spiel.getZeilenZahl(); 
	private JLabel message;
	private int h;
	private boolean gewinn;
	private boolean verlorn;
	private char temp; 
	
	private char[][] markierenfeld;
	private boolean[][] offenesminefeld;
	static final char MARK = '/' ;
	
	public MinePanel()
	{
		this.addMouseListener(this);
		message = new JLabel("");
		
		this.markierenfeld = new char[X][Y];
		this.offenesminefeld = new boolean[X][Y];
		
		this.gewinn = false;
		this.verlorn = false;
		
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				spiel.set(i,j);
				this.markierenfeld[i][j] = ' ';
				this.offenesminefeld[i][j] = false;
			}
		}
	}

	@Override
	public void paint(Graphics gr) 
	{
		super.paint(gr);
		if(this.gewinn)
		{			
			this.setBackground(Color.green);
			message.setText("You've won");
			this.add(message);
		}
		else if(this.verlorn)
		{
			this.setBackground(Color.red);
			message.setText("You have Lost");
			this.add(message);			
		}
		
		h = getHeight()/Y;
//		this.setBackground(Color.cyan);
		
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				gr.drawRect(h * i, h * j, h, h);
				if( this.offenesminefeld[i][j] == true)
				{
					gr.setColor(Color.cyan);
					gr.fillRect((h * i)+1, (h * j)+1, h-1, h-1);
					gr.setColor(Color.black);
					temp =  spiel.get(i, j);
					gr.drawString(temp+" ", h * i + (h/2) , h * j + (h/2));	
				}
//				mineClicked (gr, h, i, j);
			}
		}
	
	}
	
	

//	private void mineClicked (Graphics gr, int h, int i, int j)
//	{		
////		if(mx >= h*i && mx < (h*(i+1)) && my >= (h*(j)) && my < (h*(j+1)))
//		if(mx >= h*i && mx < (h*(i+1)) && my >= (h*(j)) && my < (h*(j+1)))
//		{
//			gr.setColor(Color.cyan);
//			gr.fillRect((h * i)+1, (h * j)+1, h-2, h-2);
//			gr.setColor(Color.black);
//			if( this.offenesminefeld[i][i] == true)
//			{
////				gr.drawString(temp+" ", h * i + (h/2) , h * j + (h/2));					
//				gr.drawString(temp+"", h * i + (h/3) , h * j + (2*(h/3)));
//			}
//		}
//		gr.setColor(Color.black);
//	}
	
	@Override
	public void mouseClicked(MouseEvent evt) 
	{	
		mx = (int) Math.ceil(evt.getX()/h);
		my = (int) Math.ceil(evt.getY()/h);
		this.offenesminefeld[mx][my] = true;
		if(evt.getButton() == 3)
		{
			System.out.println("a : " + mx + ", b : " + my);
//			spiel.markiere(b, a);
		}
		else 
		{
			this.gewinn = spiel.gewonnen();
			this.verlorn = spiel.verloren();			
		}
		System.out.println("x : " + mx + ", y : " + my);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		if(!spiel.gewonnen() && !spiel.verloren())
		{
			repaint();
		}
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
	
	public char getMarkieren(int x, int y)
	{
		return this.markierenfeld[x][y];		
	}
	
	public void setMarkieren(int x, int y)
	{
		this.markierenfeld[x][y] = MARK;
	}
	
	public boolean getOffenesMinefeld(int x, int y)
	{
		return this.offenesminefeld[x][y];		
	}

	public void setOffenesMinefeld(int x, int y)
	{
		this.offenesminefeld[x][y] = true;		
	}
	

}
