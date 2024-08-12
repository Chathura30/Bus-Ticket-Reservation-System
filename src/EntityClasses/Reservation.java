package EntityClasses;

public class Reservation {
    private Customer customer;
    private Bus bus;
    private int seatIndex;

    public Reservation(Customer customer, Bus bus, int seatIndex) {
        this.customer = customer;
        this.bus = bus;
        this.seatIndex = seatIndex;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bus getBus() {
        return bus;
    }

    public int getSeatIndex() {
        return seatIndex;
    }
}
    

