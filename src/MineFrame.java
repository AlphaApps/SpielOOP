import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MineFrame extends JFrame{
    
	public MineFrame()
	{
		BorderLayout fLayout = new BorderLayout();
		this.setLayout(fLayout);
		
		this.add(BorderLayout.CENTER, new MinePanel());
		
		this.add(BorderLayout.SOUTH, new JButton("Neues Spiel"));
		this.setSize(377,520);
		this.setLocationRelativeTo(null);
		pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	
	
}
