package gruppe24.dendigitalerestaurantoplevelse.backend;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import gruppe24.dendigitalerestaurantoplevelse.R;

/**
 * Created by Tobias on 03-01-2018.
 */

public class DummyData {
    public ArrayList<Dish> dishes;

    public DummyData(){
        dishes = new ArrayList();

        //Dummy data
        dishes.add(new Dish("Sashimi laks", 85, "/5 skiver", "http://www.sushi.dk/media/products/T352_10061_SNS.png?ts=1460443673",
                "Sashimi af laks serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("laks", "sashimi"))));
        dishes.add(new Dish("Sashimi hamachi", 99, "/5 skiver", "http://www.sushi.dk/media/products/T352_10063_SNS.png?ts=1460443714",
                "Sashimi af Yellowtail kingfish serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("kingfish", "sashimi"))));
        dishes.add(new Dish("Sashimi saba", 59, "/5 skiver", "http://www.sushi.dk/media/products/T352_13711_SNS.png?ts=1460444054",
                "Sashimi af makrel med ingefær og forårsløg serveret med soya og wasabi ",
                new ArrayList<CharSequence>(Arrays.asList("makrel", "sashimi", "ingefær"))));
        dishes.add(new Dish("Something fishy", 59, "/5 skiver", "http://www.sushi.dk/media/products/C716_13743_SNS.png?ts=1460556991",
                "Sashimi af makrel med ingefær og forårsløg serveret med soya og wasabi ",
                new ArrayList<CharSequence>(Arrays.asList("makrel", "sashimi", "ingefær"))));



    }

}
