
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MinePanel extends JPanel implements MouseListener 
{
	
	private KlickBrettSpiel spiel = new MinesweeperSpiel();
	 private int X = spiel.getSpaltenZahl();
	 private int Y = spiel.getZeilenZahl(); 

	private boolean result;
	private String temp; 
	private Dimension dimension = new Dimension(50, 50);
	
	GridLayout gbLayout = new GridLayout(Y, X);
	GridBagConstraints gbCon = new GridBagConstraints();
	
	public MinePanel()
	{
		this.addMouseListener(this);
		
		setLayout(gbLayout);
		gbCon.gridy = 0;
		gbCon.gridx = 0;
		
		for (int i = 0; i < X; i++)
		{
				for (int j = 0; j < Y; j++)
				{
					spiel.set(i,j);
					temp = spiel.get(i, j)+"";
					JButton b = new JButton(MinesweeperSpiel.UNGEKLICKT+"");
//					JButton b = new JButton(temp);
					b.setPreferredSize(dimension);
					
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							b.setText(temp);
						}
					});
					this.add(b, gbCon);
					gbCon.gridx++;
				}
				gbCon.gridx = 0;
				gbCon.gridy++;
		}
		
	}

	@Override
	public void paint(Graphics gr) 
	{
		super.paint(gr);
		if(spiel.gewonnen())
		{
			gr.setColor(Color.yellow);
			gr.fillRect(0, 0, getWidth(), getHeight());
			gr.setColor(Color.BLACK);
			this.add(new JLabel("You have won"));
		}
		else if(spiel.verloren())
		{
			gr.setColor(Color.red);
			gr.fillRect(0, 0, getWidth(), getHeight());
			gr.setColor(Color.BLACK);
			this.add(new JLabel("You have Lost"));
		}
	}

	@Override
	public void mouseClicked(MouseEvent a) {
		
		result = spiel.gewonnen();
		System.out.println(result);				
		a.getX();
		a.getY();
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!spiel.gewonnen() && !spiel.verloren())
		{
			repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	

}
