package gruppe24.dendigitalerestaurantoplevelse.backend.interfaces;

import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;

/**
 * Created by Tobias on 02-11-2017.
 */

public interface Menu {

    public Dish getDish(CharSequence name);

    public List<Dish> getDishes();

    public String[] getDishesAsStrings();

}
