import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class MeinTableModell extends AbstractTableModel {


	static Object[][] daten = {
			{ "", 0},{ "", 0},
			{ "", 0},{ "", 0},
	};
	   
	@SuppressWarnings("rawtypes")
	private Class[] spaltenKlasse = {
			String.class, Integer.class, Boolean.class	
	};

	@Override
	public Class<?> getColumnClass (int col)
	{
		return spaltenKlasse[col];
	}
	
	@Override
	public int getColumnCount() 
	{
		return 2;
	}

	@Override
	public String getColumnName(int index) 
	{
		return index == 0 ? "Player Name" : "Score";
	}

	@Override
	public int getRowCount() 
	{
		return daten.length;
	}
	
	 public void setValueAt(String value, int second, int row) 
	 {
         daten[row][0] = value;
         daten[row][1] = second;
//         fireTableCellUpdated(index, 0);
     }

	@Override
	public Object getValueAt(int row, int col) 
	{
		return daten[row][col];
	}

}
