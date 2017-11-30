package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.R;

/**
 * Created by Tobias on 02-11-2017.
 */

public class MenuArrayList implements Menu {

    private static ArrayList<Dish> dishes;

    public MenuArrayList(){
        dishes = new ArrayList<Dish>();
        /*dishes.add(new Dish("Salmon Sushi"));
        dishes.add(new Dish("Spicy Sushi"));*/
        initializeDummyData();
    }


    public void initializeDummyData(){
        //Dummy data
        dishes.add(new Dish("Sashimi laks", 85, "/5 skiver", R.drawable.dishpicture_sashimi_laks,
                "Sashimi af laks serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("laks", "sashimi"))));
        dishes.add(new Dish("Sashimi hamachi", 99, "/5 skiver", R.drawable.dishpicture_sashimi_hamachi,
                "Sashimi af Yellowtail kingfish serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("kingfish", "sashimi"))));
        dishes.add(new Dish("Sashimi saba", 59, "/5 skiver", R.drawable.dishpicture_sashimi_saba,
                "Sashimi af makrel med ingefær og forårsløg serveret med soya og wasabi ",
                new ArrayList<CharSequence>(Arrays.asList("makrel", "sashimi", "ingefær"))));
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
