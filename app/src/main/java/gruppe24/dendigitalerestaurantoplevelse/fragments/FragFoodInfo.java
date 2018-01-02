package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;

import gruppe24.dendigitalerestaurantoplevelse.R;
import gruppe24.dendigitalerestaurantoplevelse.backend.BackEndController;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.fragments.Toolbar;


public class FragFoodInfo extends android.app.Fragment implements View.OnClickListener{

    private Dish dish;
    FloatingActionButton fab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_food_info, container, false);

        insertDish(rootView);

        fab  = (FloatingActionButton) rootView.findViewById(R.id.addToBasket);
        fab.setOnClickListener(this);

        return rootView;

    }

    private void getDishData(){
        Bundle data = getArguments();
        this.dish = BackEndController.getMenu().getDish(data.getString("Food"));

    }

    private void insertDish(View rootView){
        getDishData();
        //Insert data into layout
        ImageView image = (ImageView) rootView.findViewById(R.id.imageView5);
        TextView title = (TextView) rootView.findViewById(R.id.dishName);
        TextView description = (TextView) rootView.findViewById(R.id.dishDesc);

        image.setImageResource(this.dish.getImage());
        title.setText(this.dish.getName());
        description.setText(this.dish.getDescription());

    }

    public void onClick(View v){
        if(v.getId() == R.id.addToBasket){
            BackEndController.getUser().getShoppingCart().add(this.dish);
            Toolbar toolbar = (Toolbar) getFragmentManager().findFragmentById(R.id.toolbar);
            toolbar.update();
        }
    }

}
