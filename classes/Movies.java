package classes;

import model.*;
import interfaces.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Movies {
    Movie movieList[] = new Movie[100];
    public int movieCount = 0;
    public Movies(){
        try{
			File file = new File("file/movieList.txt"); 
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String name = sc.nextLine();
					String genre = sc.nextLine();
					String showTime = sc.nextLine();
					int availableSeat = Integer.parseInt(sc.nextLine());
					int ticketPrice = Integer.parseInt(sc.nextLine());
					String emptyLine = sc.nextLine(); // for empty line
					
                    Movie m = new Movie(name,genre,showTime,availableSeat,ticketPrice);
                    movieList[movieCount] = m;
                    movieCount++;
				}
				sc.close();   //closing the file 		
		}catch(Exception ex){
			System.out.println(ex.toString());
			return;
		}
    }

    public Movie[] getMovieList(){
        return movieList;
    }

    public String[] getMovie(int index){
        return movieList[index].getMovieRow();
    }

    public void updateMovie(Movie m,int id){
        movieList[id] = m;
        String movieDetails = "";
		for(int i=0;i<movieCount;i++){
			String details = movieList[i].getMovieString();
			movieDetails += details + "\n";
		}
		try{
			String filepath = "file/movieList.txt";
			FileWriter fw = new FileWriter(filepath);
			fw.write(movieDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
    }
}

