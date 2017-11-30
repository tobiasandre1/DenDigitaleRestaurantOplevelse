package gruppe24.dendigitalerestaurantoplevelse;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
//toast er kun for at vise at det virker, skal slettes når det ikke længere er i brug
import android.widget.ListAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


public class Listview extends Activity{

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        String[] dishes = {"Sushi", "Soysauce", "Dessert", "Other Sushi"};
        ListAdapter listAdapter = new gruppe24.dendigitalerestaurantoplevelse.ListAdapter(this, dishes);
        ListView listViewID = (ListView) findViewById(R.id.listViewID);
        listViewID.setAdapter(listAdapter);

        listViewID.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String dish = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Listview.this, dish, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
