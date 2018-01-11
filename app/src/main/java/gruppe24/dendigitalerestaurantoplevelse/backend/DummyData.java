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
    public ArrayList<Dish> favorites;
    public ArrayList<Dish> dishes;

    public DummyData() {
        dishes = new ArrayList();
        favorites = new ArrayList();
        //Dummy data
        dishes.add(new Dish("Sashimi laks", 85, "/5 skiver", "http://www.sushi.dk/media/products/T352_10061_SNS.png?ts=1460443673",
                "Sashimi af laks serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("laks", "sashimi"))));
        dishes.add(new Dish("Sashimi hamachi", 99, "/5 skiver", "http://www.sushi.dk/media/products/T352_10063_SNS.png?ts=1460443714",
                "Sashimi af Yellowtail kingfish serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("kingfish", "sashimi", "hamachi"))));
        dishes.add(new Dish("Sashimi saba", 59, "/5 skiver", "http://www.sushi.dk/media/products/T352_13711_SNS.png?ts=1460444054",
                "Sashimi af makrel med ingefær og forårsløg serveret med soya og wasabi ",
                new ArrayList<CharSequence>(Arrays.asList("makrel", "sashimi", "ingefær"))));
        dishes.add(new Dish("Broccoli", 44, "/2 stk", "http://www.sushi.dk/media/products/SQ225_13814_SNS.png?ts=1485859577",
                "Grillet broccoli",
                new ArrayList<CharSequence>(Arrays.asList("grøntsag", "nigiri", "broccoli"))));
        dishes.add(new Dish("Aspara", 48, "/2 stk", "http://www.sushi.dk/media/products/SQ225_13759_SNS.png?ts=1485859330",
                "Nigiri med asparges og sesam",
                new ArrayList<CharSequence>(Arrays.asList("grøntsag", "nigiri", "asparges", "sesam"))));
        dishes.add(new Dish("En ret med en meget lang titel som muligvis er over to linjer lang", 48, "/2 stk", "http://www.sushi.dk/media/products/SQ225_13759_SNS.png?ts=1485859330",
                "Retten har også en beskrivelse som muligvis er en del længere end hvad de fleste er, den indeholder for " +
                        "eksempel lorem ipsum larum, hvilket ikke nødvendigvis smager godt, men giver en god mundsmag. " +
                        "Hvad i al verden er det dog jeg skriver i denne beskrivelse? Jeg ved det faktisk ikke selv. " +
                        "Det har muligvis noget med test at gøre, men dette er heller ikke fuldstændigt defineret i " +
                        "denne logiske sfære som vi kalder vores bevidsthed. Sushi. Sushi. Sushi. Burger. Ikke burger. " +
                        "Sushi. Sushiii. Spis sushi. Længere tekster end før. Mundsmag. Hvad? Nej. Noget. Hvem? Hvornår? " +
                        "Dette er et tankevækkende eksperiement om hvor dumme tekster jeg kan skrive for at teste et program. " +
                        "Stop...",
                new ArrayList<CharSequence>(Arrays.asList("grøntsag", "nigiri", "asparges", "sesam"))));


        favorites.add(new Dish("Sashimi saba", 59, "/5 skiver", R.drawable.dishpicture_sashimi_saba,
                "Sashimi af makrel med ingefær og forårsløg serveret med soya og wasabi ",
                new ArrayList<CharSequence>(Arrays.asList("makrel", "sashimi", "ingefær"))));
        favorites.add(new Dish("Sashimi laks", 85, "/5 skiver", R.drawable.dishpicture_sashimi_laks,
                "Sashimi af laks serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("laks", "sashimi"))));

    }
}

  
