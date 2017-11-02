package gruppe24.dendigitalerestaurantoplevelse.backend;

/**
 * Created by Tobias on 02-11-2017.
 */

public class FoodItem {

    private CharSequence name;

    public FoodItem(CharSequence name){
        this.name = name;
    }

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }
}
