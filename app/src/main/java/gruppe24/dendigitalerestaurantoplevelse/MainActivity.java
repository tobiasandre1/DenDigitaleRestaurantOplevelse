package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;


import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import gruppe24.dendigitalerestaurantoplevelse.backend.CrashLoggingActivity;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragFoodInfo;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenu;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenuItemList;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragPersonal;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragSearch;
import gruppe24.dendigitalerestaurantoplevelse.fragments.ToolbarMain;

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
        ToolbarMain toolbarMain = (ToolbarMain) fm.findFragmentById(R.id.toolbarMain);

        if (tabId == R.id.tab_home) {
            fragment = new FragMenuItemList();
            toolbarMain.setTitle(getString(R.string.Home));
        }
        else if (tabId == R.id.tab_menu) {
            fragment = new FragMenu();
            toolbarMain.setTitle(getString(R.string.Menu));
        }
        else if (tabId == R.id.tab_personal) {
            fragment = new FragPersonal();
            toolbarMain.setTitle(getString(R.string.Personal));
        }
        else if (tabId == R.id.tab_search) {
            fragment = new FragSearch();
            toolbarMain.setTitle(getString(R.string.Search));
        }

        if(fragment!=null){
            ft.replace(R.id.frag_place, fragment).addToBackStack("tag");
            ft.commit();
        }
    }

    public static void startFoodInfoActivity(CharSequence food, FragmentManager fm){
        Bundle data = new Bundle();
        data.putString("Food", food.toString());

        Fragment fragment = new FragFoodInfo();
        fragment.setArguments(data);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag_place, fragment).addToBackStack("tag");
        ft.commit();

        ToolbarMain toolbarMain = (ToolbarMain) fm.findFragmentById(R.id.toolbarMain);
        toolbarMain.setTitle(food);

    }

    @Override
    protected void onResume() {
        super.onResume();  // Always call the superclass method first


        ToolbarMain toolbarMain = (ToolbarMain) getFragmentManager().findFragmentById(R.id.toolbarMain);
        toolbarMain.update();


        //System.out.println(backend.getMenu().getDishes().get(0).getName());
    }

}

