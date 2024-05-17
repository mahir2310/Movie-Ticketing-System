package classes;

import model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdatePassword extends JFrame
{
	ImageIcon background_image,backbutton_img;
	JPanel panel;
	JLabel updatepass_label,img_label,password_label,confirmpass_label;
	JPasswordField password_f,confirmpass_f;
	JButton update,back;
	Font label_f,inside_f,text_f,text_f1;
	
	Users users;
	String email;
	public UpdatePassword(String email)
	{
		super("Update Password");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.users = new Users();
		this.email = email;
		
		panel=new JPanel();
		panel.setLayout(null);
		
		
		label_f=new Font("INTER",Font.PLAIN, 19);
		inside_f=new Font("INTER",Font.PLAIN,15);
		text_f=new Font("INTER",Font.PLAIN,30);
		text_f1=new Font("INTER",Font.PLAIN,14);
		
		
		
		//adding find your account text label
		updatepass_label=new JLabel("Update Password");
		updatepass_label.setBounds(730,140,300,50);
		updatepass_label.setFont(text_f);
		panel.add(updatepass_label);
		
		
		//adding password label
		password_label=new JLabel("Password");	
		password_label.setBounds(730,240,200,40);
		password_label.setFont(label_f);
		panel.add(password_label);
		
		
		
		//adding password field
		password_f=new JPasswordField();
		password_f.setBounds(730,280,400,40);
		password_f.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		password_f.setFont(inside_f);
		panel.add(password_f);
		
		
		//adding confirm password label
		confirmpass_label=new JLabel("Confirm Password");	
		confirmpass_label.setBounds(730,325,180,40);
		confirmpass_label.setFont(label_f);
		panel.add(confirmpass_label);
		
		
		
		//adding password field
		confirmpass_f=new JPasswordField();
		confirmpass_f.setBounds(730,365,400,40);
		confirmpass_f.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		confirmpass_f.setFont(inside_f);
		panel.add(confirmpass_f);
		
		
		
		//adding back button
		backbutton_img=new ImageIcon("image/back-button.jpg");
		back=new JButton(backbutton_img);
		back.setBounds(0,4,30,30);
		back.setBackground(new Color(255,190,0));
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae1)
			{
				Login login =  new Login();
				login.setVisible(true);
				dispose();
			}
		});
		back.setBorder(null);
		panel.add(back);
		
		
		//adding update button
		update=new JButton("Update");
		update.setBounds(730,420,400,40);
		update.setBackground(new Color(193,230,52));
		update.setBorder(BorderFactory.createLineBorder(new Color(193,230,52)));
		update.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent me1)
			{
				update.setBackground(new Color(205,235,92));
			}
			
			public void mouseExited(MouseEvent me1)
			{
				update.setBackground(new Color(193,230,52));
			}
		});
		update.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae1)
			{
				String pass = password_f.getText();
				String confirmPass = confirmpass_f.getText();

				if(pass.isEmpty() || confirmPass.isEmpty()){
					JOptionPane.showMessageDialog(null,"Please fill in all fields.");
				}
				else{
					if(pass.equals(confirmPass)){
						int index = users.userExists(email);
						if(index != -1){
							User oldUser = users.getUser(index);
							User updatedUser = new User(oldUser.getName(),oldUser.getEmail(),oldUser.getPassword(),oldUser.getGender(),oldUser.getDOB());
							updatedUser.setPassword(pass);
							users.updateUser(oldUser,updatedUser);
						}
						JOptionPane.showMessageDialog(null,"Password changed");
						Login login =  new Login();
						login.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Password doesn't match");
					}
				}
			}
			
			
		});
		update.setFont(label_f);
		panel.add(update);
		
		
		//add background_image
		background_image=new ImageIcon("image/forgot password.jpg");
		img_label=new JLabel(background_image);
		img_label.setSize(1280,720);
		panel.add(img_label);
		
		
		this.add(panel);
	}
}