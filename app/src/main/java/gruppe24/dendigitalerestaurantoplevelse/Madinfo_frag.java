package gruppe24.dendigitalerestaurantoplevelse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;


public class Madinfo_frag extends Fragment {

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
