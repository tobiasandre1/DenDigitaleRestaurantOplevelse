package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.List;

/**
 * Created by Mads on 08-01-2018.
 */

public interface Personal {
    public Dish getDish(CharSequence name);

    public List<Dish> getDishes();

    public String[] getDishesAsStrings();
}
