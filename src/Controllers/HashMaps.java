package Controllers;

import Controllers.Menus.AdminMenus;
import java.util.HashMap;


/**HashMaps holder*/
public class HashMaps {
    private static final MenuItem case0 = () -> System.out.println("Going back...");

    public static HashMap<Integer, MenuItem> adminMainOptions = new HashMap<>();
    public static void initializeAdminMainMenu() {
        adminMainOptions.put(1, AdminMenus.adminBookMenu);
        adminMainOptions.put(2, AdminMenus.adminAuthorMenu);
        adminMainOptions.put(3, AdminMenus.userMenu);
        adminMainOptions.put(4, AdminMenus.transactionMenu);
        adminMainOptions.put(0, case0);
    }

    public static HashMap<Integer, MenuItem> adminBookMenuOptions = new HashMap<>();
    public static void initializeAdminBookOptions(){
        adminBookMenuOptions.put(1, BookController.createBook);
        adminBookMenuOptions.put(3, BookController.updateBookData);
        adminBookMenuOptions.put(4, BookController.deleteBook);
        adminBookMenuOptions.put(0, case0);
    }

    public static HashMap<Integer, MenuItem> adminBookMenuLayer1 = new HashMap<>();
    public static void initializeAdminBookLayer1(){
        adminBookMenuLayer1.put(1, AuthorController::createAuthor);
        adminBookMenuLayer1.put(3, AuthorController::updateAuthorData);
        adminBookMenuLayer1.put(4, AuthorController::deleteAuthor);
        adminBookMenuLayer1.put(0, case0);
    }

    public static HashMap<Integer, MenuItem> transactionMenuLayer1 = new HashMap<>();
    public static void initializeTransactionsLayer1() {
        transactionMenuLayer1.put(1, TransactionController::validateToken);
        transactionMenuLayer1.put(2, TransactionController::showTransactions);
        transactionMenuLayer1.put(0, case0);
    }

    //ToDo: Convert every switch-case in the code to HashMap.

    public static void initializeAllMaps(){
        initializeAdminMainMenu();
        initializeAdminBookOptions();
        initializeAdminBookLayer1();
        initializeTransactionsLayer1();
        //ToDo: Finish every conversion from switch-case to HashMap and initialize it.
    }
}
