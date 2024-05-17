package model;

public class PurchaseHistory {
    String email;
    int movieId;
    int ticketCount;

    public PurchaseHistory(String email,int movieId,int ticketCount){
        this.email = email;
        this.movieId = movieId;
        this.ticketCount = ticketCount;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setMovieId(int id){
        this.movieId = id;
    }
    public void setTicketCount(int ticketCount){
        this.ticketCount = ticketCount;
    }

    public String getEmail(){
        return email;
    }
    public int getMovieId(){
        return movieId;
    }
    public int getTicketCount(){
        return ticketCount;
    }

    public String getPurchaseHistoryString(){
        return email+"\n"+
                Integer.toString(movieId)+"\n"+
                Integer.toString(ticketCount)+"\n";
    }
}
