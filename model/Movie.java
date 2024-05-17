package model;

public class Movie {
    private String movieName;
    private String genre;
    private String showTime;
    private int availableSeat;
    private int ticketPrice;


    public Movie(String movieName, String genre, String showTime, int availableSeat, int ticketPrice) {
        this.movieName = movieName;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
        this.showTime = showTime;
        this.availableSeat = availableSeat;
    }

    public String getMovieName() {
        return movieName;
    }
     public String getMovieGenre() {
        return genre;
    }
    public String getShowTime() {
        return showTime;
    }
    public int getAvailableSeat() {
        return availableSeat;
    }
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setMovieGenre(String genre) {
        this.genre = genre;
    }
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }
    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getMovieString(){
        return  getMovieName()+"\n"+
                getMovieGenre()+"\n"+
                getShowTime()+"\n"+
                Integer.toString(getAvailableSeat())+"\n"+
                Integer.toString(getTicketPrice())+"\n";
    }

    public String[] getMovieRow(){
        return new String[]{
            getMovieName(),
            getMovieGenre(),
            getShowTime(),
            Integer.toString(getAvailableSeat()),
            Integer.toString(getTicketPrice())
        };
    }
}
