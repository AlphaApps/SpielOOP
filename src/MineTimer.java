import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MineTimer extends JLabel implements ActionListener{
	
	private Timer timer ;
	private static MineTimer singletonObj = null;
	
	private int counter;

	private MineTimer()
	{
		this.timer = null;	
		this.timer = new Timer(1000, this);
		this.start();
		this.counter = 0;
	}

	public static MineTimer getInstance()
	{		
		if(singletonObj == null)
		{
			singletonObj = new MineTimer();
		}
		else
		{
			singletonObj.restart();
		}
		return singletonObj;
	}

	private void restart()
	{
		this.timer.stop();
		this.start();
		updateTime();
	}

	private void start()
	{
		this.counter = 0;
		this.timer.start();
	}

	private void updateTime()
	{
		this.setText("Zeit : " + this.counter);
		this.counter++;	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		updateTime();
	}
}
