import com.customerService.CustomerMain;
import com.driverService.DriverMain;
import java.util.Scanner;


public class App {
    static Scanner scanner = new Scanner(System.in);
    static App app = new App();
    public static void main(String[] args) {
        boolean flag = true;
        while(flag){
            System.out.println("Cab Booking System : ");
            System.out.println();
            System.out.println("1. Admin");
            System.out.println("2. Driver");
            System.out.println("3. Customer");
            System.out.println("4. Exit from application");
            System.out.println();
            System.out.print("Choose an option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (option){
                case 1 : 
                    System.out.print("Enter the username : ");
                    String admin_name = scanner.next();
                    System.out.print("Enter password : ");
                    String admin_password = scanner.next();
                    System.out.println();
                    if(admin_name.equals("swetha") && admin_password.equals("swe123"))
                    {
                        System.out.println("WELCOME ADMIN");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Incorrect username or password");
                        System.out.println();
                        System.out.println("------------------------------------------------------------------------------------");
                    }   
                    break;
                case 2 :
                    app.driverOptions();
                    break;
                case 3 :
                    app.customerOptions();
                    break;
                case 4 :
                    flag = false;
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------------------");
                    break;
                default : 
                    System.out.println("Enter the correct option...");
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------------------");
                    break;
            }
        }
    }

    public void customerOptions()
    {
        boolean flag_customer = true;
        while(flag_customer)
        {
            System.out.println("Welcome to ride : ");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit Customer");
            System.out.println();
            System.out.print("Choose an option = ");
            int option_customer = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (option_customer) {
                case 1:
                    CustomerMain.login();
                    break;
                case 2:
                    CustomerMain.register();
                    break;
                case 3:
                    flag_customer = false;
                    break;
                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }

    public void driverOptions()
    {
        boolean flag_customer = true;
        while(flag_customer)
        {
            System.out.println("Welcome to serve : ");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit driver");
            System.out.println();
            System.out.print("Choose an option = ");
            int option_driver = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (option_driver) {
                case 1:
                    DriverMain.login();
                    break;
                case 2:
                    DriverMain.register();
                    break;
                case 3:
                    flag_customer = false;
                    break;
                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }   
}