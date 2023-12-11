package logistic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ItemEvent;
import javax.swing.ListSelectionModel;

public class MainFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BackEnd backEnd;
	
	private JPanel contentPane;
	private JTable table;
	private String pressedButtonName;
	private String currentTableName;
	private Object[][] currentTableValues;
	private Object[] currentTableColumnNames;
	private int selectedRowIndex;
	Object[][] tmpBarcode;

	private void setCurrentTable(String tableName)
	{
		Object[][] tmp = backEnd.readAll(currentTableName = tableName);
		currentTableColumnNames = tmp[0].clone();
		currentTableValues = new Object[tmp.length - 1][tmp[0].length];
		for(int i = 0; i < currentTableValues.length; i++)
			currentTableValues[i] = tmp[i + 1].clone();
		table.setModel(new DefaultTableModel(currentTableValues, currentTableColumnNames));
	}
	
	public void inputFromSubframe(String[] returnText)
	{
		switch(pressedButtonName)
		{
		case "Add":
			backEnd.create(currentTableName, currentTableColumnNames, returnText);
			break;
		case "Edit":
			backEnd.update(currentTableName, currentTableColumnNames, currentTableValues[selectedRowIndex], returnText);
			selectedRowIndex = -1;
			break;
		}
		setCurrentTable(currentTableName);
		pressedButtonName = null;
	}
	
	public MainFrame(BackEnd backEnd)
	{
		this.backEnd = backEnd;
        
		setTitle("Logistics DataBase Program");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		currentTableColumnNames = new Object[] {"ID", "Name"};
		tmpBarcode = new Object[][]{{0, 1}};
		
		//combobox
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange() == ItemEvent.SELECTED)
					setCurrentTable(e.getItem().toString());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[]
				{
					"department", "employee", "role", "salary", "team",
					"customer", "order_item", "`order`",
					"account_authority", "account", "personal_info",
					"barcode", "category", "product_category", "product_info", "product", "supplier",
					"place", "shipping_log", "shipping_requirement", "shipping", "transfer_status",
					"resource_allocation", "resource", "task_assignment", "task", "vehicle",
					"location", "occupancy", "warehouse"
				}
			)
		);
		comboBox.setBounds(0, 0, 184, 30);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 65, 444, 460);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		currentTableName = comboBox.getSelectedItem().toString();
		setCurrentTable(currentTableName);
		
		//add
		JButton addButton = new JButton("Add New Row");
		MainFrame tmp = this;
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pressedButtonName = "Add";
				AddFrame addFrame = new AddFrame(tmp, currentTableColumnNames);
				addFrame.setVisible(true);
			}
		});
		addButton.setBounds(50, 104, 176, 48);
		contentPane.add(addButton);
		
		//edit
		JButton editButton = new JButton("Edit Selected Row");
		editButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(table.getSelectedRow() != -1)
				{
					pressedButtonName = "Edit";
					selectedRowIndex = table.getSelectedRow();
					EditFrame editFrame = new EditFrame(tmp, currentTableColumnNames, currentTableValues[selectedRowIndex]);
					editFrame.setVisible(true);
				}
			}
		});
		editButton.setBounds(50, 264, 176, 48);
		contentPane.add(editButton);
		
		//remove
		JButton removeButton = new JButton("Remove Selected Row");
		removeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(table.getSelectedRow() != -1)
				{
					backEnd.delete(currentTableName, currentTableColumnNames, currentTableValues[table.getSelectedRow()]);
					Object[][] tmp = new Object[currentTableValues.length - 1][currentTableValues[0].length];
					int j = 0;
					for(int i = 0; i < currentTableValues.length; i++)
					{
						if(i != table.getSelectedRow())
						{
							tmp[j] = currentTableValues[i].clone();
							j++;
						}
					}
					currentTableValues = tmp.clone();
					table.setModel(new DefaultTableModel(currentTableValues, currentTableColumnNames));
				}
			}
		});
		removeButton.setBounds(50, 424, 176, 48);
		contentPane.add(removeButton);
		
		JButton createTableButton = new JButton("Create Table");
		createTableButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				backEnd.txtToSQL("create.txt");
			}
		});
		createTableButton.setBounds(437, 8, 121, 45);
		contentPane.add(createTableButton);
		
		JButton insertExampleButton = new JButton("Insert Example");
		insertExampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				backEnd.txtToSQL("insert.txt");
				setCurrentTable(currentTableName);
			}
		});
		insertExampleButton.setBounds(586, 8, 121, 45);
		contentPane.add(insertExampleButton);
		
		setVisible(true);
	}
}
