package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Menu;


public class ShoppingCart extends CustomToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        super.makeToolbar();

        Menu info = new MenuArrayList();




        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, Backend.getInstance().getUser().getShoppingCart().getItemsAsStrings());

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }


}
