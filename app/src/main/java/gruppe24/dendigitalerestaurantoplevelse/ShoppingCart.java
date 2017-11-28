package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.Menu;


public class ShoppingCart extends CustomToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        super.makeToolbar();

        Menu info = new MenuArrayList();


        String[] names = new String[2];
        names[0] = "Salmon";
        names[1] = "Spice";

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, names);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }


}
