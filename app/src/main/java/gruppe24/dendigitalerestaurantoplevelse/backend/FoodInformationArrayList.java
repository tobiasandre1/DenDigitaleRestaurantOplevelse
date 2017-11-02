package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;

/**
 * Created by Tobias on 02-11-2017.
 */

public class FoodInformationArrayList implements FoodsInformation {

    private static ArrayList<FoodItem> foods;

    public FoodInformationArrayList(){
        foods = new ArrayList<FoodItem>();
        foods.add(new FoodItem("Salmon Sushi"));
        foods.add(new FoodItem("Spicy Sushi"));
    }


    @Override
    public FoodItem getFoodItem(CharSequence name) {
        for(int i = 0; i<foods.size(); i++){
            if(foods.get(i).getName() != null){
                if(name.equals(foods.get(i).getName())){
                    return foods.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<FoodItem> getFoodItems(){
        return foods;
    }
}
