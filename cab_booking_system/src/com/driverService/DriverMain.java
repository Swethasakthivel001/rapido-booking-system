package com.driverService;
import com.customerService.CustomerMain;
import com.main.Driver;
import java.util.HashMap;
import java.util.Scanner;

public class DriverMain {
    public static Scanner scanner = new Scanner(System.in);
    public static CustomerMain customerMain = new CustomerMain();
    public static DriverMain driverMain = new DriverMain();
    public static HashMap<Integer, Driver> mpp = new HashMap<>();

    public static void login(){
        System.out.print("Enter userId = ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter password = ");
        String password = scanner.nextLine();
        System.out.println();

        if(mpp.containsKey(userId))
        {
            Driver driver = mpp.get(userId);
            if(driver.getRole().equals("Driver")){
                if(password.equals(driver.getPassword()))
                {
                    boolean driver_flag = true;
                    while(driver_flag)
                    {
                        System.out.println("Ready to drive "+ driver.getUsername());
                        System.out.println();
                        System.out.println("1. Approve / Reject ride");
                        System.out.println("2. History");
                        System.out.println("3. Logout");
                        System.out.println();
                        System.out.print("Choose an option : ");
                        int login_customer_option = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();
                        switch(login_customer_option){
                            case 1:
                                driverMain.approve_reject_ride(driver);
                                break;
                            case 2:
                                driverMain.history(driver);
                                break;
                            case 3:
                                System.out.println("Logout .....");
                                driver_flag = false;
                                System.out.println();
                                System.out.println("------------------------------------------------------------------------------------");
                                break;
                            default:
                                System.out.println("Invalid option.");
                                System.out.println();
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
        String role = "Driver";
        System.out.print("Enter the vehical type(car, bike, auto) : ");
        String vehicaltype = scanner.nextLine();
        Driver driver = new Driver(username, password, phonenumber, role, vehicaltype);
        int id = driver.getId();
        mpp.put(id, driver);
        System.out.println("Registed successfully");
        System.out.println();
        System.out.println("Your ID is "+id);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void approve_reject_ride(Driver driver){
        customerMain.ride_driver_changes(driver);
    }

    public void history(Driver driver)
    {
        customerMain.driverHistory(driver);
    }
}
