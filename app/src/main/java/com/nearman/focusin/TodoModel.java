package com.nearman.focusin;

/**
 * Created by Chris on 4/9/2017.
 */

public class TodoModel {
    private int id;
    private String description;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
