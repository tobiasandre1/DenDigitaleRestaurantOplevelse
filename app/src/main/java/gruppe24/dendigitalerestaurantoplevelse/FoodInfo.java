package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;


public class FoodInfo extends CustomToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        ImageView image = (ImageView) findViewById(R.id.imageView5);

        Dish sushi = new Dish("Sushi", 14.95, R.drawable.test, "Dette er en ret");

        image.setImageResource(sushi.getImage());

    }

}
