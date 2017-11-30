package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;


public class FoodInfo extends CustomToolbarActivity implements View.OnClickListener{

    private Dish dish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        super.makeToolbar();

        insertDish();

        Button add = (Button) findViewById(R.id.addToBasket);
        add.setOnClickListener(this);




    }

    private void getDishData(){
        //Get dish data and set class dish variable
        Bundle data = getIntent().getExtras();
        CharSequence foodInfoDishName = data.getString("Food");
        this.dish = super.backend.getMenu().getDish(foodInfoDishName);

    }

    private void insertDish(){
        getDishData();
        //Insert data into layout
        ImageView image = (ImageView) findViewById(R.id.imageView5);
        TextView title = (TextView) findViewById(R.id.dishName);
        TextView description = (TextView) findViewById(R.id.dishDesc);

        image.setImageResource(this.dish.getImage());
        title.setText(this.dish.getName());
        description.setText(this.dish.getDescription());

    }

    public void onClick(View v){
        if(v.getId() == R.id.addToBasket){
            super.backend.getUser().getShoppingCart().add(this.dish);
        }
    }

}
