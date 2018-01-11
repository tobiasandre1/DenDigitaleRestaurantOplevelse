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


import java.util.ArrayList;
import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;

public class ListAdapter extends ArrayAdapter<String> {

    public ListAdapter(final Context context, List<String> dishes) {
        super(context, R.layout.custom_row, dishes);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater customInflater = LayoutInflater.from(getContext());
        View customView = customInflater.inflate(R.layout.custom_row, parent, false);

        //notifyDataSetChanged();
        CharSequence dishName = getItem(position);
        Backend backend = Backend.getInstance();
        final Dish currDish = backend.getMenu().getDish(dishName);


        ImageView add = (ImageView) customView.findViewById(R.id.orderID);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backend.getInstance().getUser().getShoppingCart().add(currDish);

                notifyDataSetChanged();
            }

        });

        try {
//            Backend backend = Backend.getInstance();
            Dish dish = backend.getMenu().getDish(dishName);

            TextView itemText = (TextView) customView.findViewById(R.id.nameID);
            ImageView itemImage = (ImageView) customView.findViewById(R.id.itemImageID);
            TextView itemPriceText = (TextView) customView.findViewById(R.id.priceID);
            ImageView addDish = (ImageView) customView.findViewById(R.id.orderID);

            itemText.setText(dish.getName());

            itemImage.setImageDrawable(dish.getImage());
            itemPriceText.setText(dish.getPriceText());

        } catch(NullPointerException e){
            System.out.println("Could not find dish named: " + dishName);
        }

        return customView;
    }

}
