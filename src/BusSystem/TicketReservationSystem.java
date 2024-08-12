package BusSystem;

import ModelClasses.Bus;
import ModelClasses.Customer;
import ModelClasses.Reservation;
import ModelClasses.Stack;  
import ModelClasses.Queue;  

import java.util.ArrayList;
import java.util.List;

public class TicketReservationSystem {
    private Stack<Reservation> reservations;
    private Queue<Customer> waitingQueue;
    private List<Customer> customers; 
    private Stack<Customer> customerStack; 
    private List<Bus> buses;

    public TicketReservationSystem() {
        reservations = new Stack<>();
        waitingQueue = new Queue<>();
        customers = new ArrayList<>();
        customerStack = new Stack<>();
        buses = new ArrayList<>();
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer); 
        customerStack.push(customer); 
        System.out.println("Customer registered: " + customer.getName());
    }

    public void registerBus(Bus bus) {
        buses.add(bus);
        System.out.println("Bus registered: " + bus.getBusNumber());
    }

    public void searchBuses(String from, String to) {
        boolean busFound = false;
        for (Bus bus : buses) {
            if (bus.getstartingpoint().equalsIgnoreCase(from) && bus.getEndingPoint().equalsIgnoreCase(to)) {
                System.out.println("Bus found: " + bus.getBusNumber());
                busFound = true;
            }
        }
        if (!busFound) {
            System.out.println("There are no buses to the destination: " + to);
        }
    }

    public void reserveSeat(Customer customer, Bus bus, int seatIndex) {
        if (bus.reserveSeat(seatIndex)) {
            Reservation reservation = new Reservation(customer, bus, seatIndex);
            reservations.push(reservation);
            System.out.println("Seat reserved for " + customer.getName());
        } else {
            waitingQueue.enqueue(customer);
            System.out.println("No available seats. " + customer.getName() + " added to the waiting queue.");
        }
    }

    public void cancelReservation() {
        if (!reservations.isEmpty()) {
            Reservation reservation = reservations.pop();
            reservation.getBus().cancelSeat(reservation.getSeatIndex());
            System.out.println("Reservation canceled for " + reservation.getCustomer().getName());

            if (!waitingQueue.isEmpty()) {
                Customer nextCustomer = waitingQueue.dequeue();
                reserveSeat(nextCustomer, reservation.getBus(), reservation.getSeatIndex());
            }
        } else {
            System.out.println("No reservations to cancel.");
        }
    }

    public void displayReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Customer: " + reservation.getCustomer().getName() +
                               ", Bus: " + reservation.getBus().getBusNumber() +
                               ", Seat: " + reservation.getSeatIndex());
        }
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public Bus findBusByNumber(String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    
    public void displayCustomersNewestToOldest() {
        System.out.println("Customers from newest to oldest:");
        for (Customer customer : customerStack) {
            System.out.println(customer);
        }
    }

    
    public void displayCustomersOldestToNewest() {
        System.out.println("Customers from oldest to newest:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
