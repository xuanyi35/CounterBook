/*
 *
 * CountBook
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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by XuanyiWu on 2017-09-25.
 */


/**
 *
 * View the details of a selected counter
 *
 * @author X
 * @version 1.5
 * @see EditCountActivity
 * @see AddCounterActivity
 * @see MainActivity
 * @since 1.0
 *
 */
public class ViewCounterActivity extends MainActivity{

    private TextView details;

    /**
     *  Create the details page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_counter);
        details = (TextView) findViewById(R.id.detail);
        Intent intent = getIntent();
        final int current_pos = intent.getIntExtra("Class", 0);

/////////////////////////  actions for delete ////////////////////////

        Button deleteBT = (Button) findViewById(R.id.delete);
        deleteBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                counters.remove(current_pos);
                oldCounters.setAdapter(adapter);
                saveInFile();
                Toast.makeText(getApplicationContext(), "Successfully deleted", Toast.LENGTH_SHORT).show();
            }
        });

//////////////////////////////////  actions for edit ///////////////////

        Button editBT = (Button) findViewById(R.id.edit);
        editBT.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                Intent i3 = new Intent(ViewCounterActivity.this, EditCountActivity.class);
                i3.putExtra("Class",current_pos );
                startActivity(i3);
            }
        });
    }

    /**
     * start the details page
     *
     */
    protected void onStart(){
        super.onStart();
        Intent intent = getIntent();
        int pos = intent.getIntExtra("Class",0);
        details.setText(counters.get(pos).toString());
    }

}
