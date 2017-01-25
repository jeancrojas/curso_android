package es.cice.dialogtest.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import es.cice.dialogtest.R;

/**
 * Created by cice on 25/1/17.
 */

public class MyCustomLayoutDialog extends DialogFragment {

    private CustomDialogInterface mDialogInterface;
    public static final String EMAIL_KEY = "email";
    public static final String NAME_KEY = "name";
    EditText nombreET, emailET;

    public interface CustomDialogInterface {
        public void setData(Map<String, String> data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mDialogInterface = (CustomDialogInterface) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(" el context debe implementar el interfaz CustomDialogInterface");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View layout = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);
        nombreET = (EditText) layout.findViewById(R.id.nombreEditText);
        emailET = (EditText) layout.findViewById(R.id.emailEditTex);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Custom Layout Dialog")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Map<String, String> data = new HashMap<String, String>();
                        data.put(NAME_KEY, nombreET.getText().toString());
                        data.put(EMAIL_KEY, emailET.getText().toString());
                        mDialogInterface.setData(data);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setView(layout);
        return builder.create();
    }
}
