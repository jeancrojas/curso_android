package es.cice.dialogtest;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import es.cice.dialogtest.dialogs.MyCustomLayoutDialog;
import es.cice.dialogtest.dialogs.MyPositiveNegativeDialog;

public class MainActivity extends AppCompatActivity implements MyCustomLayoutDialog.CustomDialogInterface {

    private TextView monitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monitor = (TextView) findViewById(R.id.monitor);
    }

    public void showPositiveNegativeDialog() {
        MyPositiveNegativeDialog myDialog = new MyPositiveNegativeDialog();
        myDialog.show(getFragmentManager(), "myPositiveNegativeDialog");
    }

    public void showCustomLayoutDialog(View v) {
        MyCustomLayoutDialog myDialog = new MyCustomLayoutDialog();
        myDialog.show(getFragmentManager(), "myPositiveNegativeDialog");
    }

    @Override
    public void setData(Map<String, String> data) {
        String email = data.get(MyCustomLayoutDialog.EMAIL_KEY);
        String name = data.get(MyCustomLayoutDialog.NAME_KEY);
        monitor.setText("name: "+name+"\nemail: "+email);

    }
}
