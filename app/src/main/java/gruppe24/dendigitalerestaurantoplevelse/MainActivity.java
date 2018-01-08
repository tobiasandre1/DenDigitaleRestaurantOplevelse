package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;


import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.CrashLoggingActivity;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragFoodInfo;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenu;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenuItemList;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragPersonal;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragSearch;
import gruppe24.dendigitalerestaurantoplevelse.fragments.Toolbar;

public class MainActivity extends CrashLoggingActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add listeners to the bottom nav bar
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                selectTab(tabId);
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                selectTab(tabId);
            }
        });

    }

    private void selectTab(int tabId){
        Fragment fragment = null;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Toolbar toolbar = (Toolbar) fm.findFragmentById(R.id.toolbar);

        if (tabId == R.id.tab_home) {
            fragment = new FragMenuItemList();
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
            ft.replace(R.id.frag_place, fragment).addToBackStack("tag");
            ft.commit();
        }
    }

    public void startFoodInfoActivity(CharSequence food){
        Intent intent = new Intent(this,FragFoodInfo.class);
        Dish dish = Backend.getInstance().getMenu().getDish(food);
        intent.putExtra("Food", dish.getName().toString());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();  // Always call the superclass method first


        Toolbar toolbar = (Toolbar) getFragmentManager().findFragmentById(R.id.toolbar);
        toolbar.update();


        //System.out.println(backend.getMenu().getDishes().get(0).getName());
    }

}

