package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Mads on 11-01-2018.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;


public class SharedPreference {

    public static final String PREFS_NAME = "SushiApp";
    public static final String PREFEREDITEMS = "Preferences";


    public void saveToPreferences(Context context, List<Dish> preferences) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        // saves to json object and back in order to be able to save arraylist
        Gson gson = new Gson();
        String jsonPreferedItems = gson.toJson(preferences);

        editor.putString(PREFEREDITEMS, jsonPreferedItems);

        editor.commit();
    }

    public void addToPreferences(Context context, Dish product) {
        List<Dish> preferences = getPreferences(context);
        if (preferences == null)
            preferences = new ArrayList<Dish>();
        preferences.add(product);
        saveToPreferences(context, preferences);
    }

    public void removePreference(Context context, Dish product) {
        ArrayList<Dish> preferences = getPreferences(context);
        if (preferences != null) {
            preferences.remove(product);
            saveToPreferences(context, preferences);
        }
    }

    public ArrayList<Dish> getPreferences(Context context) {
        SharedPreferences settings;
        List<Dish> preferences;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(PREFEREDITEMS)) {
            String jsonPreferedItems = settings.getString(PREFEREDITEMS, null);
            Gson gson = new Gson();
            Dish[] preferedItems = gson.fromJson(jsonPreferedItems,
                    Dish[].class);

            preferences = Arrays.asList(preferedItems);
            preferences = new ArrayList<Dish>(preferences);
        } else
            return null;

        return (ArrayList<Dish>) preferences;
    }
}