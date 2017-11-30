package gruppe24.dendigitalerestaurantoplevelse.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gruppe24.dendigitalerestaurantoplevelse.Listview;
import gruppe24.dendigitalerestaurantoplevelse.R;


public class FragHome extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Fragment fragment = new Listview();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag_place, fragment);
        ft.commit();

        return inflater.inflate(R.layout.fragment_fraghome, container, false);
    }

}
