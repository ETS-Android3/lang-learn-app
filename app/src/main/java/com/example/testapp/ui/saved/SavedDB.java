package com.example.testapp.ui.saved;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SavedDB extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "CharDB";
    private static final String TABLE_NAME = "savedTable";
    public static String KEY_ID = "id";
    public static String ITEM_HIRA = "hiraChar";
    public static String ITEM_KATA = "kataChar";
    public static String ITEM_PHO = "phoItem";
    public static String FAVORITE_STATUS = "fStatus";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + ITEM_HIRA+ " TEXT,"
            + ITEM_KATA + " TEXT," + ITEM_PHO+ " TEXT, " + FAVORITE_STATUS+" TEXT)";

    public SavedDB(Context context) { super(context, DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // create empty table
    public void insertEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // enter your value
        for (int x = 1; x < 11; x++) {
            cv.put(KEY_ID, x);
            cv.put(FAVORITE_STATUS, "0");

            db.insert(TABLE_NAME,null, cv);
        }
    }

    // insert data into database
    public void insertIntoTheDatabase(String item_hira, String item_kata, String item_pho, String id, String saved_status) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_HIRA, item_hira);
        cv.put(ITEM_KATA, item_kata);
        cv.put(ITEM_PHO, item_pho);
        cv.put(KEY_ID, id);
        cv.put(FAVORITE_STATUS, saved_status);
        db.insert(TABLE_NAME,null, cv);
    }

    // read all data
    public Cursor read_all_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID+"="+id+"";
        return db.rawQuery(sql,null,null);
    }

    // remove line from database
    public void remove_saved(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  "+ FAVORITE_STATUS+" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id);

    }

    // select all favorite list

    public Cursor select_all_favorite_list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+" ='1'";
        return db.rawQuery(sql,null,null);
    }

}
