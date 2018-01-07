package gruppe24.dendigitalerestaurantoplevelse;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import java.util.List;

import gruppe24.dendigitalerestaurantoplevelse.backend.Backend;
import gruppe24.dendigitalerestaurantoplevelse.backend.OrderItem;
import gruppe24.dendigitalerestaurantoplevelse.fragments.Toolbar;

public class ShoppingCartListAdapter extends BaseAdapter {

    private Context mContext;
    private List<OrderItem> mOrderList;



    //Constructor

    public ShoppingCartListAdapter(Context mContext, List<OrderItem> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
    }

    @Override
    public int getCount() {
        return mOrderList.size();
    }

    @Override
    public Object getItem(int position) {
        return mOrderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.order_item_card, null);
        TextView tvOrder_nameID = (TextView)v.findViewById(R.id.order_nameID);
        TextView tvOrder_priceID = (TextView)v.findViewById(R.id.order_priceID);
        TextView tvOrder_amountID = (TextView)v.findViewById(R.id.order_amountID);
        ImageView ivOrder_imgviewID = (ImageView)v.findViewById((R.id.order_imgviewID));
        final EditText amount = (EditText)v.findViewById(R.id.amountText);
        Button remove = (Button)v.findViewById(R.id.btn_order_removeID);

        tvOrder_nameID.setText(mOrderList.get(position).getDish().getName());
        tvOrder_priceID.setText(String.valueOf("kr. " + mOrderList.get(position).getDish().getPrice()));
        tvOrder_amountID.setText(String.valueOf(mOrderList.get(position).getAmount())+" stk.");
        ivOrder_imgviewID.setImageDrawable(mOrderList.get(position).getDish().getImage());
        amount.setText(String.valueOf(mOrderList.get(position).getAmount()));

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backend.getInstance().getUser().getShoppingCart().remove(mOrderList.get(position).getDish());

                notifyDataSetChanged();
//                FragmentManager manager = ((Activity) mContext).getFragmentManager();
//                Toolbar toolbar = (Toolbar) convertView.findViewById(R.id.toolbar);
//                toolbar.update();
            }
        });

        amount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER){
                    Backend.getInstance().getUser().getShoppingCart().setAmount(mOrderList.get(position).getDish(), Integer.parseInt(amount.getText().toString()));
                    InputMethodManager imm = (InputMethodManager) mContext.getSystemService(mContext.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(amount.getWindowToken(), 0);
                    notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });







        return v;
    }
}
