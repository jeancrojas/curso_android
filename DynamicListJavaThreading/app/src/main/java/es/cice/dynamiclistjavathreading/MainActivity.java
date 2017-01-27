package es.cice.dynamiclistjavathreading;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView numberListTV;
    static final String TAG = "MainActivity";
    private NumberListHandler mHandler;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberListTV = (TextView) findViewById(R.id.numericListTV);

        mHandler = new NumberListHandler();
        pBar = (ProgressBar) findViewById(R.id.progressBar);
        pBar.setVisibility(ProgressBar.INVISIBLE);
        pBar.setProgress(0);


    }

    public void startRandomList(View view) {

        new Thread(new NumberListRunnable()).start();
        //new Thread(new NumberListRunnable()).start();
    }

    public class NumberListRunnable implements Runnable {

        @Override
        public void run() {
            Message m;
            Random rdm = new Random();
            m = mHandler.obtainMessage(mHandler.SHOW_PROGRESS);
            //pBar.setVisibility(View.VISIBLE);
            mHandler.sendMessage(m);

            int v = 0;

            for ( int i = 0 ; v < pBar.getMax() ; v++) {
                int value = rdm.nextInt(1000000);
                Log.d(TAG, "\nValue: "+value);
                m = mHandler.obtainMessage(mHandler.SET_PROGRESS, new Integer(value));
                mHandler.sendMessage(m);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            m = mHandler.obtainMessage(mHandler.HIDE_PROGRESS);
            mHandler.sendMessage(m);
        }
    }


    public class NumberListHandler extends Handler {
        public final static int SHOW_PROGRESS = 2;
        public final static int HIDE_PROGRESS = 3;
        public final static int SET_PROGRESS = 4;


        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SET_PROGRESS:
                    Integer value = (Integer) msg.obj;
                    numberListTV.append ("\n"+value);
                    pBar.setProgress(pBar.getProgress()+1);
                    break;
                case SHOW_PROGRESS:
                    pBar.setVisibility(View.VISIBLE);
                    break;

                case HIDE_PROGRESS:
                    pBar.setVisibility(View.GONE);
                    break;
            }

        }
    }

}

