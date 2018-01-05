package gruppe24.dendigitalerestaurantoplevelse.backend.interfaces;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;

/**
 * Created by Tobias on 05-01-2018.
 */

public interface Search {

    public Menu search(Menu menu, String keyWordsAsSingleString);
    public Menu search(Menu menu, String... keywords);
    public Integer valueOf(Dish dish);

}
