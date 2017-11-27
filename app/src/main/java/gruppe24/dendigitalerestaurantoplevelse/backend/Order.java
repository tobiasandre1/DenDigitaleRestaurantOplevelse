package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 13-11-2017.
 */

public class Order {

    private List<OrderItem> dishes;

    public Order(){
        dishes = new ArrayList<OrderItem>();
    }

    public void add(Dish dish){
        //TODO TEST this method
        for(OrderItem i: dishes){
            if(i.getDish().equals(dish)){
                i.setAmount(i.getAmount()+1);
                return;
            }
        }
        dishes.add(new OrderItem(dish, 1));
    }

    public class OrderItem {
        Dish dish;
        int amount;

        OrderItem(Dish dish, int amount){
            this.dish = dish;
            this.amount = amount;
        }

        public Dish getDish() { return dish; }

        public int getAmount(){ return amount; }

        public void setAmount(int amount){ this.amount = amount; }
    }




}
