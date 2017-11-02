package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.List;

/**
 * Created by Tobias on 02-11-2017.
 */

public interface FoodsInformation {

    public FoodItem getFoodItem(CharSequence name);

    public List<FoodItem> getFoodItems();
}
