package com.nearman.focusin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Chris on 4/9/2017.
 */

public class TodoDatabaseAccessProvider implements TodoAccessHandler {

    DatabaseAccessInitializer mDbHelper;

    public TodoDatabaseAccessProvider(Context context)
    {
         mDbHelper= new DatabaseAccessInitializer(context);
    }

    public long createTodo(TodoModel todo){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues inputModel = mapTodoToDatabaseValues(todo);
        long result = db.insert(DatabaseContract.Todo.TABLE_NAME, null, inputModel);
        return result;
    }

    public void updateTodo(TodoModel todo) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        ContentValues values = mapTodoToDatabaseValues(todo);
        String selection = DatabaseContract.Todo._ID + "= ?";
        String idString = Integer.toString(todo.getId());
        String[] selectionArgs = {idString};
        db.update(DatabaseContract.Todo.TABLE_NAME, values, selection, selectionArgs);
    }

    public void deleteTodo(TodoModel todo) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String selection = DatabaseContract.Todo._ID + "= ?";
        String idString = Integer.toString(todo.getId());
        String[] selectionArgs = {idString};
        db.delete(DatabaseContract.Todo.TABLE_NAME, selection, selectionArgs);
    }

    public TodoModel retrieveTodo(int todoId) throws Exception{
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String[] columns = {
                DatabaseContract.Todo._ID,
                DatabaseContract.Todo.COLUMN_NAME_DESCRIPTION
        };
        String selection = DatabaseContract.Todo._ID + "= ?";
        String idString = Integer.toString(todoId);
        String[] selectionArgs = {idString};
        Cursor cursor = db.query (
                DatabaseContract.Todo.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if(cursor.getCount() > 1){
            throw new Exception();
        }
        cursor.moveToFirst();

        TodoModel result = mapTodoFromCursor(cursor);
        return result;
    }

    private ContentValues mapTodoToDatabaseValues(TodoModel todo){
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Todo.COLUMN_NAME_DESCRIPTION, todo.getDescription());
        return values;
    }

    private TodoModel mapTodoFromCursor(Cursor c){
        TodoModel result = new TodoModel();
        result.setId(c.getColumnIndexOrThrow(DatabaseContract.Todo._ID));
        result.setDescription(c.getString(c.getColumnIndexOrThrow(DatabaseContract.Todo.COLUMN_NAME_DESCRIPTION)));
        return result;
    }
}
