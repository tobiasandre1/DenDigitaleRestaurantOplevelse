package gruppe24.dendigitalerestaurantoplevelse.backend;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tobias on 27-11-2017.
 */

public class Backend {
    private User user;
    private Menu menu;
    private Personal personal;
    private static Backend instance;


    private Backend(){
        user = new User();
        menu = new MenuArrayList(new DummyData().dishes);
        personal = new PersonalArrayList(new DummyData().favorites);
    }

    public static synchronized Backend getInstance(){
        if(instance == null){
            instance = new Backend();
        }
        return instance;
    }

    //Getters and Setters

    public User getUser() {
        return this.user;
    }

    public void setUser(User userN) {
        this.user = userN;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public Personal getPersonal() {
        return this.personal;
    }

    public void setMenu(Menu menuN) {
        this.menu = menuN;
    }
}
