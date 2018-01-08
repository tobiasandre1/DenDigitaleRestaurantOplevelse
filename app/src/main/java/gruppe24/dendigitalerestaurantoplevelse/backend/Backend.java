package gruppe24.dendigitalerestaurantoplevelse.backend;

import android.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Search;

/**
 * Created by Tobias on 27-11-2017.
 */

public class Backend implements Search{
    private User user;
    private Menu menu;
    private Personal personal;
    private static Backend instance;


    private Backend(){
        user = new User();
        menu = new MenuArrayList(new DummyData().dishes);
        personal = new PersonalArrayList(new DummyData().favorites);
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

    public Personal getPersonal() {
        return this.personal;
    }

    public void setMenu(Menu menuN) {
        this.menu = menuN;
    }

    public Menu search(Menu menu, CharSequence... keywords){
        return search(menu, false, keywords);
    }

    public Menu search(Menu menu, boolean favorites, CharSequence... keywords){
        if(keywords.length == 1){
            keywords = keywords[0].toString().split(" ");
        }

        String word;
        for(int i = 0; i<keywords.length; i++){
            word = keywords[i].toString().toLowerCase();
            keywords[i] = word;
        }

        TreeMap<Integer, ArrayList<Dish>> dishMap = new TreeMap<>(Collections.reverseOrder());

        int value;
        for(Dish dish : menu.getDishes()){
            value = valueOf(dish, favorites, keywords);                         //We give the dish a value
            if(value>0){                                                        //We determine whether the dish is relevant to the search
                ArrayList<Dish> mapDishes = dishMap.get(value);                    //If it is, we add it to the list
                if(mapDishes == null){
                    mapDishes = new ArrayList<Dish>();
                    dishMap.put(value, mapDishes);
                }
                mapDishes.add(dish);
            }

        }

        ArrayList<Dish> dishes = new ArrayList<>();
        for(ArrayList<Dish> mapDishes : dishMap.values()){
            dishes.addAll(mapDishes);
        }

        Menu result = new MenuArrayList(dishes);

        return result;
    }

    private Integer valueOf(Dish dish, boolean favorites, CharSequence... keywords){
        Integer value = 0;

        ArrayList<CharSequence> title = new ArrayList<CharSequence>(Arrays.asList(dish.getName().toString().split(" ")));
        for(CharSequence word: keywords){
            if(dish.getTags().contains(word) || title.contains(word)){
                value += 1;
            }
        }

        if(favorites){
            //TODO implement when favorites has been implemented
        }

        return value;
    }
}
