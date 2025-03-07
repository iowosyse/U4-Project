package Controllers;

import Project.*;
import Repositories.*;
import java.util.*;
import UtilityClasses.*;

public class ClientController {
    /**Adds a Client object to the clients ArrayList*/
    public static void createClient() {
        System.out.println(Colors.purple + "NOTE: Clients by default can read and ask for books. If you want to change their permissions you must do it " +
                "by editing their data." + Colors.reset);

        Client newClient = new Client();

        newClient.setProfile(StuffCreator.createProfile());

        ProfileRepositories.profiles.add(newClient.getProfile());
        UserRepositories.clients.add(newClient);

        setNewClientProfile(newClient);
        UserRepositories.clients.add(newClient);
        UserRepositories.users.add(newClient);

        System.out.println(Colors.green + "Admin created successfully" + Colors.reset);
    }

    /**Shows clients with or without the books they've borrowed*/
    public static void showClients(boolean showBooks) {
        int count = 1;

        System.out.printf("| %-3s | %-20s | %-6s |%n", "No.", "Client name", "Birth");
        System.out.println("---------------------------------------");

        for (Client thisClient : UserRepositories.clients) {
            System.out.printf("| %-3s | %-20s | %-6s |%n", count, thisClient.getProfile().getName() + " " +
                    thisClient.getProfile().getLastName(), (thisClient.getProfile().getBirthDate().getMonth() + 1) + "-" +
                    thisClient.getProfile().getBirthDate().getYear());

            if (thisClient.hasBooks() && showBooks) {
                System.out.printf("| %-26s |%n", "Books borrowed by " + thisClient.getProfile().getName() +
                        " " + thisClient.getProfile().getLastName() + ":");
                for (Book bok : thisClient.getBorrowedBooks()) {
                    if (!bok.getTitle().isEmpty()) {
                        System.out.printf("| %-26s |%n", bok.getTitle());
                    }
                }
            }
            System.out.println("---------------------------------------");
            count ++;
        }
    }

    /**Deletes a Client from the clients ArrayList. Cannot delete someone if they have borrowed books*/
    public static void deleteClient() {
        int option;
        Client toDelete1;
        System.out.println("---The client must return all of their books in order to delete themselves---");

        do {
            showClients(false);

            do {
                System.out.println("Which client do you want to delete?");
                System.out.println("Enter 0 to go back.");
                option = ConsoleReader.readInteger();
            } while (option - 1 > UserRepositories.clients.size() || option < 0);

            if (option != 0) {

                toDelete1 = UserRepositories.clients.get(option - 1);

                if (!toDelete1.getBorrowedBooks().isEmpty()) {
                    System.out.println(Colors.yellow + "This client cannot be deleted since they have not returned all of their books.");
                    System.out.println("Return all of the books in the 'Transaction menu'." + Colors.reset);
                } else {
                    UserRepositories.clients.remove(toDelete1);
                    toDelete1.setInQuarantine();
                    System.out.println(Colors.green + "Client deleted successfully!" + Colors.reset);
                }
            }
        } while (option != 0);
    }

    private static void setNewClientProfile(Client newClientProfile) {
        String aux;

        System.out.println("Create a username.");
        newClientProfile.setUsername(UserRepositories.validateUsername());

        System.out.println("Create a password.");
        System.out.println(Colors.yellow + "The password must contain a special character, a lower-case letter, an upper-case letter and a number." + Colors.reset);
        aux = ConsoleReader.readString(Validators.validPassword);
        newClientProfile.setPassword(HashPassword.hashString(aux));
    }
}
