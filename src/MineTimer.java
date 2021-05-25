import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;

public class MineTimer extends JLabel implements ActionListener{
	
	Timer timer ;
	static MineTimer abc = null;
	JLabel label;
	int counter;

	private MineTimer()
	{
		this.timer = null;
		this.label = new JLabel("Time :");
		this.timer = new Timer(1000, this);
		this.start();
		this.counter = 0;
	}

	public static MineTimer getInstance()
	{
		if(abc == null)
		{
			abc = new MineTimer();			
		}
		return abc;
	}

	public void start()
	{
		this.timer.start();
	}

	public void stop()
	{
		this.timer.stop();
		this.counter = 0;
	}

	public JLabel getSeconds()
	{
		return this.label;
	}
	@Override
	public void paint(Graphics g) 
	{		
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(300,500, 20, 20);
		g.drawString("Time :" + label, 300, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.label.setText("Time : " + this.counter);

		this.counter++;
		System.out.println("Time : " + this.counter);
		// repaint();
	}

}
