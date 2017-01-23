package es.cice.staticfragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import es.cice.staticfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends Fragment {

    private Context ctx;
    private ListView titlesListView;

    public TitlesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TitlesListFragmentHostingActivity)
            ctx = context;



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_titles, container, false);
        titlesListView = (ListView) layout.findViewById(R.id.titlesListView);
        String[] titles = ctx.getResources().getStringArray(R.array.titles);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx,
                android.R.layout.simple_list_item_1,android.R.id.text1,titles);
        titlesListView.setAdapter(adapter);
        titlesListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((TitlesListFragmentHostingActivity)ctx).showTitle(i);
            }
        });
        return layout;
    }

}
