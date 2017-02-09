package es.cice.androidstackexchange.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import es.cice.androidstackexchange.model.Item;

/**
 * Created by cice on 7/2/17.
 */

public class QuestionOpenHelper extends SQLiteOpenHelper {

    public static final String OWNER_AVATAR_COLUMN = "PROFILE_IMAGE";
    public static final String QUESTION_TITLE_COLUMN = "TITLE";
    public static final String QUESTION_ID_COLUMN = "QUESTION_ID";
    public static final String QUESTION_LINK_COLUMN = "QUESTION_LINK";
    public static final String OWNER_ID__COLUMN = "USER_ID";
    public static final String QUESTION_TABLE = "QUESTIONS";


    public static final String QUESTIONS_DB = "questionDB";
    public static final int VERSION = 1;
    private static QuestionOpenHelper qoh;
    private static Context ctx;
    static final Item item = null;


    public QuestionOpenHelper(Context context) {

        super(context, QUESTIONS_DB, null, VERSION);
    }


    public static QuestionOpenHelper getInstance (Context ctx) {
        if (qoh == null) {
            qoh = new QuestionOpenHelper(ctx);
            QuestionOpenHelper.ctx = ctx;
        }

        return qoh;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE QUESTIONS(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QUESTION_ID_COLUMN+" INTEGER, " +
                QUESTION_TITLE_COLUMN+" TEXT, " +
                QUESTION_LINK_COLUMN+" TEXT, " +
                OWNER_ID__COLUMN+" INTEGER, " +
                OWNER_AVATAR_COLUMN+" INTEGER)";
        db.execSQL(sql);
    }

    public void insert (List<Item> questions) {

        String sql = "insert into "+QUESTION_TABLE+" ( "+QUESTION_ID_COLUMN+", "+QUESTION_TITLE_COLUMN+", "+QUESTION_LINK_COLUMN+", "+OWNER_ID__COLUMN+", "+OWNER_AVATAR_COLUMN+") VALUES(?,?,?,?,?)";
        SQLiteDatabase  db = qoh.getWritableDatabase();
        db.beginTransaction();

        for (Item item:questions) {
            db.execSQL(sql, new Object(){item.questionId, item.title, item.link, item.owner.userId, item.owner.profileImage});
            item.owner.profileImage;
        }

        db.setTransactionSuccessful();
        db.endTransaction();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new RuntimeException("No se admite la actualizacion de esta BBDD");
    }


}
