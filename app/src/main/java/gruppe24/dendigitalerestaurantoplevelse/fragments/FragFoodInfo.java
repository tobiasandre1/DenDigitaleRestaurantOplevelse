package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;

import gruppe24.dendigitalerestaurantoplevelse.R;
import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.Dish;
import gruppe24.dendigitalerestaurantoplevelse.backend.OrderItem;


public class FragFoodInfo extends android.app.Fragment implements View.OnClickListener{

    private Dish dish;
    FloatingActionButton add;
    FloatingActionButton remove;
    EditText amount;
    View buttons;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_food_info, container, false);

        insertDish(rootView);

        add  = (FloatingActionButton) rootView.findViewById(R.id.addToBasket);
        add.setOnClickListener(this);

        remove = (FloatingActionButton) rootView.findViewById(R.id.remove);
        remove.setOnClickListener(this);

        amount = (EditText) rootView.findViewById(R.id.amountText);
        amount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER){
                    Backend.getInstance().getUser().getShoppingCart().setAmount(dish, Integer.parseInt(amount.getText().toString()));
                    Toolbar toolbar = (Toolbar) getFragmentManager().findFragmentById(R.id.toolbar);
                    toolbar.update();
                    updateExtraButtons();
                    return true;
                }
                return false;
            }
        });

        buttons = rootView.findViewById(R.id.buttons);
        updateExtraButtons();
        return rootView;

    }

    private void getDishData(){
        Bundle data = getArguments();
        this.dish = Backend.getInstance().getMenu().getDish(data.getString("Food"));

    }

    private void insertDish(View rootView){
        getDishData();
        //Insert data into layout
        ImageView image = (ImageView) rootView.findViewById(R.id.imageView5);
        //TextView title = (TextView) rootView.findViewById(R.id.dishName);
        TextView description = (TextView) rootView.findViewById(R.id.dishDesc);

        image.setImageResource(this.dish.getImage());
        //title.setText(this.dish.getName());
        description.setText(this.dish.getDescription());

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.addToBasket:
                Backend.getInstance().getUser().getShoppingCart().add(this.dish);
                break;
            case R.id.remove:
                Backend.getInstance().getUser().getShoppingCart().remove(this.dish);
                break;


        }
        Toolbar toolbar = (Toolbar) getFragmentManager().findFragmentById(R.id.toolbar);
        toolbar.update();
        updateExtraButtons();
    }

    private void updateExtraButtons(){
        OrderItem item = Backend.getInstance().getUser().getShoppingCart().get(this.dish.getName());
        if(item == null){
            buttons.setVisibility(View.GONE);
        } else{
            buttons.setVisibility(View.VISIBLE);
            String text = Integer.toString(item.getAmount());
            amount.setText(text);
        }
    }
}
