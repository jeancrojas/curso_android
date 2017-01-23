package es.cice.staticfragments.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.cice.staticfragments.R;


public class CitasFragment extends Fragment {
    private Context ctx;
    private static final String TAG = "CitasFragment";
    private TextView titleTextView;
    private TextView citaTextView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onCreateView()...");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onCreateView()...");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onCreateView()...");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onCreateView()...");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_citas, container, false);
        titleTextView = (TextView) layout.findViewById(R.id.citasTitleTextView);
        titleTextView = (TextView) layout.findViewById(R.id.citasCitaTextView);
        Log.d(TAG, "onCreateView()...");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ctx = context;
        Log.d(TAG, "onAttach()...");
    }
}
