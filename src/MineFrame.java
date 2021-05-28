import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MineFrame extends JFrame implements ActionListener{
    
	MinePanel mPanel;
	JButton newSpiel = new JButton("Neues Spiel");
	BorderLayout fLayout = new BorderLayout();
	
	public MineFrame()
	{
		this.setLayout(fLayout);
		this.mPanel= new MinePanel();
		this.add(BorderLayout.CENTER, this.mPanel);

		this.add(BorderLayout.SOUTH, newSpiel );
		newSpiel.addActionListener(this);
		
		this.setSize(415, 640);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {		
		
		if(arg0.getSource() == newSpiel)
		{			
			this.dispose();
			new MineFrame();			
		}

	}
	
}