package logistic;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddFrame extends SubFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddFrame(MainFrame mf, Object[] columnNames)
	{
		super(mf, columnNames);
		columns = new JLabel[columnNames.length];
		enterField = new JTextField[columnNames.length];
		for(int i = 0; i < columns.length; i++)
		{
			columns[i] = new JLabel(columnNames[i].toString());
			columns[i].setBounds(15, 30 * (i+1), 100, 27);
			enterField[i] = new JTextField();
			enterField[i].setBounds(130, 30 * (i+1), 100, 27);
			contentPanel.add(columns[i]);
			contentPanel.add(enterField[i]);
		}
		setTitle("Add Row");
	}
}