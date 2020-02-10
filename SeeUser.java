import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;

public class SeeUser extends JFrame implements ActionListener
{
	
	JPanel panel;
	JButton delete,  back, logout;
	JTextField tsearch;
	JLabel label;
	Admin l;
	Connection connection=null;
	String Name, Address, City, Email, Mobile, Nationality,Gender;
	JLabel lUserIdl,lNamel, lAddressl, lCityl, lEmaill, lMobilel,lNationalityl,lGenderl;
	JLabel UserIdl, Namel, Addressl, Cityl, Emaill, Mobilel, Nationalityl,Genderl;
	String UserId;
	AdminUserInfo d;
	JLabel limg;
	ImageIcon img;
	
	public SeeUser(AdminUserInfo d)
	{
		
		super("User Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.GRAY);
		this.add(panel);
		
		this.d=d;
		
		UserIdl = new JLabel("User Id:");
		UserIdl.setBounds(200,50,200,40);
		UserIdl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(UserIdl);
	
	
		Namel = new JLabel("Name:");
		Namel.setBounds(200,100,200,40);
		Namel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Namel);
		
		
		Addressl = new JLabel("Address:");
		Addressl.setBounds(200,150,200,40);
		Addressl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Addressl);
		
		Cityl = new JLabel("City:");
		Cityl.setBounds(200,200,200,40);
		Cityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Cityl);
		
		Emaill = new JLabel("Email:");
		Emaill.setBounds(200,250,200,40);
		Emaill.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Emaill);
		
		Mobilel = new JLabel("Mobile No:");
		Mobilel.setBounds(200,300,200,40);
		Mobilel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Mobilel);
		
		Genderl = new JLabel("Gender:");
		Genderl.setBounds(200,350,200,40);
		Genderl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Genderl);
		
		Nationalityl = new JLabel("Nationality:");
		Nationalityl.setBounds(200,400,200,40);
		Nationalityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(Nationalityl);
		
		
		
		
		lUserIdl = new JLabel("");
		lUserIdl.setBounds(420,50,200,40);
		lUserIdl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lUserIdl);
		
		
		lNamel = new JLabel("");
		lNamel.setBounds(420,100,200,40);
		lNamel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lNamel);
		
		
		lAddressl = new JLabel("");
		lAddressl.setBounds(420,150,300,40);
		lAddressl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lAddressl);
		
		lCityl = new JLabel("");
		lCityl.setBounds(420,200,200,40);
		lCityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lCityl);
		
		lEmaill = new JLabel("");
		lEmaill.setBounds(420,250,200,40);
		lEmaill.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lEmaill);
		
		lMobilel = new JLabel("");
		lMobilel.setBounds(420,300,200,40);
		lMobilel.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lMobilel);
		
		lGenderl = new JLabel("");
		lGenderl.setBounds(420,350,200,40);
		lGenderl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lGenderl);
		
		lNationalityl = new JLabel("");
		lNationalityl.setBounds(420,400,200,40);
		lNationalityl.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lNationalityl);
		
		//UserId = tsearch.getText();
		
		try
		{
			UserId = d.user;
			connection=DatabaseConnection.DbConnector();
			String mysql="SELECT * FROM `user` WHERE `user`.`UserId` = '"+UserId+"'";
			Statement st = connection.createStatement();
			System.out.println("statement created");
			ResultSet rs = st.executeQuery(mysql);
			System.out.println("results received");
			
			while(rs.next())
			{
				
				
				//UserId=rs.getString("UserId");
				Name=rs.getString("Name");
				Address=rs.getString("Address");
				City=rs.getString("City");
				Email=rs.getString("Email");
				Mobile=rs.getString("Mobile");
				
				Nationality=rs.getString("Nationality");
				Gender=rs.getString("Gender");
				System.out.println("results received");
			}
			
			
			System.out.println(UserId+"	"+ Name+"	" +Address+"	"+ City+"	"+Email+"	"+Gender+"	" +Mobile+"	"+ Nationality);
			
			lUserIdl.setText(UserId);
			
			lNamel.setText(Name);
			lAddressl.setText(Address);
			lCityl.setText(City);
			lEmaill.setText(Email);
			lMobilel.setText(Mobile);
			lGenderl.setText(Gender);
			lNationalityl.setText(Nationality);
			
			
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
		
		
		delete = new JButton("Delete User");
		delete.setBounds(400,520,200,40);
		delete.setFont(new Font("Consolas",Font.BOLD,20));
		delete.setBackground(Color.DARK_GRAY);
		delete.setForeground(Color.white);
		delete.addActionListener(this);
		panel.add(delete);
		
		back = new JButton("Back");
		back.setBounds(50, 590, 200,50);
		back.setFont(new Font("Consolas",Font.BOLD,20));
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel.add(back);
		
		logout = new JButton("Log Out");
		logout.setBounds(700, 590, 200,50);
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
				String mysql="DELETE FROM `user` WHERE `user`.`UserId` = '"+UserId+"'";
				Statement st = connection.createStatement();
				System.out.println("statement created");
				st.executeUpdate(mysql);
				//ResultSet rs = st.executeQuery(mysql);
				System.out.println("results received");
				String query = "DELETE FROM `login` WHERE `login`.`UserId` = '"+UserId+"'";
				st.executeUpdate(query);
				System.out.println("results received2");
				
				JOptionPane.showMessageDialog(null,"User deleted");
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