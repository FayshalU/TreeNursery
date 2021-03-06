import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;


public class AdminDealerInfo extends JFrame implements ActionListener,MouseListener
{
	
	JPanel panel;
	JButton search,  back, logout;
	JTextField tsearch;
	JLabel label;
	Admin l;
	Connection connection=null;
	String user;
	JLabel limg;
	ImageIcon img;
	
	public AdminDealerInfo(Admin l)
	{
		
		super("Dealar Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.GRAY);
		this.add(panel);
		
		this.l = l;
		
		label = new JLabel("User ID");
		label.setBounds(200,140,200,50);
		label.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(label);
		
		search = new JButton("Search Dealar");
		search.setBounds(700,140,200,50);
		search.setFont(new Font("Consolas",Font.BOLD,20));
		search.setBackground(Color.DARK_GRAY);
		search.setForeground(Color.white);
		search.addActionListener(this);
		search.addMouseListener(this);
		panel.add(search);
		
		tsearch = new JTextField();
		tsearch.setBounds(330,140,350,50);
		tsearch.setFont(new Font("Consolas",Font.BOLD,20));
	    panel.add(tsearch);
		
		
		
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
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		System.out.println("Out");
		if(e.getSource()==search)
		{
			if(tsearch.getText().equals("") )
			{
				search.setEnabled(false);
			}

			else
			{
				search.setEnabled(true);
			}
			System.out.println("IN");
		}
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String text = event.getActionCommand();
		if(text.equals(search.getText()))
		{
			try
			{
				
				connection=DatabaseConnection.DbConnector();
				String mysql="SELECT * FROM `dealer`";
				Statement st = connection.createStatement();
				System.out.println("statement created");
				ResultSet rs = st.executeQuery(mysql);
				System.out.println("results received");
				String userId;
				int x=0;
				while(rs.next())
				{
					userId = rs.getString("UserId");
					System.out.println(userId);
					if(userId.equals(tsearch.getText()))
					{
						user = userId;
						x=1;
						
						this.setVisible(false);
						SeeDealer m = new SeeDealer(this);
						m.setVisible(true);
						tsearch.setText("");
					}
				}
				if(x==0)
				{
					System.out.println("Not found");
					JOptionPane.showMessageDialog(null,"UserID does not exist");
					tsearch.setText("");
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
			l.setVisible(true);
		}
		else if(text.equals(logout.getText()))
		{
			this.setVisible(false);
			Login m = new Login();
			m.setVisible(true);
		}
	}
	
}