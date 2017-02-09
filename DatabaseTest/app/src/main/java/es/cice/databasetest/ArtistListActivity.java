package es.cice.databasetest;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import es.cice.databasetest.databases.ArtistOpenHelper;

public class ArtistListActivity extends ListActivity {

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArtistOpenHelper openHelper = new ArtistOpenHelper(this, null, 1);
        SQLiteDatabase db =  openHelper.getReadableDatabase();

        Cursor cursor = db.query(ArtistOpenHelper.ARTIST_TABLE
                , new String[]{ArtistOpenHelper.ARTIST_PK, ArtistOpenHelper.NAME_COLUMN}
                , null
                , null
                , null
                , null
                , null);

        CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_layout, cursor
                , new String[] {ArtistOpenHelper.ARTIST_PK ,ArtistOpenHelper.NAME_COLUMN}
                , new int[]{R.id.pkTV, R.id.nameTV} );

        setListAdapter(adapter);

    }
}
