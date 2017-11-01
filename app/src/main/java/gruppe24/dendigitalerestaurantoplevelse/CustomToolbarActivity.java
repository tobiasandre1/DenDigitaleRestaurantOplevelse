/**
 * Created by Tobias on 01-11-2017.
 */

package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class CustomToolbarActivity extends AppCompatActivity{

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = (Toolbar) findViewById(R.id.uppertoolbar);
        setSupportActionBar(toolbar);

        //toolbar.getId();

        //findViewById(R.id.shoppingcart).setOnClickListener(new ToolbarActions(this.getApplicationContext()));

    }

    protected void addClickListeners(){
        findViewById(R.id.shoppingcart).setOnClickListener(new ToolbarActions(this));
        findViewById(R.id.home).setOnClickListener(new ToolbarActions(this));
    }

}
