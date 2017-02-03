package es.cice.downloadservice1.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import es.cice.downloadservice1.R;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DownloadIntentService extends IntentService {

    public static final String URL_EXTRA = "url";


    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "es.cice.downloadservice1.services.action.FOO";
    private static final String ACTION_BAZ = "es.cice.downloadservice1.services.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "es.cice.downloadservice1.services.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "es.cice.downloadservice1.services.extra.PARAM2";

    public DownloadIntentService() {
        super("DownloadIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static Intent makeIntent(URL url) {
        return null;
    }

    public static Intent makeIntent(String url) {
        return null;
    }

    public static Intent makeIntent(Context ctx, URL url) {
        Intent intent = new Intent(ctx, DownloadIntentService.class);
        intent.putExtra(URL_EXTRA, url);
        return intent;
    }

    public static Intent makeIntent(Context ctx, String url) {
        Intent intent = new Intent(ctx, DownloadIntentService.class);
        intent.putExtra(URL_EXTRA, url);
        return intent;
    }


    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DownloadIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DownloadIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String urlStr = intent.getStringExtra(URL_EXTRA);
        OutputStream out = null;
        File file = null;
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            file = openOutputStream(url);

            if (file == null){
                file = Environment.getDataDirectory();
                out = openFileOutput(url.toString(), MODE_PRIVATE);
            }

            byte[] buffer = new byte[1024];
            int bytesLeidos;

            do {
                bytesLeidos = in.read(buffer);
                out.write(buffer, 0, bytesLeidos);
            } while (bytesLeidos == buffer.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            Notification.Builder builder = new Notification.Builder(this);
            File file = Environment.getDataDirectory();
            builder
                    .setSmallIcon(R.drawable.ic_download)
                    .setContentTitle("Download finished")
                    .setContentText("descarga terminada en "+file.getAbsolutePath())
                    file.getAbsolutePath();

            Notification notification = builder.build();
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(11111, notification);


            try {
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private File openOutputStream (Url url) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File imageAndMovieDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM + "/MisImagenes"
            );

            if (!imageAndMovieDir.exists())
                imageAndMovieDir.mkdir();
            return new ;
        }
    }
}
