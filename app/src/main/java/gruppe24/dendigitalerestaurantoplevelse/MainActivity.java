package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import gruppe24.dendigitalerestaurantoplevelse.backend.BackEndController;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.backend.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.User;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragHome;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenu;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragPersonal;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragSearch;
import gruppe24.dendigitalerestaurantoplevelse.fragments.Toolbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(BackEndController.getUser()==null && BackEndController.getMenu()==null) {
            Menu menu = new MenuArrayList();
            User user = new User();
            BackEndController.initialize(user, menu);
            ;
        }



        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment = null;
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Toolbar toolbar = (Toolbar) fm.findFragmentById(R.id.toolbar);

                if (tabId == R.id.tab_home) {
                    fragment = new FragHome();
                    toolbar.setTitle("Home");
                }
                else if (tabId == R.id.tab_menu) {
                    fragment = new FragMenu();
                    toolbar.setTitle("Menu");
                }
                else if (tabId == R.id.tab_personal) {
                    fragment = new FragPersonal();
                    toolbar.setTitle("Personal");
                }
                else if (tabId == R.id.tab_search) {
                    fragment = new FragSearch();
                    toolbar.setTitle("Search");
                }

                if(fragment!=null){
                    ft.replace(R.id.frag_place, fragment);
                }
                ft.commit();

            }
        });

    }

    public void startFoodInfoActivity(CharSequence food){
        Intent intent = new Intent(this,FoodInfo.class);
        Dish dish = BackEndController.getMenu().getDish(food);
        intent.putExtra("Food", dish.getName().toString());
        startActivity(intent);
    }

}

