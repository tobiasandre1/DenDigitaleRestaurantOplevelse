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

    public void reduce(Dish dish){
        //TODO TEST this method
        for(OrderItem i: orderItems){
            if(i.getDish().equals(dish)){ //This line may be problematic, as we have not made a custom equals method for this class
                if(i.getAmount() > 1){
                    i.setAmount(i.getAmount()-1);
                }
                else{
                    orderItems.remove(i);
                }

                return;
            }
        }
    }

    public void remove(Dish dish){
        //TODO test this method
        for(OrderItem i: orderItems){
            if(i.getDish().equals(dish)){
                orderItems.remove(i);
            }
            return;
        }
    }

    public OrderItem get(CharSequence name){
        for(OrderItem i: orderItems){
            if(i.getDish().getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    public double getTotalPrice(){
        double result = 0;
        for(OrderItem i : orderItems){
            result += i.getDish().getPrice()*i.getAmount();
        }
        return result;
    }
}
