/**
 * Created by Tobias on 01-11-2017.
 */

package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import gruppe24.dendigitalerestaurantoplevelse.backend.BackEndController;
import gruppe24.dendigitalerestaurantoplevelse.backend.Menu;
import gruppe24.dendigitalerestaurantoplevelse.backend.MenuArrayList;
import gruppe24.dendigitalerestaurantoplevelse.backend.User;

public class CustomToolbarActivity extends AppCompatActivity{

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(BackEndController.getUser()==null && BackEndController.getMenu()==null) {
            Menu menu = new MenuArrayList();
            User user = new User();
            BackEndController.initialize(user, menu);
            ;
        }

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
        shop.setText(BackEndController.getUser().getShoppingCart().getTotalPriceAsText());
    }

    @Override
    public void onResume(){
        super.onResume();
        update();
    }

}
