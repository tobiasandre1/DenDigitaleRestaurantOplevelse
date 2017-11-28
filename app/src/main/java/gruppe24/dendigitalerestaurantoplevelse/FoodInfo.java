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

        super.makeToolbar();

        //Insert data into layout
        Bundle data = getIntent().getExtras();
        CharSequence foodInfoDishName = data.getString("Food");
        if(foodInfoDishName == null){System.out.println("Oi you dumb basterd, null");}
        Dish dish = super.backend.getMenu().getDish(foodInfoDishName);
        insertDish(dish);


    }

    public void insertDish(Dish dish){
        ImageView image = (ImageView) findViewById(R.id.imageView5);
        TextView title = (TextView) findViewById(R.id.dishName);
        TextView description = (TextView) findViewById(R.id.dishDesc);

        image.setImageResource(dish.getImage());
        title.setText(dish.getName());
        description.setText(dish.getDescription());

    }

}
