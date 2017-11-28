package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;

public class MainActivity extends CustomToolbarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.makeToolbar();

    }

    public void btnSushi_OnClick(View view) {
        startFoodInfoActivity("Sashimi laks"); //TODO Replace "Sashimi laks" with data from buttons in arrayadapter
    }

    public void startFoodInfoActivity(CharSequence food){
        Intent intent = new Intent(this,FoodInfo.class);
        Dish dish = super.backend.getMenu().getDish(food);
        intent.putExtra("Food", dish.getName().toString());
        startActivity(intent);
    }
    /*
    public void SkiftFrag(View view){
        Fragment fragment;
        if ( view == findViewById(R.id.shoppingcart)) {
            fragment = new ShoppingCart();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
        /* Til andre fragments
        if ( view == findViewById(R.id.hjælp)) {
            fragment = new HjaelpFrag();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_placering, fragment);
            ft.commit();
        }

    }
    */
}
