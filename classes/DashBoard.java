package classes;
import model.User;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements MouseListener, ActionListener {

	JPanel panel;

	JLabel img_label;
	JLabel text_label;
	JLabel userLabel;
	JLabel emailLabel;
	JLabel passwordLabel; 
	JLabel genderLabel;
	JLabel dobLabel;


	JButton profileBtn;
	JButton movieTicketBtn;
	JButton ticketPriceBtn;
	JButton purchaseHistoryBtn;
	JButton aboutUsBtn;
	JButton logoutBtn; 
	JButton showBtn;
	JButton updateProfileBtn;
	JButton deleteBtn;
	JButton updatePassBtn;

	Color clr1;
	Color clr2;

	Font fnt1;
	Font fnt2;

	ImageIcon img, eye;
	Users users;
	User user;
	

	//updateProfile upr;


	public DashBoard(User user){
		super("Dash Board");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 

		this.users = new Users();
		this.user = user;
		clr1 = new Color(251,186,55);
		clr2 = new Color(54,219,252);//akashi 54,219,252
		fnt1 = new Font("Century",Font.ITALIC, 17);
		fnt2 = new Font("Times New Roman",Font.BOLD, 20);

		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(clr1);

		



		//adding text
		text_label=new JLabel("Welcome to Profile");
		text_label.setBounds(550,200,250,30);
		text_label.setFont(fnt2);
		//text_label.setForeground(Color.RED);
		//text_label.setBackground(Color.WHITE);
		text_label.setFont(fnt2);
		panel.add(text_label);



		userLabel = new JLabel("User name: "+user.getName()); 
		userLabel.setBounds(350,280,300,30);
		userLabel.setFont(fnt2);
		panel.add(userLabel);
		

		emailLabel = new JLabel("Email: "+user.getEmail()); 
		emailLabel.setBounds(350,310,350,30);
		emailLabel.setFont(fnt2);
		panel.add(emailLabel); 


		passwordLabel = new JLabel("Password: "+getHiddenPassword(user.getPassword()));
		passwordLabel.setBounds(350,340,300,30);
		passwordLabel.setFont(fnt2);
		panel.add(passwordLabel);
		
		genderLabel = new JLabel("Gender: "+user.getGender());
		genderLabel.setBounds(350,370,300,30);
		genderLabel.setFont(fnt2);
		panel.add(genderLabel);
		
		dobLabel = new JLabel("Date of Birth: "+user.getDOB());
		dobLabel.setBounds(350,400,300,30);
		dobLabel.setFont(fnt2);
		panel.add(dobLabel); 


		
		profileBtn = new JButton("Profile");
		profileBtn.setBounds(140,60,150,40);
		profileBtn.setBackground(clr2);
		profileBtn.setForeground(Color.BLACK);
		profileBtn.setFont(fnt2);
		profileBtn.setOpaque(true);
		//profileBtn.addMouseListener(this);
		//profileBtn.addActionListener(this);
		panel.add(profileBtn);



		movieTicketBtn = new JButton("Movie Ticket");
		movieTicketBtn.setBounds(300,60,150,40);
		movieTicketBtn.setBackground(clr2);
		movieTicketBtn.setForeground(Color.BLACK);
		movieTicketBtn.setFont(fnt2);
		movieTicketBtn.setOpaque(true);
		//movieTicketBtn.addMouseListener(this);
		movieTicketBtn.addActionListener(this);
		panel.add(movieTicketBtn);



		ticketPriceBtn = new JButton("Ticket Price");
		ticketPriceBtn.setBounds(460,60,150,40);
		ticketPriceBtn.setBackground(clr2);
		ticketPriceBtn.setForeground(Color.BLACK);
		ticketPriceBtn.setFont(fnt2);
		ticketPriceBtn.setOpaque(true);
		//profileBtn.addMouseListener(this);
		ticketPriceBtn.addActionListener(this);
		panel.add(ticketPriceBtn);


		purchaseHistoryBtn = new JButton("History");
		purchaseHistoryBtn.setBounds(620,60,150,40);
		purchaseHistoryBtn.setBackground(clr2);
		purchaseHistoryBtn.setForeground(Color.BLACK);
		purchaseHistoryBtn.setFont(fnt2);
		purchaseHistoryBtn.setOpaque(true);
		//seatPlanBtn.addMouseListener(this);
		purchaseHistoryBtn.addActionListener(this);
		panel.add(purchaseHistoryBtn);


		aboutUsBtn = new JButton("About Us");
		aboutUsBtn.setBounds(780,60,150,40);
		aboutUsBtn.setBackground(clr2);
		aboutUsBtn.setForeground(Color.BLACK);
		aboutUsBtn.setFont(fnt2);
		aboutUsBtn.setOpaque(true);
		//profileBtn.addMouseListener(this);
		aboutUsBtn.addActionListener(this);
		panel.add(aboutUsBtn);


        logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(940,60,150,40);
		logoutBtn.setBackground(clr2);
		logoutBtn.setForeground(Color.BLACK);
		logoutBtn.setFont(fnt2);
		logoutBtn.setOpaque(true);
		//profileBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);





		eye = new ImageIcon("image/eye3.png");
		showBtn = new JButton(eye);
		showBtn.setBounds(650,340,36,26);
		showBtn.setBorder(null);
		showBtn.addMouseListener(this);
		showBtn.addActionListener(this);
		panel.add(showBtn);
		
		updateProfileBtn =  new JButton("Update profile");
		updateProfileBtn.setBounds(800,280,150,30);
		//updateProfileBtn.setBackground(Color.GREEN);
		updateProfileBtn.addActionListener(this);
		panel.add(updateProfileBtn);
		
		updatePassBtn = new JButton("Update password");
		updatePassBtn.setBounds(800,335,150,30);
		//updatePassBtn.setBackground(Color.GREEN);
		updatePassBtn.addActionListener(this);
		panel.add(updatePassBtn);
		
		deleteBtn = new JButton("Delete profile");
		deleteBtn.setBounds(800,390,150,30);
		deleteBtn.setBackground(Color.RED);
		//deleteBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		//adding image
		img=new ImageIcon("image/DashBoard.jpg");
		img_label=new JLabel(img);
		img_label.setSize(1280,720);
		panel.add(img_label);

		this.add(panel);
	}


	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){

		if(me.getSource() == showBtn){
			passwordLabel.setText("Password: "+user.getPassword());		
		}
	}  
	public void mouseReleased(MouseEvent me){

		if(me.getSource() == showBtn){
			passwordLabel.setText("Password: " + getHiddenPassword(user.getPassword()) );		
		}
	} 

	public String getHiddenPassword(String password){
		String hiddenPass = "";
		for(int i =0;i<password.length();i++){
			hiddenPass += '*';
		}
		return hiddenPass;
	}

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(logoutBtn.getText().equals(command)){
			goToLogin();
		}
		else if(updateProfileBtn.getText().equals(command)){
			UpdateProfile updateProfile = new UpdateProfile(user);
			updateProfile.setVisible(true);
			dispose();
		}
		else if(updatePassBtn.getText().equals(command)){
			UpdatePassword updatePassword = new UpdatePassword(user.getEmail());
			updatePassword.setVisible(true);
			this.setVisible(false);
		}
		else if(deleteBtn.getText().equals(command)){
			deleteUser();
		}
		else if(aboutUsBtn.getText().equals(command)){
			//System.out.println("about us");
			AboutUs ab = new AboutUs(user); /**/
			ab.setVisible(true);
			this.setVisible(false);


		}
		else if(ticketPriceBtn.getText().equals(command)){
			//System.out.println("Ticket ticket!!!");
			TicketPrice tp = new TicketPrice(user); /**/
			tp.setVisible(true);
			this.setVisible(false);
		}

		//this will be purchaseHistoryBtn
		else if(purchaseHistoryBtn.getText().equals(command)){
			//System.out.println("seat!! seat!!!");
			PurchaseTicketHistory ph = new PurchaseTicketHistory(user);
			ph.setVisible(true);
			this.setVisible(false);
		}

		//this will be movieTicketBtn

		else if(movieTicketBtn.getText().equals(command)){
			//System.out.println("seat!! seat!!!");
			PurchaseTicket pt = new PurchaseTicket(user); 
			pt.setVisible(true);
			this.setVisible(false);
		}


	}	

	public void deleteUser(){
		int dialog = JOptionPane.YES_NO_OPTION;
		int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your profile?", "Profile delete?", dialog);
		if(result==0){
			users.deleteUser(user);
			goToLogin();
		}
	}

	public void goToLogin(){
		Login login = new Login();
		login.setVisible(true);
		dispose();
	}

}
 