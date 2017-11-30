package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 27-11-2017.
 */

public class BackEndController {
    private static User user;
    private static Menu menu;

    public static void initialize(User u, Menu m){
        user = u;
        menu = m;
    }

    //Getters and Setters

    public static User getUser() {
        return user;
    }

    public static void setUser(User userN) {
        user = userN;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menuN) {
        menu = menuN;
    }
}
