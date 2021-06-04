import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class HighDialog extends JDialog{

	 MeinTableModell myModel = new MeinTableModell();
	 
	 Highscore obj;
	 String name;
	 int row = 0;
	 public HighDialog() 
	 {
		obj = Highscore.getInstance();
		 
        for (Score score: obj)
          {
          	myModel.setValueAt(score.getSpielername(), score.getSekunden(), row);
          	row++;
          }
		
		 JTable table = new JTable(myModel); 
		 table.tableChanged(null);
		 table.setPreferredScrollableViewportSize(new Dimension(400, 200));
		
		 add(new JScrollPane(table));
		 setSize(400, 300);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		 for (Score score: obj)
         {
         	System.out.println(score.getSpielername() +" :  "+ score.getSekunden() + "seconds");	     	
         }	
		 
	}
}
