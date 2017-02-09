package es.cice.sqlitedatabases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";
    SQLiteDatabase db;
    TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView) findViewById(R.id.txtMsg);

        File storagePath = getApplication().getFilesDir();
        Log.d(TAG, "Ruta: "+storagePath.getPath());
        String myDbPath = storagePath.getPath() + "/"+ "myfriends";

        txtMsg.setText("BD Path: "+myDbPath);

        try {
            db = SQLiteDatabase.openDatabase(myDbPath,null,SQLiteDatabase.CREATE_IF_NECESSARY);

            db.execSQL("CREATE TABLE IF NOT EXISTS tblAMIGO ("
                    + " recID integer PRIMARY KEY autoincrement, "
                    + " name text, "
                    + "phone text ); ");

            querySQL("select * from tblAmigo");

            db.close();

            txtMsg.append("\nAll done!");
        } catch (SQLiteException e) {
            txtMsg.setText("\nError: "+e.getMessage());
        }



    }


    public void querySQL (String consulta) {

        Cursor c1 = db.rawQuery(String.valueOf(consulta), null);
        c1.moveToPosition(-1);

        while (c1.moveToNext()){
            int recId = c1.getInt(0);
            String nombre = c1.getString(1);
            String phone = c1.getString(c1.getColumnIndex("phone"));
        }


        Log.d(TAG, "querySQL()... ");
    }

    public void insertSQL (String insert) {

        /*
        db.execSQL("INSERT INTO tblAMIGO(name, phone) VALUES ('AAA', '555-1111');");
        db.execSQL("INSERT INTO tblAMIGO(name, phone) VALUES ('BBB', '555-2222');");
        db.execSQL("INSERT INTO tblAMIGO(name, phone) VALUES ('CCC', '555-3333');");
        db.close();
        */

        Log.d(TAG, "insertSQL()... ");
    }

    private String showCursor (Cursor cursor) {
        cursor.moveToPosition(-1);
        String cursorData = "\nCursor: [";

        String[] colName = cursor.getColumnNames();


        cursorData += "]";
        cursor.moveToPosition(-1);

        //Page 13

    }



}
