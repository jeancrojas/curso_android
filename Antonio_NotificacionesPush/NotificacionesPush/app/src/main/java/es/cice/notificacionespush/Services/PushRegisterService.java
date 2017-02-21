package es.cice.notificacionespush.Services;

import android.app.IntentService;
import android.content.Intent;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import es.cice.notificacionespush.R;

/**
 * Created by cice on 17/1/17.
 */

public class PushRegisterService extends IntentService {
    public PushRegisterService() {
        super("PushRegisterService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID pushID = InstanceID.getInstance(this);
        try {
            String registrationToken = pushID.getToken(
                    getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                    null
            );
            GcmPubSub subscription = GcmPubSub.getInstance(this);
            subscription.subscribe(registrationToken, "/topics/my_little_topic", null);
        }
        catch (IOException e){

        }
    }
}
