package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 27-11-2017.
 */

public class OrderItem {
    Dish dish;
    int amount;

    OrderItem(Dish dish, int amount){
        this.dish = dish;
        this.amount = amount;
    }

    //Getters and setters
    public Dish getDish() { return dish; }

    public void setDish(Dish dish){ this.dish = dish; }

    public int getAmount(){ return amount; }

    public void setAmount(int amount){ this.amount = amount; }
}
