import javax.swing.JFrame;

public class MineFrame extends JFrame{
    
	public MineFrame()
	{
		this.add(new MinePanel());
		this.setSize(377,520);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
}
