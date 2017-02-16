package es.cice.mycustomeventreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.cice.mycustomeventreceiver.receivers.MyCustomAlarmReceiver;
import es.cice.mycustomeventreceiver.receivers.MyCustomEventReceiver;

public class MainActivity extends AppCompatActivity {

    EditText myET;
    Button btn1, btn2;
    private MyCustomEventReceiver mcer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        mcer1 = new MyCustomEventReceiver();
        myET = (EditText) findViewById(R.id.myET);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCustomEventReceiver.MY_CUSTOM_EVENT);
                sendBroadcast(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MyCustomAlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplication(), 22222, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                int elapsedTime = Integer.parseInt(myET.getText().toString());

                alarmManager.set(AlarmManager.RTC_WAKEUP
                        ,System.currentTimeMillis()+elapsedTime*1000
                        ,pendingIntent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(MyCustomEventReceiver.MY_CUSTOM_EVENT);
        registerReceiver(mcer1, intentFilter );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mcer1);
    }
}
