package es.cice.myapplication;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by cice on 31/1/17.
 */

public class AsyncTaskContador extends AsyncTask<Integer, Integer, Void> {

    TextView textViewContador;

    public void setTextViewContador(TextView textViewContador) {
        this.textViewContador = textViewContador;
    }

    static final String TAG = "AsyncTaskContador";
    @Override
    protected Void doInBackground(Integer... params) {

        for (int i = 0; i < params[0]; i++) {
            if (isCancelled()) {
                break;
            } else {
                try {
                    Thread.sleep(5000);
                    publishProgress(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.d(TAG, "Contador: "+i);
                }
            }
        }

        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
        textViewContador.setText("Cancelado");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textViewContador.setText(values[0].toString());
    }
}
