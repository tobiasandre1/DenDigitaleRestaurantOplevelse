package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 27-11-2017.
 */

public class User {

    Order shoppingCart;

    public User(){
        shoppingCart = new OrderArrayList();
    }
}
