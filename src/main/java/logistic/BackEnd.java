package logistic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BackEnd
{
	private JdbcTemplate jdbcTemplate;
	private Connection conn;
	private Statement stmt;
	
	public BackEnd(JdbcTemplate jdbcTemplate)
	{
        this.jdbcTemplate = jdbcTemplate;
		try
		{
			conn = jdbcTemplate.getDataSource().getConnection();
			stmt = conn.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
    }
	
	public Object[][] readAll(String tableName)
	{
		String sql1 ="SELECT COUNT(*) FROM " + tableName + ";";
    	String sql2 = "select * from " + tableName + ";";
    	Object[][] result = new Object[1][1];
    	
    	try
    	{
    		ResultSet rs1 = stmt.executeQuery(sql1);
            int cnt = 0;
            if (rs1.next()) {
                cnt = rs1.getInt(1); // Assuming the count is in the first column of the first row
            }
            rs1.close();
            
            ResultSet rs2 = stmt.executeQuery(sql2);
            ResultSetMetaData rsmd = rs2.getMetaData();
            result = new Object[cnt + 1][rsmd.getColumnCount()];
                      
            for(int i = 0; i < rsmd.getColumnCount(); i++)
            {
            	result[0][i] = rsmd.getColumnName(i+1);
            }
            for(int j = 1; rs2.next(); j++)
            {
            	for(int i = 0; i < rsmd.getColumnCount(); i++)
                	result[j][i] = rs2.getObject(i+1);
            }
        }catch (SQLException e)
    	{
            e.printStackTrace();
        }

        return result;
	}
	
	public void update(String tableName, Object[] columnNames, Object[] selectedValues, String[] inputValues) {
        String sql = "update " + tableName + " set ";
        String sv[] = validateSelected(selectedValues).clone();
        String iv[] = validateInput(inputValues).clone();
        
        int i;
        for(i = 0; i < columnNames.length - 1; i++)
        	sql = sql + columnNames[i] + "=" + iv[i] + ", ";
        sql = sql + columnNames[i] + "=" + iv[i] + " where ";
        for(i = 0; i < columnNames.length - 1; i++)
        	sql = sql + columnNames[i] + sv[i] + " and ";
        sql = sql + columnNames[i] + sv[i] + ";";
    	
    	//System.out.println(sql);
        jdbcTemplate.update(sql);
        
    }

    public void delete(String tableName, Object[] columnNames, Object[] selectedValues) {
        String sql = "delete from " + tableName + " where ";
        String sv[] = validateSelected(selectedValues).clone();
        int i;
        for(i = 0; i < columnNames.length - 1; i++)
        	sql = sql + columnNames[i] + sv[i] + " and ";
        sql = sql + columnNames[i] + sv[i] + ";";
        
      //System.out.println(sql);
      jdbcTemplate.update(sql);
    }
    
    public void create(String tableName, Object[] columnNames, String[] inputValues) {
        String sql = "insert into " + tableName + " (";
        String iv[] = validateInput(inputValues).clone();
        int i;
        for(i = 0; i < columnNames.length - 1; i++)
        	sql = sql + columnNames[i] + ", ";
        sql = sql + columnNames[i] + ") values (";
        for(i = 0; i < columnNames.length - 1; i++)
        	sql = sql + iv[i] + ", ";
        sql = sql + iv[i] + ");";
        
        //System.out.println(sql);
        jdbcTemplate.update(sql);
    }
    
    public void txtToSQL(String fileName)
    {
    	ArrayList<String> sql = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			char tmp;
			int i = 0;
			sql.add(new String());
			while((tmp = (char) br.read()) != (char) -1)
			{
				sql.set(i, sql.get(i) + tmp);
				if(tmp == ';')
				{
					sql.add(new String());
					i++;
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i < sql.size() - 1; i++)
			jdbcTemplate.update(sql.get(i));
    }
    
    private String[] validateInput(String[] inputValues)
    {
    	String[] returnArr = new String[inputValues.length];
    	for(int i = 0; i < inputValues.length; i++)
    	{
    		if(!inputValues[i].isEmpty())
    			returnArr[i] = "'" + inputValues[i] + "'";
    		else
    			returnArr[i] = "NULL";
    	}
    	return returnArr;
    }
    
    private String[] validateSelected(Object[] selectedValues)
    {
    	String[] returnArr = new String[selectedValues.length];
    	for(int i = 0; i < selectedValues.length; i++)
    	{
    		if(selectedValues[i] != null)
    			returnArr[i] = "=" + "'" + selectedValues[i] + "'";
    		else
    			returnArr[i] = " IS NULL";
    	}
    	return returnArr;
    }
}