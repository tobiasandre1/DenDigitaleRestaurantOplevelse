package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 27-11-2017.
 */

public interface Order {
    public void add(Dish dish);
    public void setAmount(Dish dish, int amount);
    public void reduce(Dish dish);
    public void remove(Dish dish);
    public OrderItem get(CharSequence name);
    public double getTotalPrice();
    public CharSequence getTotalPriceAsText();
    public String[] getItemsAsStrings();

}
