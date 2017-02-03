package es.cice.pingpongservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import java.util.Map;

public class PingPongService extends Service {
    private int lastUsedIdentifier;
    private PingPongHandler mHandler;
    public static final int REQUEST_ID = 1;
    public static final int SEND_PING = 2:
    public static final int SEND_PONG = 2:
    public static final int CLOSING_CONNECTION = 4;


    private Map<Integer, Messenger> clientMessengerMap;

    public PingPongService (){}


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.


        if (mHandler == null)
            throw new UnsupportedOperationException("Not yet implemented");
        new Messenger(mHandler).getBinder();



    }





    public class PingPongHandler extends Handler {

        public void handleMessage (Message msg) {
            switch (msg.what) {
                case REQUEST_ID:
                    Message responseMsg = Message.obtain();
                    Messenger clientMessenger = msg.replyTo;

                    if (clientMessenger != null) {
                        responseMsg.arg1 = lastUsedIdentifier++;
                        clientMessengerMap.put (responseMsg.arg1).send(responseMsg);
                    }
                    break;

                case SEND_PING :
                    break;

                case SEND_PONG:

                    break;


            }
        }

    }




}
