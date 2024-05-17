package classes;

import model.User;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketPrice extends JFrame implements MouseListener, ActionListener {

	JPanel panel;

	JButton backBtn;

	JLabel img_label;

	ImageIcon img;

	User user;
	Users users;

	//DashBoard db;

/*  */


	public TicketPrice(User user){
		super("Ticket Price");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 

		this.user = user;
		this.users = new Users();


	    panel = new JPanel();
		panel.setLayout(null);



		backBtn = new JButton("Back to Profile");
		backBtn.setBounds(980,30,200,30);
		backBtn.setBackground(Color.PINK);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		


		//adding image
		img=new ImageIcon("image/ticket-price.jpg");
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
			if(backBtn.getText().equals(command)){
				DashBoard db = new DashBoard(user); /**/
				db.setVisible(true);
				this.setVisible(false);
			}
		}
		
	

			
}