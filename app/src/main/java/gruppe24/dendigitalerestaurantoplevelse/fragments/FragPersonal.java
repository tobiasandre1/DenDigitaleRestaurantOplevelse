package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.ListAdapter;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.SharedPreferenceManager;
import gruppe24.dendigitalerestaurantoplevelse.CustomGrid;
import gruppe24.dendigitalerestaurantoplevelse.R;


public class FragPersonal extends Fragment {

    Activity activity;
    SharedPreferenceManager sharedPreferenceManager;
    ArrayList<Dish> favorites;


    GridView grid;
    String[] web = {
            "Favoritter",
            "Bestillings-historik",


    } ;
    int[] imageId = {
            R.drawable.ic_fav_checked,
            R.drawable.ic_order_history
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ConstraintLayout rootView = (ConstraintLayout) inflater.inflate(R.layout.fragment_fragpersonal, container, false);
        sharedPreferenceManager = new SharedPreferenceManager();
        favorites = sharedPreferenceManager.getPreferences(activity);

        CustomGrid adapter = new CustomGrid(getActivity(), web, imageId);
        grid = (GridView) rootView.findViewById(R.id.gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

        /*
        List<String> dishes = Backend.getInstance().getMenu().getDishesAsStrings();
        ListAdapter listAdapter = new gruppe24.dendigitalerestaurantoplevelse.ListAdapter(getActivity(), dishes);
        ListView listViewID = (ListView) layout.findViewById(R.id.listViewID);
        listViewID.setAdapter(listAdapter);

        listViewID.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String dish = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(getActivity(), dish, Toast.LENGTH_LONG).show();
                        startFoodInfoActivity(dish);

                    }
                }
        );*/
        return rootView;
    }

}
