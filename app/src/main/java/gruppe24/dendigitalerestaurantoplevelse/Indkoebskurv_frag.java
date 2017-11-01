package gruppe24.dendigitalerestaurantoplevelse;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;


public class Indkoebskurv_frag extends Fragment {

    private TextView tekst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TableLayout tableLayout = new TableLayout(getActivity());

        tekst = new TextView(getActivity());
        tekst.setText("Her bliver vist et fragment");
        tableLayout.addView(tekst);
        return tableLayout;
    }


}
