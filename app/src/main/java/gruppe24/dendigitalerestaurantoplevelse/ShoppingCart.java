package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import gruppe24.dendigitalerestaurantoplevelse.backend.FoodInformationArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.FoodsInformation;


public class ShoppingCart extends CustomToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        super.addClickListeners();

        FoodsInformation info = new FoodInformationArrayList();

        /*
        String[] names = new String[2];
        names[0] = "Salmon";
        names[1] = "Spice";

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_shopping_cart,names);
        */
    }


}
