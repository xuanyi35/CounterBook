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

                String current_vs = add_current.getText().toString();

                if ((add_name.length() == 0)|| initial_vs.length() == 0 ) {
                    // URL : http://developer.android.com/guide/topics/ui/dialogs.html
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AddCounterActivity.this);
                    builder1.setTitle("Warning")
                            .setMessage("Need name and initial value ")

                            .setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing
                                }
                            });
                    builder1.show();
                }
                else {
                    int initial_v=0;// current_v = 0;
                    Boolean success = true;
                    try {
                        initial_v = Integer.parseInt(initial_vs);
                        //current_v = Integer.parseInt(current_vs);
                    } catch (Exception e){
                        success = false;

                    }
                    if (initial_v <0 ){  //|| current_v <0) {
                        success = false;
                    }


                    if (success) {
                        counters.add(new Counter(name_s, initial_v,comment_s));
                        adapter.notifyDataSetChanged();
                        saveInFile();
                        Toast.makeText(getApplicationContext(), "Successfully add a counter"+'\n'+"current value is automatically set to be the initial value", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getApplicationContext(), "The current value is automatically set to be the initial value", Toast.LENGTH_SHORT).show();
                        /*if(current_v != initial_v){
                            Toast.makeText(getApplicationContext(), "The current value is set to be the same with initial value", Toast.LENGTH_SHORT).show();
                        }*/

                        //Intent intent = new Intent(AddCounterActivity.this, MainActivity.class);
                        //startActivity(intent);
                    }
                    else{

                        // URL : http://developer.android.com/guide/topics/ui/dialogs.html
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(AddCounterActivity.this);
                        builder2.setTitle("Warning")
                                .setMessage("Initial value should be a non-negative integer ")

                                .setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Do nothing
                                    }
                                });
                        builder2.show();

                    }

                }

            }
        });

    }

}
