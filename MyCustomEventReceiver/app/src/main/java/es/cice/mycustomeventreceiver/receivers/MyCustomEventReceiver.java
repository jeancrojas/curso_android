package es.cice.mycustomeventreceiver.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyCustomEventReceiver extends BroadcastReceiver {

    public static final String MY_CUSTOM_EVENT = "es.cice.mycustomeventreceiver.MYEVENT";
    public MyCustomEventReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "onReceive", Toast.LENGTH_LONG).show();
    }
}
