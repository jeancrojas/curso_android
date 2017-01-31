package es.cice.thecookiemonstersgame;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by cice on 31/1/17.
 */

public class AsyncTaskContador extends AsyncTask<Integer, Integer, Void> {

    TextView simulationClock;

    public void setSimulationClock(TextView simulationClock) {
        this.simulationClock = simulationClock;
    }

    static final String TAG = "AsyncTaskContador";

    @Override
    protected Void doInBackground(Integer... params) {

            for (int i = 1; i <= params[0]; i++) {
                if (isCancelled()) {
                    break;
                } else {
                    try {
                        Thread.sleep(1000);
                        publishProgress(i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.d(TAG, "Contador: " + i);
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
        simulationClock.setText("Cancelado");
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
        simulationClock.setText("Simulation clock: " + values[0].toString()+"/120 sec.");
    }
}
