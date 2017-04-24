package com.nearman.focusin;

/**
 * Created by Chris on 4/9/2017.
 */

public interface TodoAccessHandler {
    public long createTodo(TodoModel todo);
    public void updateTodo(TodoModel todo);
    public void deleteTodo(TodoModel todo);
    public TodoModel retrieveTodo(int todoId) throws Exception;
}
