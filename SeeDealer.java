import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;

public class SeeDealer extends JFrame implements ActionListener
{
	
	JPanel panel;
	JButton delete,  back, logout;
	JTextField tsearch;
	JLabel label;
	Admin l;
	Connection connection=null;
	String DealerID, Name, Address, City, Email, Mobile, Company, Nationality,Balance;
	JLabel UserIdl,DealerIDl, Namel, Addressl, Cityl, Emaill, Mobilel, Companyl, Nationalityl,Balancel;
	JLabel lUserIdl,lDealerIDl, lNamel, lAddressl, lCityl, lEmaill, lMobilel, lCompanyl, lNationalityl,lBalancel;
	String UserId;
	AdminDealerInfo d;
	JLabel limg;
	ImageIcon img;
	
	public SeeDealer(AdminDealerInfo d)
	{
		
		super("Dealer Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 750);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.GRAY);
		this.add(panel);
		
		UserIdl = new JLabel("User Id:");
		UserIdl.setBounds(200,50,200,40);
		UserIdl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(UserIdl);
		
		DealerIDl = new JLabel("DealerId:");
		DealerIDl.setBounds(200,100,200,40);
		DealerIDl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(DealerIDl);
		
		Namel = new JLabel("Name;");
		Namel.setBounds(200,150,200,40);
		Namel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Namel);
		
		
		Addressl = new JLabel("Address:");
		Addressl.setBounds(200,200,200,40);
		Addressl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Addressl);
		
		Cityl = new JLabel("City:");
		Cityl.setBounds(200,250,200,40);
		Cityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Cityl);
		
		Emaill = new JLabel("Email:");
		Emaill.setBounds(200,300,200,40);
		Emaill.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Emaill);
		
		Mobilel = new JLabel("Mobile No:");
		Mobilel.setBounds(200,350,200,40);
		Mobilel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Mobilel);
		
		Companyl = new JLabel("Company Name:");
		Companyl.setBounds(200,400,200,40);
		Companyl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Companyl);
		
		
		Nationalityl = new JLabel("Nationality:");
		Nationalityl.setBounds(200,450,200,40);
		Nationalityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Nationalityl);
		
		Balancel = new JLabel("Balancel:");
		Balancel.setBounds(200,500,200,40);
		Balancel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Balancel);
		
		
		
		
		lUserIdl = new JLabel("");
		lUserIdl.setBounds(420,50,200,40);
		lUserIdl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lUserIdl);
		
		lDealerIDl = new JLabel("");
		lDealerIDl.setBounds(420,100,200,40);
		lDealerIDl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lDealerIDl);
		
		lNamel = new JLabel("");
		lNamel.setBounds(420,150,200,40);
		lNamel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lNamel);
		
		
		lAddressl = new JLabel("");
		lAddressl.setBounds(420,200,200,40);
		lAddressl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lAddressl);
		
		lCityl = new JLabel("");
		lCityl.setBounds(420,250,200,40);
		lCityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lCityl);
		
		lEmaill = new JLabel("");
		lEmaill.setBounds(420,300,200,40);
		lEmaill.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lEmaill);
		
		lMobilel = new JLabel("");
		lMobilel.setBounds(420,350,200,40);
		lMobilel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lMobilel);
		
		lCompanyl = new JLabel("");
		lCompanyl.setBounds(420,400,200,40);
		lCompanyl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lCompanyl);
		
		
		lNationalityl = new JLabel("");
		lNationalityl.setBounds(420,450,200,40);
		lNationalityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lNationalityl);
		
		lBalancel = new JLabel("");
		lBalancel.setBounds(420,500,200,40);
		lBalancel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lBalancel);
		
		this.d=d;
		
		//UserId = tsearch.getText();
		
		try
		{
			UserId = d.user;
			connection=DatabaseConnection.DbConnector();
			String mysql="SELECT * FROM `dealer` WHERE `dealer`.`UserId` = '"+UserId+"'";
			Statement st = connection.createStatement();
			System.out.println("statement created");
			ResultSet rs = st.executeQuery(mysql);
			System.out.println("results received");
			
			while(rs.next())
			{
				
				
				//UserId=rs.getString("UserId");
				DealerID=rs.getString("DealerID");
				Name=rs.getString("Name");
				Address=rs.getString("Address");
				City=rs.getString("City");
				Email=rs.getString("Email");
				Mobile=rs.getString("Mobile");
				
				Nationality=rs.getString("Nationality");
				Company=rs.getString("Company");
				Balance=rs.getString("Balance");
				System.out.println("results received");
			}
			
			
			System.out.println(UserId+"	"+DealerID+"	"+ Name+"	" +Address+"	"+ City+"	"+Email+"	"+Balance+"	" +Mobile+"	"+ Nationality+"	"+Company);
			
			lUserIdl.setText(UserId);
			lDealerIDl.setText(DealerID);
			lNamel.setText(Name);
			lAddressl.setText(Address);
			lCityl.setText(City);
			lEmaill.setText(Email);
			lMobilel.setText(Mobile);
			lCompanyl.setText(Company);
			lNationalityl.setText(Nationality);
			lBalancel.setText(Balance);
			
			try
			{
				if(rs!=null)
						rs.close();

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
		
		delete = new JButton("Delete Dealar");
		delete.setBounds(400,570,200,40);
		delete.setFont(new Font("Consolas",Font.BOLD,20));
		delete.setBackground(Color.DARK_GRAY);
		delete.setForeground(Color.white);
		delete.addActionListener(this);
		panel.add(delete);
		
		back = new JButton("Back");
		back.setBounds(50, 630, 200,40);
		back.setFont(new Font("Consolas",Font.BOLD,20));
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel.add(back);
		
		logout = new JButton("Log Out");
		logout.setBounds(700, 630, 200,40);
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
		if(text.equals(delete.getText()))
		{
			try
			{
				
				connection=DatabaseConnection.DbConnector();
				String mysql="DELETE FROM `dealer` WHERE `dealer`.`UserId` = '"+UserId+"'";
				Statement st = connection.createStatement();
				System.out.println("statement created");
				st.executeUpdate(mysql);
				//ResultSet rs = st.executeQuery(mysql);
				System.out.println("results received");
				String query = "DELETE FROM `login` WHERE `login`.`UserId` = '"+UserId+"'";
				st.executeUpdate(query);
				System.out.println("results received2");
				
				JOptionPane.showMessageDialog(null,"Dealer deleted");
				this.setVisible(false);
				d.setVisible(true);
				
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
		}
		else if(text.equals(back.getText()))
		{
			this.setVisible(false);
			d.setVisible(true);
		}
		else if(text.equals(logout.getText()))
		{
			this.setVisible(false);
			Login m = new Login();
			m.setVisible(true);
		}
		
	}
}