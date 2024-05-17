package classes;
import model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AboutUs extends JFrame 
{
	ImageIcon img,backbutton_img;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,img_label;
	Font text_font,pragraph_font;
	JButton back;
	JPanel panel;

	User user;
	
	public AboutUs(User user)
	{
		super("About us");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.user = user;

		panel=new JPanel();
		panel.setLayout(null);
		
		
		text_font=new Font("INTER",Font.PLAIN, 33);
		pragraph_font=new Font("INTER",Font.PLAIN,20);
		
		
		l1=new JLabel("About Us");
		l1.setBounds(30,150,180,40);
		l1.setFont(text_font);
		panel.add(l1);
		
		
		
		l2=new JLabel("Discover the magic of the big screen with MOVIE NIGHT");
		l2.setBounds(30,220,600,40);
		l2.setFont(pragraph_font);
		panel.add(l2);
		
		
		l3=new JLabel("theatre,your go-to destination for hassle-free movie ticket");
		l3.setBounds(30,250,600,40);
		l3.setFont(pragraph_font);
		panel.add(l3);
		
		
		
		l4=new JLabel("bookings.Located in Bashundhara Dhaka, we make it easy ");
		l4.setBounds(30,280,600,40);
		l4.setFont(pragraph_font);
		panel.add(l4);
		
		
		
		l5=new JLabel("to browse showtimes, pick your seats, and get ready for an");
		l5.setBounds(30,310,600,40);
		l5.setFont(pragraph_font);
		panel.add(l5);
		
		
		
		l6=new JLabel("unforgettable cinema experience. Welcome to your ticket to");
		l6.setBounds(30,340,600,40);
		l6.setFont(pragraph_font);
		panel.add(l6);
		
		
		
		l7=new JLabel("movie night, right here in the 3rth floor of CRT building");
		l7.setBounds(30,370,600,40);
		l7.setFont(pragraph_font);
		panel.add(l7);
		
		
		
		l8=new JLabel("Bashundhara, Dhaka -1206. Call: 01731849660 ");
		l8.setBounds(30,400,600,40);
		l8.setFont(pragraph_font);
		panel.add(l8);
		
		
		
		
		//adding back button
		backbutton_img=new ImageIcon("image/back-button.jpg");
		back=new JButton(backbutton_img);
		back.setBounds(0,0,30,30);
		back.setBackground(new Color(	240,189,84));
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae1)
			{
				DashBoard db = new DashBoard(user); 
				db.setVisible(true);
				dispose();
			}
		});
		back.setBorder(null);
		panel.add(back);
		
		
		
		
		//add background_image
		img=new ImageIcon("image/about us.jpg");
		img_label=new JLabel(img);
		img_label.setSize(1280,720);
		panel.add(img_label);
		
		
		this.add(panel);
	}

	




}