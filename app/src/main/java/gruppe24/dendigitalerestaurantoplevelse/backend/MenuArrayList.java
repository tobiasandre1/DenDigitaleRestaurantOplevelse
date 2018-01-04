package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.R;

/**
 * Created by Tobias on 02-11-2017.
 */

public class MenuArrayList implements Menu {

    private ArrayList<Dish> dishes;

    public MenuArrayList(){
        dishes = new ArrayList<Dish>();
    }

    public MenuArrayList(ArrayList<Dish> d){
        dishes = d;
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

    @Override
    public String[] getDishesAsStrings(){
        List<Dish> dishes = getDishes();
        String[] result = new String[dishes.size()];
        for(int i=0; i<dishes.size(); i++){
            result[i] = dishes.get(i).getName().toString();
        }
        return result;
    }
}
