package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gruppe24.dendigitalerestaurantoplevelse.R;

/**
 * Created by Tobias on 02-01-2018.
 */

public class FragSearch extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragsearch, container, false);
    }
}
