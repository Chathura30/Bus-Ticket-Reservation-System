package ModelClasses;

public class Bus {
    private String busNumber;
    private int totalSeats;
    private String startingpoint;
    private String endingPoint;
    private String startingTime;
    private double fare;
    private boolean[] seats;

public Bus(String busNumber, int totalSeats, String startingpoint, String endingPoint, String startingTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingpoint = startingpoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.seats = new boolean[totalSeats];
    }

    public boolean reserveSeat(int seatIndex) {
        if (!seats[seatIndex]) {
            seats[seatIndex] = true;
            return true;
        }
        return false;
    }

    public void cancelSeat(int seatIndex) {
        seats[seatIndex] = false;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getstartingpoint() {
        return startingpoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

}



