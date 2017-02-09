package es.cice.databasetest;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import es.cice.databasetest.databases.ArtistOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertData(View view) {

        ArtistOpenHelper opHelper = new ArtistOpenHelper(this, null,1);
        SQLiteDatabase db = opHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();


        cv.put(ArtistOpenHelper.NAME_COLUMN, "Johny Cash");
        db.insert(ArtistOpenHelper.ARTIST_TABLE, null, cv);


        cv.put(ArtistOpenHelper.NAME_COLUMN, "Bob Dylan");
        db.insert(ArtistOpenHelper.ARTIST_TABLE, null, cv);
    }

    public void showData(View view) {

        Intent intent = new Intent(this, ArtistListActivity.class);
        startActivity(intent);

    }
}
