package logistic;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditFrame extends SubFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditFrame(MainFrame mf, Object[] columnNames, Object[] values)
	{
		super(mf, columnNames);
		columns = new JLabel[columnNames.length];
		enterField = new JTextField[columnNames.length];
		for(int i = 0; i < enterField.length; i++)
		{
			columns[i] = new JLabel(columnNames[i].toString());
			columns[i].setBounds(15, 30 * (i+1), 100, 27);
			enterField[i] = new JTextField();
			enterField[i].setBounds(130, 30 * (i+1), 100, 27);
			if(values[i] != null)
					enterField[i].setText(values[i].toString());
			contentPanel.add(columns[i]);
			contentPanel.add(enterField[i]);
		}
		setTitle("Edit Row");
	}
}
