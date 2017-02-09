package es.cice.contactsprovidertest;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Cursor cursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                new String[] {ContactsContract.Contacts._ID
                        ,ContactsContract.Contacts.DISPLAY_NAME
                        ,ContactsContract.Contacts.PHOTO_URI}
                ,null,null,null);


        List<String> contactNames = new ArrayList<>();
        while (cursor.moveToNext()){
            String name =
                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            contactNames.add(name);

        }

        cursor.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactNames);

        setListAdapter(adapter);





    }




}
