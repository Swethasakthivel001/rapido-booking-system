package com.customerService;
import com.main.ApprovedBooking;
import com.main.Bookings;
import com.main.Customer;
import com.main.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerMain {
    public static Scanner scanner = new Scanner(System.in);
    public static CustomerMain customerMain = new CustomerMain();
    public static HashMap<Integer, Customer> map = new HashMap<>();
    public static ArrayList<Bookings> bookingList = new ArrayList<>();
    public static ArrayList<ApprovedBooking> approvedBookings = new ArrayList<>();

    public static void login(){
        System.out.print("Enter userId = ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter password = ");
        String password = scanner.nextLine();
        System.out.println();
        if(map.containsKey(userId))
        {
            Customer customer = map.get(userId);
            if(customer.getRole().equals("Customer")){
                if(password.equals(customer.getPassword()))
                {
                    boolean customer_options_flag = true;
                    while(customer_options_flag)
                    {
                        System.out.println("Welcome " + customer.getUsername());
                        System.out.println();
                        System.out.println("What we like to help you.");
                        System.out.println();
                        System.out.println("1. Book a ride");
                        System.out.println("2. Cancel a ride");
                        System.out.println("3. History");
                        System.out.println("4. Logout");
                        System.out.println();
                        System.out.print("Choose an option : ");
                        int login_customer_option = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        switch(login_customer_option){
                            case 1:
                                customerMain.bookRide(customer);
                                break;
                            case 2:
                                customerMain.cancelRide(customer);
                                break;
                            case 3:
                                customerMain.showHistory(customer);
                                break;
                            case 4:
                                System.out.println("Logout .....");
                                customer_options_flag = false;
                                System.out.println("------------------------------------------------------------------------------------");
                                break;
                            default:
                                System.out.println("Invalid option.");
                                System.out.println("------------------------------------------------------------------------------------");
                                break;
                        }
                    }
                }
                else
                {
                    System.out.println("Incorrect password.");
                    System.out.println();
                }
            }
            else{
                System.out.println("Invalid login.");
            }
        }
        else
        {
            System.out.println("No user exist try again later.");
            System.out.println();
        }
        System.out.println();
    }

    public static void register(){
        System.out.print("Enter username = ");
        String username = scanner.nextLine();
        System.out.print("Enter the password = ");
        String password = scanner.nextLine();
        System.out.print("Enter the phonenumber = ");
        String phonenumber = scanner.nextLine();
        String role = "Customer";
        Customer customer = new Customer(username, password, phonenumber, role);
        int id = customer.getId();
        map.put(id, customer);
        System.out.println("Registed successfully");
        System.out.println();
        System.out.println("Your ID is "+id);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void bookRide(Customer customer){
        System.out.println();
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Auto");
        System.out.println();
        System.out.print("Choose a vehical for your drive ");
        String vehical_choose = scanner.nextLine();
        System.out.println();
        Bookings bookings = new Bookings(customer.getId(), customer.getUsername(), vehical_choose, null, null);
        bookingList.add(bookings);
        System.out.println("Your booking is successful....\n Kindly wait for approval.");
        System.out.println();
    }

    public void cancelRide(Customer customer)
    {
        int customerID = customer.getId();
        boolean to_cancel = false;

        for(Bookings booking : bookingList)
        {
            if(booking.getUserid() == customerID && booking.getBookingstatus() == null)
            {
                System.out.println(booking);
                to_cancel = true;
            }
        }

        if(!to_cancel)
        {
            System.out.println("No ride to cancel.");
        }
        else
        {
            System.out.print("Enter the booking id to cancel = ");
            int cancel_id = scanner.nextInt();
            scanner.nextLine();
            boolean found = false;
            for (Bookings booking : bookingList)
            {
                if (booking.getbookingid() == cancel_id && booking.getUserid() == customerID && booking.getCancel() == null && booking.getBookingstatus() == null)
                {
                    booking.setCancel(true);
                    found = true;
                    System.out.println("Ride cancelled successfully.");
                    break;
                }
            }
            if(!found)
            {
                System.out.println("Invalid ID.");
            }    
        }
        System.out.println();
    }

    public void showHistory(Customer customer)
    {
        int customer_id = customer.getId();
        boolean exist = false;

        for(Bookings booking : bookingList)
        {
            if(booking.getUserid() == customer_id)
            {
                System.out.println(booking);
                exist = true;
            }
        }

        if(!exist)
        {
            System.out.println("No Booking found.");
        }
        System.out.println();
    }

    public void ride_driver_changes(Driver driver){
        int driverId = driver.getId();
        String vehical = driver.getVehicaltype();
        boolean request_present = false;
        for(Bookings booking : bookingList)
        {
            if(booking.getVehical().equalsIgnoreCase(vehical) && booking.getBookingstatus() == null && booking.getCancel() == null)
            {
                System.out.println(booking);
                request_present = true;
            }
        }
        if(!request_present)
        {
            System.out.println("No request present");
        }
        else
        {
            System.out.println("Enter the booking id to approve or reject - ");
            int approve_ride_id = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            System.out.println("Enter 1 to approve and 2 to reject");
            int approve_or_reject = scanner.nextInt();
            scanner.nextLine();
            switch (approve_or_reject) {
                case 1:
                    boolean ride_approved = false;
                    for(Bookings booking : bookingList)
                    {
                        if(booking.getbookingid() == approve_ride_id && booking.getBookingstatus() == null && booking.getVehical().equalsIgnoreCase(vehical) && booking.getCancel() == null)
                        {
                            booking.setBookingstatus(true);
                            booking.setCancel(false);
                            ApprovedBooking approvedBooking = new ApprovedBooking(booking.getbookingid(), booking.getUserid(), booking.getName(), booking.getVehical(), true, false, driverId);
                            approvedBookings.add(approvedBooking);
                            System.out.println("Ride approved successfully");
                            ride_approved = true;
                            break;
                        }
                    }
                    if(!ride_approved)
                    {
                        System.out.println("No request present. Invalid ID");
                    }
                    break;
                case 2:
                    boolean ride_rejected = false;
                    for(Bookings booking : bookingList)
                    {
                        if(booking.getbookingid() == approve_ride_id && booking.getBookingstatus() == null && booking.getVehical().equalsIgnoreCase(vehical) && booking.getCancel() == null)
                        {
                            booking.setBookingstatus(false);
                            ApprovedBooking approvedBooking = new ApprovedBooking(booking.getbookingid(), booking.getUserid(), booking.getName(), booking.getVehical(), false, false, driverId);
                            approvedBookings.add(approvedBooking);
                            System.out.println("Ride Rejected");
                            ride_rejected = true;
                            break;
                        }
                    }
                    if(!ride_rejected)
                    {
                        System.out.println("No request present. Invalid ID");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    System.out.println();
                    break;
            }
        }
        System.out.println();
    }

    public void driverHistory(Driver driver){
        int driverID = driver.getId();
        boolean historyFound = false;
        for(ApprovedBooking approved : approvedBookings){
            if(approved.getDriverid() == driverID)
            {
                System.out.println(approved);
                historyFound = true;
            }
        }
        if(!historyFound)
        {
            System.out.println("No history found");
        }
        System.out.println();
    }
}