package com.example.travelmalaysia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FavDB extends SQLiteOpenHelper {

    public static int DB_VERSON = 1;
    public static String DATABASE_NAME = "PlaceDB";
    public static String TABLE_NAME = "favouriteTable";
    public static String KEY_ID = "id";
    public static String PLACE_TITLE = "placeTitle";
    public static String ITEM_IMAGE = "placeImage";
    public static String FAVOURTIE_STATUS = "fStatus";
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + PLACE_TITLE+ " TEXT,"
            + ITEM_IMAGE + " TEXT," + FAVOURTIE_STATUS +" TEXT)";

    public FavDB(Context context) { super(context,DATABASE_NAME,null,DB_VERSON);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // create empty table
    public void insertEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // enter your value
        for (int x = 1; x < 11; x++) {
            cv.put(KEY_ID, x);
            cv.put(FAVOURTIE_STATUS, "0");

            db.insert(TABLE_NAME,null, cv);
        }
    }

    // insert data into database
    public void insertIntoTheDatabase(String place_title, int place_image, String id, String fav_status) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PLACE_TITLE, place_title);
        cv.put(ITEM_IMAGE, place_image);
        cv.put(KEY_ID, id);
        cv.put(FAVOURTIE_STATUS, fav_status);
        db.insert(TABLE_NAME,null, cv);
        Log.d("FavDB Status", place_title + ", favstatus - "+fav_status+" - . " + cv);
    }

    // read all data
    public Cursor read_all_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID+"="+id+"";
        return db.rawQuery(sql,null,null);
    }

    // remove line from database
    public void remove_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  "+ FAVOURTIE_STATUS +" ='0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());

    }

    // select all favorite list

    public Cursor select_all_favorite_list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+ FAVOURTIE_STATUS +" ='1'";
        return db.rawQuery(sql,null,null);
    }

}
