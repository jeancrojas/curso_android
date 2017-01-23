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

import java.io.FileDescriptor;
import java.io.PrintWriter;

import es.cice.staticfragments.R;


public class QuoteFragment extends Fragment {
    private Context ctx;
    public static final String TAG="QuoteFragment";
    private TextView titleTV,quoteTV;
    private String[] quotes;
    private String[] titles;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"onCreated()...");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()...");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()...");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate()...");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_quote,container,false);
        quoteTV= (TextView) layout.findViewById(R.id.quoteTV);
        titleTV= (TextView) layout.findViewById(R.id.titleTV);
        Log.d(TAG,"onCreateView()...");
        return layout;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()...");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView()...");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach()...");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ctx=context;
        quotes=ctx.getResources().getStringArray(R.array.citas);
        titles=ctx.getResources().getStringArray(R.array.titles);
        Log.d(TAG,"onAttach()...");
    }

    public void showTitle(int index) {
        titleTV.setText(titles[index]);
        quoteTV.setText(quotes[index]);
    }

}
