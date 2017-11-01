package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by Tobias on 01-11-2017.
 */

public class ToolbarActions implements View.OnClickListener{

    private static Context context;

    public ToolbarActions(Context context){
        this.context = context;
    }

    public void onClick(View v){

        System.out.println("Inclick");
        if(v.getId() == ((Activity) context).findViewById(R.id.shoppingcart).getId()){
            ((Activity)context).startActivity(new Intent((Activity)context, ShoppingCart.class));
        }
        /*
        switch(v.getId()){
            case ((Activity)context).findViewById(R.id.menu).getId():
        }*/
    }

    public void update(){

    }

}
