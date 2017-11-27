package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 13-11-2017.
 */

public class OrderArrayList implements Order {

    private List<OrderItem> orderItems;

    public OrderArrayList(){
        orderItems = new ArrayList<OrderItem>();
    }

    public void add(Dish dish){
        //TODO TEST this method
        for(OrderItem i: orderItems){
            if(i.getDish().equals(dish)){
                i.setAmount(i.getAmount()+1);
                return;
            }
        }
        orderItems.add(new OrderItem(dish, 1));
    }

    public OrderItem get(CharSequence name){
        for(OrderItem i: orderItems){
            if(i.getDish().getName().equals(name)){
                return i;
            }
        }
        return null;
    }
}
