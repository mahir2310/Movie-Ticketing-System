package classes;

import model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class Signup extends JFrame
{
	JPanel panel;
	JLabel name_label,email_label,gender_label,img_label,password_label,confirmpass_label,createacc_label,dob_label,text_label,login_label;
	JTextField name_tf,email_tf;
	JPasswordField password_f,confirmpass_f;
	JRadioButton male,female,other;
	ButtonGroup mf;
	JComboBox date,month,year;
	JButton signup,back;
	Font label_f,inside_f,text_f,text_f1;
	ImageIcon img,backbutton_img;
	Users users;
	
	public Signup()
	{
		super("Sign Up");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.users = new Users();

		panel=new JPanel();
		panel.setLayout(null);
		
		
		label_f=new Font("INTER",Font.PLAIN, 19);
		inside_f=new Font("INTER",Font.PLAIN,15);
		text_f=new Font("INTER",Font.PLAIN,30);
		text_f1=new Font("INTER",Font.PLAIN,15);
		
		
		
		//adding create account label
		createacc_label=new JLabel("Create Account");
		createacc_label.setBounds(770,35,280,50);
		createacc_label.setFont(text_f);
		panel.add(createacc_label);
		
		
		
		//adding name label 
		name_label=new JLabel("Name");
		name_label.setBounds(770,95,100,50);
		name_label.setFont(label_f);
		panel.add(name_label);
		
		
		
		//adding name textfield
		name_tf=new JTextField();
		name_tf.setBounds(770,135,400,40);
		name_tf.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		name_tf.setFont(inside_f);
		panel.add(name_tf);
		
		
		
		//adding email label
		email_label=new JLabel("Email");	
		email_label.setBounds(770,180,140,50);
		email_label.setFont(label_f);
		panel.add(email_label);
		
		
		//adding email textfield	
		email_tf=new JTextField();
		email_tf.setBounds(770,220,400,40);
		email_tf.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		email_tf.setFont(inside_f);
		panel.add(email_tf);
		
		
		
		//adding gender label
		gender_label=new JLabel("Gender");
		gender_label.setBounds(770,280,150,40);
		gender_label.setFont(label_f);
		panel.add(gender_label);
		
		
		
		male=new JRadioButton("Male");
		male.setBounds(850,280,60,40);
		male.setBackground(new Color(255,188,0));
		male.setBorder(BorderFactory.createLineBorder(new Color(255,188,0)));
		male.setFont(inside_f);
		panel.add(male);
		
		
		female=new JRadioButton("Female");
		female.setBounds(940,280,80,40);
		female.setBackground(new Color(255,188,0));
		female.setBorder(BorderFactory.createLineBorder(new Color(255,188,0)));
		female.setFont(inside_f);
		panel.add(female);
		
		other=new JRadioButton("Other");
		other.setBounds(1040,280,80,40);
		other.setBackground(new Color(255,188,0));
		other.setBorder(BorderFactory.createLineBorder(new Color(255,188,0)));
		other.setFont(inside_f);
		panel.add(other);
		
		
		mf=new ButtonGroup();
		mf.add(male);
		mf.add(female);
		mf.add(other);
		
		//adding dob label
		dob_label=new JLabel("Date of Birth");
		dob_label.setBounds(770,330,130,40);
		dob_label.setFont(label_f);
		panel.add(dob_label);
		
		
		//adding date in dob
		String dates[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17",
					   "18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		date=new JComboBox(dates);
		date.setBounds(900,340,40,20);
		panel.add(date);
		
		//adding month in dob
		String months[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG", "SEP","OCT","NOV","DEC"};
		month=new JComboBox(months);
		month.setBounds(940,340,50,20);
		panel.add(month);
		
		
		//adding year in dob
		String years[]= {"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982",
		 "1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997",
		 "1998","1999" , "2000", "2001","2002" , "2003", "2004", "2005", "2006","2007" , "2008", "2009", "2010", "2011", 
		 "2012","2013", "2014","2015" ,"2016" , "2017", "2018", "2019", "2020", "2021", "2022","2023" };
		year = new JComboBox(years);
		year.setBounds(990,340,60,20);
		panel.add(year);
		
		
		
		
		//adding password label
		password_label=new JLabel("Password");	
		password_label.setBounds(770,380,200,40);
		password_label.setFont(label_f);
		panel.add(password_label);
		
		
		
		//adding password field
		password_f=new JPasswordField();
		password_f.setBounds(770,420,400,40);
		password_f.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		password_f.setFont(inside_f);
		panel.add(password_f);
		
		
		//adding confirm password label
		confirmpass_label=new JLabel("Confirm Password");	
		confirmpass_label.setBounds(770,460,200,40);
		confirmpass_label.setFont(label_f);
		panel.add(confirmpass_label);
		
		
		
		//adding password field
		confirmpass_f=new JPasswordField();
		confirmpass_f.setBounds(770,500,400,40);
		confirmpass_f.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
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
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		
		//adding sign up button
		signup=new JButton("Sign Up");
		signup.setBounds(770,570,400,40);
		signup.setForeground(new Color(237, 248, 255));
		signup.setBackground(new Color(152, 168, 248));
		signup.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		signup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a)
			{
				String name ="",email="",gender="",dt="",mnth="",yr="", dob="",password="",confirmPass="";
				name = name_tf.getText();
				email=email_tf.getText();
				if(male.isSelected()){ gender = "Male";} 
				else if(female.isSelected()){ gender = "Female";} 
				else if(other.isSelected()){ gender = "Other";}

				dt = date.getSelectedItem().toString();
				mnth = month.getSelectedItem().toString();
				yr = year.getSelectedItem().toString();
				dob = dt+"/"+mnth+"/"+yr;
				password =password_f.getText();
				confirmPass =confirmpass_f.getText();
				
				if(name.isEmpty() || email.isEmpty() || gender.isEmpty() || dob.isEmpty() || password.isEmpty() || confirmPass.isEmpty()){
					JOptionPane.showMessageDialog(null, "Please fill in all fields.");
				}
				else{
					if(password.equals(confirmPass)){
						int index = users.userExists(email);
						if(index !=- 1){
							JOptionPane.showMessageDialog(null, "This email is already in use.");
						}
						else{
							User u = new User(name,email,password,gender,dob);
							users.addUser(u);
							JOptionPane.showMessageDialog(null, "Account created successfully.");
							goToLogin();
						}
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Passwords do not match.");
					}
				}
					
			}
		});
		signup.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent me1)
			{
				signup.setBackground(new Color(152, 200, 248));
			}
			
			public void mouseExited(MouseEvent me2)
			{
				signup.setBackground(new Color(152, 168, 248));
			}
		});
		
		signup.setFont(label_f);
		panel.add(signup);
		
		
		text_label=new JLabel("Already have an Account?");
		text_label.setBounds(840,620,190,40);
		text_label.setFont(text_f1);
		panel.add(text_label);
		
		
		
		login_label=new JLabel("Login");
		login_label.setBounds(1030,620,190,40);
		login_label.setForeground(new Color(123,102,255));
		login_label.addMouseListener(new MouseAdapter() {
           public void mouseEntered(MouseEvent me4)
			{
				login_label.setForeground(new Color(56, 118, 191));
            }

          
            public void mouseExited(MouseEvent me5) 
			{
                login_label.setForeground(new Color(123,102,255));
            }
            
            
            public void mouseClicked(MouseEvent me3)
			{
          
				Login login1=new Login();
				login1.setVisible(true);
				dispose();
				
            }

        });
		login_label.setFont(text_f1);
		panel.add(login_label);
		
		
		
		//adding image
		img=new ImageIcon("image/login.jpg");
		img_label=new JLabel(img);
		img_label.setSize(1280,720);
		panel.add(img_label);
		
		
		
		this.add(panel);
		
	}	
	public void goToLogin(){
		Login login = new Login();
		login.setVisible(true);
		dispose();
	}
}