
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
	private boolean result;
	private char temp; 
	// private Dimension dimension = new Dimension(50, 50);
	
	// GridLayout gbLayout = new GridLayout(Y, X);
	// GridBagConstraints gbCon = new GridBagConstraints();
	
	public MinePanel(JButton newSpiel)
	{
		this.addMouseListener(this);
		message = new JLabel("");
		// setLayout(gbLayout);
		// h = getHeight()/Y;
		// for (int i = 0; i < X; i++)
		// {
		// 		for (int j = 0; j < Y; j++)
		// 		{
		// 			spiel.set(i,j);
		// 			temp = spiel.get(i, j);
					// JButton button = new JButton(MinesweeperSpiel.UNGEKLICKT+"");
//					JButton button = new JButton(temp);
					// button.setPreferredSize(dimension);
					
					// button.addActionListener(new ActionListener() {
						
					// 	@Override
					// 	public void actionPerformed(ActionEvent arg0) {
					// 		button.setText(temp);
					// 		System.out.println(gbCon.gridheight + "" + gbCon.gridwidth);

					// 	}
					// });
					// this.add(button, gbCon);
	// 				gbCon.gridx++;
	// 			}
	// 			gbCon.gridx = 0;
	// 			gbCon.gridy++;
	// 	}
	}

	@Override
	public void paint(Graphics gr) 
	{
		super.paint(gr);
		h = getHeight()/Y;
		this.setBackground(Color.cyan);
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				gr.drawRect(h * i, h * j, h, h);
				spiel.set(i,j);
				temp =  spiel.get(i, j);
				gr.drawString(" ", h * i + (h/2) , h * j + (h/2));
				mineClicked (gr, h, i, j);
			}
		}
		if(spiel.gewonnen())
		{			
			this.setBackground(Color.green);
			message.setText("You've won");
			this.add(message);
		}
		else if(spiel.verloren())
		{
			this.setBackground(Color.red);
			message.setText("You have Lost");
			this.add(message);			
		}
	}

	void mineClicked (Graphics gr, int h, int i, int j)
	{		
		if(mx >= h*i && mx < (h*(i+1)) && my >= (h*(j)) && my < (h*(j+1)))
		{
			gr.setColor(Color.cyan);
			gr.fillRect((h * i)+1, (h * j)+1, h-2, h-2);
			gr.setColor(Color.black);
			gr.drawString(temp+"", h * i + (h/3) , h * j + (2*(h/3)));
		}
		gr.setColor(Color.black);
	}

	@Override
	public void mouseClicked(MouseEvent evt) 
	{		
		result = spiel.gewonnen();
		mx = evt.getX();
		my = evt.getY();
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
	

}
