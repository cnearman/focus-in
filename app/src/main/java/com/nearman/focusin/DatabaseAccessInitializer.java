package com.nearman.focusin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chris on 4/9/2017.
 */

public class DatabaseAccessInitializer extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final String DATABASE_NAME = "focusin.db";

    public DatabaseAccessInitializer(Context context) {
        super(context, DATABASE_NAME, null, CurrentMigration.version);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CurrentMigration.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(CurrentMigration.SQL_UPDATE_ENTRIES);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
