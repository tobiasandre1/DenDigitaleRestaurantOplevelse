package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import gruppe24.dendigitalerestaurantoplevelse.CustomGrid;
import gruppe24.dendigitalerestaurantoplevelse.R;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.backend.SharedPreferenceManager;


public class FragMenu extends Fragment {
    Activity activity;
    SharedPreferenceManager sharedPreferenceManager;
    ArrayList<Dish> favorites;


    GridView grid;
    String[] web = {
            "Yakitori",
            "Sashimi",
            "Nigiri",
            "Rispapirruller",
            "Salater",
            "Små retter",
            "Tilbehør"


    } ;
    int[] imageId = {
            R.drawable.yakitori_category,
            R.drawable.sashimi_category,
            R.drawable.nigiri_category,
            R.drawable.rispapirruller_category,
            R.drawable.salater_category,
            R.drawable.smaaretter_category,
            R.drawable.tilbehoer_category
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
                //Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Bundle data = new Bundle();
                data.putString("category", web[+position]);

                Fragment fragment = new FragMenuItemList();
                fragment.setArguments(data);

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frag_place, fragment).addToBackStack("food");
                ft.commit();


            }
        });


        return rootView;
    }

}
