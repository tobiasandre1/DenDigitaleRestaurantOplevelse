package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import gruppe24.dendigitalerestaurantoplevelse.backend.SharedPreferenceManager;
import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;


public class ListAdapter extends ArrayAdapter<String> {
    private Context context;
    public static ArrayList<Runnable> observers = new ArrayList<>();

    List<Dish> dishes;

    public ListAdapter(Context context, List<String> dishes) {
        super(context, R.layout.custom_row, dishes);
        this.context = context;
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
                try{
                    Toast.makeText(context, currDish.getName() + " added to cart", Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e){
                    System.out.println("Activity is null, cannot make toast");
                }
                notifyObservers();
                //notifyDataSetChanged();
            }

        });
        try {
//            Backend backend = Backend.getInstance();
            Dish dish = backend.getMenu().getDish(dishName);
            final Dish dishToAdd = backend.getMenu().getDish(dishName);

            TextView itemText = (TextView) customView.findViewById(R.id.nameID);
            ImageView itemImage = (ImageView) customView.findViewById(R.id.itemImageID);
            TextView itemPriceText = (TextView) customView.findViewById(R.id.priceID);
            ImageView addDish = (ImageView) customView.findViewById(R.id.orderID);
            CheckBox checkBox = (CheckBox) customView.findViewById(R.id.checkBox2);

            itemText.setText(dish.getName());
            itemImage.setImageDrawable(dish.getImage());
            itemPriceText.setText(dish.getPriceText());

            final CheckBox check = checkBox;

            checkBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    /* Code gives transactiontoolargeexception. Have not found solution
                     * Surrounding in try-catch did not fix
                    try {
                        if (check.isChecked()) {
                            Backend.getInstance().getUser().getSharedPreferenceManager().addToPreferences(context, dishToAdd);
                        } else {
                            Backend.getInstance().getUser().getSharedPreferenceManager().removePreference(context, dishToAdd);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }*/
                }
            });

            if (checkFavoriteItem((Dish) dishes)) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        } catch(NullPointerException e){
            System.out.println("Could not find dish named: " + dishName);
        }


        return customView;
    }

    public boolean checkFavoriteItem(Dish d) {
        boolean check = false;

        try {
            List<Dish> preferred = Backend.getInstance().getUser().getSharedPreferenceManager().getPreferences(context);
            if (preferred != null) {
                for (Dish dish : preferred) {
                    if (dish.equals(d)) {
                        check = true;
                        break;
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return check;
    }

    private void notifyObservers(){
        for(Runnable obs: observers){
            obs.run();
        }
    }

}
