package gruppe24.dendigitalerestaurantoplevelse.backend;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 02-11-2017.
 */

public class Dish{

    private CharSequence name;
    private CharSequence priceText;
    private double price;
    private int imageId; //TODO get this to refer to an imageId
    private CharSequence description;
    private List<CharSequence> tags;
    private String url;
    private Drawable image;


    public Dish(CharSequence name, double price, int imageId, CharSequence description){
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        this.description = description;
        this.priceText = "";
        this.tags = new ArrayList<>();
    }

    public Dish(CharSequence name, double price, CharSequence priceText, int imageId, CharSequence description, List<CharSequence> tags){
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        this.description = description;
        this.priceText = priceText;
        this.tags = tags;
    }

    public Dish(CharSequence name, double price, CharSequence priceText, String url, CharSequence description, List<CharSequence> tags){
        this.name = name;
        this.price = price;
        this.url = url;
        this.description = description;
        this.priceText = priceText;
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Dish))return false;

        Dish d = (Dish)o;
        if (    this.name == d.getName() && this.price == d.getPrice() && this.description == d.getDescription()
                ) {
            return true;
        }
        return false;
    }

    //Getters and setters

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
    public int getImageId() {
        return imageId;
    }*/

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public CharSequence getDescription() {
        return description;
    }

    public void setDescription(CharSequence description) {
        this.description = description;
    }

    public CharSequence getPriceText(){  return price + "kr,- " + priceText; }

    public void setPriceText(CharSequence priceText) { this.priceText = priceText; }

    public List<CharSequence> getTags() {
        return tags;
    }

    public void setTags(List<CharSequence> tags) {
        this.tags = tags;
    }

    class GetImageAsyncTask extends AsyncTask<String, Void, Drawable> {
        @Override
        protected Drawable doInBackground(String... urls) {
            try {
                InputStream stream = (InputStream) new URL(urls[0]).getContent();
                Drawable result = Drawable.createFromStream(stream, "tag");
                return result;

            } catch (MalformedURLException e) {
                System.out.println("Ho boy, there was activity malformed url exception");
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

        @Override
        protected void onPostExecute(Drawable result){
            image = result;
            for (Runnable obs : newPicturesLoaded) obs.run();
        }
    }

    public static ArrayList<Runnable> newPicturesLoaded = new ArrayList<>();

    public Drawable getImage(){
        if(image != null){
            return image;
        }
        else{
            GetImageAsyncTask net = new GetImageAsyncTask();
            net.execute(url);
            return null;
        }
    }

}
