package gruppe24.dendigitalerestaurantoplevelse;



import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
//toast er kun for at vise at det virker, skal slettes når det ikke længere er i brug
import android.widget.ListAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import gruppe24.dendigitalerestaurantoplevelse.backend.BackEndController;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;


public class Listview extends Fragment{

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.listview, container, false);


        String[] dishes = BackEndController.getMenu().getDishesAsStrings();
        ListAdapter listAdapter = new gruppe24.dendigitalerestaurantoplevelse.ListAdapter(getActivity(), dishes);
        ListView listViewID = (ListView) layout.findViewById(R.id.listViewID);
        listViewID.setAdapter(listAdapter);

        listViewID.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
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

    public void startFoodInfoActivity(CharSequence food){
        Intent intent = new Intent(getActivity(),FoodInfo.class);
        Dish dish = BackEndController.getMenu().getDish(food);
        intent.putExtra("Food", dish.getName().toString());
        startActivity(intent);
    }

}
