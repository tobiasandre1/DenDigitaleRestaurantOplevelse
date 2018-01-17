package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 27-11-2017.
 */

public class User {

    Order shoppingCart;
    List<CharSequence> favorites;
    SharedPreferenceManager sharedPreferenceManager;

    public User(){
        shoppingCart = new OrderArrayList();
        favorites = new ArrayList<>();
        sharedPreferenceManager = new SharedPreferenceManager();
    }

    ///Getters and setters

    public Order getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Order shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<CharSequence> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<CharSequence> favorites) {
        this.favorites = favorites;
    }

    public SharedPreferenceManager getSharedPreferenceManager() {
        return sharedPreferenceManager;
    }

}
