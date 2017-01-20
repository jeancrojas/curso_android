package es.cice.friendsdynamiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ListView friendsLV;
    private EditText friendsET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listaInicial = new ArrayList<>();
        listaInicial.add("Juan");
        listaInicial.add("Carlos");
        listaInicial.add("Pedro");


        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaInicial);

        friendsLV = (ListView) findViewById(R.id.friendsLV);
        friendsLV.setAdapter(adapter);
        friendsET = (EditText) findViewById(R.id.newNameET);

    }

    public void addFriend (View v) {
        String newFriend = friendsET.getText().toString();
        adapter.add (newFriend);
        adapter.notifyDataSetChanged();

        friendsET.setText("");
    }
}
