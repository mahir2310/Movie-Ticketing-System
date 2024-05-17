package classes;
import model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame
{
	JPanel panel;
	JLabel img_label,email_label,password_label,text_label,signup_label,forgotpass_label;
	JTextField email_tf;
	JPasswordField password_f;
	JButton login;
	ImageIcon background_img;
	Font label_f,inside_f,text_f;
	Users users;
	
	
	public Login()
	{
		//creating frame
		super("Login");	
		this.setSize(1280,720);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.users = new Users();
		
		//creating panel
		panel=new JPanel();
		panel.setLayout(null);
		
		
		
		label_f=new Font("INTER",Font.PLAIN, 19);
		inside_f=new Font("INTER",Font.PLAIN,15);
		text_f=new Font("INTER",Font.PLAIN,15);
		
		
		
		//adding email label
		email_label=new JLabel("Email");	
		email_label.setBounds(750,175,140,50);
		email_label.setFont(label_f);
		panel.add(email_label);
		
		
		//adding email textfield	
		email_tf=new JTextField();
		email_tf.setBounds(750,220,400,40);
		email_tf.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		email_tf.setFont(inside_f);
		panel.add(email_tf);
		
		
		//adding password label
		password_label=new JLabel("Password");	
		password_label.setBounds(750,265,200,50);
		password_label.setFont(label_f);
		panel.add(password_label);
		
		
		
		//adding password field
		password_f=new JPasswordField();
		password_f.setBounds(750,310,400,40);
		password_f.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		password_f.setFont(inside_f);
		panel.add(password_f);
		
		
		
		
		
		//adding login button
		login=new JButton("Login");
		login.setBounds(750,400,400,40);
		login.setForeground(new Color(237, 248, 255));
		login.setBackground(new Color(152, 168, 248));
		login.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		
		login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae1)
			{
				//System.out.println("button pressed!!!!!");
				String email = email_tf.getText();
				String password = password_f.getText();
				int index = users.userExists(email);
				if(index!=-1){
					User u = users.checkCredentials(index,password); //checks username and password
					if(u != null){
						JOptionPane.showMessageDialog(null, "Login successfull!");
						DashBoard dashBoard = new DashBoard(u);
						dashBoard.setVisible(true);
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Password incorrect!");
					}
				}else{
					JOptionPane.showMessageDialog(null, "User doesn't exist!");
				}
          	}
		});


		
		login.addMouseListener(new MouseAdapter()
		{
			
			public void mouseEntered(MouseEvent me1)
			{
				login.setBackground(new Color(152, 200, 248));
			}
			
			public void mouseExited(MouseEvent me2)
			{
				login.setBackground(new Color(152, 168, 248));
			}
		});
		
		
		login.setFont(label_f);
		panel.add(login);
		
		
		
		//adding text
		text_label=new JLabel("Don't have an account?");
		text_label.setBounds(840,480,180,30);
		text_label.setFont(text_f);
		panel.add(text_label);
		
		
		//adding signup text
		signup_label=new JLabel("Sign up");
		signup_label.setBounds(1010,480,100,30);
		signup_label.setForeground(new Color(123,102,255));
		signup_label.setFont(text_f);
		signup_label.addMouseListener(new MouseAdapter() {
           public void mouseEntered(MouseEvent me4)
			{
				signup_label.setForeground(new Color(56, 118, 191));
            }

          
            public void mouseExited(MouseEvent me5) 
			{
                signup_label.setForeground(new Color(123,102,255));
            }
            
        
            public void mouseClicked(MouseEvent me3)
			{
          
				Signup signup=new Signup();
				signup.setVisible(true);
				dispose();
				
            }

        });
		
		panel.add(signup_label);
		
		
		
		
		forgotpass_label=new JLabel("Forgot password?");
		forgotpass_label.setBounds(880,520,150,30);
		forgotpass_label.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent me4)
			{
				forgotpass_label.setForeground(new Color(56, 118, 191));
            }

          
            public void mouseExited(MouseEvent me5) 
			{
                forgotpass_label.setForeground(new Color(0,0,0));
            }
			
			
			public void mouseClicked(MouseEvent me6)
			{
				ForgotPassword forgotpass=new ForgotPassword();
				forgotpass.setVisible(true);
				dispose();
			}
			
			
		});
		forgotpass_label.setFont(text_f);
		panel.add(forgotpass_label);
		
		
		
		//adding background image
		background_img=new ImageIcon("image/login.jpg");
		img_label=new JLabel(background_img);
		img_label.setSize(1280,720);
		panel.add(img_label);
		
		
		
		
		this.add(panel);
	}
}