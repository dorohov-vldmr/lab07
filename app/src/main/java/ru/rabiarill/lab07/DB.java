package ru.rabiarill.lab07;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {


    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE my_test (my_key TEXT, my_value TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void do_insert (String key, String value){
        String sql = "INSERT INTO my_test VALUES('" + key + "' , '" + value + "');";
        SQLiteDatabase db = getWritableDatabase (); // get ready to write into datab
        db.execSQL(sql); // run query
    }

    public String do_select(String key) {
        String sql = "SELECT my_value FROM my_test WHERE my_key = '" + key + "';";
        SQLiteDatabase db = getReadableDatabase(); // get ready to read from datab
        Cursor cur = db.rawQuery(sql, null); // run query and acquire

        if (cur.moveToFirst() == true) // jump to the first (and the only one) mat
            return cur.getString(0); // return value from the first c

        return "(!) not found"; // return special text when no results
    }

    public void do_update(String key, String value){
        String sql = "UPDATE my_test SET my_value='" + value +"' WHERE my_key='"+ key + "';";
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL(sql);

    }

    public void do_delete(String key){
        String sql = "DELETE FROM my_test WHERE my_key='" + key + "';";
        SQLiteDatabase db = getReadableDatabase();

        db.execSQL(sql);

    }


}
