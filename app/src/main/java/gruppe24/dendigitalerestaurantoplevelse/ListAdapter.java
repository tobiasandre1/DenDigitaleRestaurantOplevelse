package gruppe24.dendigitalerestaurantoplevelse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;


import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragFoodInfo;
import gruppe24.dendigitalerestaurantoplevelse.fragments.FragHome;

public class ListAdapter extends ArrayAdapter<String> {

    public ListAdapter(Context context, String[] dishes) {
        super(context, R.layout.custom_row, dishes);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_row, parent, false);

        CharSequence dishName = getItem(position);

        try {
            Backend backend = Backend.getInstance();
            Dish dish = backend.getMenu().getDish(dishName);

            TextView itemText = (TextView) customView.findViewById(R.id.nameID);
            ImageView itemImage = (ImageView) customView.findViewById(R.id.itemImageID);
            TextView itemPriceText = (TextView) customView.findViewById(R.id.priceID);

            itemText.setText(dish.getName());
            itemImage.setImageResource(dish.getImage());
            itemPriceText.setText(dish.getPriceText());
/*
            ImageButton buttonOne = (ImageButton) customView.findViewById(R.id.saveID);
           buttonOne.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
            String dish = String.valueOf(parent.getItemAtPosition(position));


                }






            });
*/
        } catch(NullPointerException e){
            System.out.println("Could not find dish named: " + dishName);
        }



        return customView;
    }
}
