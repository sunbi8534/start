package logistic;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubFrame extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	JLabel[] columns;
	protected JTextField[] enterField;
	
	public SubFrame(MainFrame mf, Object[] columnNames)
	{
		setResizable(false);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 438, 232);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 438, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton applyButton = new JButton("apply");
				applyButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String[] returnVal = new String[columnNames.length];
						for(int i = 0; i < columnNames.length; i++)
						{
							returnVal[i] = enterField[i].getText();
						}
						mf.inputFromSubframe(returnVal);
						dispose();
					}
				});
				applyButton.setBounds(312, 5, 66, 23);
				applyButton.setActionCommand("apply");
				buttonPane.add(applyButton);
				getRootPane().setDefaultButton(applyButton);
			}
		}
	}
}
