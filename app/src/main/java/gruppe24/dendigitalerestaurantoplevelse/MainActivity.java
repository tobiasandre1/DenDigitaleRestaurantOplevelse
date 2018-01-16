package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;


import com.guna.libmultispinner.MultiSelectionSpinner;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.backend.CrashLoggingActivity;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragFoodInfo;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenu;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragMenuItemList;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragPersonal;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragSearch;
import gruppe24.dendigitalerestaurantoplevelse.fragments.ToolbarMain;

public abstract class MainActivity extends CrashLoggingActivity implements MultiSelectionSpinner.OnMultipleItemsSelectedListener {

    private String currentTab = "";
    private Fragment fragment = null;
    public Runnable update = new Runnable() {
        @Override
        public void run() {
            toolbarStuff();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] array = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        MultiSelectionSpinner multiSelectionSpinner = (MultiSelectionSpinner) findViewById(R.id.spinner);
        multiSelectionSpinner.setItems(array);
        multiSelectionSpinner.setSelection(new int[]{2, 6});
        multiSelectionSpinner.setListener(this);
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

        ListAdapter.observers.add(update);

    }

    private void selectTab(int tabId){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ToolbarMain toolbarMain = (ToolbarMain) fm.findFragmentById(R.id.toolbarMain);

        if (tabId == R.id.tab_home) {
            fragment = new FragMenuItemList();
            toolbarMain.setTitle(getString(R.string.home));
            currentTab=getString(R.string.home);
        }
        else if (tabId == R.id.tab_menu) {
            fragment = new FragMenu();
            toolbarMain.setTitle(getString(R.string.menu));
            currentTab=getString(R.string.menu);
        }
        else if (tabId == R.id.tab_personal) {
            fragment = new FragPersonal();
            toolbarMain.setTitle(getString(R.string.personal));
            currentTab=getString(R.string.personal);
        }
        else if (tabId == R.id.tab_search) {
            fragment = new FragSearch();
            toolbarMain.setTitle(getString(R.string.search));
            currentTab=getString(R.string.search);
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
        ft.replace(R.id.frag_place, fragment).addToBackStack("food");
        ft.commit();

        ToolbarMain toolbarMain = (ToolbarMain) fm.findFragmentById(R.id.toolbarMain);
        toolbarMain.setTitle(food);
        toolbarMain.displayBackButton(fragment);

    }

    @Override
    protected void onResume() {
        super.onResume();  // Always call the superclass method first
        toolbarStuff();
    }

    @Override
    public void onBackPressed(){
        toolbarStuff();
        super.onBackPressed();
    }

    private void toolbarStuff(){
        ToolbarMain toolbarMain = (ToolbarMain) getFragmentManager().findFragmentById(R.id.toolbarMain);
        toolbarMain.setTitle(currentTab);
        toolbarMain.update();
    }

    @Override
    public boolean onSupportNavigateUp() {
        ToolbarMain toolbarMain = (ToolbarMain) getFragmentManager().findFragmentById(R.id.toolbarMain);
        toolbarMain.displayBackButton(fragment);
        onBackPressed();
        return true;
    }

    @Override
    public void onDestroy(){
        ListAdapter.observers.remove(update);
        super.onDestroy();
    }

}

