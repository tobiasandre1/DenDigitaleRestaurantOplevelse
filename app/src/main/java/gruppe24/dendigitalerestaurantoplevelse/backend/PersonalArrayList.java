package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mads on 08-01-2018.
 */

public class PersonalArrayList implements Personal {

    private ArrayList<Dish> dishes;

    public PersonalArrayList(){
        dishes = new ArrayList<Dish>();
    }

    public PersonalArrayList(ArrayList<Dish> d){
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
