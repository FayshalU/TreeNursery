import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.*;

public class PlantUser extends JFrame implements ActionListener
{
	
	JPanel panel;
	JButton  back, logout,order,save;
	JLabel name,sname,price,discription,imgLabel,tid,did;
	JLabel lname,lsname,lprice,ldiscription,ltid,ldid;
	String names,snames,prices,discriptions,imgLabels,tids,dids;
	ImageIcon img;
	JTextArea tdiscription;
	JScrollPane scroll;
	Connection connection=null;
	UserPlant u;
	String tree,user;
	JLabel limg;
	ImageIcon img1;
	Random r = new Random();
	int quantity;
	
	
	public PlantUser(UserPlant u, String tree)
	{
		
		super("Plant Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 750);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.GRAY);
		this.add(panel);
		
		this.u = u;
		this.tree = tree;
		this.user = u.user;
		
		System.out.println(tree +"	"+user);
		
		name = new JLabel("Name");
		name.setBounds(70,30,150,50);
		name.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(name);
		
		
		lname = new JLabel("");
		lname.setBounds(300,30,150,50);
		lname.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(lname);
		
		sname = new JLabel("Scientific Name");
		sname.setBounds(70,110,300,50);
		sname.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(sname);
		
		lsname = new JLabel("");
		lsname.setBounds(300,110,400,50);
		lsname.setFont(new Font("Consolas",Font.ITALIC+Font.BOLD,20));
		panel.add(lsname);
		
		tid = new JLabel("Tree ID");
		tid.setBounds(70,190,150,50);
		tid.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(tid);
		
		ltid = new JLabel("");
		ltid.setBounds(300,190,150,50);
		ltid.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(ltid);
		
		price = new JLabel("Price");
		price.setBounds(730,290,150,50);
		price.setFont(new Font("Consolas",Font.BOLD,25));
		price.setForeground(Color.RED);
		panel.add(price);
		
		lprice = new JLabel("");
		lprice.setBounds(815,290,150,50);
		lprice.setFont(new Font("Consolas",Font.BOLD,25));
		lprice.setForeground(Color.RED);
		panel.add(lprice);
		
		did = new JLabel("Dealer ID");
		did.setBounds(70,270,150,50);
		did.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(did);
		
		ldid = new JLabel("");
		ldid.setBounds(300,270,150,50);
		ldid.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(ldid);
		
		discription = new JLabel("Description");
		discription.setBounds(70,350,250,50);
		discription.setFont(new Font("Consolas",Font.BOLD,20));
		panel.add(discription);
		
		tdiscription = new JTextArea("");
		tdiscription.setEditable(false);
		
		
		scroll = new JScrollPane(tdiscription);
		scroll.setBounds(70,405,700,120);
		panel.add(scroll);
		
		
		
		try
		{
			String TreeId = tree;
			connection=DatabaseConnection.DbConnector();
			String mysql="SELECT * FROM `tree` WHERE `tree`.`TreeId` = '"+TreeId+"'";
			Statement st = connection.createStatement();
			System.out.println("statement created");
			ResultSet rs = st.executeQuery(mysql);
			System.out.println("results received");
			
			while(rs.next())
			{
				System.out.println("Inside");
				
				names=rs.getString("Name");
				snames=rs.getString("SciName");
				prices=rs.getString("Price");
				discriptions=rs.getString("Advantage");
				imgLabels=rs.getString("Image");
				tids=rs.getString("TreeId");
				dids=rs.getString("DealerId");
				
				System.out.println("results received");
			}
			
			
			System.out.println(names+"	"+dids+"	"+ snames+"	" +prices+"	"+ discriptions+"	"+imgLabels+"	" +tids);
			
			
			
			lname.setText(names);
			lsname.setText(snames);
			lprice.setText(prices);
			
			ltid.setText(tids);
			ldid.setText(dids);
			tdiscription.setText(discriptions);
			imgLabel.setText(imgLabels);
			
			
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
		
		img = new ImageIcon(imgLabels);
		imgLabel = new JLabel(img);
		imgLabel.setBounds(700,100,150,200);
		panel.add(imgLabel);
		
		order = new JButton("Order");
		order.setBounds(200, 540, 200,50);
		order.setFont(new Font("Consolas",Font.BOLD,20));
		order.setBackground(Color.DARK_GRAY);
		order.setForeground(Color.white);
		order.addActionListener(this);
		panel.add(order);
		
		save = new JButton("Save");
		save.setBounds(500, 540, 200,50);
		save.setFont(new Font("Consolas",Font.BOLD,20));
		save.setBackground(Color.DARK_GRAY);
		save.setForeground(Color.white);
		save.addActionListener(this);
		panel.add(save);
		
		back = new JButton("Back");
		back.setBounds(50, 610, 200,50);
		back.setFont(new Font("Consolas",Font.BOLD,20));
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.white);
		back.addActionListener(this);
		panel.add(back);
		
		logout = new JButton("Log Out");
		logout.setBounds(700, 610, 200,50);
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
	public int random()
	{
		int y = r.nextInt(99999);
		return y;
	}
	public void actionPerformed(ActionEvent event)
	{
		String text = event.getActionCommand();
		
		if(text.equals(logout.getText()))
		{
			this.setVisible(false);
			Login m = new Login();
			m.setVisible(true);
		}
		else if(text.equals(back.getText()))
		{
			this.setVisible(false);
			u.setVisible(true);
		}
		else if(text.equals(save.getText()))
		{
			try
			{
				
				System.out.println(tree +"	"+user);
				connection=DatabaseConnection.DbConnector();
				String mysql="INSERT INTO cart (`UserID`, `TreeID`) VALUES ('"+user+"', '"+tree+"')";
				Statement st = connection.createStatement();
				System.out.println("statement created");
				st.executeUpdate(mysql);
				System.out.println("results received");
				this.setVisible(false);
				u.setVisible(true);
				JOptionPane.showMessageDialog(null,"Tree saved");
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
			}
		}
		else if(text.equals(order.getText()))
		{
			try
			{
				String s = JOptionPane.showInputDialog("Enter Quantity");
				quantity = Integer.parseInt(s);
				
				int OrderID = random();
				String DealerId = dids;
				connection=DatabaseConnection.DbConnector();
				String query="INSERT INTO `order` (`OrderID`,`DealerID`, `TreeID`,`UserID`,`Quantity`) VALUES ('"+OrderID+"','"+DealerId+"', '"+tree+"','"+user+"','"+quantity+"')";

					
				Statement st = connection.createStatement();
				System.out.println("statement created");
				st.executeUpdate(query);
				System.out.println("results received");
				this.setVisible(false);
				u.setVisible(true);
				JOptionPane.showMessageDialog(null,"Tree ordered");
					
			}
			catch(Exception ex)
			{
				System.out.println("Exception : " +ex.getMessage());
				JOptionPane.showMessageDialog(null,"Enter a number");
			}
		}
	}
	
	
}
		