package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 27-11-2017.
 */

public interface Order {
    public void add(Dish dish);
    public OrderItem get(CharSequence name);

}
