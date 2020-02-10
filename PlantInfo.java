import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PlantInfo extends JFrame implements ActionListener
{
	
	JPanel panel;
	JButton search, add, remove, back, logout;
	JLabel limg;
	ImageIcon img;
	
	public PlantInfo()
	{
		
		super("Plant Home");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.GRAY);
		this.add(panel);
		
		search = new JButton("Search Plant");
		search.setBounds(100, 200, 200,40);
		search.setBackground(Color.DARK_GRAY);
		search.setForeground(Color.white);
		panel.add(search);
		
		add = new JButton("Add Plant");
		add.setBounds(400, 200, 200,40);
		add.setBackground(Color.DARK_GRAY);
		add.setForeground(Color.white);
		panel.add(add);
		
		remove = new JButton("Remove Plant");
		remove.setBounds(230, 300, 200,40);
		remove.setBackground(Color.DARK_GRAY);
		remove.setForeground(Color.white);
		panel.add(remove);
		
		
		back = new JButton("Back");
		back.setBounds(100, 400, 200,40);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.white);
		panel.add(back);
		
		logout = new JButton("Log Out");
		logout.setBounds(400, 400, 200,40);
		logout.setBackground(Color.DARK_GRAY);
		logout.setForeground(Color.white);
		panel.add(logout);
		
		img = new ImageIcon(".//Image//back.jpg");
		limg = new JLabel(img);
		limg.setBounds(0,0,1000,700);
		panel.add(limg);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
	
}