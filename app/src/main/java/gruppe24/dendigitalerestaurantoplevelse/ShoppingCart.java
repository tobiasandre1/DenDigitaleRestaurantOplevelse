package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;

import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;

import gruppe24.dendigitalerestaurantoplevelse.backend.interfaces.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.OrderItem;


public class ShoppingCart extends CustomToolbarActivity {

    private ListView lvOrder;
    private ShoppingCartListAdapter adapter;
    private List<OrderItem> mOrderList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        super.makeToolbar();

        lvOrder = (ListView)findViewById(R.id.list);

        mOrderList = Backend.getInstance().getUser().getShoppingCart().getItems();

        adapter = new ShoppingCartListAdapter(getApplicationContext(), mOrderList);
        lvOrder.setAdapter(adapter);


    }
}
