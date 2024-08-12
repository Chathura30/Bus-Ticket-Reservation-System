package Main;

import ModelClasses.Bus;
import ModelClasses.Customer;
import BusSystem.TicketReservationSystem;

import java.util.Scanner; 

public class main {
    private static TicketReservationSystem reservationSystem = new TicketReservationSystem();
    private static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBus Tickets Reservation System");
            System.out.println("1. Customer Register ");
            System.out.println("2. Bus Register ");
            System.out.println("3. Buses Search ");
            System.out.println("4. Seat Reserve ");
            System.out.println("5. Reservation Cancel ");
            System.out.println("6. Display All Reservations");
            System.out.println("7. Display Customers Oldest to Newest");
            System.out.println("8. Display Customers Newest to Oldest");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = Sc.nextInt();
            Sc.nextLine(); 

            switch (choice) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    registerBus();
                    break;
                case 3:
                    searchBuses();
                    break;
                case 4:
                    reserveSeat();
                    break;
                case 5:
                    cancelReservation();
                    break;
                case 6:
                    displayReservations();
                    break;
                case 7:
                    displayCustomersOldestToNewest();
                    break;
                case 8:
                    displayCustomersNewestToOldest();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerCustomer() {
        System.out.print("Enter customer name: ");
        String name = Sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = Sc.nextLine();
        System.out.print("Enter email ID: ");
        String emailId = Sc.nextLine();
        System.out.print("Enter city: ");
        String city = Sc.nextLine();
        System.out.print("Enter age: ");
        int age = Sc.nextInt();
        Sc.nextLine(); 

        Customer customer = new Customer(name, mobileNumber, emailId, city, age);
        reservationSystem.registerCustomer(customer);
    }

    private static void registerBus() {
        System.out.print("Enter bus number: ");
        String busNumber = Sc.nextLine();
        System.out.print("Enter total seats: ");
        int totalSeats = Sc.nextInt();
        Sc.nextLine(); // consume newline
        System.out.print("Enter starting point: ");
        String startingpoint = Sc.nextLine();
        System.out.print("Enter ending point: ");
        String endingPoint = Sc.nextLine();
        System.out.print("Enter starting time: ");
        String startingTime = Sc.nextLine();
        System.out.print("Enter fare: ");
        double fare = Sc.nextDouble();
        Sc.nextLine(); 

        Bus bus = new Bus(busNumber, totalSeats, startingpoint, endingPoint, startingTime, fare);
        reservationSystem.registerBus(bus);
    }

    private static void searchBuses() {
        System.out.print("Enter starting point: ");
        String from = Sc.nextLine();
        System.out.print("Enter ending point: ");
        String to = Sc.nextLine();
        reservationSystem.searchBuses(from, to);
    }

    private static void reserveSeat() {
        System.out.print("Enter customer name: ");
        String customerName = Sc.nextLine();
        Customer customer = reservationSystem.findCustomerByName(customerName);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter bus number: ");
        String busNumber = Sc.nextLine();
        Bus bus = reservationSystem.findBusByNumber(busNumber);
        if (bus == null) {
            System.out.println("Bus not found.");
            return;
        }

        System.out.print("Enter seat number to reserve: ");
        int seatIndex = Sc.nextInt();
        Sc.nextLine(); 
        reservationSystem.reserveSeat(customer, bus, seatIndex);
    }

    private static void cancelReservation() {
        reservationSystem.cancelReservation();
    }

    private static void displayReservations() {
        reservationSystem.displayReservations();
    }

    private static void displayCustomersOldestToNewest() {
        reservationSystem.displayCustomersOldestToNewest();
    }

    private static void displayCustomersNewestToOldest() {
        reservationSystem.displayCustomersNewestToOldest();
    }
}


