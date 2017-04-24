package com.nearman.focusin;

import android.provider.BaseColumns;

/**
 * Created by Chris on 4/9/2017.
 */

public final class DatabaseContract {
    private DatabaseContract(){}

    public static class Todo implements BaseColumns{
        public static final String TABLE_NAME = "todo";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
