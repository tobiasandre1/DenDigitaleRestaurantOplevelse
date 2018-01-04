/**
 * Created by Tobias on 01-11-2017.
 */

package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.User;

//TODO Delete this class once all other classes have been changed to no longer include it
public class CustomToolbarActivity extends AppCompatActivity{

    Backend backend = Backend.getInstance();
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = (Toolbar) findViewById(R.id.uppertoolbar);
        setSupportActionBar(toolbar);

        //toolbar.getId();

        //findViewById(R.id.shoppingcart).setOnClickListener(new ToolbarActions(this.getApplicationContext()));

    }

    protected void makeToolbar(){
        addClickListeners();
        update();

    }

    protected void addClickListeners(){
        findViewById(R.id.shoppingcart).setOnClickListener(new ToolbarActions(this));
        findViewById(R.id.home).setOnClickListener(new ToolbarActions(this));
    }

    protected void update(){
        TextView shop = (TextView) findViewById(R.id.shoppingcart_text);
        shop.setText(backend.getUser().getShoppingCart().getTotalPriceAsText());
    }

    @Override
    public void onResume(){
        super.onResume();
        update();
    }

}
