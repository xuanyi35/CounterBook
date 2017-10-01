/*
 *
 * Counter
 *
 * Version 1.0
 *
 * September 30, 2017
 *
 * Copyright (c) 2017 Team 24,CMPUT301, University of Alberta - All Rights Reserved.
 * You mayuse,distribute, or modify thid code under terms and condition of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact xuanyi@ualberta.ca.
 */

package com.example.counterbook;

import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XuanyiWu on 2017-09-25.
 */


/**
 * Create a counter object
 *
 *  @author X
 * @version 1.5
 * @since 1.0
 *
 */
public class Counter implements Serializable {


    private String name;
    private Date date;
    private int current;
    private int initial;
    private String comment;
    private String fdate;

    //////////////////////////////  constructor ////////////////////////////////////////////

    /**
     *  construct a counter object
     *
     * @param name       counter object
     * @param initial    initial value
     * @param comment    comment to the counter
     */
    public Counter (String name, int initial,String comment){

        date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fdate = dateFormat.format(date);
        this.name = name;
        this.current = initial;
        this.initial = initial;
        this.comment = comment;
    }

    ////////////////////////////  get the info of the counter /////////////////////////////////////////////

    /**
     * get the name of the counter
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * get the date of the counter
     * @return
     */
    public String getDate(){
        return fdate;
    }

    /**
     * get the current value of the counter
     * @return
     */
    public int getCurrent(){
        return current;
    }

    /**
     * get the initial value of the counter
     * @return
     */
    public int getInit(){return initial;}

    /**
     * get the comment of the counter
     * @return
     */
    public String getComment(){return comment;}

   //////////////////////////////  update the counter //////////////////////////////////////////////

    /**
     *  increment current value by 1
     */
    public void Increment(){
        this.current = this.current + 1;
    }

    /**
     * decrement current value by 1
     */
    public void Decrement(){
        this.current = this.current - 1;
    }

    /**
     * reset current value to be the initial value
     */
    public void Reset(){
        this.current = this.initial;
    }

    /**
     * update the date
     */
    public void NewDate(){
        this.date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.fdate = dateFormat.format(this.date) ;
    }

    /**
     * update the name
     *
     * @param name new counter name
     */
    public void new_name(String name){
        this.name = name;
    }

    /**
     *  update initial value
     *
     * @param initial new initial value
     */
    public void new_init(int initial){
        this.initial = initial;
    }

    /**
     * update current value
     *
     * @param current new current value
     */
    public void new_current(int current){
        this.current = current;
    }

    /**
     * update comment
     *
     * @param comment new comment
     */
    public void new_comment(String comment){
        this.comment = comment;
    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * convert to string
     *
     * @return
     */
    @Override
    public  String toString(){
        return "Name:       "+name.toString()+'\n'+ "Date:      "+ fdate +'\n'+ "Current value:     "+current +'\n'+ "Initial value:        "+ initial+'\n' + "Comment:     "+ comment.toString() ;
    }


}
