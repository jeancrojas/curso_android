package es.cice.telephonebroadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyTelephoneReceiver extends BroadcastReceiver {
    private static final String TAG = "MyTelephoneReceiver";
    public MyTelephoneReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String callState = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

        if (callState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.d(TAG, "incoming number: "+ incomingNumber);
        }

    }
}
