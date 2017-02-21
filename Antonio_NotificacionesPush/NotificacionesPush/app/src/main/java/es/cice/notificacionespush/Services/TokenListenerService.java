package es.cice.notificacionespush.Services;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

import es.cice.notificacionespush.Services.PushRegisterService;

/**
 * Created by cice on 17/1/17.
 */

public class TokenListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Intent i = new Intent(this, PushRegisterService.class);
        startService(i);
    }
}
