package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.ListAdapter;
import gruppe24.dendigitalerestaurantoplevelse.MainActivity;
import gruppe24.dendigitalerestaurantoplevelse.R;
import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Menu;

/**
 * Created by Tobias on 02-01-2018.
 */

public class FragSearch extends Fragment {

    private ListAdapter listAdapter;
    public Runnable update = new Runnable() {
        @Override
        public void run() {
            listAdapter.notifyDataSetChanged();
        }
    };
    private Menu specializedMenu;
    private List<String> dishes = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        ConstraintLayout layout = (ConstraintLayout)inflater.inflate(R.layout.fragment_fragsearch, container, false);


        listAdapter = new gruppe24.dendigitalerestaurantoplevelse.ListAdapter(getActivity(), dishes);
        ListView listViewID = (ListView) layout.findViewById(R.id.listViewID);
        listViewID.setAdapter(listAdapter);

        listViewID.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String dish = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(getActivity(), dish, Toast.LENGTH_LONG).show();
                        MainActivity.startFoodInfoActivity(dish, getFragmentManager());

                    }
                }
        );

        SearchView searchView = (SearchView) layout.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String s) {
                specializedMenu = Backend.getInstance().search(Backend.getInstance().getMenu(), s);
                dishes.clear();
                dishes.addAll(specializedMenu.getDishesAsStrings());
                listAdapter.notifyDataSetChanged();
                return true;
            }
        });


        Dish.newPicturesLoaded.add(update);
        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Dish.newPicturesLoaded.remove(update);
    }
}
