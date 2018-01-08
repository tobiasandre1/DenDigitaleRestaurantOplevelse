package gruppe24.dendigitalerestaurantoplevelse.backend.interfaces;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;

/**
 * Created by Tobias on 05-01-2018.
 */

public interface Search {

    public Menu search(Menu menu, CharSequence... keywords);
    public Menu search(Menu menu, boolean favorites, CharSequence... keywords);

}
