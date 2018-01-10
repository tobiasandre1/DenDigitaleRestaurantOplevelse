package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.R;
import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;


public class FragPersonal extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.listview, container, false);

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
        );
        return layout;
    }

    public void startFoodInfoActivity(CharSequence food) {
        Bundle data = new Bundle();
        data.putString("Food", food.toString());

        Fragment fragment = new FragFoodInfo();
        fragment.setArguments(data);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag_place, fragment).addToBackStack("tag");
        ft.commit();

        ToolbarMain toolbarMain = (ToolbarMain) fm.findFragmentById(R.id.toolbarMain);
        toolbarMain.setTitle(food);
    }
}
