package com.example.counterbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by XuanyiWu on 2017-09-25.
 */

public class AddCounterActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_counter);

        add_name = (EditText) findViewById(R.id.name);
        add_time =(TextView) findViewById(R.id.time);
        add_init = (EditText) findViewById(R.id.initial_value);
        add_current = (EditText) findViewById(R.id.current_value);
        add_comment = (EditText) findViewById(R.id.comment);

        final Button confirmBtn = (Button) findViewById(R.id.reset);
        confirmBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                String name_s = add_name.getText().toString();
                String initial_vs = add_init.getText().toString();
                String  comment_s = add_comment.getText().toString();

                if ((add_name.length() == 0)|| initial_vs.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "Need name and initial value", Toast.LENGTH_SHORT).show();
                }
                else {
                    int initial_v=0;
                    Boolean success = true;
                    try {
                        initial_v = Integer.parseInt(initial_vs);

                    } catch (Exception e){
                        success = false;

                    }
                    if (initial_v <0 ){
                        success = false;
                    }

                    if (success) {
                        counters.add(new Counter(name_s, initial_v,comment_s));
                        adapter.notifyDataSetChanged();
                        saveInFile();
                        Toast.makeText(getApplicationContext(), "Successfully add a counter"+'\n'+"current value is automatically set to be the initial value", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Initial value should be a non-negative integer", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }

}
