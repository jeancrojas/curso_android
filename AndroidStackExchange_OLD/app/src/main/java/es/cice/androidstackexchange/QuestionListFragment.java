package es.cice.androidstackexchange;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import es.cice.androidstackexchange.database.QuestionOpenHelper;
import es.cice.androidstackexchange.events.NewDataEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionListFragment extends ListFragment {

    static final String TAG = "QuestionListFragment";

    public QuestionListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CursorAdapter adapter = new SimpleCursorAdapter(getContext(), R.layout.question_row, null
                ,new String[]{QuestionOpenHelper.OWNER_AVATAR_COLUMN, QuestionOpenHelper.QUESTION_TITLE_COLUMN}
                , new int[]{R.id.avatar, R.id.question},0 );
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDataNotificationEvent (NewDataEvent event) {
        Log.d(TAG, "getDataNotificationEvent()...");

    }




}
