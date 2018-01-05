package gruppe24.dendigitalerestaurantoplevelse.backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Search;

/**
 * Created by Tobias on 27-11-2017.
 */

public class Backend implements Search{
    private User user;
    private Menu menu;

    private static Backend instance;


    private Backend(){
        user = new User();
        menu = new MenuArrayList(new DummyData().dishes);
    }

    public static synchronized Backend getInstance(){
        if(instance == null){
            instance = new Backend();
        }
        return instance;
    }

    //Getters and Setters

    public User getUser() {
        return this.user;
    }

    public void setUser(User userN) {
        this.user = userN;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menuN) {
        this.menu = menuN;
    }

    public Menu search(Menu menu, String keywordsSingleString){
        String[] keywords = keywordsSingleString.split(" ");
        Menu result = search(menu, keywords);
        return result;
    }

    public Menu search(Menu menu, String... keywords){
        Map<Integer, Dish> dishMap = new TreeMap<>(Collections.reverseOrder());
        //Treemap is a sorted data structure with keys and values, we order it from high to low, setting high value dishes first

        int value;
        for(Dish dish : menu.getDishes()){
            value = valueOf(dish);              //We give the dish a value
            if(value>0){                        //We determine whether the dish is relevant to the search
                dishMap.put(value, dish);       //If it is, we add it to the tree
            }
        }

        Menu result = new MenuArrayList(new ArrayList<Dish>(dishMap.values())); //We make a new List based on the sorted values
        return result;
    }

    public Integer valueOf(Dish dish){
        return 0;
    }
}
