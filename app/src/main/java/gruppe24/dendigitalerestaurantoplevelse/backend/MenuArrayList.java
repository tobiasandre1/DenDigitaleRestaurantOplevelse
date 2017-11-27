package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;

/**
 * Created by Tobias on 02-11-2017.
 */

public class MenuArrayList implements Menu {

    private static ArrayList<Dish> dishes;

    public MenuArrayList(){
        dishes = new ArrayList<Dish>();
        /*dishes.add(new Dish("Salmon Sushi"));
        dishes.add(new Dish("Spicy Sushi"));*/
    }


    @Override
    public Dish getDish(CharSequence name) {
        for(int i = 0; i< dishes.size(); i++){
            if(dishes.get(i).getName() != null){
                if(name.equals(dishes.get(i).getName())){
                    return dishes.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Dish> getDishes(){
        return dishes;
    }
}
