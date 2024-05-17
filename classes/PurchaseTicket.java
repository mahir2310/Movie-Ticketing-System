package classes;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class PurchaseTicket extends JFrame
{
    JPanel panel;

    JLabel text_label;
    Font fnt2;

    User user;
    Users users;
    Movies movies;

    public PurchaseTicket(User user){
        super("Ticket");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		fnt2 = new Font("Times New Roman",Font.BOLD, 20);
		Font label_font=new Font("INTER",Font.PLAIN,20);
		
        this.user = user;
        this.users = new Users();
        this.movies = new Movies();

		panel=new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);


		//adding text
		text_label=new JLabel("Purchase Your Tickets");
		text_label.setBounds(550,50,250,30);
		text_label.setFont(fnt2);
		panel.add(text_label);


        String[] columnNames = { "Movie Name", "Genre", "Show Time", "Seat Available", "Ticket Price"};

        String[][] movieData = new String[movies.movieCount][5];
        
        Movie[] movieList = movies.getMovieList();
        System.out.println(movies.movieCount);
        for(int i=0;i<movies.movieCount;i++){
            movieData[i] = movieList[i].getMovieRow();
        }

        JTable table = new JTable(movieData,columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(200, 100, 900, 300);
        panel.add(sp);

        JButton backBtn=new JButton("Back");
		backBtn.setBounds(200,430,180,40);
		backBtn.setFont(label_font);
		backBtn.setForeground(new Color(237, 248, 255));
		backBtn.setBackground(new Color(152, 168, 248));
		backBtn.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));

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
        backBtn.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a)
			{
				DashBoard dashboard = new DashBoard(user);
                dashboard.setVisible(true);
                dispose();
			}
			
		});
		panel.add(backBtn);

		
	


        JButton purchase=new JButton("Purchase");
		purchase.setBounds(920,430,180,40);
		purchase.setFont(label_font);
		purchase.setForeground(new Color(237, 248, 255));
		purchase.setBackground(new Color(152, 168, 248));
		purchase.setBorder(BorderFactory.createLineBorder(new Color(197,217,224)));
		
		purchase.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent a)
			{   
                int id = table.getSelectedRow();
                System.out.println(id);
                if(id != -1){
                    while (true) {
                        String userInput = JOptionPane.showInputDialog("Number of Ticket you want to purchase: ");
                        
                        if (userInput != null) {
                            try {
                                int inputValue = Integer.parseInt(userInput);
                                System.out.println("User entered: " + inputValue);
                                String availableSeat = (String)table.getValueAt(id,3);

                                if(inputValue <= Integer.parseInt(availableSeat)){
                                    int ticketLeft = Integer.parseInt(availableSeat) - inputValue;
                                    table.setValueAt(Integer.toString(ticketLeft),id,3);

                                    Movie m = movies.getMovieList()[id];
                                    m.setAvailableSeat(ticketLeft); //creating new movie with left ticket
                                    
                                    ///updating movie object and writing in the movie list file
                                    movies.updateMovie(m,id);
                                    //adding purchase history in the file
                                    addPurchaseHistory(user,id,inputValue);

                                    JOptionPane.showMessageDialog(null, "Purchase complete");
                                    break;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Not enough ticket.");
                                }
                            } 
                            catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            System.out.println("User canceled the input.");
                            break;
                        }
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "No Movie selected.");
                }
            }	
		});
    
		
		purchase.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent me1)
			{
				purchase.setBackground(new Color(152, 200, 248));
			}
			
			public void mouseExited(MouseEvent me2)
			{
				purchase.setBackground(new Color(152, 168, 248));
			}
			});
		panel.add(purchase);

        this.add(panel);
    }
    public void addPurchaseHistory(User user, int movieIndex,int ticketCount){
        PurchaseHistory ph = new PurchaseHistory(user.getEmail(),movieIndex,ticketCount);
        
        String oldPurchaseHistory = "";
        try{
			File file = new File("file/purchaseHistory.txt"); 
			Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String email = sc.nextLine();
                int id = Integer.parseInt(sc.nextLine());
                int count = Integer.parseInt(sc.nextLine());
                String emptyLine = sc.nextLine(); // for empty line \r\n

                PurchaseHistory temp = new PurchaseHistory(email,id,count);
                oldPurchaseHistory += temp.getPurchaseHistoryString()+"\n";
                
            }
            sc.close();   //closing the file 		
		}
        catch(Exception ex){
			System.out.println(ex.toString());
			return;
		}

        String newPurchaseHistory = oldPurchaseHistory + ph.getPurchaseHistoryString()+"\n";

        try{
			String filepath = "file/purchaseHistory.txt";
			FileWriter fw = new FileWriter(filepath);
			fw.write(newPurchaseHistory);
			fw.close();
		}
        catch(Exception ex){
			System.out.println(ex.toString());
		}
    }
}