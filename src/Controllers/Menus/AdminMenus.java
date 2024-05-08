package Controllers.Menus;

import Controllers.*;
import Controllers.MenuItem;
import Project.*;
import UtilityClasses.Colors;
import UtilityClasses.ConsoleReader;

import java.awt.*;
import java.util.*;


public class AdminMenus {
    public static Scanner sc = new Scanner(System.in);

    /** THE GAME */
    public static void adminMainMenu() { // first menu to show up
        int option;

        do {
            System.out.println("===============================");
            System.out.println("\t  ---Menus---");
            System.out.println("1. Access books menu.");
            System.out.println("2. Access authors menu.");
            System.out.println("3. Access users menu.");
            System.out.println("4. Access transactions menu (lend or return).");
            System.out.println("0. Go back.");
            option = ConsoleReader.readInteger();
            System.out.println("===============================");

            if (HashMaps.adminMainOptions.get(option) == null)
                System.out.println("Not an option");
            else
                HashMaps.adminMainOptions.get(option).execute();
        } while (option != 0);
    }

    /**Shows all the options an admin has to manipulate the books*/
    public static MenuItem adminBookMenu = () -> {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Create a book.");
            System.out.println("2. Show books.");
            System.out.println("3. Update a book's data.");
            System.out.println("4. Delete a book.");
            System.out.println("0. Go back.");
            option = ConsoleReader.readInteger();
            System.out.println("===============================");

            if (option == 2)
                BookController.showBooks(BookController.askHowToShow());
            else
                if (HashMaps.adminBookMenuOptions.get(option) == null)
                    System.out.println("Not an option");
                else
                    HashMaps.adminBookMenuOptions.get(option).execute();
        } while (option != 0);
    };

    /**Treats the author just as another profile, except this type of profile can be assigned as authors of books*/
    public static MenuItem adminAuthorMenu = () -> {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Create an author.");
            System.out.println("2. Show authors.");
            System.out.println("3. Update an author's profile.");
            System.out.println("4. Delete an author.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = ConsoleReader.readInteger();
            System.out.println("===============================");

            //every method has documentation, please read it if you don't know how something works
            if (option == 2)
                AuthorController.showAuthors(true);
            else
                if (HashMaps.adminBookMenuLayer1.get(option) == null)
                    System.out.println("Not an option");
                else
                    HashMaps.adminBookMenuLayer1.get(option).execute();
        } while (option != 0);
    };

    /**General profile manager, CRUDs and stuff*/
    public static MenuItem userMenu = () -> {
        int option;
        //turning all of this into HashMaps gotta be so hardcore, good thing I'm not

        do {
            System.out.println("===============================");
            System.out.println("1. Create a new User profile");
            System.out.println("2. Show users.");
            System.out.println("3. Update an user's data.");
            System.out.println("4. Delete an user.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = ConsoleReader.readInteger();
            System.out.println("===============================");

            switch (option) {
                case 1 -> {
                    System.out.println("1. Create an admin.\n2. Create a client.");
                    option = ConsoleReader.readInteger();
                    switch (option) {
                        case 1 -> AdminController.createAdmin();
                        case 2 -> ClientController.createClient();
                        default -> System.out.println(Colors.yellow + "Not an option" + Colors.reset);
                    }
                }
                case 2 -> {
                    System.out.println("1. Show admins");
                    System.out.println("2. Show clients");
                    System.out.println("3. Show all");
                    System.out.print(">> ");
                    int showOption = ConsoleReader.readInteger();

                    switch (showOption) {
                        case 1 -> AdminController.showAdmins();
                        case 2 -> ClientController.showClients(true);
                        case 3 -> {
                            System.out.println("Admins: ");
                            AdminController.showAdmins();
                            System.out.println("Clients: ");
                            ClientController.showClients(true);
                        }
                    }
                }
                case 3 -> UserControllers.updateUserData(ActiveUser.getActiveAdmin());
                case 4 -> {
                    System.out.println("1. Delete an admin\n2. Delete a client\n0. Go back");
                    System.out.print(">> ");
                    option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {
                        case 1 -> AdminController.deleteAdmin(ActiveUser.getActiveAdmin());
                        case 2 -> ClientController.deleteClient();
                    }
                }
                case 0 -> System.out.println("Going back...");
                default -> System.out.println("Not an option.");
            }
        } while (option != 0);
    };

    /**The program revolves around this menu and its option, can lend and return books*/
    public static MenuItem transactionMenu = () -> {
        int option;

        do {
            System.out.println("===============================");
            System.out.println("1. Validate token.");
            System.out.println("2. Show transactions.");
            System.out.println("0. Go back.");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine();
            System.out.println("===============================");

            switch (option) {
                case 1 -> TransactionController.validateToken();
                case 2 -> TransactionController.showTransactions();
                case 0 -> System.out.println("Going back...");
                default -> System.out.println("Not an option.");
            }
        } while (option != 0);
    };
}
