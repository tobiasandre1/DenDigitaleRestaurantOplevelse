package gruppe24.dendigitalerestaurantoplevelse;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import gruppe24.dendigitalerestaurantoplevelse.backend.BackEndController;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;

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
            Dish dish = BackEndController.getMenu().getDish(dishName);

            TextView itemText = (TextView) customView.findViewById(R.id.textviewitemID);
            ImageView itemImage = (ImageView) customView.findViewById(R.id.itemImageID);

            itemText.setText(dish.getName());
            itemImage.setImageResource(dish.getImage());

        } catch(NullPointerException e){
            System.out.println("Could not find dish named: " + dishName);
        }

        return customView;
    }
}
