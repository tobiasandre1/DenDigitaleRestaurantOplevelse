package gruppe24.dendigitalerestaurantoplevelse.backend;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 02-11-2017.
 */

public class Dish{

    private CharSequence name;
    private CharSequence priceText;
    private double price;
    private int image; //TODO get this to refer to an image
    private CharSequence description;
    private List<CharSequence> tags;


    public Dish(CharSequence name, double price, int image, CharSequence description){
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.priceText = "";
        this.tags = new ArrayList<>();
    }

    public Dish(CharSequence name, double price, CharSequence priceText, int image, CharSequence description, List<CharSequence> tags){
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.priceText = priceText;
        this.tags = tags;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public CharSequence getDescription() {
        return description;
    }

    public void setDescription(CharSequence description) {
        this.description = description;
    }

    public CharSequence getPriceText(){  return price + "kr,- " + priceText; }



}
