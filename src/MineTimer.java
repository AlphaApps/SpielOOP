import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MineTimer extends JLabel implements ActionListener{
	
	Timer timer ;
	static MineTimer abc = null;
	
	int counter;

	private MineTimer()
	{
		this.timer = null;	
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.setText("Zeit : " + this.counter);

		this.counter++;
		System.out.println("Time : " + this.counter);
	
	}

}
