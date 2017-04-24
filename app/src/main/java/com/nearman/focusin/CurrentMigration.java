package com.nearman.focusin;

/**
 * Created by Chris on 4/9/2017.
 */

public final class CurrentMigration {
    private CurrentMigration() {};
    public static int version = 1;

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DatabaseContract.Todo.TABLE_NAME + " (" +
                    DatabaseContract.Todo._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.Todo.COLUMN_NAME_DESCRIPTION + " TEXT)";

    public static final String SQL_UPDATE_ENTRIES = "";
}
