package classes;

import model.User;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateProfile extends JFrame implements MouseListener, ActionListener{
	
	JPanel panel;

	JLabel text_label;
	JLabel userLabel;
	JLabel emailLabel;
	//JLabel passwordLabel;
	//JLabel confirmPassLabel;
	JLabel genderLabel;
	JLabel dobLabel;
	JLabel img_label;
	
	JTextField userTF; 
	JTextField emailTF;

	//JPasswordField passwordTF;
	
	JButton updateBtn;
	JButton refreshBtn;
	JButton backBtn;
	
	JRadioButton r1,r2,r3;
	
	ButtonGroup bg;

	JComboBox date,month,year;
	
	Color clr1;
	Color clr2;

	Font fnt1;
	Font fnt2;

	ImageIcon backBtnImg;
	ImageIcon img;
	
	/*dashBoard db; // javac Main.java & java Main
	login lg;
	users us;
	user u;*/

	User user;
	Users users;
	
	public UpdateProfile(User user){
		super("Update profile");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.user = user;
		this.users = new Users();
		
		clr1 = new Color(251,186,55);
		clr2 = new Color(54,219,252);//akashi 54,219,252
		fnt1 = new Font("Times New Roman",Font.BOLD, 30);
		fnt2 = new Font("Times New Roman",Font.BOLD, 20);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.WHITE );

		//adding text
		text_label=new JLabel("Update your Profile!!");
		text_label.setBounds(450,50,300,50);
		text_label.setForeground(Color.WHITE);
		text_label.setBackground(Color.WHITE);
		text_label.setFont(fnt1);
		panel.add(text_label);


		userLabel = new JLabel("User name: "); 
		userLabel.setBounds(300,200,150,30);
		userLabel.setForeground(Color.WHITE);
		userLabel.setBackground(Color.WHITE);
		userLabel.setFont(fnt2);
		panel.add(userLabel);

		userTF = new JTextField(user.getName());
		userTF.setBounds(450,200,300,30);
		userTF.setFont(fnt2);
		panel.add(userTF);

		emailLabel = new JLabel("Email: "); 
		emailLabel.setBounds(300,240,150,30);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBackground(Color.WHITE);
		emailLabel.setFont(fnt2);
		panel.add(emailLabel);

		emailTF = new JTextField(user.getEmail());
		emailTF.setBounds(450,240,300,30);
		emailTF.setFont(fnt2);
		panel.add(emailTF);

		genderLabel = new JLabel("Gender: "); 
		genderLabel.setBounds(300,280,150,30);
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setBackground(Color.WHITE);
		genderLabel.setFont(fnt2);
		panel.add(genderLabel);

		r1 = new JRadioButton("Male");
		r1.setBounds(450,280,80,30);
		panel.add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(550,280,80,30);
		panel.add(r2);
		r3 = new JRadioButton("Other");
		r3.setBounds(650,280,80,30);
		panel.add(r3);
		
		if(user.getGender().equals("Male")){
			r1.setSelected(true);
		}
		else if(user.getGender().equals("Female")){
			r2.setSelected(true);
		}
		else{
			r3.setSelected(true);
		}

		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);

		dobLabel = new JLabel("Date of Birth:");
		dobLabel.setBounds(300,320,150,30);
		dobLabel.setForeground(Color.WHITE);
		dobLabel.setBackground(Color.WHITE);
		dobLabel.setFont(fnt2);
		panel.add(dobLabel);

		String[] dobArray = user.getDOB().split("/");


		String dates[]= {"DD","1","2","3","4","5","6","7","8","9",
						"10","11","12","13","14","15","16","17",
						"18","19","20","21","22","23","24","25",
						"26","27","28","29","30","31"};
		date = new JComboBox(dates);
		date.setBounds(450,320,80,30);
		int index = getIndex(dobArray[0],dates);
		if(index!=-1){
			date.setSelectedIndex(index);
		}
		panel.add(date);
		
		String months[]= {"MM","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG", "SEP","OCT","NOV","DEC"};
		month = new JComboBox(months);
		month.setBounds(550,320,80,30);
		index = getIndex(dobArray[1],months);
		if(index!=-1){
			month.setSelectedIndex(index);
		}
		panel.add(month);
		
		String years[]= {"YYYY","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982",
		 "1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997",
		 "1998","1999" , "2000", "2001","2002" , "2003", "2004", "2005", "2006","2007" , "2008", "2009", "2010", "2011", 
		 "2012","2013", "2014","2015" ,"2016" , "2017", "2018", "2019", "2020", "2021", "2022","2023"};
		year = new JComboBox(years);
		year.setBounds(650,320,80,30);
		index = getIndex(dobArray[2],years);
		if(index!=-1){
			year.setSelectedIndex(index);
		}
		panel.add(year);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,420,220,30);
		updateBtn.setFont(fnt2);
		updateBtn.setBackground(Color.PINK);
		updateBtn.setForeground(Color.BLACK);
		//updateBtn.addMouseListener(this);
		updateBtn.addActionListener(this);
		updateBtn.setBorder(null);
		panel.add(updateBtn);

		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(540,420,220,30);
		refreshBtn.setFont(fnt2);
		refreshBtn.setBackground(Color.PINK);
		refreshBtn.setForeground(Color.BLACK);
		//refreshBtn.addMouseListener(this);
		refreshBtn.addActionListener(this);
		updateBtn.setBorder(null);
		panel.add(refreshBtn);

		backBtnImg = new ImageIcon("image/backButton2.png");
		backBtn = new JButton(backBtnImg);
		backBtn.setBounds(1000,50,100,80);
		//backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);


		

		//adding image
		img=new ImageIcon("image/updatePass.png");
		img_label=new JLabel(img);
		img_label.setSize(1280,720);
		panel.add(img_label);

		this.add(panel);
		
	}

	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(refreshBtn.getText().equals(command)){
			userTF.setText("");
			emailTF.setText("");
			bg.clearSelection();
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
		}
		else if(backBtn.getText().equals(command)){
			DashBoard db = new DashBoard(user);
			db.setVisible(true);
			this.setVisible(false);
		}
		else if(updateBtn.getText().equals(command)){
			updateUser();
		}
	}

	public void updateUser(){
		String name ="",email="",gender="",dt="",mnth="",yr="", dob="";
		
		name = userTF.getText();
		email = emailTF.getText();
		
		if(r1.isSelected()){ gender = "Male";} 
		else if(r2.isSelected()){ gender = "Female";} 
		else if(r3.isSelected()){ gender = "Other";}
			
		dt = date.getSelectedItem().toString();
		mnth = month.getSelectedItem().toString();
		yr = year.getSelectedItem().toString();
		dob = dt+"/"+mnth+"/"+yr;
		if(dt.equals("DD") || mnth.equals("MM") || yr.equals("YYYY")){
			dob="";
		}
		
		if(name.isEmpty() || email.isEmpty() || gender.isEmpty()|| dob.isEmpty()){
			JOptionPane.showMessageDialog(null, "Please fill in all fields.");
		}
		else{
			
			int dialog = JOptionPane.YES_NO_OPTION;
			int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to update these informations?", "Profile update?", dialog);
			if(result ==0 ){
				User oldUser = user;
				User updatedUser = new User(name,email,user.getPassword(),gender,dob);
				//System.out.println(updatedUser.getUserString());
				//System.out.println("///////////////////////////");
				users.updateUser(oldUser,updatedUser);
				user = updatedUser; // updating user with the new data
				JOptionPane.showMessageDialog(null, "Profile Updated!!");
			}
			else{

			}
		}
	}

	public int getIndex(String value,String array[]){
		//System.out.println(value);
		for(int i=0;i<array.length;i++){
			if(array[i].equals(value)){
				return i;
			}
		}
		return -1;
	}

}


		
