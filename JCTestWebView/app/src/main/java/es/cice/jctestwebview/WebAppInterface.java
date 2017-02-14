package es.cice.jctestwebview;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.webkit.JavascriptInterface;

/**
 * Created by cice on 14/2/17.
 */

public class WebAppInterface {

    Context context;

    public WebAppInterface (Context context){
        this.context = context;
    }

    @JavascriptInterface
    public void showDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setMessage(message).setNeutralButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }

}
