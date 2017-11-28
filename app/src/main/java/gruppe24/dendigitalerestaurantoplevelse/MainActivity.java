package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;


import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.fragments.fraghome;
import gruppe24.dendigitalerestaurantoplevelse.fragments.fragmenu;
import gruppe24.dendigitalerestaurantoplevelse.fragments.fragpersonal;

public class MainActivity extends CustomToolbarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment;
                if (tabId == R.id.tab_home) {
                    fragment = new fraghome();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag_place, fragment);
                    ft.commit();
                } else if (tabId == R.id.tab_menu) {
                    fragment = new fragmenu();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag_place, fragment);
                    ft.commit();
                } else if (tabId == R.id.tab_personal) {
                    fragment = new fragpersonal();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag_place, fragment);
                    ft.commit();
                }

            }
        });



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

}

