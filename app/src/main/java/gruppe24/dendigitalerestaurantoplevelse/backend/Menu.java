package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.List;

/**
 * Created by Tobias on 02-11-2017.
 */

public interface Menu {

    public Dish getDish(CharSequence name);

    public List<Dish> getDishes();

    public String[] getDishesAsStrings();

}
