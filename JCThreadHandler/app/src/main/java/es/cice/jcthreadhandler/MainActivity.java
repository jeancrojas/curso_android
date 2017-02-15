package es.cice.jcthreadhandler;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Handler puente = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            progressDialog.incrementProgressBy((Integer) msg.obj);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Download");
        progressDialog.setMessage("Loading...");
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.show();

        new Thread(new Runnable(){
            @Override
            public void run() {
                while (progressDialog.getProgress() < progressDialog.getMax()){

                    try {
                        Thread.sleep(1000);
                        Message msg = new Message();
                        msg.obj = 10;
                        puente.sendMessage( msg );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                progressDialog.dismiss();

            }
        }).start();


    }







}
