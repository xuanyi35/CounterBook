package com.example.counterbook;

import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XuanyiWu on 2017-09-25.
 */

public class Counter implements Serializable {


    private String name;
    private Date date;
    private int current;
    private int initial;
    private String comment;

    private String fdate;

    ////////////////////////////////////////////////////////////////////////////
    public Counter (String name, int initial){
        date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fdate = dateFormat.format(date);

        this.name = name;
        this.current = initial;
        this.initial = initial;
        this.comment = "";
    }


    public Counter (String name, int initial,String comment){

        date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fdate = dateFormat.format(date);

        this.name = name;
        this.current = initial;
        this.initial = initial;
        this.comment = comment;
    }

    ////////////////////////////////////////////////////////////////////////////
    public String getName(){
        return name;
    }


    public String getDate(){
        return fdate;
    }

    public int getCurrent(){
        return current;
    }


    public int getInit(){return initial;}

    public String getComment(){return comment;}

   //////////////////////////////////////////////////////////////////////////////
    public void Increment(){
        this.current = this.current + 1;
    }

    public void Decrement(){
        this.current = this.current - 1;
    }

    public void Reset(){
        this.current = this.initial;
    }

    public void NewDate(){
        this.date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fdate = dateFormat.format(this.date);
    }

    public void new_name(String name){
        this.name = name;
    }

    public void new_init(int initial){
        this.initial = initial;
        this.current = initial;
    }

    public void new_comment(String comment){
        this.comment = comment;
    }

    ///////////////////////////////////////////////////////////////////////////////
    @Override
    public  String toString(){
        return "Name:       "+name.toString()+'\n'+ "Date:      "+ fdate +'\n'+ "Current value:     "+current +'\n'+ "Initial value:        "+ initial+'\n' + "Comment:     "+ comment.toString() ;
    }


}
