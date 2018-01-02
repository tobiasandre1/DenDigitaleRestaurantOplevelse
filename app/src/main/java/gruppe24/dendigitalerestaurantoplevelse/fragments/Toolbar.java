package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import gruppe24.dendigitalerestaurantoplevelse.R;
import gruppe24.dendigitalerestaurantoplevelse.ShoppingCart;

/**
 * Created by Tobias on 02-01-2018.
 */

public class Toolbar extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment

        //LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.toolbar_home, container, false);
        View rootView = inflater.inflate(R.layout.toolbar_home, container, false);
        LinearLayout shopping = (LinearLayout) rootView.findViewById(R.id.shoppingcart);
        shopping.setOnClickListener(this);

        return rootView;
    }

    public void onClick(View v){
        Activity context = this.getActivity();
        if(v.getId() == R.id.shoppingcart){
            (context).startActivity(new Intent(context, ShoppingCart.class));
        }
    }

    public void setTitle(CharSequence text){
        TextView title = (TextView) getView().findViewById(R.id.title);
        title.setText(text);
    }
}

