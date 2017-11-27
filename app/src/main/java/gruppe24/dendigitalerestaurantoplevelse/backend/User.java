package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 27-11-2017.
 */

public class User {

    Order shoppingCart;
    List<CharSequence> favorites;

    public User(){
        shoppingCart = new OrderArrayList();
        favorites = new ArrayList<>();
    }
}
