import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;


public class MyOrder extends JFrame implements ActionListener
{
	
	JPanel panel;
	JButton back, logout;
	JScrollPane scroll;
	Connection connection=null;
	boolean status;
	
	JScrollPane tableScrollPane;
	ResultSet rs;
	String user;
	User u;
	JLabel limg;
	ImageIcon img;
	
	
	public MyOrder(User u)
	{
		
		super("My Order");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.GRAY);
		this.add(panel);
		
		this.u = u;	
		user = u.UserId;
		System.out.println(user);
			
		String[] columns = {"TreeId"};
		
		Object[][] data = getTableDetails();
		
		JTable table = new JTable(data, columns);
		
		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(250,250,300,100);
		panel.add(tableScrollPane);
		

		
		back = new JButton("Back");
		back.setBounds(50, 550, 200,50);
		back.setFont(new Font("Consolas",Font.BOLD,20));
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel.add(back);
		
		logout = new JButton("Log Out");
		logout.setBounds(700, 550, 200,50);
		logout.setFont(new Font("Consolas",Font.BOLD,20));
		logout.setBackground(Color.DARK_GRAY);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		panel.add(logout);
		
		img = new ImageIcon(".//Image//back.jpg");
		limg = new JLabel(img);
		limg.setBounds(0,0,1000,700);
		panel.add(limg);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String text = event.getActionCommand();
		
		if(text.equals(back.getText()))
		{
			this.setVisible(false);
			u.setVisible(true);
		}
		else if(text.equals(logout.getText()))
		{
			this.setVisible(false);
			Login m = new Login();
			m.setVisible(true);
		}
	}
	public int getRowCount(ResultSet rs)
	{

		try {
			
			if(rs != null) {
				
				rs.last();
				
				return rs.getRow(); 
			}
			
		} 
		catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}
	public Object[][] getTableDetails()
	{
		System.out.println("Out");
		Object[][] data = null;
		try
		{
			
			
		
			connection=DatabaseConnection.DbConnector();
			String mysql="SELECT * FROM `order` WHERE `order`.`UserID` = '"+user+"'";

			Statement st = connection.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(mysql);
			System.out.println("results received");
			
			int rowCount = getRowCount(rs);
			int columnCount = getColumnCount(rs);
			data = new Object[rowCount][columnCount];
			
			rs.beforeFirst();

			int i = 0;
			
			while (rs.next()) 
			{

				int j = 0;

				data[i][j++] = rs.getString("TreeId");
				i++;
			}
			
			status = true;
			
			try
			{
				if(st!=null)
					st.close();

				if(connection!=null)
					connection.close();
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
		}
		return data;
			
	}
			
			
			
	public int getColumnCount(ResultSet rs) 
	{

		try {

			if(rs != null)
				return rs.getMetaData().getColumnCount();

		} 
		catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}
}
	