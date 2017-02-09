package es.cice.androidstackexchange;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import es.cice.androidstackexchange.database.QuestionOpenHelper;
import es.cice.androidstackexchange.events.NewDataEvent;
import es.cice.androidstackexchange.model.Item;
import es.cice.androidstackexchange.retrofitresource.QuestionCall;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModelFragment extends Fragment {


    public ModelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new ModelLoadThread().start();
    }

    public class ModelLoadThread extends Thread {

        public void run() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.stackexchage.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            QuestionCall service = retrofit.create(QuestionCall.class);

            try {
                List<Item> questionsCall = service.getQuestionsCall().execute().body();
                QuestionOpenHelper qoh = QuestionOpenHelper.getInstance(getActivity());
                qoh.insert( List <Item>  );

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
