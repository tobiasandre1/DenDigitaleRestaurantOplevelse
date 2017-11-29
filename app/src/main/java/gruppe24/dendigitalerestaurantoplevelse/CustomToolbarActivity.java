/**
 * Created by Tobias on 01-11-2017.
 */

package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import gruppe24.dendigitalerestaurantoplevelse.backend.BackEndController;

public class CustomToolbarActivity extends AppCompatActivity{

    protected Toolbar toolbar;
    protected static BackEndController backend = new BackEndController();

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
        Button shop = (Button) findViewById(R.id.shoppingcart);
        shop.setText(backend.getUser().getShoppingCart().getTotalPriceAsText());
    }

}
