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
        dishes.add(new Dish("Sashimi laks", 85, "/5 skiver", R.drawable.dishpicture_sashimi_laks,
                "Sashimi af laks serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("laks", "sashimi"))));
        dishes.add(new Dish("Sashimi hamachi", 99, "/5 skiver", R.drawable.dishpicture_sashimi_hamachi,
                "Sashimi af Yellowtail kingfish serveret med soya og wasabi",
                new ArrayList<CharSequence>(Arrays.asList("kingfish", "sashimi"))));
        dishes.add(new Dish("Sashimi saba", 59, "/5 skiver", R.drawable.dishpicture_sashimi_saba,
                "Sashimi af makrel med ingefær og forårsløg serveret med soya og wasabi ",
                new ArrayList<CharSequence>(Arrays.asList("makrel", "sashimi", "ingefær"))));

        NetworkAsyncTask net = new NetworkAsyncTask();
        net.execute("http://www.sushi.dk/media/products/C716_13743_SNS.png?ts=1460556991");

    }

    class NetworkAsyncTask extends AsyncTask<String, Void, Drawable[]> {
        @Override
        protected Drawable[] doInBackground(String... urls) {
            Drawable[] result = new Drawable[urls.length];

            try {
                System.out.println("No exceptions so far");
                InputStream stream;
                for(int i = 0; i<urls.length; i++) {
                    stream = (InputStream) new URL(urls[i]).getContent();
                    result[i] = Drawable.createFromStream(stream, "tag");
                }
                return result;

            } catch (MalformedURLException e) {
                System.out.println("Ho boy, there was a malformed url exception");
                System.out.println(e);
            } catch (IOException e) {
                System.out.println("Ho boy, there was an IOException madafakker");
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("I don't even know what happened");
                System.out.println(e);
            }
            return null;
        }

    }

}
