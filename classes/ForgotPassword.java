package classes;
import model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ForgotPassword extends JFrame
{
	ImageIcon background_image,backbutton_img;
	JPanel panel;
	JLabel find_text_label,enter_text_label,to_search_label,email_label,img_label;
	JTextField email_tf;
	JButton back,search;
	Font label_f,inside_f,text_f,text_f1;
	Users users;
	
	public ForgotPassword()
	{
		super("Forgot Password");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.users = new Users();

		panel=new JPanel();
		panel.setLayout(null);
		
		
		label_f=new Font("INTER",Font.PLAIN, 19);
		inside_f=new Font("INTER",Font.PLAIN,15);
		text_f=new Font("INTER",Font.PLAIN,30);
		text_f1=new Font("INTER",Font.PLAIN,14);
		
		
		
		
		//adding find your account text label
		find_text_label=new JLabel("Find Your Account");
		find_text_label.setBounds(730,130,300,50);
		find_text_label.setFont(text_f);
		panel.add(find_text_label);
		
		
		///adding Please enter your email address text label
		enter_text_label=new JLabel("Please enter your email address");
		enter_text_label.setBounds(730,170,330,50);
		enter_text_label.setFont(text_f1);
		panel.add(enter_text_label);
		
		
		///adding to search for your account. password text label
		to_search_label=new JLabel("to search for your account.");
		to_search_label.setBounds(730,190,330,50);
		to_search_label.setFont(text_f1);
		panel.add(to_search_label);
		
		
		
		//adding email label
		email_label=new JLabel("Email");	
		email_label.setBounds(730,260,140,50);
		email_label.setFont(label_f);
		panel.add(email_label);
		
		
		//adding email textfield	
		email_tf=new JTextField();
		email_tf.setBounds(730,300,400,40);
		email_tf.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		email_tf.setFont(inside_f);
		panel.add(email_tf);
		
		
		//adding back button
		backbutton_img=new ImageIcon("image/back-button.jpg");
		back=new JButton(backbutton_img);
		back.setBounds(0,4,30,30);
		back.setBackground(new Color(255,190,0));
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae1)
			{
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		back.setBorder(null);
		panel.add(back);
		
		
		
		
		//adding search button
		search=new JButton("Search");
		search.setBounds(730,360,400,40);
		search.setBackground(new Color(193,230,52));
		search.setBorder(BorderFactory.createLineBorder(new Color(193,230,52)));
		search.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me1)
			{
				search.setBackground(new Color(205,235,92));
			}
			
			public void mouseExited(MouseEvent me1)
			{
				search.setBackground(new Color(193,230,52));
			}
		});
		search.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae1)
			{
				String email=email_tf.getText();
				int index = users.userExists(email);
				if(index != -1){
					JOptionPane.showMessageDialog(null,"Found your account");
					UpdatePassword updatePassword = new UpdatePassword(email);
					updatePassword.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Account not found");
				}
			}
			
			
		});
		search.setFont(label_f);
		panel.add(search);
		
		
		
		//add background_image
		background_image=new ImageIcon("image/forgot password.jpg");
		img_label=new JLabel(background_image);
		img_label.setSize(1280,720);
		panel.add(img_label);
		
		
		this.add(panel);
	}
}