package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 27-11-2017.
 */

public class BackEndController {
    private User user;
    private Menu menu;

    public BackEndController(){
        user = new User();
        menu = new MenuArrayList();
    }

    //Getters and Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
