package Project;

/**Pseudo Singleton*/
public class ActiveUser {
    private static Admin activeAdmin;
    private static Client activeCLient;

    public static void generateActive(User user){
        if (user instanceof Admin){
            activeAdmin = (Admin) user;
            activeCLient = null;
        } else {
            activeAdmin = null;
            activeCLient = (Client) user;
        }

    }

    public static Admin getActiveAdmin() {
        return activeAdmin;
    }

    public static Client getActiveCLient() {
        return activeCLient;
    }
}
