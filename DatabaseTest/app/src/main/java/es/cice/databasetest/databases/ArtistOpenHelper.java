package es.cice.databasetest.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cice on 6/2/17.
 */

public class ArtistOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ArtistBD";
    public static final int DATABASE_VERSION = 1;
    public static final String SCHEMA = "CREATE TABLE ARTIST (_id INTEGER PRIMARY KEY AUTOINCREMENT" +
            "                                                   , ARTIST_NAME TEXT)";

    public static final String ARTIST_TABLE = "ARTIST";
    public static final String ARTIST_PK= "_id";
    public static final String NAME_COLUMN = "ARTIST_NAME";

    private int version;
    private Context ctx;

    public ArtistOpenHelper(Context ctx, SQLiteDatabase.CursorFactory factory, int version) {
        super(ctx, DATABASE_NAME, factory,version);
        this.ctx = ctx;
        this.version = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCHEMA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ARTIST ");
        onCreate(db);
    }
}
