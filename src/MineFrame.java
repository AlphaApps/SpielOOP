import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MineFrame extends JFrame implements ActionListener{
    
	MinePanel mPanel;
	
	public MineFrame()
	{
		BorderLayout fLayout = new BorderLayout();
		this.setLayout(fLayout);
		
		JButton newSpiel = new JButton("Neues Spiel");
		this.add(BorderLayout.SOUTH, newSpiel );
		newSpiel.addActionListener(this) ;

		
		mPanel= new MinePanel(newSpiel);
		this.add(BorderLayout.CENTER, mPanel);
		
		this.setSize(400,595);
		// this.setSize(377,520);
		this.setLocationRelativeTo(null);
		// pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
		new MineFrame();
	}
	
}