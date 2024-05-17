package classes;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class PurchaseTicketHistory extends JFrame
{
    JPanel panel;

    JLabel text_label;
    Font fnt2;



    PurchaseHistory[] purchaseHistoryList = new PurchaseHistory[100];
    public int purchaseHistoryCount = 0;
    Movies movies;
    User user;

    public PurchaseTicketHistory(User user){
        super("Purchase History");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

        fnt2 = new Font("Times New Roman",Font.BOLD, 20);

		Font label_font=new Font("INTER",Font.PLAIN,20);
		this.movies = new Movies();
        this.user = user;
        System.out.println(user.getEmail());
        loadPurchaseHistory(user);
        printPurchaseHistory();


        panel=new JPanel();
        panel.setBackground(Color.PINK);
		panel.setLayout(null);

        //adding text
        text_label=new JLabel( "Your Purchase History");
        text_label.setBounds(550,50,250,30);
        text_label.setFont(fnt2);
        panel.add(text_label);




        String[] columnNames = { "Movie Name", "Show Time", "Ticket Purchased", "Ticket Price","Total Price"};

        String[][] historyData = new String[purchaseHistoryCount][5];

        for(int i=0;i<purchaseHistoryCount;i++){
            historyData[i] = getHistoryDataRow(i);
        }

        JTable table = new JTable(historyData,columnNames);
        table.setRowSelectionAllowed(false);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(200, 100, 900, 300);
        panel.add(sp);

        JButton backBtn=new JButton("Back");
		backBtn.setBounds(200,430,180,40);
		backBtn.setFont(label_font);
		backBtn.setForeground(new Color(237, 248, 255));
		backBtn.setBackground(new Color(152, 168, 248));
		backBtn.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
        backBtn.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a)
			{
				DashBoard dashboard = new DashBoard(user);
                dashboard.setVisible(true);
                dispose();
			}
			
		});
        backBtn.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent me1)
			{
				backBtn.setBackground(new Color(152, 200, 248));
			}
			
			public void mouseExited(MouseEvent me2)
			{
				backBtn.setBackground(new Color(152, 168, 248));
			}
		});
		panel.add(backBtn);

        this.add(panel);
    }

    public void loadPurchaseHistory(User user){
        try{
			File file = new File("file/purchaseHistory.txt"); 
			Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String email = sc.nextLine();
                int movieIndex = Integer.parseInt(sc.nextLine());
                int ticketCount = Integer.parseInt(sc.nextLine());
                String emptyLine = sc.nextLine(); // for empty line
                
                if(user.getEmail().equals(email)){  // only taking the history for logged in user by comparing email
                    PurchaseHistory ph = new PurchaseHistory(email,movieIndex,ticketCount);
                    purchaseHistoryList[purchaseHistoryCount] = ph;
                    purchaseHistoryCount++;
                }
            }
            sc.close();   //closing the file 		
		}catch(Exception ex){
			System.out.println(ex.toString());
			return;
		}
    }

    public void printPurchaseHistory(){
        for(int i=0;i<purchaseHistoryCount;i++){
            System.out.println(purchaseHistoryList[i].getPurchaseHistoryString());
        }
    }

    public String[] getHistoryDataRow(int purchaseIndex){
        int movieIndex = this.purchaseHistoryList[purchaseIndex].getMovieId();
        Movie selectedMovie = this.movies.getMovieList()[movieIndex];

        String movieName = selectedMovie.getMovieName();
        String showTime = selectedMovie.getShowTime();
        int ticketCount = this.purchaseHistoryList[purchaseIndex].getTicketCount();
        int ticketPrice = selectedMovie.getTicketPrice();
        int totalPrice = ticketCount * ticketPrice;

        return new String[]{
            movieName,
            showTime,
            Integer.toString(ticketCount),
            Integer.toString(ticketPrice),
            Integer.toString(totalPrice)
        };
    }
}